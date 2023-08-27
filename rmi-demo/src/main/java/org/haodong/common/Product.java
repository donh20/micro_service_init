package org.haodong.common;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Dto 类型必须实现 UnicastRemoteObject
// 它是JRMP（Java Remote Method Protocol）在传输层协议上要求的数据格式
// 原始类型，String类型做为DTO，可以直接使用
public class Product extends UnicastRemoteObject {
    private long id;
    private String name;
    private int price;
    public Product(String name, int price) throws RemoteException {
        id = Math.round(Math.random()*100 + 1);
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
