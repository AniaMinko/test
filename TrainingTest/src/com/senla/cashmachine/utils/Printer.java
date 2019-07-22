package com.senla.cashmachine.utils;

import com.senla.cashmachine.entity.Card;
import com.senla.cashmachine.entity.Entity;

import java.util.List;

public class Printer {

    public static void printCards(List<Card> list){
        for(Entity entity:list){
            if(entity!=null){
                System.out.println(entity);
            }
        }
    }

}
