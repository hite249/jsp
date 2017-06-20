import java.util.HashMap;
import java.util.Map;

public class MapTest {
	
	public static void main(String[] args){
		Map<String, String> m =new HashMap<String, String>();
		m.put("1", "홍길동");
		m.put("2", "김철수");
		m.put("3", "동동이");
	
		System.out.println(m.get("1"));
		m.put("1", "라라라");
		System.out.println(m.get("1"));
		
		if(m.containsKey("4")){
			System.out.println(m.get("4"));
		}else{
			System.out.println("존재하지않는값입니다.");
		}

	
	}
}
