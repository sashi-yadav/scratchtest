package com.scratchtest.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scratchtest.model.ScratchPad;
import com.scratchtest.service.ScratchPadService;
import com.scratchtest.service.impl.ScratchPadServiceImpl;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet(name = "AddServlet",
			urlPatterns = "/addScratch")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ScratchPadService scratchpadService;
	
	public ScratchPadService getService()
	{
		return scratchpadService;
	}
    
	public void setService(ScratchPadService scratchPadService)
	{
		this.scratchpadService = scratchpadService;
	}
	@Override
	public void init() throws ServletException {
		this.scratchpadService = new ScratchPadServiceImpl();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ScratchPad scratchpad= new ScratchPad();
		scratchpad.setTitle(request.getParameter("title"));
		scratchpad.setDescription(request.getParameter("description"));
		scratchpad.setUserId(request.getParameter("userid"));
		if(scratchpad.isValidData()) {
		 try {
			 scratchpad = getService().doAddNotes(scratchpad);
			if(scratchpad != null)
			 {
				 response.sendRedirect(request.getContextPath() + "/insert.jsp");
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
	}

}
