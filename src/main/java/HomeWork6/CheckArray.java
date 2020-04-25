package HomeWork6;

// Task 2
public class CheckArray {
    private int[] arr;

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public boolean containsOnly(int a, int b) {
        if (arr.length==0){
            return false;
        }

        boolean containsA = false;
        boolean containsB = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == a){
                containsA = true;
            } else if (arr[i] == b){
                containsB = true;
            } else {
                return false;
            }
        }
        return containsA && containsB;
    }
}
