package structures;

import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import structures.data.DataSprite;
import structures.data.actions.IAction;
import structures.data.events.IDataEvent;

public interface IObject {

	void bindEvent(IDataEvent event, ObservableList<IAction> actions);

	void addSprite(DataSprite s);

	void removeEvent(IDataEvent e);

	void setSprite(DataSprite s);

	DataSprite getSprite();

	String getName();

	void setName(String name);

	ObservableMap<IDataEvent, ObservableList<IAction>> getEvents();

	int getZIndex();

}