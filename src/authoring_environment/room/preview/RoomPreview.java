package authoring_environment.room.preview;

import java.util.ResourceBundle;

import authoring_environment.room.RoomController;
import authoring_environment.room.configure_popup.ConfigureView;
import authoring_environment.room.object_instance.DraggableImage;
import javafx.geometry.Point2D;

import javafx.scene.control.ScrollPane;

import javafx.scene.image.*;


public class RoomPreview extends ScrollPane {
	private static final String PREVIEW_HEIGHT = "PreviewHeight";
	private static final String PREVIEW_WIDTH = "PreviewWidth";
	
	private RoomCanvas myCanvas;
	
	public RoomPreview(ResourceBundle resources) {
		super();
		initializePreview(resources);
		myCanvas = new RoomCanvas(resources);
		super.setContent(myCanvas);
	}
	
	private void initializePreview(ResourceBundle resources) {
		super.setPrefHeight(Double.parseDouble(resources.getString(PREVIEW_HEIGHT)));
		super.setPrefWidth(Double.parseDouble(resources.getString(PREVIEW_WIDTH)));
		this.setHbarPolicy(ScrollBarPolicy.ALWAYS);
		this.setVbarPolicy(ScrollBarPolicy.ALWAYS);
	}
	
	public RoomCanvas getCanvas() {
		return myCanvas;
	}
	
	public Point2D translateSceneCoordinates(Point2D scenePoint) {
		return myCanvas.sceneToLocal(scenePoint);
	}

//	public void addImage(DraggableImage element, ConfigureView popup) {
//		myCanvas.addNodeToMap(element, popup);
//	}
	
	public void addImage(DraggableImage element) {
		myCanvas.addNodeToMap(element);
	}

}