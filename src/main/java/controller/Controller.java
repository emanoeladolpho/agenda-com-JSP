package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dao;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete"})
public class Controller extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	JavaBeans contato = new JavaBeans();
	Dao dao = new Dao();

	public Controller() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			contatos(request, response);
		}else if(action.equals("/insert")) {
			novoContato(request,response);
		} else if(action.equals("/select")){
			listarContatos(request,response);
		}else if(action.equals("/update")) {
			editarContato(request,response);
		} else if(action.equals("/delete")) {
			removerContato(request,response);
		}else {
			response.sendRedirect("index.html");
		}
	}

	// listar contatos
	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<JavaBeans> contatos = dao.getContatos();
		request.setAttribute("contatos", contatos);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("agenda.jsp");
		requestDispatcher.forward(request, response);// envia o objeto contatos ao documento agenda.jsp
	}	
	
	//novo contato
	protected void novoContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		dao.inserirContato(contato);
		contato = new JavaBeans();
		response.sendRedirect("main");
	}
	
	protected void listarContatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//RECEBIMENTO DO ID DO CONTATO QUE SERÁ EDITADO!
		Long id = Long.parseLong(request.getParameter("id"));
		contato.setId(id);
		contato = dao.getContatoById(contato);
		
		//setar os atributos do formulário com o conteúdo javaBeans
		request.setAttribute("id", contato.getId());
		request.setAttribute("nome", contato.getNome());
		request.setAttribute("fone", contato.getFone());
		request.setAttribute("email", contato.getEmail());
		//Encaminhar ao documento [editar.jsp]
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("editar.jsp");
		requestDispatcher.forward(request, response);
	}
	
	protected void editarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contato.setId(Long.parseLong(request.getParameter("id")));
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		dao.editarContato(contato);
		//redirecionar para o documento agenda.jsp (atualizado as alterações)
		response.sendRedirect("main");
	}
	
	protected void removerContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println(id);
		contato.setId(Long.parseLong(id));
		dao.deletarContato(contato);
		//redirecionar para o dcumento agenda.jsp (atualizando a lista)
		response.sendRedirect("main");
	}
}