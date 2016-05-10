package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import utilerias.BaseController;
import utilerias.Constantes;

public class FiltrosController extends BaseController implements Initializable {
	@FXML
	public Label cv_filtro1;
	@FXML
	public Label cv_filtro2;
	@FXML
	public Label cv_filtro3;
	@FXML
	public Label cv_filtro4;
	@FXML
	public Label cv_filtro5;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("Iniciando FiltrosController");
		cv_filtro1.setText(Constantes.BLUR);
		cv_filtro2.setText(Constantes.ESCALA_GRISES);
		cv_filtro3.setText(Constantes.GAUSSIAN_BLUR);
		cv_filtro4.setText(Constantes.BILATERAL_FILTER);
		cv_filtro5.setText(Constantes.MEDIAN_FILTER);
		setFieldsDragable(FiltrosController.class);
	}
}
