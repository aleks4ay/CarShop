package ua.aleks4ay.dao;

import org.junit.*;
import ua.aleks4ay.model.Car;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CarDaoTest {

    Car car1, car2, car3, car4;
    List<Car> cars = null;
    private static Connection testConnection = null;
    static CarDao carDao = null;

    @BeforeClass
    public static void createConnection() throws Exception {
        testConnection = Utils.getConnectionTest();
        carDao = new CarDao(testConnection);
    }

    @Before
    public void createAndPopulateTestDB() throws Exception {
        Statement statement = testConnection.createStatement();
        statement.execute("DROP TABLE IF EXISTS car;");
        statement.execute("DROP SEQUENCE IF EXISTS car_id_seq;");
        statement.execute("CREATE SEQUENCE car_id_seq START WITH 1;");
        statement.execute("CREATE TABLE car (\n" +
                "  id          INTEGER PRIMARY KEY DEFAULT nextval('car_id_seq'),\n" +
                "  date_receiving   TIMESTAMP NOT NULL,\n" +
                "  brand            VARCHAR   NOT NULL,\n" +
                "  model            VARCHAR   NOT NULL,\n" +
                "  engine_type      VARCHAR   NOT NULL,\n" +
                "  engine_volume    DECIMAL   NOT NULL,\n" +
                "  fuel_consumption DECIMAL   NOT NULL,\n" +
                "  price            DECIMAL   NOT NULL,\n" +
                "  horse_power      INT       NOT NULL,\n" +
                "  cargo_space      INT       NOT NULL,\n" +
                "  seats            INT       NOT NULL,\n" +
                "  length           INT       NOT NULL,\n" +
                "  width            INT       NOT NULL,\n" +
                "  height           INT       NOT NULL,\n" +
                "  clearance        INT       NOT NULL\n" +
                ");");
        statement.execute("insert into car (date_receiving, brand, model, engine_type, engine_volume, fuel_consumption, horse_power,\n" +
                "                 price, cargo_space, seats, length, width, height, clearance) values\n" +
                "  ('2020-03-29 09:00:00', 'Alfa Romeo', 'Giulia 2.0 AT Veloce AWD', 'бензин', 2, 6.4, 280, 1094000, 480, 5, 4643, 1860, 1436, 100),\n" +
                "  ('2020-01-30 10:00:00', 'Fiat', 'Tipo 1.6 AT Pop', 'бензин', 1.6, 6.3, 110, 434900, 520, 5, 4532, 1792, 1497, 130),\n" +
                "  ('2021-01-05 10:00:00', 'Ford', 'Focus Active 1.5 AT Plus', 'бензин', 1.5, 6.1, 150, 884912, 375, 5, 4397, 1825, 1483, 165),\n" +
                "  ('2020-05-24 10:00:00', 'Honda', 'HR-V 1.5 AT Elegance', 'бензин', 1.5, 5.6, 130, 794900, 470, 5, 4294, 1772, 1605, 185);");
    }

    @Before
    public void setUp() throws Exception {
        car1 = new Car("Alfa Romeo", "Giulia 2.0 AT Veloce AWD", "бензин", 2, 6.4, 1094000, 280, 480, 5, 4643, 1860, 1436, 100,
                LocalDateTime.of(2020, 3, 29, 9, 0, 0));
        car2 = new Car("Fiat", "Tipo 1.6 AT Pop", "бензин", 1.6, 6.3, 434900, 110, 520, 5, 4532, 1792, 1497, 130,
                LocalDateTime.of(2020, 1, 30, 10, 0, 0));
        car3 = new Car("Ford", "Focus Active 1.5 AT Plus", "бензин", 1.5, 6.1, 884912, 150, 375, 5, 4397, 1825, 1483, 165,
                LocalDateTime.of(2021, 1, 5, 10, 0, 0));
        car4 = new Car("Honda", "HR-V 1.5 AT Elegance", "бензин", 1.5, 5.6, 794900, 130, 470, 5, 4294, 1772, 1605, 185,
                LocalDateTime.of(2020, 5, 24, 10, 0, 0));
        cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
    }


    @Test
    public void getByIdTest() throws Exception {
        Car result = carDao.getById(2);
        assertEquals(car2.toString().trim(), result.toString().trim());
    }

    @Test
    public void GetAllTest() throws Exception {
        List<Car> result = carDao.getAll();
        assertEquals(cars.toString().trim(), result.toString().trim());
    }

    @Test
    public void deleteTest() throws Exception {
        boolean result = carDao.delete(2);
        Car deletedCar = carDao.getById(2);
        assertEquals(true, result);
        assertNull(deletedCar);
    }

    @Test
    public void updateTest() throws Exception {
        car4.setCargoSpace(111);
        carDao.update(car4);
        Car newCar4 = carDao.getById(4);
        assertEquals(car4.toString().trim(), newCar4.toString().trim());
    }

    @Test
    public void createTest() throws Exception {
        Car car5FromDB = carDao.getById(5);
        assertNull(car5FromDB);

        Car car5 = new Car("brand", "model", "engineType", 0d, 0d, 0d, 0, 0, 0, 0, 0, 0, 0, LocalDateTime.of(2021, 1, 21, 21, 53, 58));
        boolean result = carDao.create(car5);
        assertEquals(true, result);

        Car car5FromDBafterCreating = carDao.getById(5);
        assertEquals(car5.toString().trim(), car5FromDBafterCreating.toString().trim());
    }

    @Test
    public void readEntityTest() throws Exception {
        Statement statement = testConnection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM car WHERE id = 2;");
        rs.next();
        Car result = carDao.readEntity(rs);
        Car expectedCar = car2;
        Assert.assertEquals(expectedCar.toString().trim(), result.toString().trim());
    }

    @AfterClass
    public static void close() throws Exception {
        carDao = null;
        Utils.closeConnection(testConnection);
    }
}
