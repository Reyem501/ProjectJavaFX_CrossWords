package modele;

public interface I_modeleGrille {
    public int getHauteur();
    public int getLargeur();

    void addObservateur(vue.GrilleGraphiqueJFX grilleGraphiqueJFX);

    char[][] getTableauDeCases();
}
