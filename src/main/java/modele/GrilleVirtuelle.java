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

    public void addCaseDef(Fleche direction, String fleche, String definition, int x, int y){
        CaseDef caseDef1 = new CaseDef(direction, fleche, definition, x, y);
        cases[x][y] = caseDef1;
    }

    public void addCaseLettre(char lettre, int x, int y){
        CaseLettre caseLettre1 = new CaseLettre(lettre);
        cases[x][y] = caseLettre1;
    }

    //Méthode pour décomposer un mot et l'afficher
    public void decomposerMot(Mot mot, int x, int y){
        for(int i=0; i<=mot.getLongueurMot(); i++){
            char lettre = mot.getMot().charAt(i);
            if(mot.directionMot()=="verticale") {
                addCaseLettre(lettre, x, i);
            }else{
                addCaseLettre(lettre, i, y);
            }
        }
    }

    //Méthode d'affichage de la grille
    public void afficherGrille() {
        for (int i = 0; i < largeur; i++) {
            System.out.print(i + " ");
        }
        System.out.print("#\n");

        for (int y = 0; y < hauteur; y++) {
            for (int x = 0; x < largeur; x++) {
                if (cases[x][y] instanceof CaseVide) {
                    System.out.print("- ");
                } else if (cases[x][y] instanceof CaseLettre caseTemp) {
                    System.out.print(Character.toUpperCase(caseTemp.getLettreCase()) + " ");
                } else if (cases[x][y] instanceof CaseDef caseTemp) {
                    System.out.print("1 "); //Une seule définition
                }  else if (cases[x][y] instanceof CaseDefinitionMultiple caseTemp) {
                    System.out.print("2 "); //Plusieurs (Deux) définitions
                }
            }
            System.out.println(y);
        }
        System.out.print("\n");
    }

    //Méthode pour vérifier si une case est vide
    public TypeCase TypeCase(int x, int y)
    {
        if (cases[x][y] instanceof CaseVide) {
            return TypeCase.Vide;
        } else if (cases[x][y] instanceof CaseLettre caseTemp) {
            return TypeCase.Lettre;
        } else if (cases[x][y] instanceof CaseDef caseTemp) {
            return TypeCase.DefSimple; //Une seule définition
        }  else if (cases[x][y] instanceof CaseDefinitionMultiple caseTemp) {
            return TypeCase.DefDouble; //Plusieurs (Deux) définitions
        }
        return null;
    }

    //Méthode permettant de rechercher les cases disponibles dans une grille vide
    public int CaseDispo(int x, int y, int hauteur, int largeur, Fleche direction)
    {
        if (direction == Fleche.HD) {
            return largeur - 1;
        } else if (direction == Fleche.HI) {
            return largeur;
        } else if (direction == Fleche.VD) {
            return hauteur - 1;
        } else if (direction == Fleche.VI) {
            return hauteur;
        }
        return 0;
    }
}
