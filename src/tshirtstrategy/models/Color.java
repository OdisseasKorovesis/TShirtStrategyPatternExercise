/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tshirtstrategy.models;

/**
 *
 * @author Odisseas KD
 */
public enum Color {
    //each element has a value (only necessary if implenting second way of calculating added price)
    RED (0.5f), ORANGE(0.15f), YELLOW(0.20f), GREEN(0.25f), BLUE(0.30f), INDIGO(0.35f), VIOLET(0.40f);
    
    //the following are needed in order to set value addedPrice for each color
    private final float addedPrice;

    public float getAddedPrice() {
        return addedPrice;
    }   

    private Color(float addedPrice) {
        this.addedPrice = addedPrice;
    }
    
    
    //first way of calculating added price based on color
    //currently not used
    public float getColorPrice(int ordinal) {        
        float result = 0;
        switch (ordinal) {
            case 0:
                result = 0.5f;
                break;
            case 1:
                result = 0.15f;
                break;
            case 2:
                result = 0.20f;
                break;
            case 3:
                result = 0.25f;
                break;
            case 4:
                result = 0.30f;
                break;
            case 5:
                result = 0.35f;
                break;
            case 6:
                result = 0.40f;
                break;
        }
        return result;
    }
    
    //second way of calculating added price based on color
    //might prove useful if list of colors has many elements
    public float getColorPrice2(int ordinal) {
        Color color = Color.values()[ordinal];        
        float result = color.getAddedPrice();        
        return result;
    }

}
