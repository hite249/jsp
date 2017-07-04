package com.test.ioc.ch4;

import java.util.HashMap;

public class AppMap {
	HashMap<String, Object> appMap = new HashMap();
	
	public void setBean(String key,Object value){
		appMap.put(key, value);
	}
	
	public Object getBean(String key){
		return appMap.get(key);
	}

}
