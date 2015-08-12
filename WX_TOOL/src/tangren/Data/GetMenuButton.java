package tangren.Data;


import java.util.ArrayList;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import tangren.Model.ButtonModel;
import tangren.button.factory.entity.ButtonEntity;
import tangren.button.factory.entity.ButtonForClick;
import tangren.button.factory.entity.ButtonForMedia;
import tangren.button.factory.entity.ButtonForURL;
import tangren.button.factory.entity.ButtonFor_Sub;
import tangren.net.HttpRequestorHelper;
import tangren.net.WeixinUtil;

public class GetMenuButton {
	private static HttpRequestorHelper httpRequestorHelper=new HttpRequestorHelper();
	private static WeixinUtil weixinUtil=new WeixinUtil();
	private static String url="https://api.weixin.qq.com/cgi-bin/menu/get?access_token=";
	private ArrayList<ButtonModel>allMenuButtons=new ArrayList<>();
	public  ArrayList<ButtonModel> getMenuButton(String access_token){
		JSONObject JsonResult;
		String getMBURL=url+access_token;
		System.out.println(getMBURL+"getMenuButton");
		try {
			JsonResult=weixinUtil.httpRequest(getMBURL, "GET", "");
			return MenuJSONManage(JsonResult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	private  ArrayList<ButtonModel> MenuJSONManage(JSONObject MBData){
		//JSONObject jsonObject=new JSONObject(MBData);
		if(MBData.get("menu")!=null){
			MBData=(JSONObject) MBData.get("menu");
		}
		
		JSONArray jsonArray=JSONArray.fromObject(MBData.getJSONArray("button").toString());
		
		for(int i=0;i<jsonArray.size();i++){
			JSONObject jObject=jsonArray.getJSONObject(i);
			if(jObject.get("type")!=null){
				if(jObject.get("key")!=null){
					saveKeyButton(jObject, 1);	
				}else if(jObject.get("url")!=null){
					saveURLButton(jObject, 1);
				}else if(jObject.get("media_id")!=null){
					saveMediaButton(jObject, 1);
				}				
			}else{
				saveSubButton(jObject, 1);
				JSONArray jsonArray2=JSONArray.fromObject(jObject.get("sub_button"));	
				for(int j=0;j<jsonArray2.size();j++){
					JSONObject jObject2=jsonArray2.getJSONObject(j);

						if(jObject2.get("key")!=null){
							saveKeyButton(jObject2, 2);	
						}else if(jObject2.get("url")!=null){
							saveURLButton(jObject2, 2);
						}else if(jObject2.get("media_id")!=null){
							saveMediaButton(jObject2, 2);
						}	
					
				}
			}
		}
		
		return allMenuButtons;
		
	}

    private  void saveKeyButton(JSONObject MBData,int layer){
    	ButtonEntity bTemp=new ButtonForClick();
		bTemp.setKey(MBData.getString("key"));
		bTemp.setName(MBData.getString("name"));
		bTemp.setType(MBData.getString("type"));
		ButtonModel bM=new ButtonModel();
		bM.setButton(bTemp, 0);
		bM.setLayer(layer);
		allMenuButtons.add(bM);
    }
    private  void saveURLButton(JSONObject MBData,int layer){
    	ButtonEntity bTemp=new ButtonForURL();
		bTemp.setUrl(MBData.getString("url"));
		bTemp.setName(MBData.getString("name"));
		bTemp.setType(MBData.getString("type"));
		ButtonModel bM=new ButtonModel();
		bM.setButton(bTemp, 1);
		bM.setLayer(layer);
		allMenuButtons.add(bM);
    }
    private  void saveMediaButton(JSONObject MBData,int layer){
    	ButtonEntity bTemp=new ButtonForMedia();
		bTemp.setMedia_id(MBData.getString("media_id"));
		bTemp.setName(MBData.getString("name"));
		bTemp.setType(MBData.getString("type"));
		ButtonModel bM=new ButtonModel();
		bM.setButton(bTemp, 2);
		bM.setLayer(layer);
		allMenuButtons.add(bM);
    }
    private  void saveSubButton(JSONObject MBData,int layer){
    	ButtonEntity bTemp=new ButtonFor_Sub();
		bTemp.setName(MBData.getString("name"));
		ButtonModel bM=new ButtonModel();
		bM.setButton(bTemp, 3);
		bM.setLayer(1);
		allMenuButtons.add(bM);
    }


}
