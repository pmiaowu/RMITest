package RMITest2.RMIServer;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RMIServerTest2 {
    // 注册中心的服务器ip
    public static final String RMI_HOST = "127.0.0.1";

    // 注册中心设置的开放端口
    public static final int RMI_PORT = 9998;

    // RMI服务名称
    public static final String RMI_NAME = "rmi://" + RMI_HOST + ":" + RMI_PORT + "/hello";

    /**
     * 注册中心创建 与 服务端创建
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            // 创建注册中心
            LocateRegistry.createRegistry(RMI_PORT);

            // 服务端
            // 功能: 注册远程对象RMITestImpl2到RMI注册中心
            Naming.bind(RMI_NAME, new RMITestImpl2());

            // 输出该对象的访问地址
            System.out.println("RMI服务启动成功,服务地址:" + RMI_NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
