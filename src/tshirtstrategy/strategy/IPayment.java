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
}
