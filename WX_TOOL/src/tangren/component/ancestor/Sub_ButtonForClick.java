package tangren.component.ancestor;

import java.util.List;
import java.util.Map;

import tangren.button.factory.entity.ButtonEntity;

public class Sub_ButtonForClick implements ButtonEntity{

	private String name;
	private String type;
	private String key;


	@Override
	public Map analysisToMap() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public Map analysisToMapForSub() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getUrl() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setUrl(String url) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getMedia_id() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setMedia_id(String media_id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List getButtonList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setButtonList(List buttonList) {
		// TODO Auto-generated method stub
		
	}
	

}
