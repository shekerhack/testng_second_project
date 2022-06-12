package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UnitedAirlinesMainPage {
    public UnitedAirlinesMainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[id^='headerNav']")
    public List<WebElement> mainMenu;

    @FindBy(xpath = "/div[@xpath='1']")
    public List<WebElement> bookTravelMenu;

    @FindBy(xpath = "//*[@id = 'roundtrip']/..")
    public WebElement roundTripButton;

    @FindBy(id = "roundtrip")
    public WebElement roundTripButtonSelected;

    @FindBy(id = "oneway")
    public WebElement oneWayButtonSelected;

    @FindBy(xpath = "//*[@id = 'oneway']/..")
    public WebElement oneWayButton;

    @FindBy(css = "[aria-label='Book with miles']")
    public WebElement bookWithMilesCheckBox;

    @FindBy(css = "[aria-label='Book with miles']>input")
    public WebElement bookWithMilesCheckBoxSelected;

    @FindBy(css = "[aria-label='Flexible dates']")
    public WebElement flexibleDatesCheckBox;

    @FindBy(css = "[aria-label='Flexible dates']>input")
    public WebElement flexibleDatesCheckBoxSelected;

    @FindBy(id = "bookFlightOriginInput")
    public WebElement fromInputBox;

    @FindBy(css = "#bookFlightDestinationInput")
    public WebElement toInputBox;

    @FindBy(id = "DepartDate")
    public WebElement datesInputBox;

    @FindBy(id = "passengerSelector")  //  #passengerSelector>button  [aria-haspopup='dialog']
    public WebElement travelersSelector;

    @FindBy(css = "button[aria-label='Substract one Adult']")
    public WebElement adult2;

    @FindBy(css = "#cabinType div")
    public WebElement cabinDropDown;

    @FindBy(css = "ul[role='listbox']>li") // [aria-label='Business or First']"
    public List<WebElement> cabinDropdown2;


    @FindBy(css = "ul[role='listbox']>li") // [aria-label='Business or First']"
    public List<WebElement> businessOrFirst;

    @FindBy(css = "button[class*='app-components-BookFlightForm-bookFlightForm__findFlightBtn--']")
    public WebElement findFlights;


}
