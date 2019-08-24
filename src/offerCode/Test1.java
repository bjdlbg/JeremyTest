package offerCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 只出现一次的字符
 */
public class Test1 {
    public static int firstNotRepeatingChar(String s){
        if (s==null||s.length()<1)
            return -1;
        //使用map存取对应的字符和出现的次数
        Map<Character,Integer> map=new HashMap<>();
        //转换为字符数组
        char[] arr=s.toCharArray();
        for (int i=0;i<arr.length;i++){
            //看是否包含重复的Key，重复一次修改一次val
            if (!map.containsKey(arr[i])){
                map.put(arr[i],i);
            }else {
                map.put(arr[i],10001);
            }
        }
        int index=10001;
        for (Map.Entry<Character,Integer> entry : map.entrySet()){
            if (entry.getValue()<index){
                index=entry.getValue();
            }
        }
        return  index==10001? -1:index;
    }

    public static void main(String[] args) {

    }
}
