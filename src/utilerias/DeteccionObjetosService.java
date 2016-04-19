package utilerias;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

public class DeteccionObjetosService {
	public Mat lineas(Mat src) {
		Mat mRgba = src.clone();
		Mat thresholdImage = new Mat();
		Imgproc.cvtColor(mRgba, thresholdImage, Imgproc.COLOR_RGB2GRAY, 4);
		Imgproc.Canny(thresholdImage, thresholdImage, 80, 100, 3, false);

		Mat lines = new Mat();
		int threshold = 50;
		int minLineSize = 20;
		int lineGap = 20;
		double CV_PI = 3.1415926535897932384626433832795;

		Imgproc.HoughLinesP(thresholdImage, lines, 1, CV_PI / 180, threshold, minLineSize, lineGap);

		for (int x = 0; x < lines.cols(); x++) {
			double[] vec = lines.get(0, x);
			double x1 = vec[0], y1 = vec[1], x2 = vec[2], y2 = vec[3];
			Point start = new Point(x1, y1);
			Point end = new Point(x2, y2);

			Imgproc.line(mRgba, start, end, new Scalar(255, 0, 0), 3);

		}
		return mRgba;
	}

	public Mat circulos(Mat src) {
		System.out.println("Filtro");
		Mat dst = new Mat(), dst2 = src.clone();
		Imgproc.cvtColor(src, dst, Imgproc.COLOR_BGR2GRAY);
		Imgproc.GaussianBlur(dst, dst, new Size(9, 9), 2, 2);
		Mat circles = new Mat();
		Imgproc.HoughCircles(dst, circles, Imgproc.CV_HOUGH_GRADIENT, 2.0, dst.rows() / 8, 100, 300, 20, 400);
		if (circles.cols() > 0)
			for (int x = 0; x < circles.cols(); x++) {
				double vCircle[] = circles.get(0, x);
				if (vCircle == null)
					break;
				Point pt = new Point(Math.round(vCircle[0]), Math.round(vCircle[1]));
				int radius = (int) Math.round(vCircle[2]);
				Imgproc.circle(dst2, pt, radius, new Scalar(6, 241, 249), 3);
				Imgproc.circle(dst2, pt, 3, new Scalar(233, 6, 249), 1);
			}
		return dst2;
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
