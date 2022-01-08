package RMITest3;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * RMI测试接口
 * 定义一个远程接口, 继承java.rmi.Remote接口
 */
public interface RMITest3Interface extends Remote {
    String name(String s) throws RemoteException;
}