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
public enum Size {
    //each element has a value (only necessary if implenting second way of calculating added price)
    XS(0.22f), S(0.23f), M(0.25f), L(0.30f), XL(0.35f), XXL(0.40f), XXXL(0.60f);
    
    //the following are needed in order to set value addedPrice for each size
    private final float addedPrice;

    public float getAddedPrice() {
        return addedPrice;
    }

    private Size(float addedPrice) {
        this.addedPrice = addedPrice;
    }
    
    
    //first way of calculating added price based on size
    public float getSizePrice(int ordinal) {
        
        float result = 0;
        switch (ordinal) {
            case 0:
                result = 0.22f;
                break;
            case 1:
                result = 0.23f;
                break;
            case 2:
                result = 0.25f;
                break;
            case 3:
                result = 0.30f;
                break;
            case 4:
                result = 0.35f;
                break;
            case 5:
                result = 0.40f;
                break;
            case 6:
                result = 0.60f;
                break;
        }
       return result;
    }
    
    //second way of calculating added price based on size
    //might prove useful if list of sizes has many elements
    public float getSizePrice2(int ordinal) {
        Size[] sizes = Size.values();
        float result = 0;
        for(Size size : sizes) {
            if(ordinal == size.ordinal()) {
                result += size.getAddedPrice();
            }
        }
        return result;
    }
}


