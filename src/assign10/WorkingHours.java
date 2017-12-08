package assign10;

import org.json.simple.JSONObject;

/**
 * A Super Useful Abstraction of Time because Java 7 doesn't have LocalTime. DO
 * NOT EDIT THIS FILE!!
 *
 * @author Len Payne <len.payne@lambtoncollege.ca>
 */
public class WorkingHours {

    private int startHour;
    private int startMin;
    private int endHour;
    private int endMin;

    /**
     * Constructor for a default workday from 9:00-5:00
     */
    public WorkingHours() {
        this.startHour = 9;
        this.startMin = 0;
        this.endHour = 17;
        this.endMin = 0;
    }

    /**
     * Constructor for a fully-detailed workday
     *
     * @param startHour the hour in which the workday starts
     * @param startMin the minute in which the workday starts
     * @param endHour the hour in which the workday ends
     * @param endMin the minute in which the workday ends
     */
    public WorkingHours(int startHour, int startMin, int endHour, int endMin) {
        setStartHour(startHour);
        setStartMin(startMin);
        setEndHour(endHour);
        setEndMin(endMin);
    }

    /**
     * Retrieve the hour that the workday started
     *
     * @return the hour that the workday started
     */
    public int getStartHour() {
        return startHour;
    }

    /**
     * Set the hour that the workday started
     *
     * @param startHour the hour that the workday started
     */
    public void setStartHour(int startHour) {
        if (startHour <= 23 && startHour >= 0) {
            this.startHour = startHour;
        } else {
            throw new TimeException("Starting Hour Invalid: " + startHour);
        }
    }

    /**
     * Retrieve the minute that the workday started
     *
     * @return the minute that the workday started
     */
    public int getStartMin() {
        return startMin;
    }

    /**
     * Set the minute that the workday started
     *
     * @param startMin the minute that the workday started
     */
    public void setStartMin(int startMin) {
        if (startMin <= 59 && startMin >= 0) {
            this.startMin = startMin;
        } else {
            throw new TimeException("Starting Minute Invalid: " + startMin);
        }
    }

    /**
     * Retrieve the hour that the workday ended
     *
     * @return the hour that the workday ended
     */
    public int getEndHour() {
        return endHour;
    }

    /**
     * Set the hour that the workday ended
     *
     * @param endHour the hour that the workday ended
     */
    public void setEndHour(int endHour) {
        if (this.endHour <= 23 && this.endHour >= 0) {
            this.endHour = endHour;
        } else {
            throw new TimeException("Ending Hour Invalid: " + endHour);
        }
    }

    /**
     * Retrieve the minute that the workday ended
     *
     * @return the minute that the workday ended
     */
    public int getEndMin() {
        return endMin;
    }

    /*
     * Set the minute that the workday ended
     *
     * @param endMin the minute that the workday ended
     */
    public void setEndMin(int endMin) {
        if (endMin <= 59 && endMin >= 0) {
            this.endMin = endMin;
        } else {
            throw new TimeException("Ending Minute Invalid: " + endMin);
        }
    }

    /**
     * Retrieve the duration of the workday in hours
     *
     * @return the duration of the workday in hours
     */
    public double getDuration() {
        int hours = endHour - startHour;
        int mins = endMin - startMin;
        if (mins < 0) { // eg: 9:45 - 4:15
            hours -= 1;
            mins += 60;
        }
        return hours + (mins / 60f);
    }

    /**
     * Retrieve the unique hashCode for this object
     *
     * @return the hashCode
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.startHour;
        hash = 53 * hash + this.startMin;
        hash = 53 * hash + this.endHour;
        hash = 53 * hash + this.endMin;
        return hash;
    }

    /**
     * Determine if another object is equal to this WorkingHours object
     *
     * @param obj the other object
     * @return whether or not the two objects represent the same workday
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof WorkingHours) {
            WorkingHours that = (WorkingHours) obj;
            return this.startHour == that.startHour
                    && this.startMin == that.startMin
                    && this.endHour == that.endHour
                    && this.endMin == that.endMin;
        } else {
            return false;
        }
    }

    /**
     * Retrieve a JSON representation of the workday translated to h:mm format
     *
     * @return the JSON string
     */
    @Override
    public String toString() {
        return toJSON().toJSONString();
    }

    /**
     * Retrieve a JSON Object representation of the workday
     *
     * @return the JSON Object
     */
    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("startTime", String.format("%d:%02d", startHour, startMin));
        json.put("endTime", String.format("%d:%02d", endHour, endMin));
        return json;
    }
}
