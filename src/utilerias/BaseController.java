package utilerias;

import java.lang.reflect.Field;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

public class BaseController {
	public void setFieldsDragable(Class<?> clazzz) {
		for (Field field : clazzz.getDeclaredFields()) {
			if (field.getName().startsWith("cv_")) {
				try {
					Label l = (Label) field.get(this);
					l.setOnDragDetected(new EventHandler<MouseEvent>() {
						public void handle(MouseEvent event) {
							Dragboard db = l.startDragAndDrop(TransferMode.ANY);
							ClipboardContent content = new ClipboardContent();
							content.putString(l.getText());
							db.setContent(content);
							event.consume();
						}
					});
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
