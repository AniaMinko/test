package com.senla.cashmachine.entity;

public class Client extends Entity {
    private String name;
    public Client(int id,String name){
        super(id);
        this.name=name;

    }
    public String getName(){
        return name;
    }
    @Override
    public String toString(){
        return getId() + " " + name;
    }
}
