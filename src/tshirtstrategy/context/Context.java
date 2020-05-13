/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tshirtstrategy.context;

import tshirtstrategy.models.Color;
import tshirtstrategy.models.Fabric;
import tshirtstrategy.models.Size;
import tshirtstrategy.models.TShirt;
import tshirtstrategy.strategy.IPayment;

/**
 *
 * @author Odisseas KD
 */
public class Context {
    
    private IPayment payment;

    public Context(IPayment payment) {
        this.payment = payment;
    }
    
    public float makePayment(TShirt tShirt) {
        return payment.pay(tShirt.getPrice(), tShirt.getColor(), tShirt.getSize(), tShirt.getFabric());
    }
}
