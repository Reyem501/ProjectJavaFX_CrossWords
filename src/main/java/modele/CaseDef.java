package modele;

/**
 * Classe CaseDef pour les définitions des mots
 */
public class CaseDef implements I_Case{
    private int nbMot;
    private Fleche[] directionDef;
    private String[] flecheDef;
    private String definition;
    private int[][] positionDef;
    private Mot[] mots;

    /**
     * Méthode Constructeur d'une case de définition de mot
     * @param dirDef
     * @param fleche
     * @param def
     * @param x
     * @param y
     */
    public CaseDef(Fleche dirDef, String fleche, String def, int x, int y)
    {
        directionDef[0] = dirDef;
        flecheDef[0] = fleche;
        definition = def;
        positionDef[0][0] = x;
        positionDef[0][1] = y;
    }

    public String getDef(int index) {
        return definition;
    }

    public String getFleche(int index) {
        return flecheDef[index];
    }

    public int getPositionDef(int index) {
        return positionDef[index][index];
    }

    public Mot getMots(int index) {
        return mots[index];
    }
}

