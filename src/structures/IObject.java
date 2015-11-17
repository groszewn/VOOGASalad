package structures;

import java.util.List;

import javafx.collections.ObservableMap;
import structures.data.DataSprite;
import structures.data.actions.IAction;
import structures.data.events.IDataEvent;

public interface IObject {

	void bindEvent(IDataEvent event, List<IAction> actions);

	void addSprite(DataSprite s);	

	void removeEvent(IDataEvent e);

	void setSprite(DataSprite s);

	String getName();
	
	void setName(String name);

	ObservableMap<IDataEvent, List<IAction>> getEvents();

	DataSprite getSprite();

}
