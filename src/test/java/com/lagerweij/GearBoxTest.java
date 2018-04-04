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
        final TestableGearBox gearBox = new TestableGearBox();
        shiftUp(gearBox, 1);
        final int s = gearBox.getS();
        assertThat(s, Is.is(1));
    }

    private void shiftUp(TestableGearBox gearBox, int times) {
        for (int i = 0; i < times; i++) {
            gearBox.doit(2500);
        }
    }

}
