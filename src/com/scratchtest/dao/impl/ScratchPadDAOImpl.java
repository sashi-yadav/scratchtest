package com.scratchtest.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.scratchtest.dao.ScratchPadDAO;
import com.scratchtest.model.ScratchPad;

public class ScratchPadDAOImpl implements ScratchPadDAO{
	 private Connection connection;
	    private String driverClass = "com.mysql.jdbc.Driver";
	    private String url = "jdbc:mysql://localhost:3306/notes";
	    private String dbUserName = "root";
	    private String dbPassword = "pass123$";

	    public  ScratchPadDAOImpl() {
	        try {
	            Class.forName(driverClass).newInstance();
	            this.connection = DriverManager.getConnection(url, dbUserName, dbPassword);
	        } catch (SQLException | IllegalAccessException | InstantiationException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public Connection getConnection() {
	        return connection;
	    }

	    public void setConnection(Connection connection) {
	        this.connection = connection;
	    }
	    
	    @Override
	    public ScratchPad AddNotes(ScratchPad scratchpad) throws SQLException {
	    	String query = "INSERT INTO scratch_pad(TITLE, DESCRIPTION, USER_ID) VALUES (?,?,?) ";
	    	PreparedStatement preparedstatement=getConnection().prepareStatement(query);
	    	preparedstatement.setString(1, scratchpad.getTitle());
	    	preparedstatement.setString(2, scratchpad.getDescription());
	    	preparedstatement.setString(3, scratchpad.getUserId());
	        preparedstatement.executeUpdate();
	        return scratchpad;
	    }
	    
	    @Override
	    public ArrayList<ScratchPad> getNotes() throws SQLException {
	    	String query="SELECT s.TITLE,s.DESCRIPTION,s.USER_ID FROM scratch_pad s";
	    	PreparedStatement preparedstatement=getConnection().prepareStatement(query);
	    	ResultSet rs=preparedstatement.executeQuery();
	    	ArrayList<ScratchPad> list=new ArrayList<ScratchPad>();
	    	while(rs.next())
	    	{
	    		ScratchPad scratch =new ScratchPad();
	    		scratch.setTitle(rs.getString(1));
	    		scratch.setDescription(rs.getString(2));
	    		scratch.setUserId(rs.getString(3));
	    		
	    		list.add(scratch);
	    	}
	    	return list;
	    }
}
