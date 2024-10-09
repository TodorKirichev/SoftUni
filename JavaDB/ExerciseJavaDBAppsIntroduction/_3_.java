package SoftUni.JavaDB.ExerciseJavaDBAppsIntroduction;

import java.sql.*;
import java.util.Scanner;

public class _3_ {

    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", "root", "qwerty1619");

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT name FROM villains WHERE id = ?" );
        Scanner scan = new Scanner(System.in);
        int id = Integer.parseInt(scan.nextLine());
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (!resultSet.next()) {
            System.out.println("No villain with ID 10 exists in the database.");
            return;
        }

        String name = resultSet.getString(1);

        preparedStatement = connection.prepareStatement("SELECT" +
                " m.name," +
                " m.age" +
                " FROM minions AS m\n" +
                " JOIN minions_villains AS mv ON mv.minion_id = m.id" +
                " JOIN villains AS v ON mv.villain_id = v.id" +
                " WHERE v.id = ?;");

        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();

        System.out.printf("Villain: %s\n", name);

        int counter = 1;

        while (resultSet.next()) {
            System.out.printf("%d. %s %d\n", counter, resultSet.getString(1), resultSet.getInt(2));
            counter++;
        }
    }
}
