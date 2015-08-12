package tangren.button.factory.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ButtonForMedia implements ButtonEntity{

	private String name;
	private String type;
	private String media_id;

	@Override
	public Map analysisToMap() {
		// TODO Auto-generated method stub
		Map<String,String> map=new HashMap<String,String>();
		map.put("name", this.getName());
		map.put("type",this.getType());
		map.put("media_id", this.getMedia_id());
		return map;
		
	}
	@Override
	public Map analysisToMapForSub() {
		// TODO Auto-generated method stub
		Map map=new HashMap();
		Map<String,String> map1=new HashMap<String,String>();
		map.put("name", this.getName());
		map.put("type",this.getType());
		map.put("media_id", this.getMedia_id());
		map.put("sub_button", map1);
		return map;
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

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
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
	public List getButtonList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setButtonList(List buttonList) {
		// TODO Auto-generated method stub
		
	}
	

}
