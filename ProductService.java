
    import java.sql.*;

    public class ProductService {
        public static void viewProducts() {
            try {
                Connection con = DBConnection.getConnection();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM products");

                System.out.println("\n===== PRODUCTS AVAILABLE =====");
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + ". " +
                            rs.getString("name") + " - ₹" +
                            rs.getDouble("price"));
                }
                System.out.println("=================================\n");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

