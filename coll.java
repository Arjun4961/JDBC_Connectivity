import java.sql.*;
import java.util.Scanner;

public class coll {
    public static void main(String[] args) {
        Connection con = null;
        CallableStatement cs = null;
        Scanner sc = new Scanner(System.in);

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "5261");

            // SQL to call the stored procedure
            String sql = "{CALL sp(?,?,?)}";

            // Create a CallableStatement
            cs = con.prepareCall(sql);

            // Get user input
            System.out.println("Enter rno: ");
            int a = sc.nextInt();
            System.out.println("Enter name: ");
            String b = sc.next();
            System.out.println("Enter branch: ");
            String c = sc.next();

            // Set the input parameters
            cs.setInt(1, a);
            cs.setString(2, b);
            cs.setString(3, c);

            // Execute the stored procedure
            cs.execute();

            System.out.println("Data inserted successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the resources
            try {
                if (cs != null) cs.close();
                if (con != null) con.close();
                sc.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
