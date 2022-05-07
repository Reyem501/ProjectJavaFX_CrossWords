package modele;

public class GrilleVirtuelle implements I_modeleGrille {
    private int hauteur;
    private int largeur;
    private I_Case[][] cases;
    private Mot[] mots;

    public GrilleVirtuelle(int h, int l){
        hauteur = l;
        largeur = h;
    }

    public int getHauteur(){
        return hauteur;
    }

    public int getLargeur(){
        return largeur;
    }

    public void addCaseDef(String direction, String fleche, String definition, int x, int y){
        CaseDef caseDef1 = new CaseDef(direction, fleche, definition, x, y);
        cases[x][y] = caseDef1;
    }

    public void addCaseLettre(String lettre, int x, int y){
        CaseLettre caseLettre1 = new CaseLettre(lettre);
        cases[x][y] = caseLettre1;
    }

    public void decomposerMot(Mot mot, int x, int y){
        for(int i=0; i<=mot.getLongueurMot(); i++){
            char lettre = mot.getMot().charAt(i);
            if(mot.directionMot()=="verticale") {
                addCaseLettre("banane", 0, i);
            }else{
                addCaseLettre("banane", i, 0);
            }
        }
    }

    public void ecrireMot(){

    }
}
