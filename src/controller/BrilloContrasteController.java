package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import utilerias.BaseController;
import utilerias.Constantes;

public class BrilloContrasteController extends BaseController implements Initializable {
	@FXML
	public Label cv_brillo;
	@FXML
	public Label cv_contraste;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("Iniciando BrilloContrasteController");
		cv_brillo.setText(Constantes.BRILLO);
		cv_contraste.setText(Constantes.CONTRASTE);
		setFieldsDragable(BrilloContrasteController.class);

	}
}