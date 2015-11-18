package authoring_environment.room;

import structures.data.DataView;
import java.util.ResourceBundle;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class RoomView {
	private DataView myDataView;
	private DoubleProperty myWidth;
	private DoubleProperty myHeight;
	private DoubleProperty myX;
	private DoubleProperty myY;
	
	public RoomView(DataView view, DoubleProperty x, DoubleProperty y) {
		myDataView = view;
		myWidth = new SimpleDoubleProperty();
		myHeight = new SimpleDoubleProperty();
		myWidth.set(myDataView.getView().width());
		myHeight.set(myDataView.getView().height());
		myX = x;
		myY = y;
		addListeners();
	}
	
	public DataView getDataView() {
		return myDataView;
	}
	
	public double getWidth() {
		return myWidth.get();
	}
	
	public double getHeight() {
		return myHeight.get();
	}
	
	public double getX() {
		return myX.get();
	}
	
	public double getY() {
		return myY.get();
	}
	
	private void addListeners() {
		myWidth.addListener(dataViewListener());
		myHeight.addListener(dataViewListener());
		myX.addListener(dataViewListener());
		myY.addListener(dataViewListener());
	}
	
	private ChangeListener<? super Number> dataViewListener() {
		ChangeListener<? super Number> listener = new ChangeListener<Number>() {
			
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				updateDataViewObject();
			}
		};
		return listener;
	}
	
	private void updateDataViewObject() {
		myDataView.setView(new utils.Rectangle(myX.get(), myY.get(), myWidth.get(), myHeight.get()));
	}
}
