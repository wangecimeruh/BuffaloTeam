package com.ngechu;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

@WebServlet(urlPatterns = "/transactions")

public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public Servlet() {}
        

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session session = TransactionHelper.getSessionFactory().getCurrentSession();
		
		Transaction tx=session.getTransaction();
		
		try {
			tx.begin();
			
			List<TransactionBean> transactions= session.createQuery("From TransactionBean t").getResultList();
			ObjectMapper json = new ObjectMapper();
            response.getWriter().println(json.writeValueAsString(transactions));
            tx.commit();
			
		} catch (Exception e) {	
			e.printStackTrace();
			
		}
	}


	}
