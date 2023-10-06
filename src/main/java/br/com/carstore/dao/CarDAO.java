package br.com.carstore.dao;

import br.com.carstore.model.Car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CarDAO {

    public void createCar(Car car) {
        String SQL = "INSERT INTO CAR (NAME) VALUES (?)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("sucess in connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, car.getName());
            preparedStatement.execute();

            System.out.println("Sucess in insert command");

            connection.close();
        } catch (Exception e) {
            System.out.println("error in connection");
        }
    }
}
