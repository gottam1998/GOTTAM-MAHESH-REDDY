package BMS;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BMS.DatabaseConnection;

import BMS.statement;


@WebServlet("/ministatement")
public class ministatement extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<statement> statement_list = new ArrayList<statement>();
		
	try {
		PreparedStatement ps = DatabaseConnection.getCon().prepareStatement("select * from( select * from bms order by transactionNo desc limit 5) sub order by transactionNo");
	
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			statement statement =new statement();
			statement.setTransactionNo(rs.getInt(1));
			statement.setCredit(rs.getDouble(2));
			statement.setDebit(rs.getDouble(3));
			statement.setBalance(rs.getDouble(4));
			statement_list.add(statement);
		}
		
}
		catch (SQLException e) {
			e.printStackTrace();
		}  
	System.out.println("statement_list size :: "+statement_list.size());
	request.setAttribute("statement", statement_list);
	request.getRequestDispatcher("ministatement.jsp").forward(request, response);
}
}