package org.haodong.service;

import org.haodong.service.impl.ProductServiceImpl;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class RmiRegister {
    public static void main(String[] args) throws MalformedURLException, AlreadyBoundException, RemoteException {
        ProductServiceImpl productService = new ProductServiceImpl();
        Naming.bind("rmi://localhost:3000/productservice",productService);
        System.out.println(productService);
        System.out.println("注册完成");
    }
}
