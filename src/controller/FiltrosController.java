package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import utilerias.BaseController;

public class FiltrosController extends BaseController implements Initializable{
	@FXML
	public Label cv_filtro1;
	@FXML
	public Label cv_filtro2;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("Iniciando FiltrosController");
		cv_filtro1.setText("Escala de grises");
		cv_filtro2.setText("Median Blur");
		setFieldsDragable(FiltrosController.class);
	}
}
