
import java.rmi.Naming;

public class MyRemoteClient {
    public static void main(String[] args) {
        try {
            MyRemote service = (MyRemote) Naming.lookup("rmi://localhost/MyRemote");
            String message = service.sayHello();
            System.out.println(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}