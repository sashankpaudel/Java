package lab1d;

public class Lab1d {
    public static class Staff{
        int code;
        String name;
        public void show(){
            System.out.println("Staff Code No.: "+ code);
            System.out.println("Staff Name: "+name);
        }
    }
    
    public static class Teacher extends Staff{
        String subject;
        String publication = "Neema";
        @Override
        public void show(){
            System.out.println("Teaching Subject: "+subject);
            System.out.println("Book Publication: "+publication);
            System.out.println("Also a staff of Code No.: "+code);
        }
    }
    public static class Officer extends Staff{
        String grade;
        @Override
        public void show(){
            System.out.println("Officer of grade: "+grade);
            System.out.println("Staff of Name: "+name);
        }
    }
    public static void main(String[] args) {
        //creating new objects of the class
        Staff s1 = new Staff();
        s1.code = 127;
        s1.name = "Rezina";
        s1.show();
        
        Teacher t1 = new Teacher();
        t1.subject = "Java";
        t1.code = 020;
        t1.show();
        
        Officer o1 = new Officer();
        o1.grade = "Senior";
        o1.name = "Rachel";
        o1.show(); 
    }
}