package com.ensta.librarymanager.dao.model;

import java.time.LocalDate;

public class Emprunt {
    private int primaryKey;
    private Membre membre;
    private Livre livre;
    private LocalDate dateEmprunt;
    private LocalDate dateRetour;

    public Emprunt( int primaryKey, Membre membre, Livre livre, LocalDate dateEmprunt, LocalDate dateRetour ) {
        this.primaryKey = primaryKey;
        this.membre = membre;
        this.livre = livre;
        this.dateEmprunt = dateEmprunt;
        this.dateRetour = dateRetour;
    }

    public Emprunt() {
        this.primaryKey = 0;
        this.membre = new Membre();
        this.livre = new Livre();
        this.dateEmprunt = LocalDate.EPOCH;
        this.dateRetour = LocalDate.EPOCH;
    }

    public String toString() {
        return "Primary Key : " + primaryKey +
            "\n Membre : " + membre.toString() +
            "\n Livre : " + livre.toString() +
            "\n Date emprunt : " + dateEmprunt +
            "\n Date retour : " + dateRetour;
    }
}
