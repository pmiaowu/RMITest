package RMITest4.RMIServer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMITest4Interface extends Remote {
    String test() throws RemoteException;
}
