import java.rmi.*;
public interface RemoteSubject extends Remote {
      public double getArea() throws RemoteException;
}
