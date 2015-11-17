package structures.data.actions.library;

import structures.data.actions.DataAction;

public class Open extends DataAction {

	public Open(){
		
	}
	
	@Override
	public String getTitle() {
		return "Open";
	}

	@Override
	public String getDescription() {
		return "open a block statement";
	}

	@Override
	protected String getSyntax() {
		return "{";
	}

}