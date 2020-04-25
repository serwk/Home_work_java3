package HomeWork6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CheckArrayTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,4,4,1,4,4,1,4,1},1,4, true},
                {new int[]{2,3,7,0,9,5,8,2,3},1,4, false}
        });
    }

    private int[] arr;
    private int a;
    private int b;
    private boolean result;

    public CheckArrayTest(int[] arr, int a, int b, boolean result) {
        this.arr = arr;
        this.a = a;
        this.b = b;
        this.result = result;
    }

    CheckArray checkArray;

    @Before
    public void init() {
        checkArray = new CheckArray();
        checkArray.setArr(arr);
    }

    @Test
    public void getArrAfterNumberTest() {
        Assert.assertEquals(result, checkArray.containsOnly(a, b));
    }
}
