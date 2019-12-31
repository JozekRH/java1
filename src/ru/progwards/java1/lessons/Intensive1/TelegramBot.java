package ru.progwards.java1.lessons.Intensive1;

import java.util.Scanner;
import org.telegram.telegrambots.ApiContextInitializer;
import ru.progwards.java1.telegrambot.ProgwardsTelegramBot;
//import ru.progwards.java1.telegrambot.ProgwardsTelegramBot.FoundTags;

import java.util.Scanner;

public class TelegramBot extends ProgwardsTelegramBot {

    private final String menu = "У нас есть картошка, пицца, напитки и десерт";

    private static final String orderKey = "order";
    private static final String addressKey = "address";

    private boolean stop = false;

    private boolean potatoIsOffered = false;
    private boolean sauceIsOffered = false;
    private boolean pizzaIsOffered = false;
    private boolean dessertIsOffered = false;
    private boolean drinkIsOffered = false;
    private FoundTags currentTags;

    // Пердложить группы блюд
    // спросить адрес доставки
    String finishCheck(Integer userid) {
        // проверить что все 4 группы блюд в заказе
        // если какой-то группы нет && бот не предлагал
        // то предложить и учтановить ключ, что бы не предлагать 2 раза
        if(!potatoIsOffered) {
            potatoIsOffered = true;
            FoundTags tags = checkTags("картоф");
            return "Вы не заказали картошку. У нас есть: \n" + extract(tags) + "Выбери что-то одно, и я добавлю это в заказ.";
        }

        if(!pizzaIsOffered) {
            pizzaIsOffered = true;
            FoundTags tags = checkTags("пицца");
            return "Вы не заказали пиццу. У нас есть: \n" + extract(tags) + "Выбери что-то одно, и я добавлю это в заказ.";
        }

        if(!dessertIsOffered) {
            dessertIsOffered = true;
            FoundTags tags = checkTags("десерт");
            return "Вы не заказали десерт. У нас есть: \n" + extract(tags) + "Выбери что-то одно, и я добавлю это в заказ.";
        }

        if(!drinkIsOffered) {
            drinkIsOffered = true;
            FoundTags tags = checkTags("напиток");
            return "Вы не заказали напиток. У нас есть: \n" + extract(tags) + "Выбери что-то одно, и я добавлю это в заказ.";
        }
        // спросить адрес доставки
        // проверить что заказ не пуст
        if (getUserData(userid, addressKey) == null ) {
            setUserData(userid, addressKey, "*");

            return "Укажите, пожалуйста адрес доставки";
        }
        stop = true;
        // если заказ пуст выдать другое сообщение
        if (getUserData(userid, orderKey) == null)
            return "Вы так ничего и не заказали. Как жаль";
        return "Спасибо за заказ.";
    }

    // сохранить в заказ
    void saveOrderItem(Integer userid, FoundTags tags) {
        // считать количество
        Integer count = 0;
        String str = getUserData(userid, orderKey);
        if (str != null)
            count = Integer.parseInt(str);
        // инкрементировать количество
        count++;
        // сохранить количество
        setUserData(userid, orderKey, count.toString());
        // сохранить позицию в заказе как orderKey + count
        // ключи - order1, order2
        // данные - getLastFound(tags)
        setUserData(userid, orderKey+count, getLastFound(tags));

        // дополнительно 1
        // проверить связанные покупки
        // если он заказывает картошку, то предложить соус, если не предлагали

    }

    String getOrder(Integer userid) {
//         считать количество
//         в цикле по каждому элементу вывести содержимое
//         ключ orderKey + номер
        String str = getUserData(userid, orderKey);
        if(str == null) return "Ваш заказ пуст";
        String order = "Ваш заказ:\n";
        int itemsCount = Integer.parseInt(str);
        for(int i = 1; i <= itemsCount; i++) {
            order += getUserData(userid, orderKey + i) + "\n";
        }
        return order;
    }

    /**
     * Метод, который возвращает ответ бота
     * @return ответ
     */
    @Override
    public String processMessage(Integer userid, String text) {
        // проверяем, спрашивали ли адрес доставки
        if (getUserData(userid, addressKey) != null && getUserData(userid, addressKey).equals("*")) {
            setUserData(userid, addressKey, text);
            return finishCheck(userid);
        }
        // сброс всех данных для пользователя - нужно для тестирования
        if (text.equals("/reset"))
            cleartUserData(userid);

        // ищем подходящие тэги рлд запрос из заданных через addTags
        FoundTags tags = checkTags(text);
        // если найдено всего один вариант
        if (foundCount(tags) == 1) {
            if (checkLastFound(tags, "привет"))
                return "Приветствую тебя, мой повелитель!\nЧто желаешь? " + menu;
            if (checkLastFound(tags, "конец"))
                return finishCheck(userid);
            if (checkLastFound(tags, "дурак"))
                return "Не надо ругаться. Я не волшебник, я только учусь";

            if (checkLastFound(tags, "заказ"))
                return getOrder(userid);
            // Добавить связанные предложения, например если он заказывает картошку, то предложить соус,
            // если отказывается - сохранить флажок, что бы бесконечно не предлагать
            // дополнительно 2
            // реализовать отмену позиции заказа
            if (checkLastFound(tags, "да") && currentTags != null) {
                tags = currentTags;
                currentTags = null;
                saveOrderItem(userid, tags);
                if (getLastFound(tags).contains("Карто") && !sauceIsOffered) {
                    sauceIsOffered = true;
                    String order = getLastFound(tags);
                    tags = checkTags("соус");
                    return "Отлично, добавляю в заказ " + order + "\n"
                            + "Вы не заказали соус к картошке. У нас есть: \n" + extract(tags)
                            + "Выбери что-то одно, и я добавлю это в заказ.";
                }
                return "Отлично, добавляю в заказ " + getLastFound(tags) + " Желаешь что-то еще?";
            }
            if(checkLastFound(tags, "да") && currentTags == null) {
                return menu;
            }

            if (checkLastFound(tags, "нет")) {
                if(currentTags == null)
                    return "Ну нет, так нет";
                String order = getLastFound(currentTags);
                currentTags = null;
                return "Вы отменили позицию заказа" + order + "\n" + " Желаешь что-то еще? " + "\n" + menu;
            }


            currentTags = tags;
            return "Вы выбрали " + getLastFound(tags)
                    + ". Для подтверждения нажмите \"Да\", для отмены позиции заказа нажмите \"Нет\"";

        }
        if (foundCount(tags) > 1)
            return "Под твой запрос подходит: \n" + extract(tags) + "Выбери что-то одно, и я добавлю это в заказ.";
        return "Я не понял, возможно у нас этго нет, попробуй сказать по другому. " + menu;
    }

    public static void main(String[] args) {
        System.out.println("Hello bot!");
        ApiContextInitializer.init();

        // инициализируем бота
        ru.progwards.java1.lessons.Intensive1.TelegramBot bot = new ru.progwards.java1.lessons.Intensive1.TelegramBot();
        bot.username = "Pizzzza25Artem451154_bot";
        bot.token = "1036712457:AAG4-VAJ61bZsdWcLkTao5AqrCIMrXDJi5o";

        // наполняем тэгами
        bot.addTags("привет", "привет, здасьте, здравствуйте, добр, день, вечер, утро, hi, hello");
        bot.addTags("конец", "конец, все, стоп");
        bot.addTags("дурак", "дурак, идиот, тупой");

        // добавлено
        bot.addTags("заказ", "заказ");
        bot.addTags("нет", "нет, Нет, НЕТ");
        bot.addTags("да", "да, Да, ДА");

        bot.addTags("Картофель фри", "картош, картоф, фри");
        bot.addTags("Картошка по-деревенски", "картош, картоф, деревен");

        bot.addTags("Соус вкусный", "соус, вкус");
        bot.addTags("Соус очень вкусный", "соус, вкус, очень");
        bot.addTags("Соус сычуаньский", "соус, сыч");

        bot.addTags("Пицца гавайская", "гавайск, пицц, ананасы, курица");
        bot.addTags("Пицца маргарита", "маргарит, пицц, моцарелла, сыр, кетчуп, помидор");
        bot.addTags("Пицца пеперони", "пеперони, пицц, салями, колюас, сыр, кетчуп, помидор");

        bot.addTags("Торт тирамису", "десерт, кофе, маскарпоне, бисквит");
        bot.addTags("Торт медовик", "десерт, мед, бисквит");
        bot.addTags("Эклеры", "десерт, заварной, крем, тесто");

        bot.addTags("Кола", "напит, пить, кола");
        bot.addTags("Холодный чай", "напит, пить, чай, липтон, лимон");
        bot.addTags("Сок", "напит, пить, сок, апельсиноый, яблочный, вишневый");

        //bot.start();
        bot.test();
    }

    void test() {
        Scanner in = new Scanner(System.in);
        String input;
        do {
            input = in.nextLine();

            System.out.println(processMessage(123, input));
        } while (!stop);
        in.close();
    }
}

