package RMITest6.RMIServer;

import RMITest6.RMITest6Interface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMITest6Impl extends UnicastRemoteObject implements RMITest6Interface {
    protected RMITest6Impl() throws RemoteException {
        super();
    }

    @Override
    public String test() throws RemoteException {
        return "test6~";
    }
}
