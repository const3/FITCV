package application;

import java.io.ByteArrayInputStream;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SampleController {
		@FXML
		private Button start_btn;
		@FXML
		private ImageView currentFrame;
		
		private ScheduledExecutorService timer;
		private VideoCapture capture = new VideoCapture();
		private boolean cameraActive = false;
		
		@FXML
		protected void startCamera(ActionEvent event)
		{	
			System.out.println("hola");
			if (!this.cameraActive)
			{
				this.capture.open(0);
				if (this.capture.isOpened())
				{
					this.cameraActive = true;
					Runnable frameGrabber = new Runnable() {
						@Override
						public void run()
						{
							Image imageToShow = grabFrame();
							currentFrame.setImage(imageToShow);
						}
					};
					this.timer = Executors.newSingleThreadScheduledExecutor();
					this.timer.scheduleAtFixedRate(frameGrabber, 0, 33, TimeUnit.MILLISECONDS);
					this.start_btn.setText("Detener Camara");
				}
				else
				{
					System.err.println("Impossible to open the camera connection...");
				}
			}
			else
			{
				this.cameraActive = false;
				this.start_btn.setText("Encender camara");
				try
				{
					this.timer.shutdown();
					this.timer.awaitTermination(33, TimeUnit.MILLISECONDS);
				}
				catch (InterruptedException e)
				{
					System.err.println("Exception in stopping the frame capture, trying to release the camera now... " + e);
				}
				this.capture.release();
				this.currentFrame.setImage(null);
			}
		}
		private Image grabFrame()
		{
			Image imageToShow = null;
			Mat frame = new Mat();
			if (this.capture.isOpened())
			{
				try
				{
					this.capture.read(frame);
					
					if (!frame.empty())
					{
						Imgproc.cvtColor(frame, frame, Imgproc.COLOR_BGR2GRAY);
						imageToShow = mat2Image(frame);
					}
				}
				catch (Exception e)
				{
					System.err.println("Exception during the image elaboration: " + e);
				}
			}
			return imageToShow;
		}
		private Image mat2Image(Mat frame)
		{
			MatOfByte buffer = new MatOfByte();
			Imgcodecs.imencode(".png", frame, buffer);
			return new Image(new ByteArrayInputStream(buffer.toArray()));
		}
}
