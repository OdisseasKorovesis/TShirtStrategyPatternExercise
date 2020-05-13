/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tshirtstrategy.strategy;

import tshirtstrategy.models.Color;
import tshirtstrategy.models.Fabric;
import tshirtstrategy.models.Size;

/**
 *
 * @author Odisseas KD
 */
public class BankPaymentImpl extends PaymentImpl implements IPayment {

    @Override
    public float pay(float basePrice, Color color, Size size, Fabric fabric) {
        float result = super.getItemPrice(basePrice, color, size, fabric) * 1.05f;      
        //adding 5% when paying with bank transfer
        return result;
    }
    
}
