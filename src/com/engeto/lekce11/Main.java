package com.engeto.lekce11;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        System.out.println("start ...");

        Goods goods = new Goods();
        // loadItemById
        System.out.println("goods.loadItemById(2)");
        System.out.println(goods.loadItemById(2));

        // deleteAllOutOfStockItems
        System.out.println("\ngoods.deleteAllOutOfStockItems");
        goods.deleteAllOutOfStockItems();

        //loadAllAvailableItems
        System.out.println("goods.loadAllAvailableItems");
        System.out.println(goods.loadAllAvailableItems());

        // saveItem
        System.out.println("\ngoods.saveItem");
        Item item = new Item(null,"PN00010","SN102201","PRIM","hodinky PRIM",0,new BigDecimal("12001"));
        goods.saveItem(item);

        // update price
        BigDecimal price = new BigDecimal((int)(Math.random()*(1000+1)+5000));
        System.out.println("\nupdate price=" + price + " for id=2");
        goods.updatePrice(2,price);
        System.out.println(goods.loadItemById(2));

    }
}
