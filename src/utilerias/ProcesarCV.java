package utilerias;

import org.opencv.core.Mat;

public class ProcesarCV {
	FiltrosService filtrosService = new FiltrosService();
	DeteccionObjetosService deteccionObjetosService = new DeteccionObjetosService();

	public Mat procesando(Mat src, String tipoProceso) {
		Mat dst = new Mat();
		if (Constantes.BORDES.contains(tipoProceso)) {
			dst = deteccionObjetosService.seleccionarProceso(src, tipoProceso);

		} else if (Constantes.FILTROS.contains(tipoProceso)) {
			dst = filtrosService.seleccionarProceso(src, tipoProceso);
		}
		return dst;
	}
}