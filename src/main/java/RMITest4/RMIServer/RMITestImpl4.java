package RMITest4.RMIServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMITestImpl4 extends UnicastRemoteObject implements RMITest4Interface {
    /**
     * 调用父类的构造函数
     *
     * @throws RemoteException
     */
    protected RMITestImpl4() throws RemoteException {
        super();
    }

    @Override
    public String test() throws RemoteException {
        return "test4～～～";
    }
}
