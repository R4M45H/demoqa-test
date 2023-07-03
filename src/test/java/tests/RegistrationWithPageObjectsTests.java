package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationWithPageObjectsTests extends TestBase {

    @Test
    void successfulRegistrationTest() {
        String userName = "Dmitriy";
        String lastName = "Ramaw";
        String email = "RamawOne@gmail.com";
        String gender = "Male";
        String dateOfBirth = "09 March,1973";
        String phone = "8911999999";
        String pathFile = "img/Toolsqa.jpg";
        String fileName = "Toolsqa.jpg";
        String currentAddress = "New address is here";

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhone(phone)
                .setBirthDate("9", "March", "1973")
                .setSubjects("Biology")
                .setHobbies("Sports")
                .uploadFile(pathFile)
                .setCurrentAddress(currentAddress)
                .setStateAndCity("Uttar Pradesh", "Agra")
                .submit();


        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", userName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", phone)
                .verifyResult("Date of Birth", dateOfBirth)
                .verifyResult("Subjects", "Biology")
                .verifyResult("Hobbies", "Sports")
                .verifyResult("Picture", fileName)
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", "Uttar Pradesh Agra");
    }

//    @Test
//    void successfulRegistrationTest1() {
//        String userName = "Dmitriy";
//
//        registrationPage.openPage();
//
//        registrationPage.setFirstName(userName);
//        registrationPage.setLastName("Ramaw");
//        registrationPage.setEmail("RamawOne@gmail.com");
//        registrationPage.setGender("Other");
//        registrationPage.setPhone("8911999999");
//
//
//        $("#dateOfBirthInput").click();
        //...
//    }
}


