package webserver;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcStreamServer;
import org.apache.xmlrpc.webserver.WebServer;

import java.io.IOException;
import java.util.HashMap;

//这个做法的好处是,客户端除了类.方法名以外,没有与服务端有任何耦合
public class RpcServer {
    private static final int port = 9000;

    public static void main(String[] args) throws XmlRpcException, IOException {

        //webServer 扮演 http的连接器，服务形式： http://ip:port/XML_RPC_Server/service
        WebServer webServer = new WebServer(port);

        //xmlRpcServer扮演RPC的注册中心
        XmlRpcStreamServer xmlRpcServer = webServer.getXmlRpcServer();
        PropertyHandlerMapping propertyHandlerMapping = new PropertyHandlerMapping();

        HashMap<Object, Object> map = new HashMap<>();
        map.put("Calculator","service.Calculator");//写死了
        propertyHandlerMapping.load(Thread.currentThread().getContextClassLoader(),map);

        xmlRpcServer.setHandlerMapping(propertyHandlerMapping);

        webServer.start();
        System.out.println("服务器启动成功,端口为"+ port);
    }
}
