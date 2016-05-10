package utilerias;

import org.opencv.core.Mat;

import java.util.ArrayList;

public class ProcesarCV{
	DeteccionObjetosService deteccionObjetosService = new DeteccionObjetosService();

	public Mat procesando(Mat src, String tipoProceso, ArrayList<String> arrayParams) {
		Mat dst = new Mat();
		if (Constantes.BORDES.contains(tipoProceso)) {
			dst = deteccionObjetosService.seleccionarProceso(src, tipoProceso);

		} else if (Constantes.FILTROS.contains(tipoProceso)) {
			FiltrosService filter = new FiltrosService();
			switch (tipoProceso) {
				case Constantes.BLUR:
					dst = filter.blur(src, arrayParams.get(0));
					break;
				/*case Constantes.ESCALA_GRISES:
					dst = filter.escalaGrises(src, arrayParams[0]);
					break;
				case Constantes.GAUSSIAN_BLUR:
					dst = filter.gaussianBlur(src, arrayParams[0]);
					break;
				*/
				default:
					System.out.println("No se selecciono un proceso existente");
					break;
			}
		}
		return dst;
	}
}