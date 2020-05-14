package tshirtstrategy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
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

    private static Context context;

    public static void main(String[] args) {
        
        HashMap<String, Float> allPayments = allPossiblePrices();
        
    }

    public static void printPrices(TShirt tShirt, HashMap<String, Float> allPayments) {
        System.out.printf("For tshirt No. %s pricing is as follows \n", tShirt.getName());
        System.out.println("(" + tShirt.toString() + ")");
        for (String key : allPayments.keySet()) {
            System.out.println(key.replace("Impl", "") + " " + allPayments.get(key));
        }
    }

    public static void createCatalog(TShirt tShirt, HashMap<String, Float> allPayments) {
        try {
            File myCatalog = new File("C:\\Users\\Odisseas KD\\Desktop\\Coding\\catalog.txt");
            PrintWriter pw = new PrintWriter(new FileWriter(myCatalog, true));
            pw.printf("For tshirt No. %s pricing is as follows \n", tShirt.getName());
            pw.println("(" + tShirt.toString() + ")");
            for (String key : allPayments.keySet()) {
                pw.println(key.replace("Impl", "") + " " + allPayments.get(key));               
            }
            pw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static HashMap<String, Float> allPossiblePrices() {
        HashMap<String, Float> allPayments = new HashMap();
        IPayment[] p = new IPayment[]{new CardPaymentImpl(), new BankPaymentImpl(), new CashPaymentImpl()};
        List<IPayment> payments = Arrays.asList(p);
        TShirt tshirt = new TShirt();
        int counter = 1;
        for (Color color : Color.values()) {
            tshirt.setColor(color);
            for (Size size : Size.values()) {
                tshirt.setSize(size);
                for (Fabric fabric : Fabric.values()) {
                    tshirt.setFabric(fabric);
                    tshirt.setName(String.valueOf(counter));
                    Context context = new Context(payments);
                    allPayments = context.makeAllPayments(tshirt);
                    printPrices(tshirt, allPayments);
                    createCatalog(tshirt, allPayments);
                    counter++;
                }
            }
        }
        return allPayments;
    }    
}
