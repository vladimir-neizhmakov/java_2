package lesson_3;

public class Lesson_3 {



    public static void main(String[] args) {
        FirstHW();
        SecondHW();
    }

    private static void FirstHW() {

        String text = "Лошадь сказала взглянув на верблюда " +
                "Какая гигантская лошадь ублюдок " +
                "Верблюд же вскричал " +
                "Да лошадь разве ты " +
                "Ты просто напросто верблюд недоразвитый " +
                "И знал лишь бог седобородый " +
                "что это животные разной породы";

        WordsOfText WoT = new WordsOfText(text);

        System.out.println(WoT.ExtractWords());
        System.out.println(WoT.CountWords());
    }

    private static void SecondHW() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addRecord("Иванов","89026784536","ivanov@mail.ru");
        phoneBook.addRecord("Иванов","89026784537", "ivanov123@mail.ru");
        phoneBook.addRecord("Петров","89675884536","petrov@mail.ru");
        phoneBook.addRecord("Сидоров","89035679867","sidorov@mail.ru");
        phoneBook.addRecord("Иванчук","89673464536","Ivanchuk@gmail.com");
        phoneBook.addRecord("Иванчук","89672484536","Ivanchuk@mail.ru");


        System.out.println(phoneBook.getPhoneByFamily("Иванов"));
        System.out.println(phoneBook.getMailByFamily("Иванов"));



    }

}
