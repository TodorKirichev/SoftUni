package SoftUni.JavaDB.ExerciseJavaDBAppsIntroduction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _6_ {
    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", "root", "qwerty1619");

        int villainId = Integer.parseInt(scan.nextLine());

        PreparedStatement getMinions = connection.prepareStatement("SELECT COUNT(minion_id) FROM minions_villains WHERE villain_id = ?;");
        getMinions.setInt(1, villainId);

        ResultSet minionsSet = getMinions.executeQuery();
        minionsSet.next();

        int numberOfMinions = minionsSet.getInt(1);

        PreparedStatement selectVillain = connection.prepareStatement("SELECT name FROM villains WHERE id = ?;");
        selectVillain.setInt(1, villainId);

        ResultSet villainSet = selectVillain.executeQuery();

        String villainName;

        if (!villainSet.next()) {
            System.out.println("No such villain was found");
            return;
        } else {
            villainName = villainSet.getString(1);
        }

        connection.setAutoCommit(false);

        try {
            PreparedStatement deleteMinionsVillains = connection.prepareStatement("DELETE FROM minions_villains WHERE villain_id = ?;");
            deleteMinionsVillains.setInt(1, villainId);
            deleteMinionsVillains.executeUpdate();

            PreparedStatement deleteVillain = connection.prepareStatement("DELETE FROM villains WHERE id = ?;");
            deleteVillain.setInt(1, villainId);
            deleteVillain.executeUpdate();

            connection.commit();

            System.out.printf("%s was deleted\n", villainName);
            System.out.printf("%d minions released\n", numberOfMinions);

        } catch (Exception e) {
            connection.rollback();
        }
    }
}
