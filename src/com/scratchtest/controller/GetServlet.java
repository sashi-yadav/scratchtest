package com.scratchtest.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scratchtest.model.ScratchPad;
import com.scratchtest.service.ScratchPadService;
import com.scratchtest.service.impl.ScratchPadServiceImpl;

/**
 * Servlet implementation class GetServlet
 */
@WebServlet(name="GetServlet" , urlPatterns="/show2.jsp")
public class GetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ScratchPadService scratchpadservice;
	
	public ScratchPadService getService()
	{
		return scratchpadservice;
	}
	public void setService(ScratchPadService scratchPadService)
	{
		this.scratchpadservice=scratchpadservice;
	}
       @Override
    public void init() throws ServletException {
    	this.scratchpadservice = new ScratchPadServiceImpl();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<ScratchPad> li=getService().doGetNotes();
			request.setAttribute("list", li);
			request.getRequestDispatcher("/show2.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*try {
			ArrayList<ScratchPad> li=getService().doGetNotes();
			request.setAttribute("list", li);
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
	}

}
