package tangren.json;

import java.util.HashMap;
import java.util.Iterator;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;




/** 
 * developer:fcg
 * date:2015/07/30
 * description:json 解析
 * 
 **/

public class JsonHelper {
	
	
	/*
	 * 将Json对象解析为Map
	 * @param json
	 * @return Map
	 * 
	 */
    public static Map toMap(String json) throws JSONException {

        JSONObject jsonObject = new JSONObject(json);
        
        Map result = new HashMap();
        Iterator iterator = jsonObject.keys();
        String key = null;
        String value = null;
        
        while (iterator.hasNext()) {

            key = (String) iterator.next();
            value = jsonObject.getString(key);
            result.put(key, value);

        }
        return result;

    }

    

}
