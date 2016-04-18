package utilerias;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

public class DeteccionObjetosService {
	public Mat lineas(Mat src) {
		System.out.println("Filtro");
		Mat dst = new Mat(), dst2 = new Mat();
		Imgproc.cvtColor(src, dst, Imgproc.COLOR_BGR2GRAY);
		Imgproc.blur(dst, dst2, new Size(3, 3));
		return dst2;
	}

	public Mat circulos(Mat src) {
		System.out.println("Filtro");
		Mat dst = new Mat();// dst2 = new Mat();
		Imgproc.cvtColor(src, dst, Imgproc.COLOR_BGR2GRAY);
		Imgproc.GaussianBlur(dst, dst, new Size(9, 9), 2, 2);
		Mat circles = new Mat();
		Imgproc.HoughCircles(dst, circles, Imgproc.HOUGH_GRADIENT, 1, dst.rows() / 8, 200, 100, 0, 0);
		// for(Mat i =0; i<circles.size().; i++){
		//
		// }
		return dst;
	}

	public Mat canny(Mat src) {
		Mat grayImage = new Mat(), detectedEdges = new Mat();
		Imgproc.cvtColor(src, grayImage, Imgproc.COLOR_BGR2GRAY);
		Imgproc.blur(grayImage, detectedEdges, new Size(3, 3));
		Imgproc.Canny(detectedEdges, detectedEdges, 3.0, 3.0 * 3, 3, false);
		Mat dest = new Mat();
		Core.add(dest, Scalar.all(0), dest);
		src.copyTo(dest, detectedEdges);
		return dest;

	}

	public Mat seleccionarProceso(Mat src, String proceso) {
		Mat dst = new Mat();
		switch (proceso) {
		case Constantes.CIRCULOS:
			dst = circulos(src);
			break;
		case Constantes.LINEAS:
			dst = lineas(src);
			break;
		case Constantes.CANNY:
			dst = canny(src);
			break;
		default:
			System.out.println("No se selecciono un proceso existente");
			break;
		}
		return dst;
	}

}
