import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class prep {
    public static void main(String[] args) throws Exception {
        // Load the MySQL driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish the connection
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "5261");

        // Prepare the SQL statement
        PreparedStatement ps = con.prepareStatement("INSERT INTO student1 (rno, name, branch) VALUES (?, ?, ?)");

        // Create a Scanner object to read input
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter roll number: ");
            int rno = sc.nextInt();
            sc.nextLine(); // Consume newline

            System.out.println("Enter name: ");
            String name = sc.nextLine();

            System.out.println("Enter branch: ");
            String branch = sc.nextLine();

            // Set the values for the PreparedStatement
            ps.setInt(1, rno);
            ps.setString(2, name);
            ps.setString(3, branch);

            // Execute the update
            ps.executeUpdate();

            System.out.println("Record inserted successfully.");

            // Ask the user if they want to insert another record
            System.out.println("Do you want to insert another record? (yes/no): ");
            String answer = sc.nextLine();
            if (!answer.equalsIgnoreCase("yes")) {
                break;
            }
        }

        // Close the resources
        ps.close();
        con.close();
        sc.close();
    }
}
