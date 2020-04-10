package HomeWork1;

import java.util.Arrays;

public class Task1 {

    public static void main(String[] args) {
        String[] strings = {"apple", "banana", "chery", "melon", "potato"};
        swap(strings,1, 2);

        Integer[] ints = {1, 2, 3, 4};
        swap(ints,1, 2);
    }

    public static <T> void swap(T[] array, int ind1, int ind2) {
        if (ind1 < 0 || ind1 > array.length - 1) {
            System.out.println("index 1 is not correct");
            return;
        }
        if (ind2 < 0 || ind2 > array.length - 1) {
            System.out.println("index 2 is not correct");
            return;
        }
        T temp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = temp;

        System.out.println(Arrays.toString(array));
    }
}

