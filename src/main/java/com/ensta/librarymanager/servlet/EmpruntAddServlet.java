package com.ensta.librarymanager.servlet;

import com.ensta.librarymanager.dao.implementation.EmpruntDaoImpl;
import com.ensta.librarymanager.exception.DaoException;
import com.ensta.librarymanager.exception.ServiceException;
import com.ensta.librarymanager.services.implementation.LivreServiceImpl;
import com.ensta.librarymanager.services.implementation.MembreServiceImpl;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( "/emprunt_add" )
public class EmpruntAddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LivreServiceImpl livreServiceImpl = LivreServiceImpl.getInstance();
    private MembreServiceImpl membreServiceImpl = MembreServiceImpl.getInstance();

    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        try {
            request.setAttribute( "ListLivreDispo", livreServiceImpl.getListDispo() );
            request.setAttribute( "ListMembreEmpruntPossible", membreServiceImpl.getListMembreEmpruntPossible() );
        } catch ( ServiceException e ) {
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher( "/WEB-INF/View/emprunt_add.jsp" ).forward( request, response );
    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        try {
            int idMembre = Integer.valueOf( request.getParameter( "idMembre" ) );
            int idLivre = Integer.valueOf( request.getParameter( "idLivre" ) );
            EmpruntDaoImpl.getInstance().create( idMembre, idLivre, LocalDate.now() );
            response.sendRedirect( "/TP3Ensta/emprunt_list" );
        } catch ( DaoException e ) {
            e.printStackTrace();
            doGet(request, response);
        } catch ( SQLException e ) {
            e.printStackTrace();
            doGet(request, response);
        }
    }
}
