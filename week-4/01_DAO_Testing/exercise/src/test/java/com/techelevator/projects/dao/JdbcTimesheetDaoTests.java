package com.techelevator.projects.dao;

import com.techelevator.projects.model.Timesheet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class JdbcTimesheetDaoTests extends BaseDaoTests {

    private static final Timesheet TIMESHEET_1 = new Timesheet(1, 1, 1,
            LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
    private static final Timesheet TIMESHEET_2 = new Timesheet(2, 1, 1,
            LocalDate.parse("2021-01-02"), 1.5, true, "Timesheet 2");
    private static final Timesheet TIMESHEET_3 = new Timesheet(3, 2, 1,
            LocalDate.parse("2021-01-01"), 0.25, true, "Timesheet 3");
    private static final Timesheet TIMESHEET_4 = new Timesheet(4, 2, 2,
            LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");
    
    private JdbcTimesheetDao dao;

    private Timesheet testTimesheet;


    @Before
    public void setup() {
        dao = new JdbcTimesheetDao(dataSource);

        testTimesheet = new Timesheet(99, 1, 1, LocalDate.now(), 3.00, false, "Timesheet 5");
    }

    @Test
    public void getTimesheet_returns_correct_timesheet_for_id() {
        Timesheet timesheets = dao.getTimesheet(4);
        Assert.assertEquals("Timesheet 4", timesheets.getDescription());
        Assert.assertEquals(4,timesheets.getTimesheetId());

        timesheets = dao.getTimesheet(1);
        Assert.assertEquals("Timesheet 1", timesheets.getDescription());
        Assert.assertEquals(1,timesheets.getTimesheetId());

        /* Assert.fail(); */
    }

    @Test
    public void getTimesheet_returns_null_when_id_not_found() {
        Timesheet timesheets = dao.getTimesheet(10);
        Assert.assertNull("getTimesheet failed to return null for Description not in database", timesheets);
        Assert.assertNull("getTimesheet failed to return null for id not in database", timesheets);

        /* Assert.fail(); */
    }

    @Test
    public void getTimesheetsByEmployeeId_returns_list_of_all_timesheets_for_employee() {
        List<Timesheet> timesheets = dao.getTimesheetsByEmployeeId(1);

        Assert.assertEquals("getTimesheetsByEmployeeId failed to return all timesheets for employees", 2, timesheets.size());
        assertTimesheetsMatch("getTimesheetsByEmployeeId returned wrong or partial data", TIMESHEET_1, timesheets.get(0));
         /* Assert.fail(); */
    }

    @Test
    public void getTimesheetsByProjectId_returns_list_of_all_timesheets_for_project() {
        List<Timesheet> timesheets = dao.getTimesheetsByProjectId(1);

        Assert.assertEquals("getTimesheetsByProjectId failed to return all timesheets for projects", 3, timesheets.size());
        assertTimesheetsMatch("getTimesheetsByProjectId returned wrong or partial data", TIMESHEET_1, timesheets.get(0));
        /* Assert.fail(); */
    }

    @Test
    public void createTimesheet_returns_timesheet_with_id_and_expected_values() {
        Timesheet createdTimesheet = dao.createTimesheet(testTimesheet);

        Assert.assertNotNull("createTimesheet returned null", createdTimesheet);

        Integer newId = createdTimesheet.getTimesheetId();
        Assert.assertTrue("createTimesheet failed to return a project with an id", newId > 0);

        testTimesheet.setTimesheetId(newId);
        assertTimesheetsMatch("createTimesheet returned timesheet with wrong or partial data", testTimesheet, createdTimesheet);
        /* Assert.fail(); */
    }

    @Test
    public void created_timesheet_has_expected_values_when_retrieved() {
        Timesheet createdTimesheet = dao.createTimesheet(testTimesheet);

        Assert.assertNotNull("can't test if created timesheet has correct values until createTimesheet is working", createdTimesheet);

        Integer newId = createdTimesheet.getTimesheetId();
        Timesheet retrievedTimesheet = dao.getTimesheet(newId);

        assertTimesheetsMatch("createTimesheet did not save correct data in database", createdTimesheet, retrievedTimesheet);

        /* Assert.fail(); */
    }

    @Test
    public void updated_timesheet_has_expected_values_when_retrieved() {
        Timesheet timesheet = dao.getTimesheet(1);
        Assert.assertNotNull("can't test updateTimesheet until getTimesheet is working", timesheet);
        timesheet.setDescription("TIMESHEET 1");
        timesheet.setBillable(false);

        dao.updateTimesheet(timesheet);

        Timesheet updatedTimesheet = dao.getTimesheet(1);
        Assert.assertEquals("updateTimesheet failed to change timesheet name in database", "TIMESHEET 1", updatedTimesheet.getDescription());

        updatedTimesheet = dao.getTimesheet(1);
        Assert.assertEquals("updateTimesheet failed to change timesheet billable flag in database", false, updatedTimesheet.isBillable());

        /* Assert.fail(); */
    }

    @Test
    public void deleted_timesheet_cant_be_retrieved() {
        dao.deleteTimesheet(1);

        Timesheet timesheet = dao.getTimesheet(1);
        Assert.assertNull("deleteTimesheet failed to remove project from database", timesheet);

    }

    @Test
    public void getBillableHours_returns_correct_total() {
       double timesheetBillableHours = dao.getBillableHours(2,2);
        // Assert.assertEquals(0, 2, 0);

        /* Timesheet timesheet = dao.getTimesheet(4);
        Assert.assertNotNull("getBillableHours failed to retrieve billable hours from timesheet_id 4",timesheet);  */
        // Assert.assertEquals(0.00, 2.00, 2.00);
        Assert.assertEquals(0, timesheetBillableHours, 0.0);

        /* timesheet = dao.getTimesheet(1);
        Assert.assertEquals(true, timesheet.isBillable()); */

        // Assert.assertEquals(null, 0.00, 0.00);

        /* Assert.fail(); */
    }

    /* private void assertTimesheetsMatch(Timesheet expected, Timesheet actual) {
        Assert.assertEquals(expected.getTimesheetId(), actual.getTimesheetId());
        Assert.assertEquals(expected.getEmployeeId(), actual.getEmployeeId());
        Assert.assertEquals(expected.getProjectId(), actual.getProjectId());
        Assert.assertEquals(expected.getDateWorked(), actual.getDateWorked());
        Assert.assertEquals(expected.getHoursWorked(), actual.getHoursWorked(), 0.001);
        Assert.assertEquals(expected.isBillable(), actual.isBillable());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
    } */

    private void assertTimesheetsMatch(String message ,Timesheet expected, Timesheet actual) {
        Assert.assertEquals(message, expected.getTimesheetId(), actual.getTimesheetId());
        Assert.assertEquals(message, expected.getEmployeeId(), actual.getEmployeeId());
        Assert.assertEquals(message, expected.getProjectId(), actual.getProjectId());
        Assert.assertEquals(message, expected.getDateWorked(), actual.getDateWorked());
        Assert.assertEquals(message, expected.getHoursWorked(), actual.getHoursWorked(), 0.001);
        Assert.assertEquals(message, expected.isBillable(), actual.isBillable());
        Assert.assertEquals(message, expected.getDescription(), actual.getDescription());
    }

}
