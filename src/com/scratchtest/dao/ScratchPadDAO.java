package com.scratchtest.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.scratchtest.model.ScratchPad;

public interface ScratchPadDAO {
	
ScratchPad AddNotes(ScratchPad scratchpad)throws SQLException;

ArrayList<ScratchPad> getNotes() throws SQLException;

}
