package com.scratchtest.Bean;

import java.sql.SQLException;
import java.util.List;

import com.scratchtest.model.ScratchPad;
import com.scratchtest.service.ScratchPadService;
import com.scratchtest.service.impl.ScratchPadServiceImpl;

public class ScratchPadBean {
	private List<ScratchPad> scratchPad;
	
	// Service declarations
	ScratchPadService scratchPadService;

	public List<ScratchPad> getScratchPad() {
		return scratchPad;
	}

	public void setScratchPad(List<ScratchPad> scratchPad) {
		this.scratchPad = scratchPad;
	}

	public ScratchPadService getScratchPadService() {
		return scratchPadService;
	}

	public void setScratchPadService(ScratchPadService scratchPadService) {
		this.scratchPadService = scratchPadService;
	}

	public ScratchPadBean() {
		this.scratchPadService = new ScratchPadServiceImpl();
		try {
			this.scratchPad = getScratchPadService().doGetNotes();
		} catch (SQLException e) {
			e.printStackTrace();
		};
	}
}
