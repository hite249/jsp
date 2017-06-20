package util;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;



public class Cookies {
	private Map<String, Cookie> cookieMap=
			new java.util.HashMap<String, Cookie>();
	
	
		
	public Map<String, Cookie> getCookieMap() {
		return cookieMap;
	}
	public void setCookieMap(Map<String, Cookie> cookieMap) {
		this.cookieMap = cookieMap;
	}

	
	public Cookies(HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		if(cookies !=null){
			for(int i=0; i<cookies.length;i++){
				cookieMap.put(cookies[i].getName(), cookies[i]);
			}
		}
	}
		public Cookie getCookie(String name) {
			return cookieMap.get(name);
		
		}
		
		public String getValue(String name) throws IOException {
			Cookie cookie = cookieMap.get(name);
			if (cookie == null) {
				return null;
			}
			return URLDecoder.decode(cookie.getValue(), "utf-8");
		}


		
		
	}


