/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tshirtstrategy.context;

import java.util.HashMap;
import java.util.List;
import tshirtstrategy.models.TShirt;
import tshirtstrategy.strategy.IPayment;

/**
 *
 * @author Odisseas KD
 */
public class Context {
    
    private IPayment payment;
    private List<IPayment> payments;

    public Context(IPayment payment) {
        this.payment = payment;
    }
    
    public Context(List<IPayment> payments) {
        this.payments = payments;
    }
    
    public float makePayment(TShirt tShirt) {
        return payment.pay(tShirt.getBasePrice(), tShirt.getColor(), tShirt.getSize(), tShirt.getFabric());
    }
    
    public HashMap<String, Float> makeAllPayments(TShirt tShirt) {
        HashMap<String, Float> mapOfPayments = new HashMap();
        for(IPayment payment : this.payments) {            
            Float finalPrice = payment.pay(tShirt.getBasePrice(), tShirt.getColor(), tShirt.getSize(), tShirt.getFabric());
            mapOfPayments.put(payment.getClass().getSimpleName(), finalPrice);
        }        
       return mapOfPayments;
    }
}
