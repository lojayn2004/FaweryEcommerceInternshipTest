import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date date = new Date(2026 - 1900, 7, 4);
        Product  cheese = new Product(
                "Cheese",
                100,
                10,
                new NormalShippableStrategy(200),
                new NormalExpiryStrategy(date));

        Product  biscuits = new Product(
                "Biscuits",
                350,
                9,
                new NormalShippableStrategy(700),
                new NormalExpiryStrategy(date));

        Product scratchCard = new Product(
                "ScratchCard",
                200,
                9,
                new UnShippableStrategy(),
                new NonExpiryStrategy());

        Customer judy = new Customer("Judy", 40000);
        Customer ali = new Customer("Ali", 70000);

        try {

            judy.AddProductToCart(cheese, 3);
            judy.AddProductToCart(biscuits, 4);

            judy.CheckOut();
        }
        catch(Exception ex) {
            // Use Ascii to print red to screen
            System.out.println("\033[0;31m" + ex.getMessage() + "\033[0;31m");
        }

    }
}