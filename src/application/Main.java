package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

	public static File initImage;

	@Override
	public void start(Stage primaryStage) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/views/Main.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("JavaFX meets OpenCV");
			primaryStage.setScene(scene);
			primaryStage.show();
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Open Resource File");
			initImage = fileChooser.showOpenDialog(primaryStage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.load(new File("../opencv/build/lib/libopencv_java310.so").getAbsolutePath());
//		 System.load(new File("/Users/Sam/opencv-3.1.0/build/lib/opencv_java310.so").getAbsolutePath());
		launch(args);
	}
}
