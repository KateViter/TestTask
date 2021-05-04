package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

import static com.codeborne.selenide.Selenide.*;

public class AutoTest {

    @Test
    void moveToYoutube(){

        Configuration.startMaximized=true; //откріть во весь экран
        open("https://www.youtube.com");
        Assertions.assertEquals(Selenide.title(), "YouTube");
        int random = ThreadLocalRandom.current().nextInt(10,10000);
        $("input[id*='search']").sendKeys(String.valueOf(random));
        $("button[id*='search-icon-legacy']").click();
        $("div[id*='contents'] > ytd-video-renderer:nth-child(4)").click();
        $("div[class*='style-scope ytd-video-secondary-info-renderer'] img").click();
        $("div[id*='channel-header'] div[id*='subscribe-button']").click();
        $("ytd-modal-with-title-and-button-renderer tp-yt-paper-button").shouldHave(Condition.text("Войти"));

    }

}
