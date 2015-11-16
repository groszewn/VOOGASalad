package structures.data.events;

import javafx.scene.input.KeyCode;

public class KeyPressedEvent implements IDataEvent {
	
	public final KeyCode keyCode;

    public KeyPressedEvent(KeyCode code){
        keyCode = code;
    }
    
    public int hashCode() {
    	return 10000 + keyCode.hashCode();
    }
    
    public boolean equals(Object obj) {
    	if (obj.getClass().equals(this.getClass())) {
    		if (((KeyPressedEvent)obj).keyCode.hashCode() == this.keyCode.hashCode()) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public String getName() {
    	return String.format("Key Press %s", keyCode.getName());
    }

}
