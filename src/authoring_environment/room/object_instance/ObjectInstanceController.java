package authoring_environment.room.object_instance;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.image.Image;
import structures.data.DataInstance;
import structures.data.DataObject;

public class ObjectInstanceController {
	private DraggableImage view;
	private DataInstance model;
	private DoubleProperty myX;
	private DoubleProperty myY;

	public ObjectInstanceController(Image sprite, DataObject object, DoubleProperty x, DoubleProperty y) {
		model = new DataInstance(object, x.get(), y.get());
		view = new DraggableImage(sprite, x, y, model.getAngle());
		myX = x;
		myY = y;
		addListeners();
	}
	
	public ObjectInstanceController(DataInstance dataInstance) {
		myX = new SimpleDoubleProperty();
		myY = new SimpleDoubleProperty();
		myX.set(dataInstance.getX());
		myY.set(dataInstance.getY());
		view = new DraggableImage(dataInstance.getImage(), myX, myY, dataInstance.getAngle());
		model = dataInstance;
		addListeners();
	}
	
	public double getX() {
		return myX.get();
	}
	
	public double getY() {
		return myY.get();
	}
	
	private void addListeners() {
		myX.addListener(dataInstanceListener());
		myY.addListener(dataInstanceListener());
	}
	
	private ChangeListener<? super Number> dataInstanceListener() {
		ChangeListener<? super Number> listener = new ChangeListener<Number>() {
			
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				updateDataInstancePosition();
			}
		};
		return listener;
	}
	
	private void updateDataInstancePosition() {
		model.setPosition(myX.get(), myY.get());
	}
	
	public DraggableImage getDraggableImage() {
		return view;
	}
	
	public DataInstance getDataInstance() {
		return model;
	}
}
