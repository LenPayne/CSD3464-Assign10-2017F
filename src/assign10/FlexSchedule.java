/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assign10;

/**
 *
 * @author c0587637
 */
public class FlexSchedule extends Schedule {

    private int missedLastWeek;
    private int totalHours;

    public FlexSchedule() {
        this.missedLastWeek = 0;
        this.totalHours = 0;
    }

    public int getmissedlastweek() {
        return missedLastWeek;
    }

    public void setmissedlastweek(int missedLastWeek) {
        this.missedLastWeek = missedLastWeek;
    }

    public double getTimeLeft() {
        // TODO: Get a running total (sum) of the Duration of all WorkingHours
        // TODO: Subtract the running total from the totalHours
        return 0;
    }
}
