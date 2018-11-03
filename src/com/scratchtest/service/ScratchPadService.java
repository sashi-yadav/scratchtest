package com.scratchtest.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.scratchtest.model.ScratchPad;

public interface ScratchPadService {
	ScratchPad doAddNotes(ScratchPad scratchpad) throws SQLException;
	ArrayList<ScratchPad> doGetNotes() throws SQLException;
}
