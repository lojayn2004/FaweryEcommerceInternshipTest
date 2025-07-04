
import java.util.List;

public  class ShippingService {

    private static int shippingFees = 30;

    public static double CheckOut(List<ShippingItem> _items) {
        if(_items.isEmpty())
            return 0.0;
        PrintShippingNotice(_items);
        return PrintCheckoutReceipt(_items);

    }

    private static void PrintShippingNotice(List<ShippingItem> _items) {
        System.out.println("------------------------ Shipment notice ----------------------------\n");
        double totalWeight = 0.0;
        for(ShippingItem item: _items) {
            String format = "            %dx       %s      %sg";
            String shippingInfo = format.formatted(item.GetQuantity(), item.GetName(), item.GetWeight() * item.GetQuantity());
            totalWeight += item.GetWeight() * item.GetQuantity();
            System.out.println(shippingInfo);
        }

        System.out.print("\nTotal package weight ");
        System.out.println((totalWeight / 1000.0) + " kg");
        System.out.print("\n\n");
    }

    private static double PrintCheckoutReceipt(List<ShippingItem> _items) {
        System.out.println("------------------------ Checkout receipt ----------------------------\n");
        double subTotal = 0;
        for(ShippingItem item: _items) {
            String format = "            %dx       %s      %f$";
            String shippingInfo = format.formatted(item.GetQuantity(), item.GetName(), item.GetPrice() * item.GetQuantity());
            subTotal += item.GetQuantity() * item.GetPrice();
            System.out.println(shippingInfo);
        }

        System.out.print("\nSubtotal: ");
        System.out.println(subTotal);


        System.out.print("Shipping: ");
        System.out.println(shippingFees);


        System.out.print("Total: ");
        System.out.println(shippingFees + subTotal);

        System.out.print("\n\n");


        return shippingFees + subTotal;
    }
}
