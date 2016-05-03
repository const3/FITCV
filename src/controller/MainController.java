package controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;

import com.sun.javafx.collections.MappingChange.Map;

import application.Main;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import utilerias.BaseController;
import utilerias.ProcesarCV;

public class MainController extends BaseController implements Initializable {
	@FXML
	private Text dragText;
	@FXML
	private Label cv_dropLabel;
	@FXML
	private Button run, clear;
	@FXML
	private ImageView original;
	@FXML
	private ImageView procesada;
	private StringBuffer elementos = new StringBuffer();
	ProcesarCV procesarCV = new ProcesarCV();
    Mat src;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("Iniciando MainController");
		cv_dropLabel.setStyle("-fx-background-color: #D0D6DC;");
		cv_dropLabel.setOnDragOver(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				if (event.getGestureSource() != cv_dropLabel && event.getDragboard().hasString()) {
					event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
				}
				event.consume();
			}
		});

		cv_dropLabel.setOnDragEntered(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				System.out.println("onDragEntered");
				if (event.getGestureSource() != cv_dropLabel && event.getDragboard().hasString()) {
					cv_dropLabel.setTextFill(Color.GREEN);
				}
				event.consume();
			}
		});

		cv_dropLabel.setOnDragExited(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				cv_dropLabel.setTextFill(Color.BLACK);
				event.consume();
			}
		});

		cv_dropLabel.setOnDragDropped(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				Dragboard db = event.getDragboard();
				boolean success = false;
				if (db.hasString() && !db.getString().startsWith("Arrastrar")) {
					elementos.append((elementos.length() > 0 ? ">" : "") + db.getString());
					cv_dropLabel.setText(elementos.toString());
					success = true;
				}
				event.setDropCompleted(success);
				event.consume();
			}
		});
	}

	@FXML
	public void procesaImgCV() {
		System.out.println("Procesando");
		run.setText("Procesando...");
		String[] aProcesar = elementos.toString().split(">");
//		Mat src = Imgcodecs.imread("/Users/Sam/Downloads/circle-logo-large.png");
        if (src == null){
            src = Imgcodecs.imread(String.valueOf(Main.initImage));
        }
		Mat dst = src, dstTemp = src;
		for (String proceso : aProcesar) {
			dst = procesarCV.procesando(dstTemp, proceso);
			dstTemp = new Mat();
			dstTemp = dst;
		}
		System.out.println("Salio");
		Image img = mat2Image(src);
		original.setImage(img);
		Image imgProc = mat2Image(dst);
		procesada.setImage(imgProc);
		run.setText("Run!");
	}

    @FXML
    public void clearAndSet(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        src = Imgcodecs.imread(String.valueOf(fileChooser.showOpenDialog((Stage)clear.getScene().getWindow())));

    }

	private Image mat2Image(Mat toImg) {
		MatOfByte buffer = new MatOfByte();
		Imgcodecs.imencode(".png", toImg, buffer);
		return new Image(new ByteArrayInputStream(buffer.toArray()));
	}
}
