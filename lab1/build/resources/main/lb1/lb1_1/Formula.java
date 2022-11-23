package lb1_1;

public class Formula
{
    public static float countFormula(float a, float b, float c){
        float res = (a + b) * (a + b) / (a - c);
        return(res);
    }
    public static void main(String[] args) {
        float a = Float.parseFloat(args[0]);
        float b = Float.parseFloat(args[1]);
        float c = Float.parseFloat(args[2]);
        System.out.println(countFormula(a, b, c));
    }
}