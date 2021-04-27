package entity;

public class Calculator {
    private Calculator() {
    }

    public static double sum(double x, double y){
        return x + y;
    }
    public static double sub(double x,double y){
        return x - y;
    }
    public static double multiply(double x,double y){
        return x * y;
    }
    public static double division(double x,double y){
        return x / y;
    }
}
