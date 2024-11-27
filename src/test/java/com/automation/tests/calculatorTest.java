package com.automation.tests;

import com.automation.Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class calculatorTest extends BaseTest {
    @Test(priority = 1)
    public void revenueCalculatorTest() {
        homepage.revenueCalculatorOpen();
        String actualTitle = homepage.titleValidation();
        Assert.assertEquals(actualTitle, "Medicare Eligible Patients", "Title validation failed!");
    }
    @Test(priority = 2)
    public void scrollPageTest() {
        homepage.scrollPageToPatientSlider();
        Assert.assertTrue(homepage.scrollPageToPatientSlider(), "Title validation failed!");
    }

    @Test(priority = 3)
    public void updatePatientNumberTest() {
        int userAddedPatientNumber = 560;
        homepage.addPatientNumberInInputField(userAddedPatientNumber);
        int actualPatientNumber = homepage.getPatientNumber();
        Assert.assertEquals(actualPatientNumber, userAddedPatientNumber,"Patient Number mismatch!");
    }
    @Test(priority = 4)
    public void validateSliderValueTest() {
        int actualInputPatientNumber = homepage.getPatientNumber();
        int expectedSliderValue = homepage.getSliderValue();
        Assert.assertEquals(actualInputPatientNumber, expectedSliderValue, "Slider patient value MisMatch!");
    }
    @Test(priority = 5)
    public void selectCPTCodesCheckbox99091Test() {
        boolean isSelected = homepage.selectCPTCodesCheckbox99091();
        Assert.assertTrue(isSelected, "Checkbox CPT 99091 was not selected.");
    }

    @Test(priority = 6)
    public void selectCPTCodesCheckbox99453Test() {
        boolean isSelected = homepage.selectCPTCodesCheckbox99453();
        Assert.assertTrue(isSelected, "Checkbox CPT 99453 was not selected.");
    }

    @Test(priority = 7)
    public void selectCPTCodesCheckbox99454Test() {
        boolean isSelected = homepage.selectCPTCodesCheckbox99454();
        Assert.assertTrue(isSelected, "Checkbox CPT 99454 was not selected.");
    }

    @Test(priority = 8)
    public void selectCPTCodesCheckbox99474Test() {
        boolean isSelected = homepage.selectCPTCodesCheckbox99474();
        Assert.assertTrue(isSelected, "Checkbox CPT 99474 was not selected.");
    }

    @Test(priority = 9)
    public void validateTotalRecurringReimbursementTest() {
        int actualTotalRecurringReimbursement = homepage.actualTotalRecurringReimbursement();
        int expectedTotalRecurringReimbursement = homepage.expectedTotalTimeReimbursement();

        Assert.assertEquals(actualTotalRecurringReimbursement,expectedTotalRecurringReimbursement);
    }
    @Test(priority = 10)
    public void validateOneTimeReimbursementTest() {
        double actualOneTimeRecurringReimbursement = homepage.actualOneTimeReimbursementValue();
        double expectedOneTimeRecurringReimbursement = homepage.expectedOneTimeReimbursementValue();

        // Assert that the values are equal
        Assert.assertEquals(actualOneTimeRecurringReimbursement, expectedOneTimeRecurringReimbursement,
                "The actual and expected one-time reimbursement values do not match (up to 2 decimal places).");
    }

    @Test(priority = 11)
    public void validateTotalRecurringReimbursementHeaderTest() {
        int totalRecurringReimbursementHeaderValue = homepage.totalRecurringReimbursementHeader();
        int expectedTotalRecurringReimbursementBoxValue = homepage.expectedTotalTimeReimbursement();

        Assert.assertEquals(expectedTotalRecurringReimbursementBoxValue,totalRecurringReimbursementHeaderValue);
    }

    @Test(priority = 12)
    public void validatePatientSliderTest() {
        homepage.slider();
        int patientNumber = homepage.getPatientNumber();
        Assert.assertEquals(patientNumber,1223);
    }







}
