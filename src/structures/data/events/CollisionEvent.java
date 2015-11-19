package structures.data.events;


import structures.data.DataObject;

public class CollisionEvent implements IDataEvent {

    public final DataObject other;
    public final String otherName;

    public CollisionEvent(DataObject other){
        this.other = other;
        this.otherName = null;
    }

    public CollisionEvent(String other) {
    	this.other = null;
    	this.otherName = other;
    }

    public String otherName() {
    	return this.other == null ? otherName : this.other.getName();
    }

    @Override
    public int hashCode() {
    	return this.getClass().hashCode() ^ otherName().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
    	if (this.getClass().equals(obj.getClass())) {
    		if (otherName().equals(((CollisionEvent)obj).otherName())) {
    			return true;
    		}
    	}
    	return false;
    }

	@Override
	public String getName() {
		return String.format("Collision with ", other.getName());
	}


	@Override
    public String toString(){
    	return "Collision with " + other.toString();
    }
}
