package modele;

import com.example.projectjavafx_crosswords.GrilleGraphiqueJFX;

public interface I_modeleGrille {
    public int getHauteur();
    public int getLargeur();

    void addObservateur(GrilleGraphiqueJFX grilleGraphiqueJFX);

    char[][] getTableauDeCases();
}
