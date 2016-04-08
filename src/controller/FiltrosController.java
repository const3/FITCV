package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class FiltrosController implements Initializable{
	@FXML
	private Label filtro1;
	@FXML
	private Label filtro2;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("Iniciando FiltrosController");
		filtro1.setText("Escala de grises");
		filtro2.setText("Median Blur");
	}
}
