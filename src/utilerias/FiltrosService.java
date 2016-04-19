package utilerias;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

public class FiltrosService {

	public Mat blur(Mat src) {
		System.out.println("Filtro");
		Mat dst = new Mat(), dst2 = new Mat();
		Imgproc.cvtColor(src, dst, Imgproc.COLOR_BGR2GRAY);
		Imgproc.blur(dst, dst2, new Size(3, 3));
		return dst2;
	}

	public Mat gaussianBlur(Mat src) {
		System.out.println("Filtro");
		Mat dst = new Mat(), dst2 = new Mat();
		// Imgproc.cvtColor(src, dst, Imgproc.COLOR_BGR2GRAY);
		Imgproc.GaussianBlur(src, dst2, new Size(3, 3), 0);
		return dst2;
	}

	public Mat escalaGrises(Mat src) {
		System.out.println("Filtro");
		Mat dst = new Mat();
		Imgproc.cvtColor(src, dst, Imgproc.COLOR_BGR2GRAY);
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
		default:
			System.out.println("No se selecciono un proceso existente");
			break;
		}
		return dst;
	}
}
