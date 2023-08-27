package org.haodong.service.impl;

import org.haodong.common.Product;
import org.haodong.service.ProductService;

import java.io.Serializable;
import java.rmi.RemoteException;

//注册到RMI注册中心
public class ProductServiceImpl implements ProductService, Serializable {
    @Override
    public Product addProduct(String msg, int price) {
        Product product = null;
        try {
            product = new Product(msg, price);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return product;
    }
}
