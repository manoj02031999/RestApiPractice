package jdbcconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCConnection {

    public static void main(String[] args) {
        // Step 1: Load the JDBC driver class
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("Failed to load JDBC driver.");
            e.printStackTrace();
            return;
        }

        // Step 2: Define the database connection URL
        String url = "jdbc:mysql://cf_rds_dev_java:qQtLB8XdZvp269m8@cf-rds-mysql8.coolstqbhxhn.ap-south-1.rds.amazonaws.com:3306/loanfront?useSSL=false";
//            String url = "jdbc:mysql://cf-rds-mysql8.coolstqbhxhn.ap-south-1.rds.amazonaws.com:3306/loanfront?useSSL=false";
        String username = "cf_rds_dev_java";
        String password = "qQtLB8XdZvp269m8";

        // Step 3: Open a connection to the database
//            try (Connection connection = DriverManager.getConnection(url, username, password)) {
        try {

//                Connection connection = DriverManager.getConnection(url, username, password);
            Connection connection = DriverManager.getConnection(url);

            connection.beginRequest();


            System.out.println("Connected to the database.");

            // Step 4: Execute SQL queries or statements

            // Example: Execute a query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT user_id FROM user_profiles where mobile_phone_number='9947618560'");


//
//                 if(resultSet != null) {
            while (resultSet.next()) {
                System.out.println("data found");
                long customerId = resultSet.getLong("user_id");

                System.out.println("User_id : " + customerId);
                return;
            }

            System.out.println("data not found////////////");
//                 }else {
//                     System.out.println("Data not found");
//                 }
            // Example: Execute an update statement
            // Statement statement = connection.createStatement();
            // int rowsAffected = statement.executeUpdate("UPDATE my_table SET column1 = value1 WHERE column2 = value2");

        } catch (Exception e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        }

        // Step 5: Close the connection (not necessary with try-with-resources)
    }


}
