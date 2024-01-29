
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyRemoteServer {
    public static void main(String[] args) {
        try {
            MyRemote service = new MyRemoteImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            Naming.rebind("MyRemote", service);
            System.out.println("Server is ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}