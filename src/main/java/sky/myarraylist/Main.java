package sky.myarraylist;

import sky.myarraylist.exception.OutOfArrayLimitsException;

import java.security.InvalidParameterException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)  throws OutOfArrayLimitsException, InvalidParameterException {
        ArrayList stringList = new ArrayList();
        stringList.add("String 1");
        stringList.add("String 2");
        stringList.add("String 3");
        stringList.add("String 4");
        stringList.add("String 5");
//        System.out.println(stringList.add("String 4"));
//        String item = "New String";
//        System.out.println(stringList.add(item));
//        System.out.println(stringList.add(3, item));
        System.out.println(Arrays.toString(stringList.allArray()));
        System.out.println("stringList.size() = " + stringList.size());

//        stringList.add(3, item);
//        stringList.set(2, item);
//        stringList.remove(2);
//        System.out.println(Arrays.toString(stringList.allArray()));
//        System.out.println("stringList.size() = " + stringList.size());
//        System.out.println("String 4 = " + stringList.contains("String 1"));
//        System.out.println("String 2 = " + stringList.indexOf("String 2"));
//        System.out.println("String 2 = " + stringList.lastIndexOf("String 1"));

//        System.out.println(stringList.remove("String 1"));
//        System.out.println(stringList.remove("String 7"));
//        System.out.println(stringList.get(3));
//       ArrayList stringList2 = new ArrayList();
//        stringList2.add("String 1");
//        stringList2.add("String 2");
//        stringList2.add("String 3");
//        stringList2.add("String 4");
//        stringList2.add("String 5");
//        System.out.println(Arrays.toString(stringList2.allArray()));
//        System.out.println("stringList2.size() = " + stringList2.size());
//        ArrayList stringList2 = null;
//        System.out.println(stringList.equals(stringList2));
//        System.out.println(stringList2.isEmpty());
//        stringList.clear();
//        System.out.println(Arrays.toString(stringList.allArray()));
//        System.out.println("stringList.size() = " + stringList.size());
//        String[] newList = stringList.toArray();
//        stringList.set(2, "New Line");
//        System.out.println(Arrays.toString(stringList.toArray()));
//        System.out.println(Arrays.toString(newList));



    }
}