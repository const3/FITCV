package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import utilerias.BaseController;
import utilerias.Constantes;

public class ReduccionDeRuidoController extends BaseController implements Initializable {
	
	@FXML
	public Label cv_reduccion;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("Iniciando ReduccionDeRuidoController");
		cv_freduccion.setText(Constantes.REDUCCIONDERUIDO);
		
		setFieldsDragable(ReduccionDeRuidoController.class);

	}
}