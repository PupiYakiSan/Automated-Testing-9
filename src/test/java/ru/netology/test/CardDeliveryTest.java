package ru.netology.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import ru.netology.data.DataGenerator;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryTest {

    @BeforeAll
    static void setupAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    public void openLocalhost() {
        open("http://localhost:9999");
    }
    @Test
    void successSubmitFormFirstMeetingDayLessSecond() {

        DataGenerator.UserInfo validUser = DataGenerator.Registration.generateUser("ru");
        int addDaysForFirstMeeting = 4;
        String firstMeetingDate = DataGenerator.generateDate(addDaysForFirstMeeting);
        int addDaysForSecondMeeting = 7;
        String secondMeetingDate = DataGenerator.generateDate(addDaysForSecondMeeting);

        $("[data-test-id=city] input").val(validUser.getCity());
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(firstMeetingDate);
        $("[data-test-id=name] input").val(validUser.getName());
        $("[data-test-id=phone] input").val(validUser.getPhone());
        $("[data-test-id=agreement]").click();
        $(byText("Запланировать")).click();

        $(byText("Успешно!")).shouldBe(Condition.visible, Duration.ofSeconds(15));
        $("[data-test-id='success-notification'] .notification__content")
               .shouldHave(Condition.exactText("Встреча успешно запланирована на " + firstMeetingDate))
               .shouldBe(Condition.visible);

        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(secondMeetingDate);
        $(byText("Запланировать")).click();

        $("[data-test-id='replan-notification'] .notification__title")
                .shouldHave(Condition.exactText("Необходимо подтверждение"))
                .shouldBe(Condition.visible);
        $("[data-test-id='replan-notification'] .notification__content")
                .shouldHave(Condition.text("У вас уже запланирована встреча на другую дату. Перепланировать?"))
                .shouldBe(Condition.visible);
        $("[data-test-id='replan-notification'] button").click();

        $("[data-test-id='success-notification'] .notification__content")
                .shouldHave(Condition.exactText("Встреча успешно запланирована на " + secondMeetingDate))
                .shouldBe(Condition.visible);
    }

    @Test
    void successSubmitFormFirstMeetingDayEqualSecond() {

        DataGenerator.UserInfo validUser = DataGenerator.Registration.generateUser("ru");
        int addDaysForFirstMeeting = 7;
        String firstMeetingDate = DataGenerator.generateDate(addDaysForFirstMeeting);
        int addDaysForSecondMeeting = 7;
        String secondMeetingDate = DataGenerator.generateDate(addDaysForSecondMeeting);

        $("[data-test-id=city] input").val(validUser.getCity());
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(firstMeetingDate);
        $("[data-test-id=name] input").val(validUser.getName());
        $("[data-test-id=phone] input").val(validUser.getPhone());
        $("[data-test-id=agreement]").click();
        $(byText("Запланировать")).click();

        $(byText("Успешно!")).shouldBe(Condition.visible, Duration.ofSeconds(15));
        $("[data-test-id='success-notification'] .notification__content")
                .shouldHave(Condition.exactText("Встреча успешно запланирована на " + firstMeetingDate))
                .shouldBe(Condition.visible);

        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(secondMeetingDate);
        $(byText("Запланировать")).click();

        $("[data-test-id='replan-notification'] .notification__title")
                .shouldHave(Condition.exactText("Необходимо подтверждение"))
                .shouldBe(Condition.visible);
        $("[data-test-id='replan-notification'] .notification__content")
                .shouldHave(Condition.text("У вас уже запланирована встреча на другую дату. Перепланировать?"))
                .shouldBe(Condition.visible);
        $("[data-test-id='replan-notification'] button").click();

        $("[data-test-id='success-notification'] .notification__content")
                .shouldHave(Condition.exactText("Встреча успешно запланирована на " + secondMeetingDate))
                .shouldBe(Condition.visible);
    }

    @Test
    void successSubmitFormFirstMeetingDayMoreSecond() {

        DataGenerator.UserInfo validUser = DataGenerator.Registration.generateUser("ru");
        int addDaysForFirstMeeting = 7;
        String firstMeetingDate = DataGenerator.generateDate(addDaysForFirstMeeting);
        int addDaysForSecondMeeting = 4;
        String secondMeetingDate = DataGenerator.generateDate(addDaysForSecondMeeting);

        $("[data-test-id=city] input").val(validUser.getCity());
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(firstMeetingDate);
        $("[data-test-id=name] input").val(validUser.getName());
        $("[data-test-id=phone] input").val(validUser.getPhone());
        $("[data-test-id=agreement]").click();
        $(byText("Запланировать")).click();

        $(byText("Успешно!")).shouldBe(Condition.visible, Duration.ofSeconds(15));
        $("[data-test-id='success-notification'] .notification__content")
                .shouldHave(Condition.exactText("Встреча успешно запланирована на " + firstMeetingDate))
                .shouldBe(Condition.visible);

        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(secondMeetingDate);
        $(byText("Запланировать")).click();

        $("[data-test-id='replan-notification'] .notification__title")
                .shouldHave(Condition.exactText("Необходимо подтверждение"))
                .shouldBe(Condition.visible);
        $("[data-test-id='replan-notification'] .notification__content")
                .shouldHave(Condition.text("У вас уже запланирована встреча на другую дату. Перепланировать?"))
                .shouldBe(Condition.visible);
        $("[data-test-id='replan-notification'] button").click();

        $("[data-test-id='success-notification'] .notification__content")
                .shouldHave(Condition.exactText("Встреча успешно запланирована на " + secondMeetingDate))
                .shouldBe(Condition.visible);
    }

}
