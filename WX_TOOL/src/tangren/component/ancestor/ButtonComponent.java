package tangren.component.ancestor;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public abstract class ButtonComponent {
	

    List<Map> ButtonList = new ArrayList<Map>();
	
	public List getButtonList(){
		return ButtonList;
	}

}
