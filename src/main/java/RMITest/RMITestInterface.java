package RMITest;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * RMI测试接口
 * 定义一个远程接口, 继承java.rmi.Remote接口
 */
public interface RMITestInterface extends Remote {
    String test() throws RemoteException;
}
