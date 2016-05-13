package controller;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import utilerias.BaseController;
import utilerias.Constantes;
import utilerias.ProcesarCV;

import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainController extends BaseController implements Initializable {
    public AnchorPane AP;
    @FXML
    private VBox params;
	@FXML
	private Label cv_dropLabel;
	@FXML
	private Button run, clear;
	@FXML
	private ImageView original;
	@FXML
	private ImageView procesada;
	private StringBuffer elementos = new StringBuffer();
	private ProcesarCV procesarCV = new ProcesarCV();
    private Mat src;
	private ArrayList<String> arrayParams = new ArrayList<>();
	private ArrayList<String> arrayProcesos = new ArrayList<>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("Iniciando MainController");
		cv_dropLabel.setStyle("-fx-background-color: #D0D6DC;");
		cv_dropLabel.setOnDragOver(event -> {
            if (event.getGestureSource() != cv_dropLabel && event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            }
            event.consume();
        });

		cv_dropLabel.setOnDragEntered(event -> {
            System.out.println("onDragEntered");
            if (event.getGestureSource() != cv_dropLabel && event.getDragboard().hasString()) {
                cv_dropLabel.setTextFill(Color.GREEN);
            }
            event.consume();
        });

		cv_dropLabel.setOnDragExited(event -> {
            cv_dropLabel.setTextFill(Color.BLACK);
            event.consume();
        });

		cv_dropLabel.setOnDragDropped(event -> {
            Dragboard db = event.getDragboard();
            boolean success = false;
            if (db.hasString() && !db.getString().startsWith("Arrastrar")) {
                elementos.append(elementos.length() > 0 ? ">" : "").append(db.getString());
                cv_dropLabel.setText(elementos.toString());
                success = true;
            }
            event.setDropCompleted(success);
            event.consume();
            arrayProcesos.add(elementos.toString());
            for (String proceso : arrayProcesos) {
                arrayParams = mostrarparams(proceso);
            }
        });
	}

	@FXML
	public void procesaImgCV() {
		System.out.println("Procesando");
		run.setText("Procesando...");
//		Mat src = Imgcodecs.imread("/Users/Sam/Downloads/circle-logo-large.png");
        if (src == null){
            src = Imgcodecs.imread(String.valueOf(Main.initImage));
        }
		Mat dst, dstTemp = src;
		dst = procesarCV.procesando(dstTemp, arrayProcesos.get(0), arrayParams);
        System.out.println("Salio");
		Image img = mat2Image(src);
		original.setImage(img);
		if(procesada.getImage()!=null){
			System.out.println("tieneimg");
			procesada.setImage(null);
		}
		Image imgProc = mat2Image(dst);
		procesada.setImage(imgProc);
		run.setText("Run!");
	}
 
    @FXML
    public void clearAndSet(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        elementos= new StringBuffer();
        cv_dropLabel.setText("Arrastrar elementos aquí...");
        original.setImage(null);;
        procesada.setImage(null);;
        arrayParams.clear();
        arrayProcesos.clear();
        params.getChildren().clear();
        src = Imgcodecs.imread(String.valueOf(fileChooser.showOpenDialog(clear.getScene().getWindow())));

    }

    @FXML
    private ArrayList<String> mostrarparams(String tipoProceso){
        ArrayList<String> parameters = new ArrayList<>();
		if (tipoProceso.equals(Constantes.BLUR)){
            // for ()
			TextField kernel = new TextField("3");
            params.getChildren().addAll(new Label("Kernel: "),kernel);
			parameters.add(kernel.getText());

		}
		
		if (tipoProceso.equals(Constantes.GAUSSIAN_BLUR)){
			// for ()
			TextField kernel = new TextField("3");
			params.getChildren().addAll(new Label("Kernel: "),kernel);
			parameters.add(kernel.getText());
			TextField sigmaX = new TextField("3");
			params.getChildren().addAll(new Label("sigmaX: "),kernel);
			parameters.add(sigmaX.getText());
			
		}
		if (tipoProceso.equals(Constantes.BILATERAL_FILTER)){
			// for ()
			TextField delta = new TextField("3");
			params.getChildren().addAll(new Label("delta: "),delta);
			parameters.add(delta.getText());
			TextField sigmaColor = new TextField("3");
			params.getChildren().addAll(new Label("sigmaColor: "),sigmaColor);
			parameters.add(sigmaColor.getText());
			TextField sigmaSpace = new TextField("3");
			params.getChildren().addAll(new Label("sigmaSpace: "),sigmaSpace);
			parameters.add(sigmaSpace.getText());
			
		}
		if (tipoProceso.equals(Constantes.MEDIAN_FILTER)){
			// for ()
			TextField kernel = new TextField("3");
			params.getChildren().addAll(new Label("Kernel: "),kernel);
			parameters.add(kernel.getText());
			
		}
		if (tipoProceso.equals(Constantes.CANNY)){
			// for ()
			TextField threshold = new TextField("3");
			params.getChildren().addAll(new Label("threshold: "),threshold);
			parameters.add(threshold.getText());
			
		}
		if (tipoProceso.equals(Constantes.SOBEL)){
			// for ()
			TextField threshold = new TextField("3");
			params.getChildren().addAll(new Label("threshold: "),threshold);
			parameters.add(threshold.getText());
			TextField scala = new TextField("3");
			params.getChildren().addAll(new Label("scala: "),scala);
			parameters.add(scala.getText());
			TextField delta = new TextField("3");
			params.getChildren().addAll(new Label("delta: "),delta);
			parameters.add(delta.getText());
			
		}
		return parameters;

    }

	private Image mat2Image(Mat toImg) {
		MatOfByte buffer = new MatOfByte();
		Imgcodecs.imencode(".png", toImg, buffer);
		return new Image(new ByteArrayInputStream(buffer.toArray()));
	}
}
