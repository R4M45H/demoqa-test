package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final String TITLE_TEXT = "Practice Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            stateSelector = $("#state"),
            citySelector = $("#city");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".pattern-backgound .main-header").shouldHave(text(TITLE_TEXT));

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }
    public RegistrationPage clearLastName(String value) {
        lastNameInput.clear();

        return this;
    }
    
    public RegistrationPage setEmail(String value) {
        $("#userEmail").setValue(value); // todo move to SelenideElements

        return this;
    }

    public RegistrationPage setGender(String value) {
        $("#gender-radio-1").parent().click(); // todo move to SelenideElements

        return this;
    }

    public RegistrationPage setPhone(String value) {
        $("#userNumber").setValue(value); // todo move to SelenideElements

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        $(".react-datepicker__month-container").shouldBe(visible);
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        $(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadFile(String value) {
        $("#uploadPicture").uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        $("#currentAddress").setValue(value);;

        return this;
    }

    public RegistrationPage setStateAndCity(String value1, String value2) {
        stateSelector.click();
        $(byText(value1)).click();
        citySelector.click();
        $(byText(value2)).click();

        return this;
    }

    public RegistrationPage submit() {
        $("#submit").click();

        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);

        return this;
    }


}
