package utilerias;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.Size;

public class ReconocimientoDePatrones {

	
	private Mat harris (Mat src) {
		Mat dst = new Mat();
		Mat dst2 = src.clone();
		
		Mat mRgba = src.clone();
		Mat thresholdImage = new Mat();
		
		/// Global variables
	
		int thresh = 200;
		int max_thresh = 255;
		
		Imgproc.cvtColor(src, dst, Imgproc.COLOR_BGR2GRAY); 
	
		  Mat  dst_norm, dst_norm_scaled;
		  dst = Mat::zeros( src.size(), CV_32FC1 );

		  /// Detector parameters
		  int blockSize = 2;
		  int apertureSize = 3;
		  double k = 0.04;

		  /// Detecting corners
		  Imgproc.cornerHarris( dts, dst2, blockSize, apertureSize, k, BORDER_DEFAULT );

		  /// Normalizing
		  Imgproc. normalize( dst2, dst_norm, 0, 255, NORM_MINMAX, CV_32FC1, Mat() );
		  Imgproc.convertScaleAbs( dst_norm, dst_norm_scaled );

		  /// Drawing a circle around corners
		  for( int j = 0; j < dst_norm.rows ; j++ )
		     { for( int i = 0; i < dst_norm.cols; i++ )
		          {
		            if( (int) dst_norm.at<float>(j,i) > thresh )
		              {
		            	Imgproc.circle( dst_norm_scaled, Point( i, j ), 5,  Scalar(0), 2, 8, 0 );
		              }
		          }
		     }
		return  dst_norm_scaled;
	}	
}
