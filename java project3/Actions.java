package Proje_3;

import java.util.ArrayList;
import java.util.Arrays;


public class Actions {
    ArrayList<String> actions = new ArrayList<>(Arrays.asList("Para Yatırmak İçin", "Para Çekmek İçin", "Transfer İşlemleri İçin", "Çıkış Yapmak İçin"));

    @Override
    public String toString() {
        return "Actions{" +
                "actions=" + actions +
                '}';
    }
}
