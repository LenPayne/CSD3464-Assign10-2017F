/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assign10;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author c0587637
 */
public class ScheduleTest {

    public ScheduleTest() {
    }

    @Test
    public void testValidEmployeeId() {
        Schedule instance = new ScheduleImpl();
        instance.setEmployeeId("abc0123456");
        String expResult = "abc0123456";
        String result = instance.getEmployeeId();
        assertEquals(expResult, result);
    }

    @Test
    public void testInvalidEmployeeId() {
        Schedule instance = new ScheduleImpl();
        instance.setEmployeeId("0123abc456");
        String expResult = null;
        String result = instance.getEmployeeId();
        assertEquals(expResult, result);
    }

    @Test
    public void testValid9To5OfSunday() {
        int day = 0;
        Schedule instance = new ScheduleImpl();
        instance.setHoursOfDay(0, new WorkingHours(9, 0, 17, 0));
        WorkingHours expResult = new WorkingHours(9, 0, 17, 0);
        WorkingHours result = instance.getHoursOfDay(day);
        assertEquals(expResult, result);
    }

    @Test
    public void testInvalidNegative4To26OfSunday() {
        int day = 0;
        Schedule instance = new ScheduleImpl();
        boolean hasThrownException = false;
        try {
            instance.setHoursOfDay(0, new WorkingHours(-4, 0, 26, 0));
            WorkingHours expResult = null;
            WorkingHours result = instance.getHoursOfDay(day);
            assertEquals(expResult, result);
        } catch (TimeException ex) {
            hasThrownException = true;
        }
        assertTrue(hasThrownException);
    }

    @Test
    public void testNotEqualsNull() {
        Object obj = null;
        ScheduleImpl instance = new ScheduleImpl();
        instance.setEmployeeId("abc0234234");
        instance.setHoursOfDay(2, new WorkingHours(9, 0, 17, 0));
        instance.setHoursOfDay(3, new WorkingHours(9, 0, 17, 0));
        instance.setHoursOfDay(4, new WorkingHours(9, 0, 17, 0));
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    @Test
    public void testNotEqualsDifferent() {
        Object obj = null;
        ScheduleImpl instance1 = new ScheduleImpl();
        instance1.setEmployeeId("abc0234234");
        instance1.setHoursOfDay(2, new WorkingHours(9, 0, 17, 0));
        instance1.setHoursOfDay(3, new WorkingHours(9, 0, 17, 0));
        instance1.setHoursOfDay(4, new WorkingHours(9, 0, 17, 0));
        ScheduleImpl instance2 = new ScheduleImpl();
        instance2.setEmployeeId("abc0123456");
        instance2.setHoursOfDay(2, new WorkingHours(8, 0, 17, 0));
        instance2.setHoursOfDay(3, new WorkingHours(9, 0, 15, 0));
        instance2.setHoursOfDay(4, new WorkingHours(9, 0, 12, 0));
        boolean expResult = false;
        boolean result = instance1.equals(instance2);
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals() {
        Object obj = null;
        ScheduleImpl instance1 = new ScheduleImpl();
        instance1.setEmployeeId("abc0234234");
        instance1.setHoursOfDay(2, new WorkingHours(9, 0, 17, 0));
        instance1.setHoursOfDay(3, new WorkingHours(9, 0, 17, 0));
        instance1.setHoursOfDay(4, new WorkingHours(9, 0, 17, 0));
        ScheduleImpl instance2 = new ScheduleImpl();
        instance2.setEmployeeId("abc0234234");
        instance2.setHoursOfDay(2, new WorkingHours(9, 0, 17, 0));
        instance2.setHoursOfDay(3, new WorkingHours(9, 0, 17, 0));
        instance2.setHoursOfDay(4, new WorkingHours(9, 0, 17, 0));
        boolean expResult = true;
        boolean result = instance1.equals(instance2);
        assertEquals(expResult, result);
    }

    @Test
    public void testToString() {
        try {
            Schedule instance = new ScheduleImpl();
            instance.setEmployeeId("abc0234234");
            instance.setHoursOfDay(2, new WorkingHours(9, 0, 17, 0));
            instance.setHoursOfDay(3, new WorkingHours(9, 0, 17, 0));
            instance.setHoursOfDay(4, new WorkingHours(9, 0, 17, 0));
            JSONObject expResult = (JSONObject) new JSONParser().parse("{\"Thursday\":{\"startTime\":\"9:00\",\"endTime\":\"17:00\"},\"Wednesday\":{\"startTime\":\"9:00\",\"endTime\":\"17:00\"},\"employeeId\":\"abc0234234\",\"Tuesday\":{\"startTime\":\"9:00\",\"endTime\":\"17:00\"}}");
            JSONObject result = (JSONObject) new JSONParser().parse(instance.toString());
            assertEquals(expResult, result);
        } catch (ParseException ex) {
            fail("One of the JSON Objects is invalid JSON. Go to jsonlint.com to find out why.");
        }
    }

    public class ScheduleImpl extends Schedule {
    }

}
