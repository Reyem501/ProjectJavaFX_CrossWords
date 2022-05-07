package com.example.projectjavafx_crosswords;

import controller.I_Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.*;
import modele.GrilleVirtuelle;
import modele.I_modeleGrille;
import observer.I_Observateur;
import org.w3c.dom.events.MouseEvent;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

import static javax.swing.text.StyleConstants.Background;

public class GrilleGraphiqueJFX implements I_Observateur, I_Grille, EventHandler<MouseEvent> {

    private static final int HAUTEUR_MENU = 26;
    private int largeur = 3;
    private int hauteur = 3;
    private final int TAILLECASE = 100;
    private ArrayList<Label> tableau = new ArrayList<>();

    private MenuBar menuBar;
    private Menu menu;
    private MenuItem addTestMenuItem;
    private MenuItem addEssaiMenuItemOk;
    private MenuItem addEssaiMenuItemKO;
    private I_Controller controller;
    private I_modeleGrille modele;
    private TilePane layout;

    public GrilleGraphiqueJFX(I_modeleGrille modele) {
        this.modele= modele;
        modele.addObservateur(this);
        this.largeur = modele.getLargeur();
        this.hauteur= modele.getHauteur();
        System.out.printf("création d'une grille %s x %s%n",this.largeur,this.hauteur);
    }

    public Scene getScene() {
        GroupLayout.Group root = new GroupLayout.Group();
        Scene scene = new Scene(root,TAILLECASE * largeur, TAILLECASE * hauteur+HAUTEUR_MENU, Color.LIGHTGRAY);
        layout = new TilePane();
        layout.setVgap(0);
        layout.setHgap(0);
        layout.setMinSize(TAILLECASE * largeur, TAILLECASE * hauteur);
        buildGrilleChiffres();
        VBox vBox = new VBox();
        vBox.getChildren().add(createControls());
        vBox.getChildren().add(layout);
        root.getChildren().add(vBox);
        return scene;
    }

    private void buildGrilleChiffres() {
        for (int i=1;i<=hauteur * largeur;i++) {
            Label jl = jl(".");
            jl.setOnMouseClicked(this);
            tableau.add(jl);
            layout.getChildren().add(jl);
        }

    }

    private Label jl(String lettre) {
        Label label = new Label(lettre);
        label.setOpacity(100);
        label.setBackground(Background.EMPTY);
        label.setAlignment(Pos.BASELINE_CENTER);
        label.setFont(new Font("Arial", TAILLECASE/2));
        label.setPrefSize(TAILLECASE , TAILLECASE );
        label.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
        return label;
    }

    private MenuBar createControls() {
        menuBar = new MenuBar();
        menu = new Menu("actions");
        addTestMenuItem = new MenuItem("ajouter test en 0,0");
        menu.getItems().add(addTestMenuItem);
        addTestMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(java.awt.event.ActionEvent e) {
                controller.ajouterMotHoriz("test", 0, 0);
            }
        });
        addEssaiMenuItemOk = new MenuItem("ajouter essai en 5,4 (ok)");
        menu.getItems().add(addEssaiMenuItemOk);
        addEssaiMenuItemOk.setOnAction(new EventHandler<java.awt.event.ActionEvent>() {
            @Override
            public void handle(java.awt.event.ActionEvent e) {
                controller.ajouterMotHoriz("essai", 5, 4);
            }
        });
        addEssaiMenuItemKO = new MenuItem("ajouter essai en 6,4 (KO)");
        menu.getItems().add(addEssaiMenuItemKO);
        addEssaiMenuItemKO.setOnAction(new EventHandler<java.awt.event.ActionEvent>() {
            @Override
            public void handle(java.awt.event.ActionEvent e) {
                controller.ajouterMotHoriz("essai", 6, 4);
            }
        });
        MenuItem exit = new MenuItem("Quitter");
        exit.setOnAction(new EventHandler<java.awt.event.ActionEvent>() {
            @Override
            public void handle(java.awt.event.ActionEvent e) {
                System.exit(0);
            }
        });

        menu.getItems().add(exit);
        menuBar.getMenus().add(menu);
        //layout.getChildren().add()setMenuBar(menuBar);
        return menuBar;
    }

    @Override
    public void sendMessage(String s) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText(s);
        alert.showAndWait();
    }

    @Override
    public void update(GrilleVirtuelle gv) {
        for (int i=1;i<=hauteur * largeur;i++) {
        }

        char[][] tab = gv.getTableauDeCases();
        for (int h = 0; h < gv.getHauteur(); h++) {
            for (int l = 0; l < gv.getLargeur(); l++) {
                tableau.get(h * gv.getLargeur()+ l).setText(String.valueOf(tab[l][h]));
            }
        }
    }

    @Override
    public void setController(I_Controller ctrl) {
        this.controller = ctrl;
    }

    @Override
    public void handle(MouseEvent arg0) {
        // coordonnEes dans le Label
        double x = arg0.getX();
        double y = arg0.getY();
        // coordonnEes dans la scEne
        double xScene = arg0.getSceneX();
        double yScene = arg0.getSceneY();
        if (arg0.getSource() instanceof Label) {
            Label j = (Label) arg0.getSource();
            System.out.println(j.getText());
//			System.out.printf("x=%s , y=%s, xScene=%s , yScene = %s%n",x,y,xScene,yScene);
            int xcase = (int) xScene / TAILLECASE;
            int ycase = (int) (yScene - HAUTEUR_MENU) / TAILLECASE;

            System.out.printf("case y=%s par  x=%s%n", ycase, xcase);
//			g.gereCase(xcase,ycase);
        }
    }
}