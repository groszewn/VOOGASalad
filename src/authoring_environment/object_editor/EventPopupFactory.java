package authoring_environment.object_editor;


import java.lang.reflect.InvocationTargetException;
import java.util.List;

import authoring_environment.ObjectPopUps.CollisionPopUp;
import authoring_environment.ObjectPopUps.GameEndPopUp;
import authoring_environment.ObjectPopUps.GameStartPopUp;
import authoring_environment.ObjectPopUps.GlobalMousePressedPopUp;
import authoring_environment.ObjectPopUps.KeyPressedPopUp;
import authoring_environment.ObjectPopUps.KeyReleasedPopUp;
import authoring_environment.ObjectPopUps.LeaveRoomPopUp;
import authoring_environment.ObjectPopUps.ObjectCreatePopUp;
import authoring_environment.ObjectPopUps.ObjectDestroyPopUp;
import authoring_environment.ObjectPopUps.ObjectMousePressedPopUp;
import authoring_environment.ObjectPopUps.PopUp;
import authoring_environment.ObjectPopUps.StepPopUp;
import javafx.collections.ObservableList;
import structures.data.DataObject;
import structures.data.actions.params.IParameter;
import structures.data.interfaces.IAction;

public class EventPopupFactory {
	PopUp kp;
	public void create(String event,DataObject obj, ObservableList<DataObject> list) {
		//		if (event.equalsIgnoreCase("Collision Event")) {
		//
		//		}
		if (event.equalsIgnoreCase("Game End Event")) {
			kp = new GameEndPopUp(obj);
		}
		if (event.equalsIgnoreCase("Collision Event")) {
			kp = new CollisionPopUp(obj,list);
		}
		if (event.equalsIgnoreCase("Game Start Event")) {
			kp = new GameStartPopUp(obj);
		}
		if (event.equalsIgnoreCase("Key Pressed Event")) {
			kp = new KeyPressedPopUp(obj);
		}
		if (event.equalsIgnoreCase("Key Released Event")) {
			kp = new KeyReleasedPopUp(obj);
		}
		if (event.equalsIgnoreCase("Object Create Event")) {
			kp = new ObjectCreatePopUp(obj);
		}
		if (event.equalsIgnoreCase("Object Destroy Event")) {
			kp = new ObjectDestroyPopUp(obj);
		}
		if (event.equalsIgnoreCase("Global Mouse Pressed Event")) {
			kp = new GlobalMousePressedPopUp(obj);
		}
		if (event.equalsIgnoreCase("Object Mouse Pressed Event")) {
			kp = new ObjectMousePressedPopUp(obj);
		}
		if (event.equalsIgnoreCase("Step Event")) {
			kp = new StepPopUp(obj);
		}
		if (event.equalsIgnoreCase("Leave Room Event")) {
			kp = new LeaveRoomPopUp(obj);
		}

		//	}
	}
}

//
//	public void createPopup(String event,DataObject obj, ObservableList<DataObject> list){
//
//		String className = (event.substring(0, event.lastIndexOf(" ")).replaceAll("\\s+","")+"PopUp");
//		Class c=null;
//		PopUp act  =null;
//		try {
//			c = Class.forName("authoring_environment.ObjectPopUps." +className);
//
//		} catch (ClassNotFoundException e) {
//		}
//		try {
//			 act = (PopUp) c.getDeclaredConstructor().newInstance(obj);
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalArgumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//		} catch (NoSuchMethodException e) {
//			 try {
//				act = (PopUp) c.getDeclaredConstructor().newInstance(obj,list);
//			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
//					| InvocationTargetException | NoSuchMethodException | SecurityException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			e.printStackTrace();
//		} catch (SecurityException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		}
//
////
//}

