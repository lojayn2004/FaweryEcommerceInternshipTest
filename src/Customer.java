public class Customer {

    private String customerName;
    private double  balance;

    private ShoppingCart cart;

    public Customer(String customerName, double balance) {
         this.customerName = customerName;
         this.balance = balance;
         cart = new ShoppingCart();
    }

    // Adding to the cart doesnot requires that he has bought the item so we don't decrease the size here we decraese it in the checkout
    public void AddProductToCart(Product product, int quantity) throws Exception {
          if(product.GetAvaliableQuantity() < quantity)  {
              throw new Exception("Cannot Add Quantity of product to cart \nQuantity needed exceeds the avaliable");
          }
          cart.AddProduct(product, quantity);
    }


    public void CheckOut() throws Exception {
        double fees = cart.CheckOut();
        if(fees > balance) {
            throw new Exception("No sufficient balance in customer balance");
        }
        balance -= fees;
        System.out.println("Checkout is done successfully!");
        System.out.println("Your Current Balance is: " + balance);
        System.out.println("Wait for your items to be shipped\n");
    }

}
