package structures.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import structures.data.access_restricters.IObjectInterface;
import structures.data.actions.IAction;
import structures.data.events.IDataEvent;

import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

//TODO check if IObjectInterface is being used
public class DataGame extends Observable implements IObjectInterface, IDataGame {

    public static final String SPRITE_REL_DIRECTORY = "/resources/";
    public static final String SOUND_REL_DIRECTORY = "/sounds/";
    private static final int DEFAULT_VIEW_SIZE = 600;
    ObservableList<DataRoom> myRooms;
    ObservableList<DataObject> myObjects;
    ObservableList<DataSprite> mySprites;
    ObservableList<DataSound> mySounds;
    private String myName, myGameDirectory;
    private int myStartRoom, myCurrentRoom;
    private int myViewWidth, myViewHeight;
    private double myHighScore;
    private ResourceBundle fileFormat = ResourceBundle.getBundle("resources/GameFileFormat");

    public DataGame(String name, String gameDirectory) {
        myName = name;
        myGameDirectory = gameDirectory;
        myRooms = FXCollections.observableArrayList();
        myObjects = FXCollections.observableArrayList();
        mySprites = FXCollections.observableArrayList();
        mySounds = FXCollections.observableArrayList();
        myViewWidth = DEFAULT_VIEW_SIZE;
        myViewHeight = DEFAULT_VIEW_SIZE;
        myHighScore = 0;
        myCurrentRoom = 0;
    }

    public String getName() {
        return myName;
    }

    public int getViewWidth() {
        return myViewWidth;
    }

    public void setViewWidth(int width) {
        myViewWidth = width;
    }

    public int getViewHeight() {
        return myViewHeight;
    }

    public void setViewHeight(int height) {
        myViewHeight = height;
    }

    public double getHighScore() {
        return myHighScore;
    }

    public void setHighScore(double highScore) {
        myHighScore = highScore;
    }

    public ObservableList<DataRoom> getRooms() {
        return myRooms;
    }

    public String getGameDirectory() {
        return myGameDirectory;
    }

    public DataRoom getStartRoom() {
        return myRooms.get(myStartRoom);
    }

    public void setStartRoom(int index) {
        myStartRoom = index;
        myCurrentRoom = index;
    }

    public void setStartRoom(DataRoom room) {
        if (myRooms.contains(room)) {
            myStartRoom = myRooms.indexOf(room);
            myCurrentRoom = myStartRoom;
        }
    }

    public DataRoom getCurrentRoom() {
        return myRooms.get(myCurrentRoom);
    }

    public void setCurrentRoom(int index) {
        myCurrentRoom = index;
    }

    public void setCurrentRoom(DataRoom room) {
        if (myRooms.contains(room)) {
            myCurrentRoom = myRooms.indexOf(room);
        }
    }

    public DataSprite getSpriteFromString(String spriteName){
        for(DataSprite s : mySprites){
            if(s.getName().equals(spriteName)){
                return s;
            }
        }
        System.out.println("-Sprite not found");
        return null;
    }

    public DataObject getObjectFromString(String objectName){
        for(DataObject o : myObjects){
            if(o.getName().equals(objectName)){
                return o;
            }
        }
        System.out.println("-Object not found");
        return null;
    }

    public int getStartRoomIndex() {
        return myStartRoom;
    }

    public int getCurrentRoomIndex() {
        return myCurrentRoom;
    }

    public String getSpriteDirectory() {
        return myGameDirectory + fileFormat.getString("RelativeSpriteDirectory");
    }

    public String getSoundDirectory() {
        return myGameDirectory + fileFormat.getString("RelativeSoundDirectory");
    }

    public void addObject(DataObject... o) {
        myObjects.addAll(o);
        update();
    }

    public void addSprite(DataSprite s) {
        mySprites.add(s);
        update();
    }

    public void addSound(DataSound s) {
        mySounds.add(s);
        update();
    }

    public void addRoom(DataRoom room) {
        myRooms.add(room);
        update();
    }

    public void removeObject(DataObject o) {
        myObjects.remove(o);
        update();
    }

    public ObservableList<DataSprite> getSprites() {
        return mySprites;
    }

    public ObservableList<DataObject> getObjects() {
        return myObjects;
    }

    public ObservableList<DataSound> getSounds() {
        return mySounds;
    }

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        r.append("Game title: " + myName + "\n");

        r.append("Start room: " + getStartRoom().getName() + "\n");
        r.append("Current room: " + getCurrentRoom().getName() + "\n");

        r.append("\n");
        r.append("Objects: \n");

        for (DataObject o : myObjects) {
            r.append("  " + o.getName() + "\n");

            for (ObservableMap.Entry<IDataEvent, ObservableList<IAction>> e : o.getEvents().entrySet()) {

                r.append("      Event: " + e.getKey().getName() + "\n");
                List<IAction> actions = e.getValue();

                for (IAction a : actions) {
                    if(a != null) {
                        r.append("          Action: " + a.getDescription() + "\n");
                    }

                }
            }
        }

        r.append("\n");
        r.append("Sprites: \n");

        for (DataSprite s : mySprites) {
            r.append("  " + s.getName() + "\n");
        }

        r.append("\n");
        r.append("Sounds: \n");

        for (DataSound s : mySounds) {
            r.append("  " + s.getName() + "\n");
        }

        r.append("\n");
        r.append("Rooms: \n");
        for (DataRoom room : myRooms) {
            r.append("  " + room.getName() + "\n");
            for (DataInstance di : room.getObjectInstances()) {
                r.append("      Object Instance: ID: " + di.getID() + " Object type: " + di.getParentObject().getName() + "\n");
            }
        }

        return r.toString();
    }

    private void update() {
        notifyObservers();
    }

}
