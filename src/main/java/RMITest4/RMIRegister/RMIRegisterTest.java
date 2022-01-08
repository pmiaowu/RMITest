package RMITest4.RMIRegister;

import sun.rmi.registry.RegistryImpl;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.rmi.MarshalException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.UnmarshalException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.RemoteCall;
import java.rmi.server.SkeletonMismatchException;

public class RMIRegisterTest {
    // 注册中心设置的开放端口
    public static final int RMI_PORT = 9998;

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(RMI_PORT);
            System.out.println("RMI注册启动成功,端口:" + RMI_PORT);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        while (true) ;
    }
}
