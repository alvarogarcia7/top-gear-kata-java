package com.lagerweij;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class GearBoxTest {

    @Test
    public void canary_test() {
        Assert.assertTrue(true);
    }

    @Test
    public void over_the_upper_bound_it_shifts_gear_up() {
        shiftUpTo(1);
        shiftUpTo(2);
        shiftUpTo(3);
        shiftUpTo(4);
        shiftUpTo(5);
        shiftUpTo(6);
        shiftUpTo(6);
    }

    @Test
    @Ignore("Discuss with business whether it should shift down or not")
    public void below_the_lower_bound_it_shifts_gear_down() {
        shiftUpToThenDescendOneTo(1);
        shiftUpToThenDescendOneTo(2);
        shiftUpToThenDescendOneTo(3);
        shiftUpToThenDescendOneTo(4);
        shiftUpToThenDescendOneTo(5);
        shiftUpToThenDescendOneTo(6);
        shiftUpToThenDescendOneTo(6);
    }

    private void shiftUpToThenDescendOneTo(int gearNumber) {
        final TestableGearBox gearBox = gearBoxReadingGear(gearNumber + 1);
        shiftDown(gearBox, 1);
        assertThat(gearBox.getGear(), Is.is(gearNumber));
    }

    @Test
    public void cannot_shift_up_from_the_uppest_gear() {
        final TestableGearBox gearBox = gearBoxReadingGear(6);
        final int gear = gearBox.getGear();
        assertThat(gear, Is.is(6));
        shiftUp(gearBox, 1);
        assertThat(gear, Is.is(6));
    }

    private void shiftUpTo(int gearNumber) {
        final TestableGearBox gearBox = gearBoxReadingGear(gearNumber);
        final int gear = gearBox.getGear();
        assertThat(gear, Is.is(gearNumber));
    }

    private TestableGearBox gearBoxReadingGear(int gearNumber) {
        final TestableGearBox gearBox = new TestableGearBox();
        shiftUp(gearBox, gearNumber);
        return gearBox;
    }

    private void shiftUp(TestableGearBox gearBox, int times) {
        for (int i = 0; i < times; i++) {
            gearBox.doit(2500);
        }
    }

    private void shiftDown(TestableGearBox gearBox, int times) {
        for (int i = 0; i < times; i++) {
            gearBox.doit(400);
        }
    }

}
