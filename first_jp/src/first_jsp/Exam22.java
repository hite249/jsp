package first_jsp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Exam22 {
	public static void main(String[]args){
		List<User> list = new ArrayList<User>();
		for(int i = 0;i<3;i++){
			User u = new User();
			u.setAdmin(i);
			u.setAge(i+20);
			u.setUser_name("홍길동"+i);
			list.add(u);
			
		}
		System.out.println(list.size());
		for(int i=0;i<list.size();i++){
			User u = list.get(i);
			System.out.println(u.getUser_name());
		}
		for(User u : list){
			System.out.println(u.getUser_name());
		}
		Iterator<?> iterator =list.iterator();
		
		while(iterator.hasNext()){
			Object o = iterator.next();
			if(o instanceof User){
				User u = (User)o;
				
			}
		}
			
				
	}
}
