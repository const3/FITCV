package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import utilerias.BaseController;
import utilerias.Constantes;

public class ReconocimientoDePatronesController extends BaseController implements Initializable {
	@FXML
	public Label cv_reconocimiento;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("Iniciando ReduccionDeRuidoController");
		cv_reconocimiento.setText(Constantes.RECONOCIMIENTODEPATRONES);
		setFieldsDragable(ReconocimientoDePatronesController.class);

	}
}