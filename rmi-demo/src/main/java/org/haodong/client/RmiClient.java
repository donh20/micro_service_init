package org.haodong.client;

import org.haodong.common.Product;
import org.haodong.service.ProductService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class RmiClient {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        ProductService productservice = (ProductService)Naming.lookup("rmi://localhost:3000/productservice");
        Product product = productservice.addProduct("电脑", 10000);
        System.out.println(productservice);
        System.out.println(product);
    }
}
