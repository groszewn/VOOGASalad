package structures.data.events;

import javafx.scene.input.KeyCode;
import structures.data.actions.DataAction;

public class KeyPressedEvent extends AKeyEvent implements IDataEvent {

    public KeyPressedEvent(KeyCode code){
        super(code);
    }

    @Override
    public void addAction(DataAction a) {

    }

    @Override
    public void removeAction(DataAction a) {

    }
}
