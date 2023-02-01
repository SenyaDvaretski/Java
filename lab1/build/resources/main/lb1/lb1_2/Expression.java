package lb1_2;

public class Expression {

    private static double factorial(double num){
        double fact = 1;
        for(;num > 0; num -= 1){
            fact *= num;
        }
        return fact;
    }
    public static double sumCounter(double x, double accuracy) {
        double curTerm = Double.MAX_VALUE;
        double n = 0;
        int iterNum = 0;
        double res = 0;
        while (Math.abs(curTerm) > accuracy && iterNum < 1000) {
            curTerm = Math.pow(x, 2 * n + 1) / factorial(2 * n + 1);
            res += curTerm;
            iterNum++;
            n += 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(sumCounter(-3, 0.02));
        System.out.println(Math.sinh(-3));
    }
}