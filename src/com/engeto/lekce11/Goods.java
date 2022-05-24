package com.engeto.lekce11;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Goods implements GoodsMethods{
    private ArrayList  itemList = new ArrayList();

    @Override
    public Item loadItemById(Integer id) {
        return null;
    }

    @Override
    public void deleteAllOutOfStockItems() {

    }

    @Override
    public List<Item> loadAllAvailableItems() {
        return null;
    }

    @Override
    public void saveItem(Item item) {

    }

    @Override
    public void updatePrice(Integer id, BigDecimal newPrice) {

    }
}
