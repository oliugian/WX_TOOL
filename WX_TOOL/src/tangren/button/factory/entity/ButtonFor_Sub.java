package tangren.button.factory.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ButtonFor_Sub implements ButtonEntity{
	


	private String name;
	private List ButtonList=new ArrayList<>();
	
	@Override
	public Map analysisToMap() {
		// TODO Auto-generated method stub
		Map map=new HashMap();
		map.put("name", this.getName());
		map.put("sub_button",this.getButtonList());
		return map;
	}
	@Override
	public Map analysisToMapForSub() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List getButtonList() {
		return ButtonList;
	}


	public void setButtonList(List buttonList) {
		ButtonList = buttonList;
	}
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setType(String type) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setKey(String key) {
		// TODO Auto-generated method stub
		
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



	



}
