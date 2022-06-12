package scripts;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;

public class UnitedAirlinesTest extends Base{
    /*
    est Case 1: Validate "Main menu" navigation items
    Given user is on "https://www.united.com/en/us"
    Then user should see “Main menu” navigation items
    |BOOK                                  |
    |MY TRIPS                             |
    |TRAVEL INFO                      |
    |MILEAGEPLUS® PROGRAM|
    |DEALS                                  |
    |HELP
     */

    @Test(priority = 1, description = "Test Case 1: Validate united.com Main menu navigation items")
    public void testMainMenu() {
        driver.get("https://www.united.com/en/us");

        String[] mainMenuNavigationItems ={"BOOK", "MY TRIPS", "TRAVEL INFO", "MILEAGEPLUS® PROGRAM", "DEALS", "HELP"};

        for(int i = 0; i < unitedAirlinesMainPage.mainMenu.size(); i++){
            Assert.assertTrue(unitedAirlinesMainPage.mainMenu.get(i).isDisplayed());
            Assert.assertEquals(unitedAirlinesMainPage.mainMenu.get(i).getText(),mainMenuNavigationItems[i]);
        }
    }
        /*
        Test Case 2: Validate "Book travel menu" navigation items
         Given user is on "https://www.united.com/en/us"
        Then user should see "Book travel menu" navigation items
        |Book            |
        |Flight Status|
        |Check-in      |
        |My trips       |
         */

        @Test(priority = 2, description = "Test case 2: Validate united.com Book travel menu navigation items")
        public void testBookTravelMenu() {
            driver.get("https://www.united.com/en/us");

            String[] bookTravel = {"Book", "Flight Status", "Check-in", "My trips"};

            for(int i = 0; i < unitedAirlinesMainPage.bookTravelMenu.size(); i++){
                Assert.assertTrue(unitedAirlinesMainPage.bookTravelMenu.get(i).isDisplayed());
                Assert.assertEquals(unitedAirlinesMainPage.bookTravelMenu.get(i).getText(), bookTravel);
            }
        }
            /*
            Test Case 3: Validate "Round-trip" and "One-way" radio buttons
            Given user is on "https://www.united.com/en/us"
            Then validate "Roundtrip" radio button is displayed, is enabled and is selected
            And validate "One-way" radio button is displayed, is enabled but is not selected
            When user clicks on "One-way" radio button
            Then validate "One-way" radio button is selected while "Roundtrip" radio button is deselected
             */

            @Test(priority = 3, description = "Test case 3: Validate united.com Round-trip and One-way radio buttons")
            public void testRound_TripAndOne_WayRadioButtons(){
                driver.get("https://www.united.com/en/us");

                Assert.assertTrue(unitedAirlinesMainPage.roundTripButton.isDisplayed() &&
                        unitedAirlinesMainPage.roundTripButton.isEnabled() && unitedAirlinesMainPage.roundTripButtonSelected.isSelected());

                Assert.assertTrue(unitedAirlinesMainPage.oneWayButton.isDisplayed() && unitedAirlinesMainPage.oneWayButton.isEnabled());
                Assert.assertFalse(unitedAirlinesMainPage.oneWayButtonSelected.isSelected());
                unitedAirlinesMainPage.oneWayButton.click();
                Assert.assertTrue(unitedAirlinesMainPage.oneWayButtonSelected.isSelected());
                Assert.assertFalse(unitedAirlinesMainPage.roundTripButtonSelected.isSelected());
            }

            /*
            Test Case 4: Validate "Book with miles" and "Flexible dates" checkboxes
            Given user is on "https://www.united.com/en/us"
            Then validate "Book with miles" checkbox is displayed, is enabled but is not selected
            And validate "Flexible dates" checkbox is displayed, is enabled but is not selected
            When user clicks both checkboxes
            Then validate both checkboxes are selected
            When user clicks on both selected checkboxes again
            Then validate both checkboxes are deselected
                     */

    @Test(priority = 4, description = "Test case 4: Validate united.com Book with miles and Flexible dates checkboxes")
    public void testBookMilesAndFlexibleDatesCheckboxes() {
        driver.get("https://www.united.com/en/us");

        Assert.assertTrue(unitedAirlinesMainPage.bookWithMilesCheckBox.isDisplayed() && unitedAirlinesMainPage.bookWithMilesCheckBox.isEnabled());
        Assert.assertFalse(unitedAirlinesMainPage.bookWithMilesCheckBoxSelected.isSelected());

        Assert.assertTrue(unitedAirlinesMainPage.flexibleDatesCheckBox.isDisplayed() && unitedAirlinesMainPage.flexibleDatesCheckBox.isEnabled());
        Assert.assertFalse(unitedAirlinesMainPage.flexibleDatesCheckBoxSelected.isSelected());

        unitedAirlinesMainPage.bookWithMilesCheckBox.click();
        unitedAirlinesMainPage.flexibleDatesCheckBox.click();
        Assert.assertTrue(unitedAirlinesMainPage.bookWithMilesCheckBoxSelected.isSelected());
        Assert.assertTrue(unitedAirlinesMainPage.flexibleDatesCheckBoxSelected.isSelected());
        unitedAirlinesMainPage.bookWithMilesCheckBox.click();
        unitedAirlinesMainPage.flexibleDatesCheckBox.click();
        Assert.assertFalse(unitedAirlinesMainPage.bookWithMilesCheckBoxSelected.isSelected());
        Assert.assertFalse(unitedAirlinesMainPage.flexibleDatesCheckBoxSelected.isSelected());
    }
        /*
        Test Case 5: Validate One-way ticket search results "from Chicago, IL, US (ORD) to Miami, FL, US (MIA)”
        Given user is on "https://www.united.com/en/us"
        When user selects "One-way" ticket radio button
        And user enters "Chicago, IL, US (ORD)" to from input box
        And user enters "Miami, FL, US (MIA)" to to input box
        And user selects "Jan 30" to the dates input box
        And user selects "2 Adults" from travelers selector
        And user selects "Business or First" from cabin dropdown
        And user clicks on "Find Flights" button
        Then validate departure equals to "Depart: Chicago, IL, US to Miami, FL, US
         */

        @Test(priority = 5, description = "Test case 4: Validate united.com One-way search results")
        public void testOneWayTicketSearchResults(){
            driver.get("https://www.united.com/en/us");

            unitedAirlinesMainPage.oneWayButtonSelected.click();

            unitedAirlinesMainPage.fromInputBox.sendKeys("Chicago, IL, US (ORD)" + Keys.ENTER);
            unitedAirlinesMainPage.toInputBox.sendKeys("Miami, FL, US (MIA)" + Keys.ENTER);
            unitedAirlinesMainPage.datesInputBox.clear();
           unitedAirlinesMainPage.datesInputBox.sendKeys("Jan 30" + Keys.ENTER);

           unitedAirlinesMainPage.travelersSelector.click();
           unitedAirlinesMainPage.adult2.click();

           unitedAirlinesMainPage.cabinDropDown.click();
            unitedAirlinesMainPage.cabinDropdown2.get(2).click();
            unitedAirlinesMainPage.findFlights.click();
            Assert.assertEquals(departurePage.depart.getText(), "Chicago, IL, US to Miami, FL, US");
        }
}
