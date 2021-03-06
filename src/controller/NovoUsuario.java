package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Perfil;
import model.Usuario;
import util.Mensagem;

/**
 * Servlet implementation class CadastraUsuario
 */
@WebServlet("/novo-usuario")
public class NovoUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public NovoUsuario() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address;		
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
		
		address = "/WEB-INF/jsp/pages/cadastra-usuario.jsp";
		
		if(usuario != null) {
			List<Perfil> perfis = new Perfil().lista();
			request.getSession().setAttribute("perfis", perfis);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address;		
		
		if(request.getSession().getAttribute("usuarioLogado") != null) {
			if(request.getParameter("editar_id") != null) {
				
			}
		}
		Usuario usuario = new Usuario();
		usuario.setNome(request.getParameter("nome"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));
		
		Perfil perfil = null;
		if(request.getSession().getAttribute("usuarioLogado") != null) {
			perfil = Perfil.getPerfilPeloId(Integer.parseInt(request.getParameter("perfil")));
		}
		else {
			perfil = Perfil.getPerfilPeloId(2);
		}
		usuario.setPerfil(perfil);
		
		if(usuario.salva()) {
			Mensagem mensagem = new Mensagem("Usuario cadastrado.");
			request.setAttribute("mensagem", mensagem);
			request.setAttribute("usuario", usuario);
			address = "/WEB-INF/jsp/pages/sucesso.jsp";
		}
		else {
			Mensagem mensagem = new Mensagem("Nao foi possivel logar.");
			request.setAttribute("erro", mensagem);
			address = "/WEB-INF/jsp/pages/erro.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

}
