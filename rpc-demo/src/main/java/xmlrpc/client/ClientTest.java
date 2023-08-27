package xmlrpc.client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;

public class ClientTest {
    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        XmlRpcClient xmlRpcClient = new XmlRpcClient();
        //在其中配置http请求的信息
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        //http://ip:port/XML_RPC_Server/service
        config.setServerURL(new URL("http://localhost:9000/XML_RPC_Server/service"));
        config.setEncoding("UTF-8");
        xmlRpcClient.setConfig(config);

        Integer[] params = new Integer[]{32, 11};
        Integer result = (Integer) xmlRpcClient.execute("Calculator.add", params);
        System.out.printf("两数相加的结果是: %d", result);

        result = (Integer) xmlRpcClient.execute("Calculator.subtract", params);
        System.out.printf("两数相减的结果是: %d", result);
    }
}
