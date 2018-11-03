package com.scratchtest.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import com.scratchtest.dao.ScratchPadDAO;
import com.scratchtest.dao.impl.ScratchPadDAOImpl;
import com.scratchtest.model.ScratchPad;
import com.scratchtest.service.ScratchPadService;

public class ScratchPadServiceImpl implements ScratchPadService{
	private ScratchPadDAO scratchpadDAO;
	
	public ScratchPadServiceImpl() {
		this.scratchpadDAO = new ScratchPadDAOImpl();
	}
	
	 public ScratchPadDAO getScratchPadDAO() {
	        return scratchpadDAO;
	    }

	    public void setScratchPadDAO(ScratchPadDAO scratchPadDAO) {
	        this.scratchpadDAO = scratchPadDAO;
	    }
	    
	    @Override
	    public ScratchPad doAddNotes(ScratchPad scratchpad) throws SQLException {
	    	
	    	return scratchpadDAO.AddNotes(scratchpad);
	    }
	    
	    public ArrayList<ScratchPad> doGetNotes() throws SQLException {
	    	return scratchpadDAO.getNotes();
	    }
}
