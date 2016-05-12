package utilerias;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

public class FiltrosService {

	public Mat blur(Mat src, String kernel) {
		int kernelI = Integer.parseInt(kernel);
		Mat dst = new Mat(), dst2 = new Mat();
		Imgproc.cvtColor(src, dst, Imgproc.COLOR_BGR2GRAY);
		Imgproc.blur(dst, dst2, new Size(kernelI, kernelI));
		return dst2;
	}

	public Mat gaussianBlur(Mat src, String kernel, String sigmaX) {
		Mat dst = new Mat(), dst2 = new Mat();
		Imgproc.cvtColor(src, dst, Imgproc.COLOR_BGR2GRAY);
		Imgproc.GaussianBlur(dst, dst2, new Size(Integer.parseInt(kernel), Integer.parseInt(kernel)), Double.parseDouble(sigmaX));
		return dst2;
	}

	public Mat escalaGrises(Mat src) {
		Mat dst = new Mat();
		Imgproc.cvtColor(src, dst, Imgproc.COLOR_BGR2GRAY);
		return dst;
	}

	public Mat bilateralFilter(Mat src, String delta, String sigmaColor, String sigmaSpace) {
		Mat source = src.clone(), dst = new Mat();
		Imgproc.bilateralFilter(source, dst, Integer.parseInt(delta), Integer.parseInt(sigmaColor), Integer.parseInt(sigmaSpace));
		return dst;
	}

	public Mat medianBlur(Mat src, String kernel) {
		Mat source = src.clone(), dst = new Mat();
		Imgproc.medianBlur(source, dst, Integer.parseInt(kernel));
		return dst;

	}

}