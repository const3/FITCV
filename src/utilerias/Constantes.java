package utilerias;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Variables Java utilizadas como Constantes para ser utilizadas para ser
 * mostradas en la pantalla
 */
public class Constantes {
	// CONSTANTES FILTROS INICIO
	public static final String ESCALA_GRISES = "ESCALA_GRISES";
	public static final String BLUR = "BLUR";
	public static final String GAUSSIAN_BLUR = "GAUSSIAN_BLUR";
	public static final List<String> FILTROS = Arrays.asList(ESCALA_GRISES, BLUR, GAUSSIAN_BLUR);
	// CONSTANTES FILSTROS TOOLTIPS
	public static final String TOOLTIP_ESCALA_GRISES = "Convierte imagen original a escala de grises para poder aplicar un filtro.";
	public static final String TOOLTIP_BLUR = "Suaviza (desenfoca) la imagen original de tal forma que este se visualiza borrosa.\\ "
			+ "src -recibe la  imagen de entrada.\\"
			+ "dst - recibe la imagen de salida del mismo tamaño y tipo que el de entrada.\\"
			+ "Tamaño - .Tamaño del núcleo a utilizar (ancho de píxeles y alto de píxeles).\\"
			+ "ancla - Píxel central predeterminado en el punto (-1, -1) significa que  está en el\\"
			+ "centro situado con respecto a los píxeles vecinos.";
	public static final String TOOLTIP_GAUSSIAN_BLUR = " Suaviza una imagen para mejorar la calidad de visualización eliminando\\"
			+ "los granos conocidos como ruido que hacen borrosa una imagen.\\"
			+ "src - recibe la imagen de entrada.//"
			+ "dst - recibe la imagen de salida del mismo tamaño y tipo que el de entrada.\\"
			+ "Tamaño -. Tamaño del núcleo a utilizar (ancho de píxeles y alto de píxeles).\\"
			+ "puede ser diferente, pero ambos deben ser positivos e impar. O bien, pueden ser cero\\"
			+ "Sigmax - desviación estándar del núcleo de Gauss en la dirección X.\\"
			+ "Sigmay - Gauss desviación estándar del núcleo en la dirección Y.";
	// CONSTANTES FILTROS FIN

	// CONSTANTES DETECCION DE OBJETOS INICIO
	public static final String LINEAS = "LINEAS";
	public static final String CIRCULOS = "CIRCULOS";
	public static final String CANNY = "CANY";
	public static final List<String> BORDES = Arrays.asList(LINEAS, CIRCULOS, CANNY);
	// CONSTANTES DETECCION DE OBJETOS TOOLTIPS
	public static final String TOOLTIP_LINEAS = "ESTO ES UN TOOLTIP PARA LINEAS";
	public static final String TOOLTIP_CIRCULOS = "ESTO ES UN TOOLTIP PARA CIRCULOS";
	public static final String TOOLTIP_CANNY = "ESTO ES UN TOOLTIP PARA CANY";
	// CONSTANTES DETECCION DE OBJETOS FIN

	// MAP UTILIZADO PARA MOSTRAR LOS TOOLTIPS EN LA PANTALLA
	public static final Map<String, String> TOOLTIPS() {
		return Collections.unmodifiableMap(Stream.of(
				// FILTROS TOOLTIPS INICIO
				new SimpleEntry<>(ESCALA_GRISES, TOOLTIP_ESCALA_GRISES), new SimpleEntry<>(BLUR, TOOLTIP_BLUR),
				new SimpleEntry<>(GAUSSIAN_BLUR, TOOLTIP_GAUSSIAN_BLUR),
				// FILTROS TOOLTIPS FIN
				// DETECCION DE OBJETOS TOOLTIPS INICIO
				new SimpleEntry<>(LINEAS, TOOLTIP_LINEAS), new SimpleEntry<>(CIRCULOS, TOOLTIP_CIRCULOS),
				new SimpleEntry<>(CANNY, TOOLTIP_CANNY)
		// DETECCION DE OBJETOS TOOLTIPS INICIO
		).collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue())));
	}
}