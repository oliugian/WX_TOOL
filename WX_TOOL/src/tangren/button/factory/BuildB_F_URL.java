package tangren.button.factory;

import tangren.button.factory.entity.ButtonEntity;
import tangren.button.factory.entity.ButtonForURL;

public class BuildB_F_URL implements ButtonProvider{

	@Override
	public ButtonEntity Build() {
		// TODO Auto-generated method stub
		return new ButtonForURL();
	}

}
