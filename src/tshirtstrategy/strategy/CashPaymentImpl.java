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
public class CashPaymentImpl implements IPayment  {

    @Override
    public float pay(float basePrice, Color color, Size size, Fabric fabric) {        
        float result = getItemPrice(basePrice, color, size, fabric);
        //no additional price when paying with cash
        return result;
    }
    
}
