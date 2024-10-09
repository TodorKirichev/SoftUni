package SoftUni.JavaDB.ExerciseJavaDBAppsIntroduction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _7_ {
    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", "root", "qwerty1619");

        PreparedStatement getMinions = connection.prepareStatement("SELECT name FROM minions");

        ResultSet minionsSet = getMinions.executeQuery();

        List<String> minionsList = new ArrayList<>();

        while (minionsSet.next()) {
            minionsList.add(minionsSet.getString(1));
        }

        for (int i = 0; i < minionsList.size() / 2; i++) {
            System.out.println(minionsList.get(i));
            System.out.println(minionsList.get(minionsList.size() - 1 - i));
        }

        if (minionsList.size() % 2 != 0) {
            System.out.println(minionsList.get(minionsList.size() / 2));
        }
    }
}






