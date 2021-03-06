package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Dispatch;

import model.Autor;
import model.Categoria;
import model.Editora;
import model.Livro;

/**
 * Servlet implementation class Google
 */
@WebServlet("/google")
public class Google extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Google() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Autor autor = null;
		Editora editora = null;
		Categoria categoria = null;
		String titulo = "";
		int autor_id = 0, editora_id = 0, categoria_id = 0;
		if(request.getParameter("titulo") != null){ 
			titulo = request.getParameter("titulo");  
		}
		if(request.getParameter("autor") != null && Integer.parseInt(request.getParameter("autor")) != 0){ 
			autor = Autor.getAutorPeloId(Integer.parseInt(request.getParameter("autor")));
			autor_id = autor.getAutor_Id(); 
		}
		if(request.getParameter("categoria") != null && Integer.parseInt(request.getParameter("categoria")) != 0) {
			categoria = Categoria.getCategoriaPeloId(Integer.parseInt(request.getParameter("categoria")));
			categoria_id = categoria.getCategoria_id();
		}
		if(request.getParameter("editora") != null && Integer.parseInt(request.getParameter("editora")) != 0) {
			editora = Editora.getEditoraPeloId(Integer.parseInt(request.getParameter("editora")));
			editora_id = editora.getId();
		}
		
		List<Livro> livros = Livro.listaGoogle(titulo, autor_id, editora_id, categoria_id);
		List<Categoria> categorias = Categoria.lista();
		List<Editora> editoras = Editora.lista();
		List<Autor> autores = Autor.lista();
		
		request.setAttribute("livros", livros);
		request.setAttribute("categorias", categorias);
		request.setAttribute("editoras", editoras);
		request.setAttribute("autores", autores);
		request.setAttribute("tituloPesquisadoAntes", request.getParameter("titulo"));
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pages/resultado-busca.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
