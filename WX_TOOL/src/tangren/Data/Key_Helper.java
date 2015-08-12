package tangren.Data;

import java.util.HashMap;
import java.util.Map;

import tangren.json.JsonHelper;
import tangren.net.HttpRequestorHelper;

/*
 * 获取请求中各项数据
 * 
 * 
 */
public class Key_Helper {
	
	
	private static HttpRequestorHelper httpRequestorHelper=new HttpRequestorHelper();
	
	
	
	public static String get_access_token_with_key(String AppID,String AppSecret){
		
		String get_access_token_url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+AppID+"&secret="+AppSecret;
		return get_access_token(get_access_token_url);
	}
	public static String get_access_token(String url){
		
		String JsonResult="";
		Map map=new HashMap<>();
		String access_token="";
		try {
			JsonResult=httpRequestorHelper.doGet(url);
			map=JsonHelper.toMap(JsonResult);
			access_token=(String) map.get("access_token");
			//System.out.println(access_token+"key_Helper");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
//		System.out.println(access_token);
		
		return access_token;
	}
	
	

}
