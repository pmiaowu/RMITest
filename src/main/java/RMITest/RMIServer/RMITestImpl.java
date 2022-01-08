package RMITest.RMIServer;

import RMITest.RMITestInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMITestImpl extends UnicastRemoteObject implements RMITestInterface {
    /**
     * 调用父类的构造函数
     *
     * @throws RemoteException
     */
    protected RMITestImpl() throws RemoteException {
        super();
    }

    /**
     * RMI测试方法
     *
     * @return 返回测试的字符串
     */
    @Override
    public String test() throws RemoteException {
        return "test~";
    }
}
