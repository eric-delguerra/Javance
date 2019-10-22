package com.progwitheric.restservice.MicroProgram;

public class Cars {
    private int id;
    private String name;
    private String model;

    public Cars(){

    }

    public Cars(int id,String name, String modele){
        this.model = modele;
        this.name = name;
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
