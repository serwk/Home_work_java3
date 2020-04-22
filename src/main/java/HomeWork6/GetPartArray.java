package HomeWork6;

// Task 1
public class GetPartArray {

    public int[] getArrAfterNumber(int[] arr, int num) throws RuntimeException{

        int lastInd = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                lastInd = i;
            }
        }

        if (lastInd == -1){
            throw new RuntimeException("Number " + num + " not found");
        } else {
            int[] newArr = new int[arr.length-lastInd];
            for (int i = 0; i < newArr.length; i++) {
                newArr[i] = arr[i+lastInd+1];
            }
            return newArr;
        }
    }
}
