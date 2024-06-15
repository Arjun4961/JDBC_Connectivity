import java.sql.*;

public class insert {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/College";
        String username = "root";
        String password = "5261";

        try {
            // Register MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection con = DriverManager.getConnection(url, username, password);

            

            // Insert values into student1 table
            insertValuesIntoStudentTable(con);

            // Close connection
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to check if table exists
    private static boolean isTableExists(Connection con, String tableName) throws SQLException {
        DatabaseMetaData meta = con.getMetaData();
        ResultSet resultSet = meta.getTables(null, null, tableName, new String[] {"TABLE"});
        return resultSet.next();
    }

    // Method to create student1 table
    private static void createStudentTable(Connection con) throws SQLException {
        Statement st = con.createStatement();
        st.executeUpdate("CREATE TABLE student1 (rno INT, name VARCHAR(20), branch VARCHAR(20))");
        System.out.println("Table 'student1' created successfully.");
        st.close();
    }

    // Method to insert values into student1 table
    private static void insertValuesIntoStudentTable(Connection con) {
        try {
            // Create a prepared statement
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO student1 (rno, name, branch) VALUES (?, ?, ?)");

            // Inserting a single row
            pstmt.setInt(1, 1);
            pstmt.setString(2, "arjun");
            pstmt.setString(3, "cse");
            // Inserting a single row
            pstmt.setInt(1, 2);
            pstmt.setString(2, "Annapoorna");
            pstmt.setString(3, "cse");
            // Inserting a single row
            pstmt.setInt(1, 2);
            pstmt.setString(2, "tirumala");
            pstmt.setString(3, "It");



            // Execute update
            int rowsInserted = pstmt.executeUpdate();
            System.out.println(rowsInserted + " record inserted successfully.");

            // Close prepared statement
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
