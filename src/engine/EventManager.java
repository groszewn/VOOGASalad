package engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import structures.data.events.IDataEvent;
import structures.run.RunObject;
import structures.run.RunRoom;

public class EventManager {
	
	private RunRoom myRoom;
	private IGamePlayHandler inputs;
	
	private Map<IDataEvent, ArrayList<RunObject>> myEvents;
	private EventFactory myEventFactory;
	
	public EventManager(RunRoom room, IGamePlayHandler inputs){
		myRoom = room;
		myEventFactory = new EventFactory();
		
		myEvents = new HashMap<IDataEvent, ArrayList<RunObject>>();
		
		for(RunObject o : room.getObjects()){
			for(IDataEvent e : o.getEvents()){
				if(!myEvents.containsKey(e)){
					myEvents.put(e, new ArrayList<RunObject>());
				}
				myEvents.get(e).add(o);
			}
		}
		
		this.inputs = inputs;
	}
	
	void loop() {
		//List<RunObject> it = myGame.getCurrentRoom().getObjects();
		List<RunObject> it = new ArrayList<RunObject>();
		step(it);
		processEvents(inputs.getEvents());
	}
	
	private void step(List<RunObject> it) {
		//call step Events
	}

	private void processEvents(Queue<InputEvent> events){
		for(InputEvent e : events){
			IDataEvent runEvent = myEventFactory.getEvent(e);
			//execute events in myEvents.get(runEvent);
		}
		events.clear();
	}

}
