package objects;

import utils.Randomizer;

public class Mail {
    private static Mail mail;
    private static String subject;
    private static String text;
    private static String to;

    public  Mail()
    {
        subject = Randomizer.subject;
        text = Randomizer.textForTextField;
        to = "aldoshin.2013@mail.ru";
    }
    public static Mail getInstance()
    {
        if (mail == null)
        {
            mail = new Mail();
        }return mail;
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
}
