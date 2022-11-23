package lb1_1;

import org.junit.*;

public class FormulaTest {
        @Test
        public void testFormulaAvg(){
                float res = Formula.countFormula(1, 2 ,3);
                Assert.assertEquals(-4.5, res, 0);
        }
        @Test
        public void testFormulaZero(){
                Formula formula = new Formula();
                float res = formula.countFormula(3, 2, 3);
                Assert.assertEquals(res, Double.POSITIVE_INFINITY, 0);
        }
        @Test
        public void testFormulaLarge(){
                Formula formula = new Formula();
                float res = formula.countFormula(12345, 54321, 678912);
                Assert.assertEquals(res, -6667.53,0.5);
        }
}
