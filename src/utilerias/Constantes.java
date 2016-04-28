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
	public static final String TOOLTIP_LINEAS = "Detecta líneas en una imagen\\"
			+ "dst:  La salida del detector de bordes. Debe ser una imagen de escala de grises.\\"
			+ "lines: Es un vector que almacena los parámetros  de las líneas detectadas, que son coordenadas del punto de intersección, \\"
			+ "almacena la longitud de la línea y el ángulo que tiene.\\"
			+ " rho : La resolución del parámetro en pixeles. Se usa 1 pixel. \\"
			+ "theta: La resolución del parámetro  en radianes. Se uso 1 grado \\"
			+ "threshold: El número mínimo de intersecciones para detectar una línea.S";
	
	public static final String TOOLTIP_CIRCULOS = "detecta círculos en una imagen.\\"
			+ "src_gray: Imagen de entrada en escala de grises.\\"
			+ "circles: vector que almacena el nombre de 3 valores : posición del centro( xc,yc)  r (radio) para cada círculo detectado.\\"
			+ "HOUGH_GRADIENT: Define el método de detección.\\"
			+ "dp = 1:  La relación inversa de la resolución.\\"
			+ "min_dist = src_gray.rows/8: Distancia mínima entre los cetros detectados.\\"
			+ "param_1 = 200: límite  superior para el detector de bordes interno de Canny.\\"
			+ "param_2 = 100*: límite  para la detección de centros.\\"
			+ "min_radius = 0: Radio mínimo a detectar. Si no se conoce, se pone cero por defecto.\\"
			+ "max_radius = 0: Radio máximo a detectar. Si no se conoce, se pone cero por defecto.";

	
	public static final String TOOLTIP_CANNY = "detección de bordes\\"
			+ "detected_edges: Almacena la Imagen en escala de grises\\"
			+ "detected_edges: salida del detector (puede ser la misma que la entrada)"
			+ "lowThreshold: límite menor para el detector de bordes introducido por el usuario por medio del Trackbar.\\"
			+ "highThreshold: Se define en el programa como tres veces el lowThreshold\\"
			+ "kernel_size: Se define que sea 3 (el tamaño del Kernel Sobel a ser utilizado internamente)";
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