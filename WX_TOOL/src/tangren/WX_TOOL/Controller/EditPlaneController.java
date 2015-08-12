package tangren.WX_TOOL.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import tangren.Model.ButtonModel;
import tangren.button.factory.entity.ButtonEntity;
import tangren.component.GUI.EditPanel;
import tangren.component.GUI.KeyAccessPanel;
import tangren.json.JsonHelper;
import tangren.net.HttpRequestorHelper;
import tangren.net.WeixinUtil;

public class EditPlaneController {
	private ArrayList<ButtonModel> allButtons=new ArrayList<>(18);
	private List<Map> resultLists=new ArrayList<>();
	
	public EditPlaneController(){
		this.allButtons=EditPanel.getAllButtons();
	}
	public List handleAllButtons(){
        int b[]={0,6,12};
        for(int i=0;i<b.length;i++){
        	int b_0=allButtons.get(b[i]).getType();
        	if(b_0!=-1){
        		ButtonEntity b_Sub=allButtons.get(b[i]).getButton();
            	Map BM;
        		if(b_0==3){
        			
        			b_Sub.setName(allButtons.get(b[i]).getButton().getName());
        			b_Sub.setButtonList(addToResult(b[i]));
        			BM=b_Sub.analysisToMap();
        		}else{
        			BM=b_Sub.analysisToMap();
        		}
        		resultLists.add(BM);
        	}
        
        }
        return resultLists;
        
		
	}
    public static String toJoson(List ButtonsList){
    	JSONObject jo=new JSONObject();
    	JSONArray ja=JSONArray.fromObject(ButtonsList);
    	jo.put("button", ja);
    	System.out.println(jo.toString());
    	return jo.toString();
    }
	
	private List  addToResult(int index){
		 		
		int begin=0;
		int end=0;
		if(index==0){
			begin=1;
			end=6;
		}else if(index==6){
			begin=7;
			end=12;
		}else if(index==12){
			begin=13;
			end=18;
		}
			List ButtonList=new ArrayList<>();			
			for(int i=end-1;i>=begin;i--){
				int bType=allButtons.get(i).getType();
                if(bType!=-1){
                	ButtonEntity bE=allButtons.get(i).getButton();
                	Map mT=bE.analysisToMapForSub();
                	ButtonList.add(mT);                	
				}		
			}
			return ButtonList;
			
	}
	
	public int saveWXMenu(){
		String jsonData=toJoson(handleAllButtons());
		String access_token=KeyAccessPanel.getAccess_token();
		if(access_token==null){
			return 1;
		}
		WeixinUtil weixinUtil=new WeixinUtil();
		try {
			int resultCode=(int) weixinUtil.httpRequest("https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+access_token, "POST", jsonData).get("errcode");
//		    System.out.println(resultCode);
			return resultCode;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return 10;
		}	
		
	}
	

}
