
package tshirtstrategy;


import tshirtstrategy.context.Context;
import tshirtstrategy.models.Color;
import tshirtstrategy.models.Fabric;
import tshirtstrategy.models.Size;
import tshirtstrategy.models.TShirt;
import tshirtstrategy.strategy.BankPaymentImpl;
import tshirtstrategy.strategy.CardPaymentImpl;
import tshirtstrategy.strategy.CashPaymentImpl;


public class MainClass {

    private static Context context;
    
    public static void main(String[] args) {
        TShirt tShirt = new TShirt("Polo", Color.ORANGE, Size.XL, Fabric.LINEN, 15);
        
        context = new Context(new CardPaymentImpl());
        float cardPrice = context.makePayment(tShirt);
        context = new Context(new BankPaymentImpl());
        float bankPrice = context.makePayment(tShirt);
        context = new Context(new CashPaymentImpl());
        float cashPrice = context.makePayment(tShirt);
        
        printPrices(tShirt, cardPrice, bankPrice, cashPrice);        
    }
    
    public static void printPrices(TShirt tShirt, float cardPrice, float bankPrice, float cashPrice) {
        System.out.printf("For %s tshirt pricing is as follows \n", tShirt.getName());
        System.out.printf("1. Card price: %20f \n", cardPrice);
        System.out.printf("2. Bank transfer price: %11f \n", bankPrice);
        System.out.printf("3. Cash price: %20f \n", cashPrice);
    }   
}
