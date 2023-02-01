package lb1_2;
import org.junit.Assert;
import org.junit.Test;

public class TestSum {
    @Test
    public void testSumCounterAvg1(){
        double res = Expression.sumCounter(4, 0.02);
        Assert.assertEquals(Math.sinh(4), res, 0.02);
    }
    @Test
    public void testSumCounterAvg2() {
        double res = Expression.sumCounter(73, 0.0003);
        Assert.assertEquals(Double.NaN, res, 0.0003);
    }
    @Test
    public void testSumCounterZero(){
        double res = Expression.sumCounter(0, 0.02);
        Assert.assertEquals(Math.sinh(0), res, 0.02);
    }
    @Test
    public void testSumCounterNegative(){
        double res = Expression.sumCounter(-10, 0.0005);
        Assert.assertEquals(Math.sinh(-10), res, 0.0005);
    }
}
