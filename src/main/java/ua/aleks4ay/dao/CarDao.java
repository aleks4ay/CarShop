package ua.aleks4ay.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.aleks4ay.model.Car;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;

public class CarDao extends AbstractDao<Car, Integer>{
    private static final Logger log = LoggerFactory.getLogger(CarDao.class);
    private static final String SQL_GET_ONE = "SELECT * FROM car WHERE id = ?;";
    private static final String SQL_GET_ALL = "SELECT * FROM car;";
    private static final String SQL_DELETE = "DELETE FROM car WHERE id = ?;";
    private static final String SQL_CREATE = "INSERT INTO car (date_receiving, engine_type, engine_volume, " +
            "fuel_consumption, horse_power, price, cargo_space, seats, length, width, height, clearance, brand, model) values " +
            "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SQL_UPDATE = "UPDATE car set date_receiving = ?, engine_type=?, engine_volume=?, " +
            "fuel_consumption=?, horse_power=?, price=?, cargo_space=?, seats=?, length=?, width=?, height=?, clearance=? " +
            "WHERE brand = ? AND model = ?;";

    public CarDao(Connection connection) {
        super(connection);
    }

    @Override
    public Car getById(Integer id) {
        return getAbstractById(SQL_GET_ONE, id);
    }

    @Override
    public List<Car> getAll() {
        return getAbstractAll(SQL_GET_ALL);
    }

    @Override
    public boolean delete(Integer id) {
        return deleteAbstract(SQL_DELETE, id);
    }

    @Override
    public Car update(Car car) {
        boolean result = createAbstract(SQL_UPDATE, car);
        return result ? car : null;
    }

    @Override
    public boolean create(Car car) {
        return createAbstract(SQL_CREATE, car);
    }

    @Override
    public Car readEntity(ResultSet rs) throws SQLException {
        String brand = rs.getString("brand");
        String model = rs.getString("model");
        String engineType = rs.getString("engine_type");
        double engineVolume = rs.getDouble("engine_volume");
        double fuelConsumption = rs.getDouble("fuel_consumption");
        double cost = rs.getDouble("price");
        int horsePower = rs.getInt("horse_power");
        int cargoSpace = rs.getInt("cargo_space");
        int seats = rs.getInt("seats");
        int length = rs.getInt("length");
        int width = rs.getInt("width");
        int height = rs.getInt("height");
        int clearance = rs.getInt("clearance");
        LocalDateTime dateReceiving = rs.getTimestamp("date_receiving").toLocalDateTime();
        return new Car(brand, model, engineType, engineVolume, fuelConsumption, cost, horsePower, cargoSpace,
        seats, length, width, height, clearance, dateReceiving);
    }

    @Override
    public void fillEntityStatement(PreparedStatement statement, Car car) throws SQLException {
        LocalDateTime localDateTime = car.getDateReceiving();
        statement.setTimestamp(1, Timestamp.valueOf(localDateTime));
        statement.setString(2, car.getEngineType());
        statement.setDouble(3, car.getEngineVolume());
        statement.setDouble(4, car.getFuelConsumption());
        statement.setInt(5, car.getHorsePower());
        statement.setDouble(6, car.getPrice());
        statement.setInt(7, car.getCargoSpace());
        statement.setInt(8, car.getSeats());
        statement.setInt(9, car.getLength());
        statement.setInt(10, car.getWidth());
        statement.setInt(11, car.getHeight());
        statement.setInt(12, car.getClearance());
        statement.setString(13, car.getBrand());
        statement.setString(14, car.getModel());
    }
}
