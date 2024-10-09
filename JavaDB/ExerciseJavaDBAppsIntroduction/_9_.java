package SoftUni.JavaDB.ExerciseJavaDBAppsIntroduction;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class _9_ {
    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);

        int ID = Integer.parseInt(scan.nextLine());

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", "root", "qwerty1619");

        CallableStatement callableStatement = connection.prepareCall("CALL usp_get_older (?);");
        callableStatement.setInt(1, ID);
        callableStatement.executeUpdate();
    }
}
