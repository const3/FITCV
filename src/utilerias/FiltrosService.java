package utilerias;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

public class FiltrosService {

	public Mat blur(Mat src) {
		Mat dst = new Mat(), dst2 = new Mat();
		Imgproc.cvtColor(src, dst, Imgproc.COLOR_BGR2GRAY);
		Imgproc.blur(dst, dst2, new Size(3, 3));
		return dst2;
	}

	public Mat gaussianBlur(Mat src) {
		Mat dst = new Mat(), dst2 = new Mat();
		Imgproc.cvtColor(src, dst, Imgproc.COLOR_BGR2GRAY);
		Imgproc.GaussianBlur(dst, dst2, new Size(3, 3), 0);
		return dst2;
	}

	public Mat escalaGrises(Mat src) {
		Mat dst = new Mat();
		Imgproc.cvtColor(src, dst, Imgproc.COLOR_BGR2GRAY);
		return dst;
	}

	public Mat bilateralFilter(Mat src) {
		Mat source = src.clone(), dst = new Mat();
		Imgproc.bilateralFilter(source, dst, 15, 80, 80);
		return dst;
	}

	public Mat medianBlur(Mat src) {
		Mat source = src.clone(), dst = new Mat();
		Imgproc.medianBlur(source, dst, 15);
		return dst;

	}

	public Mat seleccionarProceso(Mat src, String proceso) {
		Mat dst = new Mat();
		switch (proceso) {
		case Constantes.BLUR:
			dst = blur(src);
			break;
		case Constantes.ESCALA_GRISES:
			dst = escalaGrises(src);
			break;
		case Constantes.GAUSSIAN_BLUR:
			dst = gaussianBlur(src);
			break;
		case Constantes.BILATERAL_FILTER:
			dst = bilateralFilter(src);
			break;
		case Constantes.MEDIAN_FILTER:
			dst = medianBlur(src);
			break;
		default:
			System.out.println("No se selecciono un proceso existente");
			break;
		}
		return dst;
	}
}