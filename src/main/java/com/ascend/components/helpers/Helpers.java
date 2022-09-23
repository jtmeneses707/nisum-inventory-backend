package com.ascend.components.helpers;

import com.ascend.components.entities.Products;

public class Helpers {
    public static Products stock_logic(Products p, Products new_p){
        //making changes on old product and returning the old as new.
        new_p.setBrand(p.getBrand());
        new_p.setCategory(p.getCategory());
        new_p.setImageURL(p.getImageURL());
        new_p.setUPC(p.getUPC());
        new_p.setProdDesc(p.getProdDesc());
        new_p.setPricePerUnit(p.getPricePerUnit());
        new_p.setProdName(p.getProdName());

        int avail_dif = -1;
        int res_dif = -1;
        int ship_dif = -1;

        if (p.getAvailableStock() > new_p.getAvailableStock()) { //available stock increase
            avail_dif = p.getAvailableStock() - new_p.getAvailableStock();
            new_p.setAvailableStock(p.getAvailableStock());

            if(p.getReservedStock() > new_p.getReservedStock()){
                //add items to reserve, thus decreasing available by same amount
                res_dif = p.getReservedStock() - new_p.getReservedStock();
                if(res_dif > p.getAvailableStock()){
                    //not enough available stock to move to reserved, error (or maybe move whats available?)
                    System.out.println("Error, not enough available stock to move to reserved stock.");
                    return null;
                }
                else if(res_dif <= p.getAvailableStock()){
                    //there is enough, subtract available stock from dif.
                    new_p.setAvailableStock(new_p.getAvailableStock()-res_dif);

                }
                new_p.setReservedStock(p.getReservedStock());

                //handle shipped
                if(p.getShippedStock() > new_p.getShippedStock()){
                    //add items to shipped, thus decreasing reserved by same amount.
                    ship_dif = p.getShippedStock() - new_p.getShippedStock();
                    if(ship_dif > p.getReservedStock()){
                        //not enough reserved stock to move to shipped, error (or maybe move whats available?)
                        System.out.println("Error, not enough reserved stock to move to shipped stock.");
                        return null;
                    }
                    else if(ship_dif <= p.getReservedStock()) {
                        //there is enough, subtract available stock from dif.
                        new_p.setReservedStock(new_p.getReservedStock() - ship_dif);
                    }
                    new_p.setShippedStock(p.getShippedStock());

                }
                else if(p.getShippedStock() < new_p.getShippedStock()){
                    //decreasing shipped stock amount, thus being canceled.
                    ship_dif = new_p.getShippedStock() - p.getShippedStock();
                    new_p.setShippedStock(p.getShippedStock());
                }
                else{
                    //no change to shipped stock
                    new_p.setShippedStock(p.getShippedStock());
                }
            }
            else if(p.getReservedStock() == new_p.getReservedStock()){
                //no changes made to reserved stock
                new_p.setReservedStock(p.getReservedStock());

                //handle shipped
                if(p.getShippedStock() > new_p.getShippedStock()){
                    //add items to shipped, thus decreasing reserved by same amount.
                    ship_dif = p.getShippedStock() - new_p.getShippedStock();
                    if(ship_dif > p.getReservedStock()){
                        //not enough reserved stock to move to shipped, error (or maybe move whats available?)
                        System.out.println("Error, not enough reserved stock to move to shipped stock.");
                        return null;
                    }
                    else if(ship_dif <= p.getReservedStock()){
                        //there is enough, subtract available stock from dif.
                        new_p.setReservedStock(new_p.getReservedStock()-ship_dif);
                    }

                }else if(p.getShippedStock() == new_p.getShippedStock()){
                    new_p.setShippedStock(p.getShippedStock());
                }
            }

        } else if (p.getAvailableStock() == new_p.getAvailableStock()) { //available stock stays the same

        } else {
            //available stock manually gets subtracted. I don't know if this is allowed to happen.

        }

        return new_p;
    }
}
