package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SampleController {

	@FXML
	private Button button2;
	@FXML
	private Button buttonA;
	@FXML
	private Button button;
	@FXML
	private Button buttonB;
	@FXML
	private Button button1A;
	@FXML
	private Button button1B;
	@FXML
	private Label label;

	@FXML
	private void handleButtonAction(ActionEvent event) {

		button1A.setVisible(true);
		button1B.setVisible(true);

		buttonA.setVisible(false);
		buttonB.setVisible(false);
	}

	@FXML
	private void set(ActionEvent event) {

		buttonA.setVisible(true);
		buttonB.setVisible(true);

		button1A.setVisible(false);
		button1B.setVisible(false);
	}

	@FXML
	public void initialize() {
		buttonA.setVisible(false);
		buttonB.setVisible(false);
		button1A.setVisible(false);
		button1B.setVisible(false);
	}

}
