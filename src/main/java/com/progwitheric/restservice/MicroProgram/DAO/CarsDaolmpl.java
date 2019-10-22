package com.progwitheric.restservice.MicroProgram.DAO;

import com.progwitheric.restservice.MicroProgram.Cars;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarsDaolmpl implements CarDao {
    public static List<Cars> cars = new ArrayList<>();
    static {
        cars.add(new Cars(1, "Fiat", "Punto"));
        cars.add(new Cars(2, "Renaud", "R5"));
        cars.add(new Cars(3, "Citroen", "2CV"));
    }

    @Override
    public List<Cars> findAll() {
        return cars;
    }

    @Override
    public Cars findById(int id) {
        for (Cars car : cars){
            if (car.getId() == id){
                return car;
            }
        }
        return null;
    }

    @Override
    public Cars save(Cars car) {
        cars.add(car);
        return car;
    }

    @Override
    public void delete(int id) {
        cars.remove(id - 1);
    }

    @Override
    public void update(Cars newCar) {
        cars.set(newCar.getId()-1, newCar);
    }

}
