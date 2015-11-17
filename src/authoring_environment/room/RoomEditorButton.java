package authoring_environment.room;

import java.util.ResourceBundle;

import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;

public class RoomEditorButton extends Button {
	private static final String ROOM_EDITOR_BUTTON_WIDTH = "RoomEditorButtonWidth";

	public RoomEditorButton(ResourceBundle resources, String title) {
		super(resources.getString(title));
		this.setPrefWidth(Double.parseDouble(resources.getString(ROOM_EDITOR_BUTTON_WIDTH)));
	}

}