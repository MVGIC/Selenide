package ru.netology.web;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

class OrderDeliveryCardTest {

      @Test
    void shouldOrderCard() {
          open("http://localhost:9999");
          $("[data-test-id=city] input").setValue("Красноярск");
          $("[data-test-id=date] input").setValue("09.06.21");
          $("[data-test-id=name] input").setValue("Иван Иванов");
          $("[data-test-id=phone] input").setValue("+78005553535");
          $("[data-test-id=agreement]").click();
          $$("button").find(exactText("Забронировать")).click();
          $(withText("Встреча успешно забронирована")).shouldHave(exist, Duration.ofSeconds(10));
      }
}

