package TestScript;

import org.testng.annotations.Test;
import Base.Basetest;
import pages.ScheduleAppointment;

public class TestScheduleAppointment extends Basetest {

    @Test
    public void testScheduleAppointment() throws InterruptedException {

        ScheduleAppointment scheduleAppointment = new ScheduleAppointment(driver);
        scheduleAppointment.scheduleAppoint("Zone 4", "1", "Grammy", "new");

        System.out.println("✅ Schedule Appointment test executed successfully");
    }
}
