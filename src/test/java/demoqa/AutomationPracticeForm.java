package demoqa;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutomationPracticeForm {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
    }
    @Test
    void PracticeForm() {
        String filePath = "src/test/java/demoqa/Toolsqa.jpg";

        open("/automation-practice-form");
        $(".pattern-backgound .main-header").shouldHave(text("Practice Form"));

        $("#firstName").setValue("Dmitriy");
        $("#lastName").setValue("Ramaw");
        $("#userEmail").setValue("RamawOne@gmail.com");

        $(byText("Male")).click();

        $("#userNumber").setValue("8911999999");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-container").shouldBe(visible);
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1973");
        $(byText("9")).click();

        $("#subjectsInput").setValue("b");

        $(byText("Biology")).click();
        $(byText("Sports")).click();

        $("#currentAddress").setValue("New address is here");

        $(byId("state")).click();
        $(byText("Uttar Pradesh")).click();
        $(byId("city")).click();
        $(byText("Agra")).click();

        $("#uploadPicture").uploadFile(new File(filePath));

        $("#submit").click();
        $(".modal-content").shouldBe(visible);
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));

        $("#closeLargeModal").click();
    }
}
