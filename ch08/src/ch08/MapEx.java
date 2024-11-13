package ch08;

import java.util.HashMap;
import java.util.Iterator;

public class MapEx {

	public static void main(String[] args) {
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("고양이", "01012345678");
		hm.put("강아지", "01019970922");
		hm.put("여우", "01019970922");
	
	
	Iterator<String> it = hm.keySet().iterator();
	
	while(it.hasNext()) {
		String key = it.next();
		System.out.println(key);
	}
	}
}
