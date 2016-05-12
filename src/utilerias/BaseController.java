package utilerias;

import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

import java.lang.reflect.Field;

public class BaseController {
	protected void setFieldsDragable(Class<?> clazzz) {
		for (Field field : clazzz.getDeclaredFields()) {
			if (field.getName().startsWith("cv_")) {
				try {
					Label l = (Label) field.get(this);
					if (Constantes.TOOLTIPS().containsKey(l.getText())) {
						Tooltip tooltip = new Tooltip(Constantes.TOOLTIPS().get(l.getText()));
						l.setTooltip(tooltip);
					}
					l.setOnDragDetected(event -> {
                        Dragboard db = l.startDragAndDrop(TransferMode.ANY);
                        ClipboardContent content = new ClipboardContent();
                        content.putString(l.getText());
                        db.setContent(content);
                        event.consume();
                    });
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
