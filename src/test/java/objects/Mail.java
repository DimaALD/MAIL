package objects;

import utils.Randomizer;

public class Mail {
    private static String subject;
    private static String text;
    private static String to;

    public Mail() {
        to = "aldoshin.2013@mail.ru";
    }

    public static Mail getInstance() {
        return MailFactory.createMailWithRandomString();
    }

    public static String getText() {
        return text;
    }

    public static String getTo() {
        return to;
    }

    public static String getSubject() {
        return subject;
    }

    public static void setSubject(String subject) {
        Mail.subject = subject;
    }

    public static void setText(String text) {
        Mail.text = text;
    }

}
