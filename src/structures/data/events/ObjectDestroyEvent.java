package structures.data.events;

import java.util.HashMap;
import java.util.Map;

public class ObjectDestroyEvent extends AbstractBasicEvent {

	@Override
	public String getName() {
		return "Object Destroyed";
	}
	@Override
    public String toString(){
    	return this.getName();
	}

    @Override
    public Map<String, String> dumpContents() {
        Map<String, String> ret = new HashMap<>();
        ret.put("class", getClass().getName());
        return ret;
    }

}
