package RMITest6;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMITest6Interface extends Remote {
    String test() throws RemoteException;
}
