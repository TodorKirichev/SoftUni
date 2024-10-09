package SoftUni.JavaDB.ExerciseJavaDBAppsIntroduction;

import java.sql.*;
import java.util.Scanner;

public class _4_ {

    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", "root", "qwerty1619");

        Scanner scan = new Scanner(System.in);

        String[] minionInfo = scan.nextLine().split(": ")[1].split(" ");
        String minionName = minionInfo[0];
        int minionAge = Integer.parseInt(minionInfo[1]);
        String minionTown = minionInfo[2];

        String villainName = scan.nextLine().split(": ")[1];

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT id FROM towns WHERE name = ?;");
        preparedStatement.setString(1, minionTown);

        ResultSet townSet = preparedStatement.executeQuery();

        int townID;

        if (!townSet.next()) {
            PreparedStatement insertTown = connection.prepareStatement("INSERT INTO towns(name) VALUES (?);");
            insertTown.setString(1, minionTown);
            insertTown.executeUpdate();
            townSet = preparedStatement.executeQuery();
            townSet.next();
            townID = townSet.getInt("id");

            System.out.printf("Town %s was added to the database.\n", minionTown);
        } else {
            townID = townSet.getInt("id");
        }

        preparedStatement = connection.prepareStatement("SELECT id FROM villains WHERE name = ?;");
        preparedStatement.setString(1, villainName);

        ResultSet villainSet = preparedStatement.executeQuery();

        int villainId;

        if (!villainSet.next()) {
            PreparedStatement insertVillain = connection.prepareStatement("INSERT INTO villains (name, evilness_factor) VALUES (?, ?);");
            insertVillain.setString(1, villainName);
            insertVillain.setString(2, "evil");
            insertVillain.executeUpdate();
            villainSet = preparedStatement.executeQuery();
            villainSet.next();
            villainId = villainSet.getInt("id");

            System.out.printf("Villain %s was added to the database.\n", villainName);
        } else {
            villainId = villainSet.getInt("id");
        }

        int minionID;

        preparedStatement = connection.prepareStatement("SELECT id FROM minions WHERE name = ?;");
        preparedStatement.setString(1, minionName);
        ResultSet minionSet = preparedStatement.executeQuery();
        
        if (!minionSet.next()) {
            PreparedStatement insertMinion = connection.prepareStatement("INSERT INTO minions (name, age, town_id) VALUES (?, ?, ?)");
            insertMinion.setString(1, minionName);
            insertMinion.setInt(2, minionAge);
            insertMinion.setInt(3,townID);
            insertMinion.executeUpdate();

            minionSet = preparedStatement.executeQuery();
            minionSet.next();
            minionID = minionSet.getInt("id");
        } else {
            minionID = minionSet.getInt("id");
        }

        preparedStatement = connection.prepareStatement("SELECT * FROM minions_villains WHERE minion_id = ? AND villain_id = ?;");
        preparedStatement.setInt(1, minionID);
        preparedStatement.setInt(2, villainId);

        ResultSet minionsVillainsSet = preparedStatement.executeQuery();

        if (!minionsVillainsSet.next()) {
            PreparedStatement insertMinionVillain = connection.prepareStatement("INSERT INTO minions_villains (minion_id, villain_id) VALUES (?, ?);");
            insertMinionVillain.setInt(1, minionID);
            insertMinionVillain.setInt(2, villainId);
            insertMinionVillain.executeUpdate();

            System.out.printf("Successfully added %s to be minion of %s.\n", minionName, villainName);
        } else {
            System.out.printf("Villain %s already owns minion %s !\n", villainName, minionName);
        }
    }
}
