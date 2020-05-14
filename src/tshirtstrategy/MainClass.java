package tshirtstrategy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import tshirtstrategy.context.Context;
import tshirtstrategy.models.Color;
import tshirtstrategy.models.Fabric;
import tshirtstrategy.models.Size;
import tshirtstrategy.models.TShirt;
import tshirtstrategy.strategy.BankPaymentImpl;
import tshirtstrategy.strategy.CardPaymentImpl;
import tshirtstrategy.strategy.CashPaymentImpl;
import tshirtstrategy.strategy.IPayment;

public class MainClass {   

    public static void main(String[] args) {

        List<HashMap<String, Float>> allProductsWithPrices = allProductsWithPrices();

    }

    //this method prints each possible TShirt
    //with its final prices depending on payment method
    public static void printPrices(TShirt tShirt, HashMap<String, Float> allPayments) {
        System.out.printf("\nFor tshirt No. %s pricing and characteristics are as follows \n", tShirt.getName());
        System.out.println(tShirt.toString());
        for (String key : allPayments.keySet()) {
            System.out.println(key.replace("Impl", "") + ": " + allPayments.get(key));
        }
    }

    //this method creates a text file containing each possible TShirt
    //with its final prices depending on payment method
    public static void createCatalog(TShirt tShirt, HashMap<String, Float> allPayments) {
        try {
            File myCatalog = new File("C:\\Users\\Odisseas KD\\Desktop\\Coding\\catalog.txt");
            PrintWriter pw = new PrintWriter(new FileWriter(myCatalog, true));            
            pw.printf("\nFor tshirt No. %s pricing and characteristics are as follows \n", tShirt.getName());
            pw.println(tShirt.toString());
            for (String key : allPayments.keySet()) {
                pw.println(key.replace("Impl", "") + ": " + allPayments.get(key));
            }
            pw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    
    public static List<HashMap<String, Float>> allProductsWithPrices() {
        List<HashMap<String, Float>> allPrices = new ArrayList();
        IPayment[] p = new IPayment[]{new CardPaymentImpl(), new BankPaymentImpl(), new CashPaymentImpl()};
        List<IPayment> payments = Arrays.asList(p);
        int counter = 1;
        for (Color color : Color.values()) {
            TShirt tshirt = new TShirt();
            tshirt.setColor(color);
            for (Size size : Size.values()) {
                tshirt.setSize(size);
                for (Fabric fabric : Fabric.values()) {
                    tshirt.setFabric(fabric);
                    tshirt.setName(String.valueOf(counter));
                    Context context = new Context(payments);
                    HashMap<String, Float> allPayments = context.makeAllPayments(tshirt);
                    allPrices.add(allPayments);
                    printPrices(tshirt, allPayments);
                    createCatalog(tshirt, allPayments);
                    counter++;
                }
            }
        }
        return allPrices;
    }
}
