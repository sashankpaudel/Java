
package Lab1b;

public class Lab1b {

    public static void main(String[] args) {
        int length = 35;
        int breadth = 20;
        
        double base = 7.2;
        double height = 5.9;
        
        Shape Rect = new Shape(length, breadth);
        Shape Triangle = new Shape(base,height);
        
        int RectArea = Rect.Area(length, breadth);
        double TriArea = Triangle.Area(base, height);
        
        System.out.println("Area of Rectangle is: " + RectArea);
        System.out.println("Area of Triangle is: " + TriArea);
    }
}