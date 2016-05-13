package utilerias;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

public class ReconocimientoDePatrones {

	//TODO: Agregar el codigo correcto HarrisCorner
	private Mat harris (Mat src) {
		Mat dst = new Mat();
		Mat dst2 = src.clone();
		
		Mat mRgba = src.clone();
		Mat thresholdImage = new Mat();
		
		/// Global variables
	
		int thresh = 200;
		int max_thresh = 255;
		
		Imgproc.cvtColor(src, dst, Imgproc.COLOR_BGR2GRAY); 
	
		  Mat  dst_norm = new Mat(), dst_norm_scaled= new Mat();
		  dst = new Mat( src.size(), CvType.CV_32FC1 );

		  /// Detector parameters
		  int blockSize = 2;
		  int apertureSize = 3;
		  double k = 0.04;

		  /// Detecting corners
		  Imgproc.cornerHarris( dst, dst2, blockSize, apertureSize, k, 1 );

		  /// Normalizing
		  Core.convertScaleAbs( dst_norm, dst_norm_scaled );

		  /// Drawing a circle around corners
		return  dst_norm_scaled;
	}	
}
