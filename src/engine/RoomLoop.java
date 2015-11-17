package engine;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import structures.run.RunRoom;

public class RoomLoop {
	
	private Timeline myGameLoop;
	private EventManager eventManager;
	private RunRoom myRoom;
	private IDraw drawingListener;
	
	public RoomLoop(RunRoom room, IGamePlayHandler listener, IDraw drawListener){
		myRoom = room;
		drawingListener = drawListener;
		eventManager = new EventManager(room, listener);
		createRoomLoop();
	}
	
	public void createRoomLoop(){
		
		final Duration oneFrameAmt = Duration.millis(5000);
        final KeyFrame oneFrame = new KeyFrame(oneFrameAmt,
                                               new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                step();
                draw();

            }
        });
		
		Timeline animation = new Timeline();
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(oneFrame);
		myGameLoop = animation;
		
	}
	
	public void step() {
		eventManager.loop();
	}
	
	public void draw(){
		drawingListener.draw(myRoom);
	}
	
	public void start(){
		myGameLoop.play();
	}

}
