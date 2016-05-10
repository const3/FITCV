package utilerias;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

class FiltrosService {

	Mat blur(Mat src, String kernel) {
		int kernelI = Integer.parseInt(kernel);
		Mat dst = new Mat(), dst2 = new Mat();
		Imgproc.cvtColor(src, dst, Imgproc.COLOR_BGR2GRAY);
		Imgproc.blur(dst, dst2, new Size(kernelI, kernelI));
		return dst2;
	}

	public Mat gaussianBlur(Mat src, int kernel, double sigmaX) {
		Mat dst = new Mat(), dst2 = new Mat();
		Imgproc.cvtColor(src, dst, Imgproc.COLOR_BGR2GRAY);
		Imgproc.GaussianBlur(dst, dst2, new Size(kernel, kernel), sigmaX);
		return dst2;
	}

	public Mat escalaGrises(Mat src) {
		Mat dst = new Mat();
		Imgproc.cvtColor(src, dst, Imgproc.COLOR_BGR2GRAY);
		return dst;
	}
}