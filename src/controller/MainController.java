package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class MainController implements Initializable {
	@FXML
	private Text dragText;
	@FXML
	private Label dropLabel;
	private StringBuffer elementos = new StringBuffer();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("Iniciando MainController");
		dropLabel.setStyle("-fx-background-color: #D0D6DC;");
		dropLabel.setOnDragOver(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				if (event.getGestureSource() != dropLabel && event.getDragboard().hasString()) {
					event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
				}
				event.consume();
			}
		});

		dropLabel.setOnDragEntered(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				System.out.println("onDragEntered");
				if (event.getGestureSource() != dropLabel && event.getDragboard().hasString()) {
					dropLabel.setTextFill(Color.GREEN);
				}
				event.consume();
			}
		});

		dropLabel.setOnDragExited(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				dropLabel.setTextFill(Color.BLACK);
				event.consume();
			}
		});

		dropLabel.setOnDragDropped(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				Dragboard db = event.getDragboard();
				boolean success = false;
				if (db.hasString() && !db.getString().startsWith("Arrastrar")) {
					elementos.append((elementos.length()>0?">":"")+db.getString());
					dropLabel.setText(elementos.toString());
					success = true;
				}
				event.setDropCompleted(success);
				event.consume();
			}
		});
	}
}
