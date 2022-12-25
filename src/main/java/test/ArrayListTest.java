package test;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        List<String> tmpList = new ArrayList<>(){{
            add("Hello");
            add("My");
            add("Son");
        }};
        for (String str : tmpList) {
            if (str.equals("Hello")) {
                tmpList.remove("Hello");
            }
            System.out.println(tmpList+"\n"+str);
        }

    }
}
