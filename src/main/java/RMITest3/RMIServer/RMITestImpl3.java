package RMITest3.RMIServer;

import RMITest3.RMITest3Interface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMITestImpl3 extends UnicastRemoteObject implements RMITest3Interface {
    /**
     * 调用父类的构造函数
     *
     * @throws RemoteException
     */
    protected RMITestImpl3() throws RemoteException {
        super();
    }

    /**
     * RMI服务端可被攻击的环境
     *
     * @param s
     * @return
     * @throws RemoteException
     */
    @Override
    public String name(String s) throws RemoteException {
        return s;
    }
}
