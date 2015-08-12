package tangren.button.factory;

import tangren.button.factory.entity.ButtonEntity;
import tangren.button.factory.entity.ButtonForClick;

public class Build_B_F_C implements ButtonProvider{

	@Override
	public ButtonEntity Build() {
		// TODO Auto-generated method stub
		return new ButtonForClick();
	}
	
	
}
