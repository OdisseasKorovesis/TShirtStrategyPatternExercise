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
public class PaymentImpl {
    
    //method to be called by all classes extending PaymentImpl 
    //can use either way of calculating color, size, fabric price
    //currently using the 2nd one
    public float getItemPrice(float basePrice, Color color, Size size, Fabric fabric) {
        float result = basePrice;
        result += color.getColorPrice2(color.ordinal());
        result += size.getSizePrice2(size.ordinal());
        result += fabric.getFabricPrice2(fabric.ordinal());
        return result;
    }
    
   
}
