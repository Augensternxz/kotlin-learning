import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

import javax.sound.midi.Soundbank;
import java.io.IOException;

public class Jhava {

    /*public*/ private int hitPoints = 52489112;
    private String greeting = "BLARGH";

    public static void main(String[] args) {
        System.out.println(Hero/*Kt*/.makeProclamation());

        System.out.println("Spells:");
        Spellbook spellbook = new Spellbook();
        for (String spell : spellbook.spells) {
            System.out.println(spell);
        }

        System.out.println("Max spell count: " + Spellbook.MAX_SPELL_COUNT);

        Spellbook.getSpellbookGreeting();

        Function1<String, Unit> translator = Hero.getTranslator();
        translator.invoke("TRUCE");
    }

    @NotNull
    public String utterGreeting() {
        return greeting;
    }

    @Nullable
    public String determineFriendshipLevel() {
        return null;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public void offerFood() {
        Hero.handOverFood("pizza");
    }

    public void extendHandInFriendship() throws Exception {
        throw new Exception();
    }

    public void apologize() {
        try {
            Hero.acceptApology();
        } catch (IOException e) {
            System.out.println("Caught!");
        }
    }
}
