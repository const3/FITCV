package src.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import utilerias.BaseController;
import utilerias.Constantes;

public class HistogramaController extends BaseController implements Initializable {
	@FXML
	public Label cv_histograma;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("Iniciando HistogramaController");
		cv_histograma.setText(Constantes.HISTOGRAMA);
		setFieldsDragable(HistogramaController.class);

	}
}