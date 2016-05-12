package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import utilerias.BaseController;
import utilerias.Constantes;

public class OperacionesMorfologicasController extends BaseController implements Initializable {
	@FXML
	public Label cv_dilatacion;
	@FXML
	public Label cv_erosion;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("Iniciando OperacionesMorfologicasController");
		cv_erosion.setText(Constantes.EROSION);
		cv_dilatacion.setText(Constantes.DILATACION);
		setFieldsDragable(OperacionesMorfologicasController.class);

	}
}