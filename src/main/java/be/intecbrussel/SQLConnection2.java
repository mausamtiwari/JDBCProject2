package be.intecbrussel;

import javax.naming.Name;
import java.sql.*;

public class SQLConnection2 {
    public static void main(String[] args) {
        try {

            // STAP 01: de pakketten importeren
            // Class.forName("com.mysql.cj.jdbc.Driver");
            // System.out.println("Step 1 -> Success: " + "Driver is configured");

            // STAP 2 : een verbinding openen
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thebelgianbrewerydb", "mausam", "mausam2024");
            System.out.println(" Step 2 -> SUCCESS: " + "Connection is made between MYSQL and JAVA");

            // STAP 03: Een/Meerdere queries uitvoeren/Statement uitvoeren

            Statement statement = connection.createStatement();
            ResultSet selectResult = statement.executeQuery("select Id, Name, BrewerId, CategoryId, Price, Stock, Alcohol, Version, Image from Beers ");

            while (selectResult.next()) {
                System.out.println(selectResult.getRow() + " | " +
                        selectResult.getInt("Id") + " | " +
                        selectResult.getString("Name") + " | " +
                        selectResult.getInt("CategoryId") + " | " +
                        selectResult.getInt("Price") + " | " +
                        selectResult.getInt("Stock") + " | " +
                        selectResult.getInt("Alcohol")
                );

            }


            String insert = "INSERT IGNORE INTO Beers VALUES (1558,'Mausam1',2,11,2,222,2.5,1,NULL)";
            statement.executeUpdate(insert);
            System.out.println("Data inserted");

            //String update = "UPDATE Beers" + " SET Name = 'Mausam3' WHERE ID IN(1558)";
            //statement.executeUpdate(update);
            //System.out.println("Data updated");

            /*String delete = "DELETE FROM Beers" + " WHERE Id = 1557";
            statement.executeUpdate(delete);*/


            Statement updateStatement = connection.createStatement();

            Statement deleteStatement = connection.createStatement();


        } //catch (ClassNotFoundException notFoundException){
        //System.err.println("Step 1 -> CLASS NOT FOUND EXCEPTION: " + notFoundException.getMessage());
        // }


        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
