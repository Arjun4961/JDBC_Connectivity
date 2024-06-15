import java.sql.*;

public class create {
    public static void main(String[] args) throws Exception {
        // Register MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish connection
        String url = "jdbc:mysql://localhost:3306/College";
        String username = "root";
        String password = "5261";
        Connection con = DriverManager.getConnection(url, username, password);

        // Check if table 'student' exists
        if (!isTableExists(con, "student1")) {
            // Create a statement
            Statement st = con.createStatement();

            // Execute SQL query to create a table
            st.executeUpdate("create table student1(rno int, name varchar(20), branch varchar(20))");

            // Close resources
            st.close();
        } else {
            System.out.println("Table 'student' already exists.");
        }

        // Close connection
        con.close();
    }

    // Method to check if table exists
    private static boolean isTableExists(Connection con, String tableName) throws SQLException {
        DatabaseMetaData meta = con.getMetaData();
        ResultSet resultSet = meta.getTables(null, null, tableName, new String[] {"TABLE"});
        return resultSet.next();
    }
}
