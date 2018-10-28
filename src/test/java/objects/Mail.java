package objects;

import utils.Randomizer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Mail {
    private static Mail mail;
    private static String subject;
    private static String text;
    private static String to;
    private Date date;
    private SimpleDateFormat simpleDateFormat;

    public  Mail()
    {
        date = new Date();
        simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

        subject = simpleDateFormat.format(date);
        text = simpleDateFormat.format(date);
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
