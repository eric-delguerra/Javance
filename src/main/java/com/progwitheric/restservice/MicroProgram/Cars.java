package com.progwitheric.restservice.MicroProgram;

public class Cars {
    private String name;
    private String model;

    public Cars(){

    }

    public Cars(String name, String modele){
        this.model = modele;
        this.name = name;
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
}
