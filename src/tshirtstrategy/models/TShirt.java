/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tshirtstrategy.models;

import java.util.Objects;

/**
 *
 * @author Odisseas KD
 */
public class TShirt {

    private String name;    
    private Color color;
    private Size size;
    private Fabric fabric;
    private float basePrice = 10.0f;
    private float price;

    public TShirt() {
    }

    public TShirt(String name, Color color, Size size, Fabric fabric, float price) {
        this.name = name;        
        this.color = color;
        this.size = size;
        this.fabric = fabric;
        setPrice(price);
    }

    public Fabric getFabric() {
        return fabric;
    }

    public void setFabric(Fabric fabric) {
        this.fabric = fabric;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }
    
    public void setPrice(float price) {
        this.price = this.basePrice + price;
    }

    public float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(float basePrice) {
        this.basePrice = basePrice;
    }   
    

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Float.floatToIntBits(this.price);
        hash = 67 * hash + Objects.hashCode(this.color);
        hash = 67 * hash + Objects.hashCode(this.size);
        hash = 67 * hash + Objects.hashCode(this.fabric);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TShirt other = (TShirt) obj;
        if (Float.floatToIntBits(this.price) != Float.floatToIntBits(other.price)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.color != other.color) {
            return false;
        }
        if (this.size != other.size) {
            return false;
        }
        if (this.fabric != other.fabric) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Characteristics: Color=" + color + ", Size=" + size + ", Fabric=" + fabric;
    }

}
