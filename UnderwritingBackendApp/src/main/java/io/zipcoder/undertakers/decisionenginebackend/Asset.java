package io.zipcoder.undertakers.decisionenginebackend;

/**
 * Asset Class
 * @author Gregory Furlong
 */
public class Asset {
    private String type;
    private String name;
    private int value;


    public Asset() {
    }


    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Asset Constructor
     * @param type      The type of asset
     * @param name      The name of the asset
     * @param value     The current value in dollars
     */
    public Asset(String type, String name, int value) {
        this.type = type;
        this.name = name;
        this.value = value;
    }

    /**
     * Get type
     * @return  this asset's type
     */
    public String getType() {
        return this.type;
    }

    /**
     * Get name
     * @return  this asset's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get value
     * @return  this asset's value
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Calculate this asset's value based on its information
     * @return  Asset s
     */
    public int calculateScore() {
        if(this.type.toLowerCase().equals("car")) {
            return (int) (.8 * this.value)/1000;
        }
        else {
            return this.value/1000;
        }
    }
}
