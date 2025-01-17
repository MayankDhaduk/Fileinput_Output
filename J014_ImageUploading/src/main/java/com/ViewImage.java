package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewimg")
public class ViewImage extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn  =DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava","root","");
			
			PreparedStatement ps  =cn.prepareStatement("select * from upload");
			
			ResultSet rs = ps.executeQuery();
			
			ArrayList<Upload> al = new ArrayList();
			while(rs.next())
			{
				Upload up = new Upload();
				up.setId(rs.getInt(1));
				up.setName(rs.getString(2));
				up.setImg(rs.getString(3));
				
				al.add(up);
				
				
				
			}
			
			PrintWriter pw = resp.getWriter();
			Gson json = new Gson();
			
			pw.append(json.toJson(al));
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
