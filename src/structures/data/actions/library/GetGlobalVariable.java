package structures.data.actions.library;

import structures.data.actions.DataAction;
import structures.data.actions.params.DoubleParam;
import structures.data.actions.params.StringParam;

public class GetGlobalVariable extends DataAction {
	
	public GetGlobalVariable(){
		init(new StringParam("VariableKey"), new StringParam("VariableOperation"), new DoubleParam("VariableValueCheck"));
	}

	@Override
	public String getTitle() {
		return "GetGlobalVariable";
	}

	@Override
	public String getDescription() {
		return String.format("if %s is %s %.2f", get("VariableKey"), get("VariableOperation"), get("VariableValueCheck"));
	}

	@Override
	protected String getSyntax() {
		return "if (library.get_variable('%s') %s %f)";
	}

}