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
        gearBox.doit(2500);
        final int s = gearBox.getS();
        assertThat(s, Is.is(1));
    }

}
