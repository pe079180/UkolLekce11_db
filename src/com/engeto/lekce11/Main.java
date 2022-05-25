package com.engeto.lekce11;

import java.math.BigDecimal;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("start ...");

        Goods goods = new Goods();
        // loadItemById
        System.out.println("goods.loadItemById(1) ");
        System.out.println(goods.loadItemById(1));
        //System.out.println(goods.loadItemById(2));

        // saveItem
        System.out.println("\ngoods.saveItem");
        Item item = new Item(null,"PN00010","SN102201","PRIM","hodinky PRIM",10,new BigDecimal("12001"));
        goods.saveItem(item);
        System.out.println(goods.loadItemById(3));

    }
}
