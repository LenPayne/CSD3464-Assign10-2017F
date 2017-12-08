/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assign10;

import assign10.WorkingHours;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author c0587637
 */
public class WorkingHoursTest {

    public WorkingHoursTest() {
    }

    @Test
    public void testValidStartHour() {
        WorkingHours instance = new WorkingHours();
        instance.setStartHour(4);
        int expResult = 4;
        int result = instance.getStartHour();
        assertEquals(expResult, result);
    }

    @Test
    public void testValidStartMin() {
        WorkingHours instance = new WorkingHours();
        instance.setStartMin(45);
        int expResult = 45;
        int result = instance.getStartMin();
        assertEquals(expResult, result);
    }

    @Test
    public void testValidEndHour() {
        WorkingHours instance = new WorkingHours();
        instance.setEndHour(4);
        int expResult = 4;
        int result = instance.getEndHour();
        assertEquals(expResult, result);
    }

    @Test
    public void testValidEndMin() {
        WorkingHours instance = new WorkingHours();
        instance.setEndMin(45);
        int expResult = 45;
        int result = instance.getEndMin();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDuration() {
        WorkingHours instance = new WorkingHours(9, 0, 17, 0);
        double expResult = 8.0;
        double result = instance.getDuration();
        assertEquals(expResult, result, 0.0);
    }

}
