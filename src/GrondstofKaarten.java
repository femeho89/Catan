import java.security.cert.CertSelector;
import java.util.ArrayList;

public class GrondstofKaarten {
    private static ArrayList<String> grondstofKaarten = new ArrayList<>();

    /*
    abcdefghijklmnopqrstuvwxyz

    Erts
    Graan
    Hout
    Schaap
    Steen
    */

    public GrondstofKaarten() {
        grondstofKaarten.add("Erts");
        grondstofKaarten.add("Graan");
        grondstofKaarten.add("Hout");
        grondstofKaarten.add("Schaap");
        grondstofKaarten.add("Steen");
    }

    public ArrayList<String> getGrondstofKaarten() {
        return grondstofKaarten;
    }
}
