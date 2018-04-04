package com.lagerweij;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class GearBoxTest {

    @Test
    public void canary_test() {
        Assert.assertTrue(true);
    }

    @Test
    public void over_the_upper_bound_it_shifts_gear_up() {
        shiftTo(1);
        shiftTo(2);
        shiftTo(3);
        shiftTo(4);
        shiftTo(5);
        shiftTo(6);
    }

    private void shiftTo(int gearNumber) {
        final TestableGearBox gearBox = new TestableGearBox();
        shiftUp(gearBox, gearNumber);
        final int gear = gearBox.getGear();
        assertThat(gear, Is.is(gearNumber));
    }

    private void shiftUp(TestableGearBox gearBox, int times) {
        for (int i = 0; i < times; i++) {
            gearBox.doit(2500);
        }
    }

}
