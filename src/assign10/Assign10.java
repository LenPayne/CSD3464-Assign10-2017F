package assign10;

/**
 *
 * @author <ENTER YOUR NAME HERE>
 */
public class Assign10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Your team lead has also asked you to build a proof-of-concept
         * Schedule record. In the main method of your application, instantiate
         * one object of each regular class: SalarySchedule, FlexSchedule and
         * FixedSchedule. Use their getters and setters to build a sample, and
         * put all of them in an array of Schedule objects. Iterate over the
         * array and output the JSON objects as a valid JSON array. You can use
         * www.jsonlint.com to validate your JSON objects.
         */

        // NOTE: The following code should actually work when you're done.
        //       DO NOT CHANGE IT
        SalarySchedule salary = new SalarySchedule();
        salary.setEmployeeId("abc0123456");
        salary.setFlexDaysRemaining(40);

        FlexSchedule flex = new FlexSchedule();
        flex.setEmployeeId("abc0456789");
        flex.setMissedLastWeek(3);
        flex.setTotalHours(24);
        flex.setHoursOfDay(1, new WorkingHours(9, 0, 17, 0));
        flex.setHoursOfDay(3, new WorkingHours(9, 0, 17, 0));
        flex.setHoursOfDay(5, new WorkingHours(9, 0, 17, 0));

        FixedSchedule fixed = new FixedSchedule();
        fixed.setEmployeeId("abc0234234");
        fixed.setHoursOfDay(2, new WorkingHours(9, 0, 17, 0));
        fixed.setHoursOfDay(3, new WorkingHours(9, 0, 17, 0));
        fixed.setHoursOfDay(4, new WorkingHours(9, 0, 17, 0));

        // TODO: Put all of the above in an array of Schedule objects. Iterate over the
        //       array and output the JSON objects as a valid JSON array. You can use
        //       www.jsonlint.com to validate your JSON objects.
    }

}
