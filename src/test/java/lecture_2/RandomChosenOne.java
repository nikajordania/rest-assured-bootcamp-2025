package lecture_2;

import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class RandomChosenOne {
    @Test
    public void chooseRandom() {
        List<String> s = List.of("Kiladze.Ana",
                "Zabakhidze.Avtandil",
                "Gevorkiani.Davit",
                "Molashvili.Elene",
                "Patashuri.Giorgi",
                "Dolidze.Givi",
                "Zviadauri.Irakli",
                "Epitashvili.Irakli",
                "Mghebrishvili.Jaba",
                "Gabadze.Kakhaber",
                "Iremashvili.Luka",
                "Kapanadze.Luka",
                "Kabulovi.Mariam",
                "Bogveradze.Nikoloz",
                "Sologhashvili.Nikoloz",
                "Mikeladze.Tamar",
                "Tophuria.Tekla",
                "Amoevi.Tengizi",
                "Samkharadze.Tinatin",
                "Ramishvili.Tornike");

        Random random = new Random();
        String randomString = s.get(random.nextInt(s.size()));
        System.out.println("Choose One: " + randomString);
    }
}
