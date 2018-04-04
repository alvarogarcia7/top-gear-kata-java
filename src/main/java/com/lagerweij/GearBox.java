/*
 * CodingAssignments Refactoring: GearBox
 *
 * This is a refactoring challenge where the candidate can look at a single-method
 * case, where the method is untested, needs refactoring, and is hard to read. Oh,
 * and contains bugs;-)
 *
 * The assignment is as follows:
 *
 * This is the code for our customer's new environmentally friendly electric car.
 * The car is very dependent on software for almost everything, and the part that we're
 * working on is the automatic gear box. The code you see is the automatic gear box, which
 * currently shifts up if the engine goes over 2000 rpm, and down if it goes under 500.
 *
 * For our this new car, it's been determined that the choice of gear can be much
 * more efficient if we could just set more specific ranges of rpm for each gear.
 * Future versions of the car could then use actual measurements of fuel consumption
 * to configure those ranges on the fly!
 * Your assignment is to make the gearbox accept a range of rpms for each gear (and
 * of course use that range to shift gears!)
 *
 */

package com.lagerweij;

public class GearBox {

    protected int gear = 0;
    private final int UPPER_BOUND_RPM = 2000;
    private final int LOWER_BOUND_RPM = 500;

    public void doit(int rpm) {
        if (this.gear == 0) {
            this.gear++;
            return;
        }
        if (this.gear >= 6) {
            return;
        }
        if (rpm > this.UPPER_BOUND_RPM) {
            this.gear++;
        }
    }
}
