package BMS;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BMS.DatabaseConnection;

import BMS.statement;

/**
 * Servlet implementation class Deposit
 */
@WebServlet("/Deposit")
public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		double credit =Double.parseDouble(request.getParameter("credit"));
		double debit =Double.parseDouble(request.getParameter("debit"));


	double balance = 0;
	if(credit==0.00)
	{

		try {
		PreparedStatement ps = DatabaseConnection.getCon().prepareStatement("select * from bms");
		//ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			
			double now=rs.getDouble("balance");
			balance=now;
		}
		System.out.println("username is: " + balance);
}
		catch (SQLException e) {
			e.printStackTrace();
		}  
      balance=balance-debit;
    		  
	try {
		
		
		
		PreparedStatement ps = DatabaseConnection.getCon().prepareStatement("insert into bms (credit,debit,balance)values (?,?,?)");
		//ps.setInt(1, id);
	
		
		
		ps.setDouble(1, credit);
		ps.setDouble(2, debit);
		ps.setDouble(3, balance);
		
		
		ps.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
		
}

	request.setAttribute("score", balance);
	request.setAttribute("balance", "back");
	request.getRequestDispatcher("withdraw.jsp").forward(request, response);
	}
	else
	{
try {
		
		
		
		PreparedStatement ps = DatabaseConnection.getCon().prepareStatement("select * from bms");
		//ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			
			double now=rs.getDouble("balance");
			balance=now;
		}
		System.out.println("username is: " + balance);
}
		catch (SQLException e) {
			e.printStackTrace();
		}  
      balance=balance+credit;
	try {
		
		
		
		PreparedStatement ps = DatabaseConnection.getCon().prepareStatement("insert into bms (credit,debit,balance)values (?,?,?)");
		//ps.setInt(1, id);
	
		
		
		ps.setDouble(1, credit);
		ps.setDouble(2, debit);
		ps.setDouble(3, balance);
		
		
		ps.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}  
	request.setAttribute("score", balance);
	request.setAttribute("balance", "back");
	request.getRequestDispatcher("deposit.jsp").forward(request, response);
	}
	
	
}
}


