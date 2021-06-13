package ru.netology.web;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

class OrderDeliveryCardTest {

    @Test
    void shouldOrderCard() {
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Красноярск");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        String planningDate = LocalDate.now().plusDays(4).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=date] input").setValue(planningDate);
        $("[data-test-id=name] input").setValue("Иван Иванов");
        $("[data-test-id=phone] input").setValue("+78005553535");
        $("[data-test-id=agreement]").click();
        $$("button").find(exactText("Забронировать")).click();
        $("[data-test-id='notification'] .notification__content").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Встреча успешно забронирована на " + planningDate));
    }
}

