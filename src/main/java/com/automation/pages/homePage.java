package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class homePage {
    private final WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    /*============= 1.Page Locator============*/
    private final By revenueCalculatorTab = By.xpath("//div[text()='Revenue Calculator']");
    private final By medicareEligiblePatientsTitle = By.xpath("//div[@class='MuiBox-root css-79elbk']//h4");
    private final By scrollPageElement = By.xpath("//p[text()='CPT-99091']");
    private final By patientNumberInputField = By.xpath("//input[@type='number']");
    private final By sliderValue = By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 inter css-12bch19'])[2]");
    private final By checkboxCPT99091 = By.xpath("(//input[@type='checkbox'])[1]");
    private final By checkboxCPT99453 = By.xpath("(//input[@type='checkbox'])[2]");
    private final By checkboxCPT99454 = By.xpath("(//input[@type='checkbox'])[3]");
    private final By checkboxCPT99474 = By.xpath("(//input[@type='checkbox'])[8]");
    private final By reimbursementCPT99091 = By.xpath("(//span[@class='MuiTypography-root MuiTypography-body1 MuiFormControlLabel-label css-1s3unkt'])[1]");
    private final By reimbursementCPT99453 = By.xpath("(//span[@class='MuiTypography-root MuiTypography-body1 MuiFormControlLabel-label css-1s3unkt'])[2]");
    private final By reimbursementCPT99454 = By.xpath("(//span[@class='MuiTypography-root MuiTypography-body1 MuiFormControlLabel-label css-1s3unkt'])[3]");
    private final By reimbursementCPT99474 = By.xpath("(//span[@class='MuiTypography-root MuiTypography-body1 MuiFormControlLabel-label css-1s3unkt'])[8]");
    private final By oneTimeReimbursement  = By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 inter css-12bch19'])[1]");
    private final By totalRecurringReimbursement  = By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 inter css-12bch19'])[3]");
    private final By totalRecurringReimbursementHeader  = By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 inter css-1bl0tdj'][normalize-space()='$75600']");
    private final By slider  = By.xpath("//input[@type='range']");


    /*============= 2.Public constructor of the page ============*/
    public homePage(WebDriver driver) {
        this.driver = driver;
    }

    /*============= 3.Methods to interact with page elements============*/

    public void revenueCalculatorOpen() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(revenueCalculatorTab)).click();
    }
    public String titleValidation() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(medicareEligiblePatientsTitle));
        return element.getText();
    }

    public boolean scrollPageToPatientSlider(){
        try{
            WebElement scrollPageToElement  = driver.findElement(scrollPageElement);
            actions = new Actions(driver);
            actions.moveToElement(scrollPageToElement).perform();
            Thread.sleep(2000); // Wait for the page to load completely before scrolling
            scrollPageToElement.click();
            return true;
        } catch (Exception e) {
            return false;
        }
        // Implement scroll page to the slider section

    }
    public void addPatientNumberInInputField(int patientNumber){
        try {
            // Step 1: Click the input field to focus on it
            WebElement inputValue = driver.findElement(patientNumberInputField);
            inputValue.click();
            // Step 2: Use Actions class to perform backspace 4 times to remove the default value
            actions = new Actions(driver);
            actions.sendKeys(inputValue, "\u0008") // Send backspace key
                    .sendKeys(inputValue, "\u0008")
                    .sendKeys(inputValue, "\u0008")
                    .sendKeys(inputValue, "\u0008")
                    .perform();
            Thread.sleep(2000);
            // Step 3: Send the user input value (200) to the input field
            inputValue.sendKeys(String.valueOf(patientNumber));
            Thread.sleep(2000);
            driver.findElement(medicareEligiblePatientsTitle).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public int getPatientNumber(){
        // Wait for the input field to load completely before entering the value
        WebElement patientNumberInputFieldValue = wait.until(ExpectedConditions.visibilityOfElementLocated(patientNumberInputField));
        int actualPatientNumber = Integer.parseInt(patientNumberInputFieldValue.getAttribute("value"));
        System.out.println("Patient Number: " + actualPatientNumber);
        return actualPatientNumber;
    }

    public int getSliderValue(){
        WebElement expectedSliderValueElement = wait.until(ExpectedConditions.visibilityOfElementLocated(sliderValue));
        int expectedSliderValue = Integer.parseInt(expectedSliderValueElement.getText());
        System.out.println("Expected Slider Value: " + expectedSliderValue);
        return expectedSliderValue;
    }


    public boolean selectCPTCodesCheckbox99091() {
        try {
            // Wait for the checkbox to be visible
            WebElement checkbox99091 = wait.until(ExpectedConditions.presenceOfElementLocated(checkboxCPT99091));
            actions = new Actions(driver);
            actions.moveToElement(checkbox99091).perform();
            // Click the checkbox
            checkbox99091.click();
            Thread.sleep(2000);
            // Validate if it is selected
            return checkbox99091.isSelected();
        } catch (Exception e) {
            // Log the exception if needed
            System.err.println("Error while selecting the checkbox CPT 99091: " + e.getMessage());
            return false; // Return false in case of any failure
        }
    }

    public boolean selectCPTCodesCheckbox99453() {
        try {
            // Wait for the checkbox to be visible
            WebElement checkbox99453 = wait.until(ExpectedConditions.presenceOfElementLocated(checkboxCPT99453));
            actions = new Actions(driver);
            actions.moveToElement(checkbox99453).perform();
            // Click the checkbox
            checkbox99453.click();
            Thread.sleep(2000);
            // Validate if it is selected
            return checkbox99453.isSelected();
        } catch (Exception e) {
            // Log the exception if needed
            System.err.println("Error while selecting the checkbox CPT 99453: " + e.getMessage());
            return false; // Return false in case of any failure
        }
    }

    public boolean selectCPTCodesCheckbox99454() {
        try {
            // Wait for the checkbox to be visible
            WebElement checkbox99454 = wait.until(ExpectedConditions.presenceOfElementLocated(checkboxCPT99454));
            actions = new Actions(driver);
            actions.moveToElement(checkbox99454).perform();
            // Click the checkbox
            checkbox99454.click();
            Thread.sleep(2000);
            // Validate if it is selected
            return checkbox99454.isSelected();
        } catch (Exception e) {
            // Log the exception if needed
            System.err.println("Error while selecting the checkbox CPT 99454: " + e.getMessage());
            return false; // Return false in case of any failure
        }
    }

    public boolean selectCPTCodesCheckbox99474() {
        try {
            // Wait for the checkbox to be visible
            WebElement checkbox99474 = wait.until(ExpectedConditions.presenceOfElementLocated(checkboxCPT99474));
            actions = new Actions(driver);
            actions.moveToElement(checkbox99474).perform();
            // Click the checkbox
            checkbox99474.click();
            Thread.sleep(2000);
            // Validate if it is selected
            return checkbox99474.isSelected();
        } catch (Exception e) {
            // Log the exception if needed
            System.err.println("Error while selecting the checkbox CPT 99474: " + e.getMessage());
            return false; // Return false in case of any failure
        }
    }

    public int actualTotalRecurringReimbursement(){
        WebElement totalRecurringReimbursementElement = wait.until(ExpectedConditions.visibilityOfElementLocated(totalRecurringReimbursement));
        String reimbursementText = totalRecurringReimbursementElement.getText().trim();
        System.out.println("reimbursementText : " +reimbursementText);
        int actualTotalTimeReimbursementValue = Integer.parseInt(reimbursementText.replaceAll("[^\\d.]", ""));

        System.out.println("Actual Total Recurring Reimbursement Value(Web): " + actualTotalTimeReimbursementValue);

        return actualTotalTimeReimbursementValue;
    }

    public int expectedTotalTimeReimbursement(){
        WebElement expectedSliderValueElement = wait.until(ExpectedConditions.visibilityOfElementLocated(sliderValue));
        WebElement reimbursementCPT99091Element = wait.until(ExpectedConditions.visibilityOfElementLocated(reimbursementCPT99091));
        WebElement reimbursementCPT99454Element = wait.until(ExpectedConditions.visibilityOfElementLocated(reimbursementCPT99454));
        WebElement reimbursementCPT99474Element = wait.until(ExpectedConditions.visibilityOfElementLocated(reimbursementCPT99474));

        int actualSliderValue = Integer.parseInt(expectedSliderValueElement.getText());
        int reimbursementCPT99091Value = Integer.parseInt(reimbursementCPT99091Element.getText());
        int reimbursementCPT99454Value = Integer.parseInt(reimbursementCPT99454Element.getText());
        int reimbursementCPT99474Value = Integer.parseInt(reimbursementCPT99474Element.getText());

        System.out.println("Expected reimbursement CPT99091 Value: " + reimbursementCPT99091Value);
        System.out.println("Expected reimbursement CPT99454 Value: " + reimbursementCPT99454Value);
        System.out.println("Expected reimbursement CPT99474 Value: " + reimbursementCPT99474Value);

        int expectedTotalRecurringReimbursement = (actualSliderValue * reimbursementCPT99091Value) + (actualSliderValue * reimbursementCPT99454Value) + (actualSliderValue * reimbursementCPT99474Value);

        System.out.println("Expected Total Recurring Reimbursement: " + expectedTotalRecurringReimbursement);
        return expectedTotalRecurringReimbursement;
    }

    public double roundToTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
    public double actualOneTimeReimbursementValue() {
        WebElement oneTimeReimbursementElement = wait.until(ExpectedConditions.visibilityOfElementLocated(oneTimeReimbursement));
        String oneTimeReimbursementText = oneTimeReimbursementElement.getText().trim();
        System.out.println("One Time Reimbursement Text: " + oneTimeReimbursementText);

        // Parse and round to 2 decimal places
        double actualOneTimeReimbursementValue = Double.parseDouble(oneTimeReimbursementText.replaceAll("[^\\d.]", ""));
        actualOneTimeReimbursementValue = roundToTwoDecimals(actualOneTimeReimbursementValue);

        System.out.println("Actual One Time Reimbursement Value (rounded): " + actualOneTimeReimbursementValue);
        return actualOneTimeReimbursementValue;
    }



    public double expectedOneTimeReimbursementValue() {
        WebElement expectedSliderValueElement = wait.until(ExpectedConditions.visibilityOfElementLocated(sliderValue));
        WebElement reimbursementCPT99453Element = wait.until(ExpectedConditions.visibilityOfElementLocated(reimbursementCPT99453));

        int actualSliderValue = Integer.parseInt(expectedSliderValueElement.getText().trim());
        double reimbursementCPT99453Value = Double.parseDouble(reimbursementCPT99453Element.getText().trim());

        // Calculate the expected value
        double expectedOneTimeReimbursementValue = actualSliderValue * reimbursementCPT99453Value;

        // Round to 2 decimal places
        expectedOneTimeReimbursementValue = roundToTwoDecimals(expectedOneTimeReimbursementValue);

        System.out.println("Expected One Time Reimbursement Value (rounded): " + expectedOneTimeReimbursementValue);
        return expectedOneTimeReimbursementValue;
    }

    public int totalRecurringReimbursementHeader(){
        WebElement totalRecurringReimbursementHeaderElement = wait.until(ExpectedConditions.visibilityOfElementLocated(totalRecurringReimbursementHeader));
        String totalRecurringReimbursementHeaderText = totalRecurringReimbursementHeaderElement.getText().trim();
        System.out.println("total Recurring Reimbursement Header Text : " +totalRecurringReimbursementHeaderText);
        int actualTotalRecurringReimbursementHeaderValue = Integer.parseInt(totalRecurringReimbursementHeaderText.replaceAll("[^\\d.]", ""));
        System.out.println("Actual Total Recurring Reimbursement Header: " + actualTotalRecurringReimbursementHeaderValue);
        return actualTotalRecurringReimbursementHeaderValue;
    }

    public void slider(){
        try {
            // Locate the slider element
            WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));

            // Set hard-coded values for slider range if attributes don't exist
            int minValue = 0; // Replace with slider.getAttribute("min") if available
            int maxValue = 2000; // Replace with slider.getAttribute("max") if available

            Thread.sleep(2000);
            // Target value (820)
            int targetValue = 100;

            System.out.println("values minValue : " + minValue + " maxValue : " + maxValue + " target" + targetValue);
            // Calculate the offset based on slider width
            int sliderWidth = slider.getSize().getWidth(); // Width in pixels
            double valueRatio = (double) (targetValue  / sliderWidth);
            int xOffset = (int) (sliderWidth * valueRatio); // Calculate the pixel offset
            System.out.println("Slider width : " + sliderWidth);
            System.out.println("offset : " + xOffset);
            // Use Actions to move the slider
            actions = new Actions(driver);
            Thread.sleep(2000);

            WebElement scrollPageToElement  = driver.findElement(scrollPageElement);
            actions.moveToElement(scrollPageToElement).perform();

            actions.clickAndHold(slider).moveByOffset(xOffset, 0).release().perform();

            // Add a wait to observe changes (optional)
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
