package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ListaDeDesejos;
import model.Livro;
import model.Usuario;

/**
 * Servlet implementation class Index
 */
@WebServlet("/home")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
				
		if(usuario == null || usuario.getPerfil().getId() != 1) {
			List<Livro> livrosAleatorios = Livro.listaAleatoria();
			request.setAttribute("livrosAleatorios", livrosAleatorios);
			
			if(usuario != null) {
				List<Livro> listaDeDesejos = ListaDeDesejos.lista(usuario);
				if (!listaDeDesejos.isEmpty()) {
					request.setAttribute("listaDeDesejos", listaDeDesejos);
				}
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pages/index.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
