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
public enum Fabric {
    //each element has a value (only necessary if implenting second way of calculating added price)
    WOOL(2.5f), COTTON(4.5f), POLYESTER(5.0f), RAYON(7.5f), LINEN(8.2f), CASHMERE(9.3f), SILK(22.0f);
    
    //the following are needed in order to set value addedPrice for each fabric
    private final float addedPrice;

    public float getAddedPrice() {
        return addedPrice;
    }

    private Fabric(float addedPrice) {
        this.addedPrice = addedPrice;
    }
    
    //first way of calculating added price based on size
    public float getFabricPrice(int ordinal) {
        
        float result = 0;
        switch (ordinal) {
            case 0:
                result = 2.5f;
                break;
            case 1:
                result = 4.5f;
                break;
            case 2:
                result = 5.0f;
                break;
            case 3:
                result =7.5f;
                break;
            case 4:
                result = 8.2f;
                break;
            case 5:
                result = 9.3f;
                break;
            case 6:
                result = 22.0f;
                break;
        }
        return result;
    }
    
    //second way of calculating added price based on size
    //might prove useful if list of sizes has many elements
    public float getFabricPrice2(int ordinal) {
        Fabric[] fabrics = Fabric.values();
        float result = 0;
        for(Fabric fabric : fabrics) {
            if(ordinal == fabric.ordinal()) {
                result += fabric.getAddedPrice();
            }
        }
        return result;
    }
}
