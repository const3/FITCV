package utilerias;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc; 

public class ReduccionDeRuido {
	
	public  Mat ruido (Mat src, String kernel) {
		
		Mat dst = new Mat();Mat dst2 = new Mat();Mat dst3 = new Mat();
	
		  int kernel_size = 3;
		  int scale = 1;
		  int delta = 0;
		  int ddepth = CvType.CV_16S;
		
		int kernelI = Integer.parseInt(kernel);
			
		Imgproc.GaussianBlur( src, src, new Size(3,3), 0, 0, 4 );
	
		Imgproc.cvtColor(dst, dst2, Imgproc.COLOR_BGR2GRAY);
	

		Mat abs_dst = new Mat();

		Imgproc.Laplacian( dst2, dst3, ddepth, kernel_size, scale, delta, 4 );
		Core.convertScaleAbs( dst3, abs_dst );

		
		return abs_dst;
	}



}
