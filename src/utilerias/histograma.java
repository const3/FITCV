package utilerias;


import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
;

public class histograma {
	
	private Mat histograma (Mat src) {	
		Mat dst = new Mat(), dst2 = new Mat();
		Imgproc.cvtColor(src, dst, Imgproc.COLOR_BGR2GRAY); 
		Imgproc.equalizeHist( dst, dst2 ); 

		return dst2;
	
	}	
	
	}

	  

