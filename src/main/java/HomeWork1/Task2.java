package HomeWork1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        String[] strings = {"apple", "banana", "chery", "melon", "potato"};
        Integer[] ints = {1, 2, 3, 4};

        arrayToArrayList(strings);
        arrayToArrayList(ints);
    }

    public static <T> void arrayToArrayList(T[] array){
        List<T> list = new ArrayList<>();
        Collections.addAll(list,array);
        System.out.println(list.toString());
    }
}


