package HomeWork6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class GetPartArrayTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[]{1,2,4,4,2,3,4,1,7},4,new int[]{1,7}},
                {new int[]{1,2,4,4,2,3,0,1,7},4,new int[]{2,3,0,1,7}},
                {new int[]{1,2,4,4,2,4,8,1,7},4,new int[]{8,1,7}}
        });
    }

    private int[] inArr;
    private int num;
    private int[] result;

    public GetPartArrayTest(int[] inArr, int num, int[] result) {
        this.inArr = inArr;
        this.num = num;
        this.result = result;
    }

    GetPartArray getPartArray;

    @Before
    public void init() {
        getPartArray = new GetPartArray();
    }

    @Test
    public void getArrAfterNumberTest() {
        Assert.assertTrue("Arrays are not equals", Arrays.equals(result, getPartArray.getArrAfterNumber(inArr, num)));
    }

    @Test(expected = RuntimeException.class)
    public void getArrAfterNumberTestEx() {
        getPartArray.getArrAfterNumber(new int[]{1,2,2,3,1,7}, 4);
    }
}
