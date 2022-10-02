package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ong;
import model.OngDAO;

/**
 * Servlet implementation class CadastrarOng
 */
@WebServlet("/CadastrarOng")
public class CadastrarOng extends HttpServlet {
	
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Ong ong = new Ong();
		
		String nomeOng = request.getParameter("nomeOng");
		String cnpj = request.getParameter("cnpj");
		String nomeAdm = request.getParameter("nomeAdm");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		String descricao = request.getParameter("descricao");
		String linkDaocao = request.getParameter("linkDoacao");
		String  linkAluno = request.getParameter("linkAluno");
		
		
		
		
		ong.setNomeInstituicao(nomeOng);
		ong.setNomeAdm("Joao");
		ong.setCnpj(cnpj);
		ong.setNomeAdm(nomeAdm);
		ong.setCidade(cidade);
		ong.setEstado(estado);
		ong.setTelefone(telefone);
		ong.setEmail(email);
		ong.setDescricao(descricao);
		ong.setLinkDoacao(linkDaocao);
		ong.setLinkAluno(linkAluno);
		
		OngDAO ongDAO = new OngDAO();
		ongDAO.save(ong);
		
		response.sendRedirect("sucesso.jsp");
		
		
	}

}
