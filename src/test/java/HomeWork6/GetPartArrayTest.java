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
        return Arrays.asList(new Object[][][] {
                {{1,7},{1,2,4,4,2,3,4,1,7},{4}},
                {{2,3,0,1,7},{1,2,4,4,2,3,0,1,7},{4}},
                {{18,1,7},{1,2,4,4,2,4,8,1,7},{4}}
        });
    }

    private int[] result;
    private int[] inArr;
    private int num;

    public GetPartArrayTest(int[] result, int[] inArr, int[] num) {
        this.result = result;
        this.inArr = inArr;
        this.num = num[0];
    }

    GetPartArray getPartArray;

    @Before
    public void init() {
        getPartArray = new GetPartArray();
    }

    @Test
    public void getArrAfterNumberTest() {
        Assert.assertEquals(result, getPartArray.getArrAfterNumber(inArr, num));
    }

    @Test(expected = RuntimeException.class)
    public void getArrAfterNumberTestEx() {
        getPartArray.getArrAfterNumber(new int[]{1,2,2,3,1,7}, 4);
    }
}
