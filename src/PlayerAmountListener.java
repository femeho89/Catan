public class PlayerAmountListener {
    private static boolean twoPlayers = false;
    private static boolean threePlayers = false;
    private static boolean fourPlayers = false;

    public static void setTwoPlayers(){
        twoPlayers = true;
        threePlayers = false;
        fourPlayers = false;
        System.out.println("two players");
    }
    public static void setThreePlayers(){
        twoPlayers = false;
        threePlayers = true;
        fourPlayers = false;
        System.out.println("three players");
    }
    public static void setFourPlayers(){
        twoPlayers = false;
        threePlayers = false;
        fourPlayers = true;
        System.out.println("four players");
    }

    /**
     * A getter for the variable twoPlayers
     * @return twoPlayers
     */
    public static boolean getTwoPlayers(){
        return twoPlayers;
    }
    /**
     * A getter for the variable threePlayers
     * @return threePlayers
     */
    public static boolean getThreePlayers(){
        return threePlayers;
    }
    /**
     * A getter for the variable fourPlayers
     * @return fourPlayers
     */
    public static boolean getFourPlayers(){
        return fourPlayers;
    }


}
