package RMITest.RMIClient;

import RMITest.RMITestInterface;

import java.rmi.Naming;

public class RMIClientTest {
    public static void main(String[] args) {
        try {
            String rmiName = "rmi://127.0.0.1:9998/test";

            // 查找远程RMI服务
            RMITestInterface rt = (RMITestInterface) Naming.lookup(rmiName);

            // 调用远程接口RMITestInterface类的test方法
            String result = rt.test();

            // 输出服务端执行结果
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
