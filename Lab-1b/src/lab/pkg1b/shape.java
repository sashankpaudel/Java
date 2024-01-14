package lab1b;
public class shape {
   int length, breadth;
   double base, height;
    public shape(int a,int b){
        this.length = a;
        this.breadth = b;
    }
    public shape(double a,double b){
        this.base = a;
        this.height = b;
    }
    public int Area(int length, int breadth){
        return length * breadth;
    }
    
    public double Area(double base, double height){
        return (base * height)/2;
    }
}
