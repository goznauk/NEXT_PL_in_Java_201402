package goznauk.No5;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by goznauk on 2014. 9. 24..
 */
public class TreeMapTest {
    public void main() {
        Map<String, String> map = new TreeMap<String, String>() {
            @Override
            public String get(Object key) {
                return key.toString();
            }

            @Override
            public String put(String key, String value) {
                return super.put(value, key);
            }
        };
        map.put("1", "이도호");
        map.put("2", "최훈존");
        map.put("3", "조성환");
        map.put("4", "김기렴");
        map.put("5", "김중일");


        //출력코드 작성
        Iterator<String> isKey = map.keySet().iterator();

        while(isKey.hasNext()) {
            System.out.println(map.get(isKey.next()));
        }
    }
}

