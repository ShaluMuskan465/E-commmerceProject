
import java.sql.*;
import java.util.Scanner;

    public class Login {
        public static int loginUser() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Username: ");
            String user = sc.nextLine();
            System.out.print("Enter Password: ");
            String pass = sc.nextLine();

            try {
                Connection con = DBConnection.getConnection();
                PreparedStatement pst = con.prepareStatement(
                        "SELECT * FROM users WHERE username=? AND password=?"
                );
                pst.setString(1, user);
                pst.setString(2, pass);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    System.out.println("\nLOGIN SUCCESSFUL!\n");
                    return rs.getInt("id");
                } else {
                    System.out.println("Invalid credentials! Try again.");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            return -1;
        }
    }

