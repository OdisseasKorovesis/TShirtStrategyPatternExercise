/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tshirtstrategy.strategy;

import tshirtstrategy.models.Color;
import tshirtstrategy.models.Fabric;
import tshirtstrategy.models.Size;
import tshirtstrategy.models.TShirt;

/**
 *
 * @author Odisseas KD
 */
public interface IPayment {
    float pay(float basePrice, Color color, Size size, Fabric fabric);
    
    default float getItemPrice(float basePrice, Color color, Size size, Fabric fabric) {
        float result = basePrice;
        result += color.getColorPrice2(color.ordinal());
        result += size.getSizePrice2(size.ordinal());
        result += fabric.getFabricPrice2(fabric.ordinal());
        return result;
    }
}
