package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import utilerias.BaseController;
import utilerias.Constantes;

public class BordesController extends BaseController implements Initializable {
	@FXML
	public Label cv_borde1;
	@FXML
	public Label cv_borde2;
	@FXML
	public Label cv_borde3;
	@FXML
	public Label cv_borde4;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("Iniciando BordesController");
		cv_borde1.setText(Constantes.LINEAS);
		cv_borde2.setText(Constantes.CIRCULOS);
		cv_borde3.setText(Constantes.CANNY);
		cv_borde4.setText(Constantes.SOBEL);
		setFieldsDragable(BordesController.class);

	}
}