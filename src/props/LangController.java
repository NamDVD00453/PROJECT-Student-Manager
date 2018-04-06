package props;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

public class LangController {

    public static ResourceBundle bundle;
    private static Locale locale;

    public static void loadLang(String lang){
        locale = new Locale(lang);
        bundle = ResourceBundle.getBundle("props.lang", locale);
    }

    public static String transLang(String st){
        String trans = bundle.getString(st);
        String tmp = null;
        try {
            tmp = new String(trans.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return tmp;
    }
}
