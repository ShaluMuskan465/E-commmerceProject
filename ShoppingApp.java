
    import java.util.Scanner;

    public class ShoppingApp {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int userId = -1;
            while (userId == -1) {
                userId = Login.loginUser();
            }

            while (true) {
                System.out.println("1. View Products");
                System.out.println("2. Add to Cart");
                System.out.println("3. Place Order");
                System.out.println("4. Exit");

                System.out.print("Choose option: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1: ProductService.viewProducts(); break;
                    case 2: CartService.addToCart(userId); break;
                    case 3: CartService.placeOrder(userId); break;
                    case 4: System.out.println("Thank you for shopping!"); return;
                    default: System.out.println("Invalid choice.");
                }
            }
        }
    }


