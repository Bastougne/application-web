package com.ensta.librarymanager.dao.model;

public class Livre {
    private int primaryKey;
    private String titre;
    private String auteur;
    private String isbn;

    public Livre( int primaryKey, String titre, String auteur, String isbn ) {
        this.primaryKey = primaryKey;
        this.titre = titre;
        this.auteur = auteur;
        this.isbn = isbn;
    }

    public Livre() {
        this.primaryKey = 0;
        this.titre = "";
        this.auteur = "";
        this.isbn = "";
    }

    public String toString() {
        return "Primary Key : " + primaryKey +
            "\n Titre : " + titre +
            "\n Auteur : " + auteur +
            "\n ISBN : " + isbn;
    }
}
