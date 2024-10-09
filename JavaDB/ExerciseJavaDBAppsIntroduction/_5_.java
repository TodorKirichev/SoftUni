package SoftUni.JavaDB.ExerciseJavaDBAppsIntroduction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _5_ {

    public static void main(String[] args) throws SQLException {

        Scanner scan = new Scanner(System.in);
        String country = scan.nextLine();

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", "root", "qwerty1619");

        PreparedStatement selectTowns = connection.prepareStatement("SELECT name FROM towns WHERE country = ?;");
        selectTowns.setString(1, country);

        ResultSet townSet = selectTowns.executeQuery();

        if (townSet.next()) {
            PreparedStatement renameTowns = connection.prepareStatement("UPDATE towns" +
                    " SET name = UPPER(name)" +
                    " WHERE country = ?;");
            renameTowns.setString(1, country);
            renameTowns.executeUpdate();

            ResultSet newTownSet = selectTowns.executeQuery();
            List<String> affectedTowns = new ArrayList<>();

            while (newTownSet.next()) {
                affectedTowns.add(newTownSet.getString("name"));
            }
            System.out.printf("%d town names were affected.\n", affectedTowns.size());
            System.out.println(affectedTowns);
        } else {
            System.out.println("No town names were affected.");
        }
    }
}
