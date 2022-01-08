package RMITest2;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * RMI测试接口
 * 定义一个远程接口, 继承java.rmi.Remote接口
 */
public interface RMITest2Interface extends Remote {
    String test() throws RemoteException;

    String hello(Object o) throws RemoteException;
}
