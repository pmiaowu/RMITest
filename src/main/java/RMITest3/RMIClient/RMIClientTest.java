package RMITest3.RMIClient;

import RMITest3.RMITest3Interface;

import java.rmi.Naming;

public class RMIClientTest {
    public static void main(String[] args) {
        try {
            // 服务地址
            String rmiName = "rmi://127.0.0.1:9998/t3";

            // 查找远程RMI服务
            RMITest3Interface rt3 = (RMITest3Interface) Naming.lookup(rmiName);

            // 调用远程接口RMITest3Interface类的name方法
            // 并且尝试进行漏洞利用
            String result3 = rt3.name("test");

            // 输出服务端执行结果
            System.out.println(result3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
