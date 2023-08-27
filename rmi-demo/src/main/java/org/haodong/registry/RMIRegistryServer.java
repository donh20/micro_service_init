package org.haodong.registry;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

//RMI注册中心,要先启动
public class RMIRegistryServer {
    public static void main(String[] args) throws RemoteException {
        Registry registry = LocateRegistry.createRegistry(3000);
        //阻塞主线程,使用RMI注册服务器保持运行
        System.out.println("RMI注册服务启动完成...");

        //为了
        new Scanner(System.in).next();
    }
}
