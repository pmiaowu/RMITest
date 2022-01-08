package RMITest5;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMITest5Interface extends Remote {
    String test() throws RemoteException;
}
