import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
    private Map<Product, Integer> cartItems;

    public ShoppingCart() {
        cartItems = new HashMap<>();
    }


    public void AddProduct(Product product, int quantity) {
        cartItems.put(product, quantity);
    }

    public double CheckOut() throws Exception {
        if(cartItems.isEmpty()) {
            throw new Exception("No Items In Cart\n");
        }
        List<ShippingItem> _shippedItems = new ArrayList<>();

        for(Product product : cartItems.keySet()) {
            int quantity = cartItems.get(product);
            if(IsValidProduct(product)) {
                product.DecreaseProductQuantity(quantity);
                if(!(product.GetShippingStrategy() instanceof UnShippableStrategy)) {
                    _shippedItems.add(new ShippingItem(product.getProductName(), product.GetWeight(), quantity, product.getProductPrice()));
                }
            }
        }

        return ShippingService.CheckOut(_shippedItems);
    }

    private boolean IsValidProduct(Product product) throws Exception {
        int quantity = cartItems.get(product);
        if(product.GetAvaliableQuantity() < quantity) {
            throw new Exception("Product  quantity is not sufficient!\n");
        }

        if(product.IsExpired()) {
            throw new Exception("Product " + product.getProductName() +  " is Expired!\n");
        }

        return true;
    }


}
