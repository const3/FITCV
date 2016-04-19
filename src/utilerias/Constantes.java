package utilerias;

import java.util.Arrays;
import java.util.List;

public class Constantes {
	// CONSTANTES FILTROS
	public static final String ESCALA_GRISES = "ESCALA_GRISES";
	public static final String BLUR = "BLUR";
	public static final String GAUSSIAN_BLUR = "GAUSSIAN_BLUR";
	public static final List<String> FILTROS = Arrays.asList(ESCALA_GRISES, BLUR, GAUSSIAN_BLUR);
	// CONSTANTES DETECCION DE OBJETOS
	public static final String LINEAS = "LINEAS";
	public static final String CIRCULOS = "CIRCULOS";
	public static final String CANNY = "CANY";
	public static final List<String> BORDES = Arrays.asList(LINEAS, CIRCULOS, CANNY);
}
