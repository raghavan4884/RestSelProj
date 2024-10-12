package com.test.utilities;

import org.json.simple.JSONObject;

public class JSONUtil {
	
	public String putJsonString(String jsonKey,String jsonValue)
	{
		JSONObject js=new JSONObject();
		js.put(jsonKey,jsonValue);
		return js.toJSONString();
	}
	public String getJsonValue(String jsonKey)
	{
		JSONObject js=new JSONObject();
		String jsonValue=(String) js.get(jsonKey);
		return jsonValue;
	}

}
