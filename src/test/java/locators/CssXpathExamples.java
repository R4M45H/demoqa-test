package locators;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples {
    void cssXpathExamples() {
        // <input type="email" class="inputtext login_from_input_box" name="email" id="email" data-testid="email">
        $("[data-testid=email").setValue("1");
        $(by("data-testid", "email")).setValue("1");
        $("input. login_form_input_box[name=email]#email[data-testid=email]").setValue("1");

        // <input type="email" class="inputtext login_from_input_box" name="email" id="email">
        $("[id=email").setValue("1");
        $("#email").setValue("1");
        $("input#email").setValue("1");
        $x("//input[@id='email']").setValue("1");


        // <input type="email" class="inputtext login_from_input_box" name="email">
        $("[name=email").setValue("1");
        $(byName("email")).setValue("1");

        // <input type="email" class="inputtext login_from_input_box">
        $("[class=login_form_input_box").setValue("1");
        $(".login_form_input_box").setValue("1");
        $(".inputtext.login_form_input_box").setValue("1");
        $("input.inputtext.login_form_input_box").setValue("1");
        $x("//input[@class='inputtext'][@class='login_form_input_box']").setValue("1");

        /*
            <div class="inputtext">
                <input type="email" class="inputtext login_from_input_box">
            </div>
        */
        $(".inputtext .login_form_input_box").setValue("1");
        $(".inputtext").$(".login_form_input_box").setValue("1");

        //<div>Hello Ramaw One</div>
        $x("//div[text()='Hello Ramaw One']");
        $(byText("Hello Ramaw One"));
        $(withText("Hello Ramaw One"));
    }
}
