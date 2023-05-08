package br.ucsal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/sessions10")
public class lista10q1 extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
	IOException{
		
		String log = req.getParameter("log");
		String senha = req.getParameter("senha");
		String name = req.getParameter("name");
		String curso = req.getParameter("curso");
		String ocu = req.getParameter("ocu");
		
		try{			
			HttpSession lista10q1 = req.getSession(true);			
			Integer acessos = (Integer) lista10q1.getAttribute("Numero_acessos");
			if (acessos == null) { acessos = 1;
			}else { acessos = acessos + 1; }
			lista10q1.setAttribute("Numero_acessos", acessos);	
			PrintWriter writer = resp.getWriter();			
			writer.append( " <h1> Exemplo de sessão </h1>" );			
			writer.append( "O documento foi acessado " +  acessos + " vezes.");
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}
