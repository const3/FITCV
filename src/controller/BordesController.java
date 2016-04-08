package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class BordesController implements Initializable{
	@FXML
	private Label borde1;
	@FXML
	private Label borde2;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("Iniciando BordesController");
		borde1.setText("Lineas");
		borde2.setText("Circulos");
	}
}