package com.solaidoff.headsupholdem.web;

import java.io.IOException;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.solaidoff.headsupholdem.poker.mechanics.Card;
import com.solaidoff.headsupholdem.poker.mechanics.Deck;

/**
 * Servlet implementation class PlayGame
 */
//@WebServlet("/Play") // TODO see if this works without annotation, simply from web.xml
public class PlayGame extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayGame() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    Deck deck = new Deck();
	    Card hole1 = deck.draw();
	    Card hole2 = deck.draw();
	    
        response.getWriter().append("Your hand: " + hole1.getLongName() + ", and " + hole2.getLongName() + ".   ");
        response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
