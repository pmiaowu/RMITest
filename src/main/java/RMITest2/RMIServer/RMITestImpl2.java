package RMITest2.RMIServer;

import RMITest2.RMITest2Interface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMITestImpl2 extends UnicastRemoteObject implements RMITest2Interface {
    /**
     * 调用父类的构造函数
     *
     * @throws RemoteException
     */
    protected RMITestImpl2() throws RemoteException {
        super();
    }

    @Override
    public String test() throws RemoteException {
        return "test~";
    }

    /**
     * RMI服务端可被攻击的环境
     *
     * @param o
     * @return
     * @throws RemoteException
     */
    @Override
    public String hello(Object o) throws RemoteException {
        return "hello~";
    }
}
