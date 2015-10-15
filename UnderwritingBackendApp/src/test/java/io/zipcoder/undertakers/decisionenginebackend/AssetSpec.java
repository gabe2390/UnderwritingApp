package io.zipcoder.undertakers.decisionenginebackend;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
/**
 * Specification and unit tests for Asset class
 * @author Gregory Furlong
 */
public class AssetSpec {
    private String type;
    private String name;
    private int value;

    private Asset asset;

    @Before
    public void before() {
        this.name = "Some asset";
        this.type = "Doodad";
        this.value = 40000;

        this.asset = new Asset(this.type, this.name, this.value);
    }

    @Test
    public void testGetName() {
        assertEquals("getName should return 'Some asset'", this.name, this.asset.getName());
    }

    @Test
    public void testGetType() {
        assertEquals("getType should return 'Some asset'", this.type, this.asset.getType());
    }

    @Test
    public void testGetValue() {
        assertEquals("getValue should return 40000", this.value, this.asset.getValue());
    }

    @Test
    public void testCalculateScoreDefault() {
        assertEquals("calculateValue should return 4", this.value / 1000, this.asset.calculateValue());
    }

    @Test
    public void testCalculateScoreCar() {
        this.value = 20000;
        this.asset = new Asset("car", "Subaru", this.value);

        assertEquals("calculateValue should return 16", (int) ((this.value * .8) / 1000), this.asset.calculateValue());
    }
}
