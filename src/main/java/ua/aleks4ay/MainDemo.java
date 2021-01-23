package ua.aleks4ay;

import ua.aleks4ay.dao.CarDao;
import ua.aleks4ay.dao.Utils;
import ua.aleks4ay.model.Car;

import java.sql.Connection;
import java.util.List;

public class MainDemo {
    public static void main(String[] args) {
//        Car car = new CarDao().getById(4);
//        System.out.println(car);
        Connection connection = Utils.getConnectionTest();
        Car car = new CarDao(connection).getById(4);
        System.out.println(car);
    }
}
