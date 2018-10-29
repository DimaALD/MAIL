package objects;

import utils.Randomizer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MailFactory  {

    public static Mail createMailWithRandomString()
    {
        Mail.setSubject(Randomizer.getRandomString(4));
        Mail.setText(Randomizer.getRandomString(10));
        return new Mail();
    }

    public static Mail createMailWithCurrentDate()
    {
        Mail.setSubject(new SimpleDateFormat("yyyy.MM.dd HH:mm:ss:SS").format(new Date()));
        Mail.setText(new SimpleDateFormat("yyyy.MM.dd HH:mm:ss:SS").format(new Date()));
        return new Mail();
    }
}
