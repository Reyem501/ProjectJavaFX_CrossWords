package modele;

public class Mot {
    private String Mot;
    private int longueurMot;
    private String directionMot;
    private int[][] positionDepartMot;
    private String def;

    public Mot(String mot, int longueur, String direction, int x, int y){
        Mot = mot;
        longueurMot = longueur;
        directionMot = direction;
        positionDepartMot[0][0] = x;
        positionDepartMot[0][1] = y;
    }

    public int getLongueurMot() {
        return longueurMot;
    }

    public String getMot() {
        return Mot;
    }

    public String directionMot() {
        return directionMot;
    }
}
