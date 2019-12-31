package ru.progwards.java1.lessons.test;

import org.telegram.telegrambots.ApiContextInitializer;
import ru.progwards.java1.testlesson.ProgwardsTelegramBot;

public class PizzaBot extends ProgwardsTelegramBot {
    private final String menu = "У нас есть пицца, напитки и десерт";

    @Override
    public String processMessage(String text) {
        checkTags(text);
        if (foundCount() == 1) {
            if (checkLastFound("привет"))
                return "Приветствую тебя, о мой повелитель!\n Что желаешь? " + menu;
            if (checkLastFound("конец"))
                return "Спасибо за заказ.";
            if (checkLastFound("дурак"))
                return "Не надоругаться. Я не волшебник, я только учусь";

            return "Отлично, добавляю в заказ " + getLastFound() + " Желаешь что-то еще?";
        }
        if (foundCount() > 1)
            return "Под твой запрос подходит: \n" + extract() + "Выбери что-то одно, и я добавлю это в заказ.";
        return "Я не понял, возможно у нас этого нет, попробуй сказать по другому. " + menu;
    }

    public static void main(String[] args) {
        ApiContextInitializer.init();

        PizzaBot bot = new PizzaBot();
        bot.username = "Pizzzza25Artem451154_bot";
        bot.token = "1036712457:AAG4-VAJ61bZsdWcLkTao5AqrCIMrXDJi5o";

        bot.addTags("привет", "привет, здрасьте, здравствуй, добр, день, вечер, утро, hi, hello");
        bot.addTags("конец", "конец, все, стоп, нет");
        bot.addTags("дурак", "дурак, придурок, идиот, тупой");

        bot.addTags("Пицца гавайская", "гавайск, пицц, ананас, куриц");
        bot.addTags("Пицца маргарита", "маргарит, пицц, моцарелла, сыр, кетчуп, помидор");
        bot.addTags("Пицца пеперони", "пеперони, пицц, салями, колбас, сыр, кетчуп, помидор");

        bot.addTags("Торт тирамису", "десерт, кофе, маскарпоне, бисквит");
        bot.addTags("Торт медовик", "десерт, мед, бисквит");
        bot.addTags("Эклеры", "десерт, заварной, крем, тесто");

        bot.addTags("Кола", "напит, пить, кола");
        bot.addTags("Холодный чай", "напит, пить, чай, липтон, лимон");
        bot.addTags("Сок", "напит, пить, сок, апельсиноый, яблочный, вишневый");

        //bot.start();
        //bot.test();

        System.out.println("Hello bot!");


    }



}
