package modele;

/**
 * Classe CaseLettre pour les lettres des mots
 */
public class CaseLettre implements I_Case{
    private char lettreCase;

    public char getLettreCase() {
        return lettreCase;
    }

    public CaseLettre(char lettre){
        lettreCase = (lettre);
    }

}
