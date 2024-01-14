package lab1a;

public class Lab1a {
    public static void main(String[] args) {
        int tBase = 11;
        int tHeight = 7;
        
        int tLength = 6;
        int tBreadth = 9;
        
        triangle T1 = new triangle();
        float triangleAreaResult = T1.Area(tBase,tHeight);
        System.out.println("Area of the Triangle is: " + triangleAreaResult);
        
        rectangle R1 = new rectangle();
        float rectAreaResult = R1.Area(tLength,tBreadth);
        System.out.println("Area of the Rechtangle is: " + rectAreaResult);
    }
}
