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

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != a || arr[i] != b) {
                return false;
            }
        }
        return true;
    }
}
