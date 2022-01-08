package RMITest5.RMIClient;

import RMITest.RMITestInterface;

import java.rmi.Naming;

public class RMIClientTest5 {
    public static void main(String[] args) {
        try {
            String rmiName = "rmi://127.0.0.1:9998/t5";

            // 查找远程RMI服务
            RMITestInterface rt = (RMITestInterface) Naming.lookup(rmiName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
