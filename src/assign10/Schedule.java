package assign10;

import org.json.simple.JSONObject;

/**
 *
 * @author <ENTER YOUR NAME HERE>
 */
public class Schedule {

    private String employeeId;
    private final WorkingHours[] workingHours = new WorkingHours[7];

    public WorkingHours getHoursOfDay(int day) {
        return workingHours[0];
    }

    public void setHoursOfDay(int day, WorkingHours hours) {
        workingHours[day] = hours;
    }

    public String toString() {
        JSONObject json = new JSONObject();
        json.put("employeeId", employeeId);
        json.put("Sunday", workingHours[3].toJSON());
        return json.toJSONString();
    }
}
