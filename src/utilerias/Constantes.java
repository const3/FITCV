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
	public static final String BILATERAL_FILTER = "BILATERAL_FILTER";
	public static final String MEDIAN_FILTER = "MEDIAN_FILTER";
	static final List<String> FILTROS = Arrays.asList(ESCALA_GRISES, BLUR, GAUSSIAN_BLUR, BILATERAL_FILTER, MEDIAN_FILTER);
	// CONSTANTES FILSTROS TOOLTIPS
	private static final String TOOLTIP_ESCALA_GRISES = "Convierte imagen original a escala de grises para poder aplicar un filtro.";
	private static final String TOOLTIP_BLUR = "Suaviza (desenfoca) la imagen original de tal forma que este se visualiza borrosa.\n "
			+ "src -recibe la  imagen de entrada.\n"
			+ "dst - recibe la imagen de salida del mismo tamaño y tipo que el de entrada.\n"
			+ "Tamaño - .Tamaño del núcleo a utilizar (ancho de píxeles y alto de píxeles).\n"
			+ "ancla - Píxel central predeterminado en el punto (-1, -1) significa que  está en el\n"
			+ "centro situado con respecto a los píxeles vecinos.";
	private static final String TOOLTIP_GAUSSIAN_BLUR = " Suaviza una imagen para mejorar la calidad de visualización eliminando\n"
			+ "los granos conocidos como ruido que hacen borrosa una imagen.\n"
			+ "src - recibe la imagen de entrada.\n"
			+ "dst - recibe la imagen de salida del mismo tamaño y tipo que el de entrada.\n"
			+ "Tamaño -. Tamaño del núcleo a utilizar (ancho de píxeles y alto de píxeles).\n"
			+ "puede ser diferente, pero ambos deben ser positivos e impar. O bien, pueden ser cero\n"
			+ "Sigmax - desviación estándar del núcleo de Gauss en la dirección X.\n"
			+ "Sigmay - Gauss desviación estándar del núcleo en la dirección Y.";
	// CONSTANTES FILTROS FIN

	// CONSTANTES DETECCION DE OBJETOS INICIO
	public static final String LINEAS = "LINEAS";
	public static final String CIRCULOS = "CIRCULOS";
	public static final String CANNY = "CANY";
	public static final String SOBEL = "SOBEL";
	static final List<String> BORDES = Arrays.asList(LINEAS, CIRCULOS, CANNY, SOBEL);
	// CONSTANTES DETECCION DE OBJETOS TOOLTIPS
	private static final String TOOLTIP_LINEAS = "Detecta líneas en una imagen\n"
			+ "dst:  La salida del detector de bordes. Debe ser una imagen de escala de grises.\n"
			+ "lines: Es un vector que almacena los parámetros  de las líneas detectadas, que son coordenadas del punto de intersección, \n"
			+ "almacena la longitud de la línea y el ángulo que tiene.\n"
			+ " rho : La resolución del parámetro en pixeles. Se usa 1 pixel. \n"
			+ "theta: La resolución del parámetro  en radianes. Se uso 1 grado \n"
			+ "threshold: El número mínimo de intersecciones para detectar una línea.S";

	
	private static final String TOOLTIP_CIRCULOS = "detecta círculos en una imagen.\n"
			+ "src_gray: Imagen de entrada en escala de grises.\n"
			+ "circles: vector que almacena el nombre de 3 valores : posición del centro( xc,yc)  r (radio) para cada círculo detectado.\n"
			+ "HOUGH_GRADIENT: Define el método de detección.\n"
			+ "dp = 1:  La relación inversa de la resolución.\n"
			+ "min_dist = src_gray.rows/8: Distancia mínima entre los cetros detectados.\n"
			+ "param_1 = 200: límite  superior para el detector de bordes interno de Canny.\n"
			+ "param_2 = 100*: límite  para la detección de centros.\n"
			+ "min_radius = 0: Radio mínimo a detectar. Si no se conoce, se pone cero por defecto.\n"
			+ "max_radius = 0: Radio máximo a detectar. Si no se conoce, se pone cero por defecto.";

	
	private static final String TOOLTIP_CANNY = "detección de bordes\n"
			+ "detected_edges: Almacena la Imagen en escala de grises\n"
			+ "detected_edges: salida del detector (puede ser la misma que la entrada)\n"
			+ "lowThreshold: límite menor para el detector de bordes introducido por el usuario por medio del Trackbar.\n"
			+ "highThreshold: Se define en el programa como tres veces el lowThreshold\n"
			+ "kernel_size: Se define que sea 3 (el tamaño del Kernel Sobel a ser utilizado internamente)";
	// CONSTANTES DETECCION DE OBJETOS FIN

	// MAP UTILIZADO PARA MOSTRAR LOS TOOLTIPS EN LA PANTALLA
	static Map<String, String> TOOLTIPS() {
		return Collections.unmodifiableMap(Stream.of(
				// FILTROS TOOLTIPS INICIO
				new SimpleEntry<>(ESCALA_GRISES, TOOLTIP_ESCALA_GRISES), new SimpleEntry<>(BLUR, TOOLTIP_BLUR),
				new SimpleEntry<>(GAUSSIAN_BLUR, TOOLTIP_GAUSSIAN_BLUR),
				// FILTROS TOOLTIPS FIN
				// DETECCION DE OBJETOS TOOLTIPS INICIO
				new SimpleEntry<>(LINEAS, TOOLTIP_LINEAS), new SimpleEntry<>(CIRCULOS, TOOLTIP_CIRCULOS),
				new SimpleEntry<>(CANNY, TOOLTIP_CANNY)
		// DETECCION DE OBJETOS TOOLTIPS INICIO
		).collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue)));
	}

	// Brillo contraste inicio
	public static final String BRILLO = "BRILLO";
	public static final String CONTRASTE = "CONSTRASTE";
	// Brillo contraste fin
	// operaciones morfologicas inicio
	public static final String EROSION = "EROSIÓN";
	public static final String DILATACION = "DILATACIÓN";
	// operaciones morfologicas fin
	// histograma inicio
	public static final String HISTOGRAMA = "HISTOGRAMA";
	// histograma fin
}