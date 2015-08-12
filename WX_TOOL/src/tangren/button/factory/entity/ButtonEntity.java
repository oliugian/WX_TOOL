package tangren.button.factory.entity;

import java.util.List;
import java.util.Map;

public interface ButtonEntity {
	public String getName();
	public void setName(String name);
	
	public String getType();
	public void setType(String type);
	
	public String getKey();
	public void setKey(String key);
	
	public String getUrl();
	public void setUrl(String url);
	
	public String getMedia_id();
    public void setMedia_id(String media_id);
	
	public List getButtonList();


	public void setButtonList(List buttonList);
	public Map analysisToMap(); 
	public Map analysisToMapForSub();

}
