package SoftUni.JavaDB.ExerciseJavaDBAppsIntroduction;

import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _8_ {
    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);

        List<Integer> minionsIDs = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", "root", "qwerty1619");

        minionsIDs.forEach(i -> {
            PreparedStatement increaseMinionsAge = null;
            try {
                increaseMinionsAge = connection.prepareStatement("UPDATE minions SET age = age + 1, name = LOWER(name) WHERE id = ?;");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                increaseMinionsAge.setInt(1, i);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                increaseMinionsAge.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        PreparedStatement selectMinions = connection.prepareStatement("SELECT name, age FROM minions;");

        ResultSet minionsSet = selectMinions.executeQuery();

        while (minionsSet.next()) {
            System.out.printf("%s %d\n", minionsSet.getString("name"), minionsSet.getInt("age"));
        }
    }
}
