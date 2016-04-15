package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import utilerias.BaseController;

public class BordesController extends BaseController implements Initializable {
	@FXML
	public Label cv_borde1;
	@FXML
	public Label cv_borde2;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("Iniciando BordesController");
		cv_borde1.setText("Lineas");
		cv_borde2.setText("Circulos");
		setFieldsDragable(BordesController.class);

	}
}