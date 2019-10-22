package com.progwitheric.restservice.MicroProgram.DAO;

import com.progwitheric.restservice.MicroProgram.Cars;

import java.util.List;

public interface CarDao {
    public List<Cars>findAll();
    public Cars findById(int id);
    public Cars save(Cars car);
    public void delete(int id);
    public void update(Cars newCar);
}
