package com.lagerweij;

public class TestableGearBox extends GearBox {
    public TestableGearBox(GearBox gearBox) {
        super(gearBox.gearBoxSchemeList);
    }

    public static TestableGearBox aNew() {
        return new TestableGearBox(GearBox.aNew());
    }

    public int getGear() {
        return this.gear;
    }
}
