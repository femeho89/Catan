import java.util.Random;

public enum GrondstofKaart {
    ERTS,
    GRAAN,
    HOUT,
    SCHAAP,
    STEEN;

    public static GrondstofKaart getRandom() {
        Random rng = new Random();
        switch(rng.nextInt(1, 5)) {
            case 1 -> {return ERTS;}
            case 2 -> {return GRAAN;}
            case 3 -> {return HOUT;}
            case 4 -> {return SCHAAP;}
            case 5 -> {return STEEN;}
        }
        return ERTS;
    }
}
