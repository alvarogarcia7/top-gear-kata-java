package com.lagerweij;

import java.util.Arrays;

import com.lagerweij.GearBox.GearBoxScheme;
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
        shiftUpTo(1);
        shiftUpTo(2);
        shiftUpTo(3);
        shiftUpTo(4);
        shiftUpTo(5);
        shiftUpTo(6);
        shiftUpTo(6);
    }

    @Test
    public void use_the_custom_scheme() {
        final TestableGearBox gearBox1 = new TestableGearBox(new GearBox(Arrays.asList(new GearBoxScheme(100, 150), new GearBoxScheme(100, 150))));
        gearBox1.doit(0);
        assertThat(gearBox1.getGear(), Is.is(1));
        gearBox1.doit(160);
        assertThat(gearBox1.getGear(), Is.is(2));
        gearBox1.doit(160);
        assertThat(gearBox1.getGear(), Is.is(3));
        gearBox1.doit(160);
        assertThat(gearBox1.getGear(), Is.is(3));
    }

    @Test
    public void staying_within_the_rpm_limit_does_not_change_gears() {
        stayIn(1);
        stayIn(2);
        stayIn(3);
        stayIn(4);
        stayIn(5);
        stayIn(6);
        stayIn(6);
    }

    @Test
    public void below_the_lower_bound_it_shifts_gear_down() {
        shiftUpToThenDescendOne(1);
        shiftUpToThenDescendOne(2);
        shiftUpToThenDescendOne(3);
        shiftUpToThenDescendOne(4);
        shiftUpToThenDescendOne(5);
        shiftUpToThenDescendOne(6);
    }

    @Test
    public void cannot_shift_up_from_the_uppest_gear() {
        final TestableGearBox gearBox = gearBoxReadingGear(6);
        final int gear = gearBox.getGear();
        assertThat(gear, Is.is(6));
        shiftUp(gearBox, 1);
        assertThat(gear, Is.is(6));
    }

    private void shiftUpToThenDescendOne(int gearNumber) {
        final TestableGearBox gearBox = gearBoxReadingGear(gearNumber);
        System.out.println(gearBox.gear);
        shiftDown(gearBox, 1);
        assertThat(gearBox.getGear(), Is.is(gearNumber - 1));
    }

    private void stayIn(int gearNumber) {
        final TestableGearBox gearBox = gearBoxReadingGear(gearNumber);
        inTheThreshold(gearBox);
        final int gear = gearBox.getGear();
        assertThat(gear, Is.is(gearNumber));
    }

    private void shiftUpTo(int gearNumber) {
        final TestableGearBox gearBox = gearBoxReadingGear(gearNumber);
        final int gear = gearBox.getGear();
        assertThat(gear, Is.is(gearNumber));
    }

    private TestableGearBox gearBoxReadingGear(int gearNumber) {
        final TestableGearBox gearBox = TestableGearBox.aNew();
        shiftUp(gearBox, gearNumber);
        return gearBox;
    }

    private void shiftUp(TestableGearBox gearBox, int times) {
        for (int i = 0; i < times; i++) {
            gearBox.doit(2500);
        }
    }

    private void inTheThreshold(TestableGearBox gearBox) {
        gearBox.doit(600);
    }

    private void shiftDown(TestableGearBox gearBox, int times) {
        for (int i = 0; i < times; i++) {
            gearBox.doit(400);
        }
    }

}
