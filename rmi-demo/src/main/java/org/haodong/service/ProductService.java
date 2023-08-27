package org.haodong.service;

import org.haodong.common.Product;

import java.rmi.Remote;

public interface ProductService extends Remote {
    Product addProduct(String msg, int price);
}
