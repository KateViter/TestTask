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

        // Изменяем настройки браузера чтоб страница была открыта во весь экран
        Configuration.startMaximized=true;

        // Открываем страницу youtube.com
        open("https://www.youtube.com");

        // Проверяем, что название вкладки - YouTube
        Assertions.assertEquals(Selenide.title(), "YouTube");

        // Создаем переменную которая может принимать за значение рандомное число >=10 и <10000
        int random = ThreadLocalRandom.current().nextInt(10,10000);
        // На странице находим строку поиска и передаем ей значение random преобразованное в строку
        $("input[id*='search']").sendKeys(String.valueOf(random));

        // Находим на странице кнопку поиска и нажимаем на неё
        $("button[id*='search-icon-legacy']").click();

        // Находим 4 по счету видео в результатах поиска и нажимаем на него
        $("div[id*='contents'] > ytd-video-renderer:nth-child(4)").click();

        // Находим иконку автора видео и нажимаем на неё
        $("div[class*='style-scope ytd-video-secondary-info-renderer'] img").click();

        // Находим кнопку Подписаться и нажимаем на неё
        $("div[id*='channel-header'] div[id*='subscribe-button']").click();

        // Находим кнопку Войти и проверяем, что в кнопке нужный текст - Войти
        $("ytd-modal-with-title-and-button-renderer tp-yt-paper-button").shouldHave(Condition.text("Войти"));

    }

}
