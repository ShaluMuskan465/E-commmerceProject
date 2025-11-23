
    import java.sql.*;
import java.util.Scanner;

    public class CartService {
        public static void addToCart(int userId) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Product ID to add: ");
            int pid = sc.nextInt();
            System.out.print("Enter Quantity: ");
            int qty = sc.nextInt();

            try {
                Connection con = DBConnection.getConnection();
                PreparedStatement pst = con.prepareStatement(
                        "INSERT INTO cart(user_id, product_id, quantity) VALUES (?,?,?)"
                );
                pst.setInt(1, userId);
                pst.setInt(2, pid);
                pst.setInt(3, qty);
                pst.executeUpdate();
                System.out.println("Product Added to Cart!\n");
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        public static void placeOrder(int userId) {
            double total = 0;
            try {
                Connection con = DBConnection.getConnection();
                PreparedStatement pst = con.prepareStatement(
                        "SELECT p.price, c.quantity FROM cart c " +
                                "JOIN products p ON c.product_id=p.id WHERE user_id=?"
                );
                pst.setInt(1, userId);
                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    total += rs.getDouble("price") * rs.getInt("quantity");
                }

                PreparedStatement pst2 = con.prepareStatement(
                        "INSERT INTO orders(user_id, total) VALUES(?,?)"
                );
                pst2.setInt(1, userId);
                pst2.setDouble(2, total);
                pst2.executeUpdate();

                con.createStatement().executeUpdate(
                        "DELETE FROM cart WHERE user_id=" + userId
                );

                System.out.println("Order Placed Successfully!");
                System.out.println("Total Amount: ₹" + total + "\n");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

