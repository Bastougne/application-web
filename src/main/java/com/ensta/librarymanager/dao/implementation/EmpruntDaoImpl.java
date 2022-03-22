package com.ensta.librarymanager.dao.implementation;

import com.ensta.librarymanager.dao.interfaces.EmpruntDao;
import com.ensta.librarymanager.exception.DaoException;
import com.ensta.librarymanager.modele.Emprunt;
import com.ensta.librarymanager.persistence.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;

public class EmpruntDaoImpl implements EmpruntDao {
    public List<Emprunt> getList() throws DaoException {
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement stnt = conn.prepareStatement(
            "SELECT e.id AS id, idMembre, nom, prenom, adresse, email, telephone, abonnement, "
            + "idLivre, titre, auteur, isbn, dateEmprunt, dateRetour FROM emprunt AS e INNER JOIN "
            + "membre ON membre.id = e.idMembre INNER JOIN livre ON livre.id = e.idLivre ORDER BY dateRetour DESC;" );
        // stnt.setInt( 1, id );
        ResultSet listEmprunts = stnt.executeQuery();
        return new List<Emprunt>();
        conn.close();
    };
    public List<Emprunt> getListCurrent() throws DaoException{

    };
    public List<Emprunt> getListCurrentByMembre( int idMembre ) throws DaoException{

    };
    public List<Emprunt> getListCurrentByLivre( int idLivre ) throws DaoException{

    };
    public Emprunt getById( int id ) throws DaoException{

    };
    public void create( int idMembre, int idLivre, LocalDate dateEmprunt ) throws DaoException{

    };
    public void update( Emprunt emprunt ) throws DaoException{

    };
    public int count() throws DaoException{

    };
}
