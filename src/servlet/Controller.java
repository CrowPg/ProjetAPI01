package servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import other.Toolbox;

public class Controller extends HttpServlet {
	private static final long	serialVersionUID	= 1L;

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		this.redirect(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		this.redirect(request,response);
	}
	
	// Gère l'appel des pages JSP.
	private void redirect(HttpServletRequest request, HttpServletResponse response) {
		//***** DECLARATION DES VARIABLES *****//
		String root = this.get_root();
		String main = "/WEB-INF/main.jsp";
		String page = request.getParameter("page");
		String dir_css = Toolbox.parse_filename(root.concat("WebContent/WEB-INF/css/"));
		//***** DECLARATION DES VARIABLES *****//
		
		//***** GESTION DE LA PAGE *****//
		if (page == null) { // Si aucune page renseignée, on met l'index du site.
			page = "index";
		} else { // Sinon on la formate.  
			page = page.toLowerCase();
		}
		// On vérifie que la page (le fichier) existe.
		String filename_page = root.concat("WebContent/WEB-INF/jsp/").concat(page).concat(".jsp");
		filename_page = Toolbox.parse_filename(filename_page);
		File file_page =  new File(filename_page);
		if(file_page.exists() == false) { // Si la page n'existe pas, on met la page d'erreur.
			page = "error";
		}
		// Récupération du contenu du fichier css général (main.css).
		String css = Toolbox.load_file(dir_css + "main.css");
		// Récupération du contenu du fichier css spécifique (page.css).
		css = css + Toolbox.load_file(dir_css + page + ".css");
		page = "/WEB-INF/jsp/" + page + ".jsp";
		//***** GESTION DE LA PAGE *****//
		
		//***** APPEL DE LA PAGE PRINCIPALE (main.jsp) ET ENVOIE DES INFOS *****//
		RequestDispatcher rd = request.getRequestDispatcher(main);
		request.setAttribute("page",page);
		request.setAttribute("css",css);
		try {
			rd.forward(request, response);
		}
		catch (IOException e) {} 
		catch (ServletException e) {}
		//***** APPEL DE LA PAGE PRINCIPALE (main.jsp) ET ENVOIE DES INFOS *****//
		
	}
	
	// Retourne les informations sur la requetes.
	private void get_info(HttpServletRequest request) {
		System.out.println("Servlet Name: " + getServletName());
		System.out.println("Protocol: " + request.getProtocol());
		System.out.println("Scheme: " + request.getScheme());
		System.out.println("Server Name: " + request.getServerName());
		System.out.println("Server Port: " + request.getServerPort());
		System.out.println("Remote Addr: " + request.getRemoteAddr());
		System.out.println("Remote Host: " + request.getRemoteHost());
		System.out.println("Character Encoding: " + request.getCharacterEncoding());
		System.out.println("Content Length: " + request.getContentLength());
		System.out.println("Content Type: "+ request.getContentType());
		System.out.println("Locale: "+ request.getLocale());
		System.out.println("Request Is Secure: " + request.isSecure());
		System.out.println("Auth Type: " + request.getAuthType());
		System.out.println("HTTP Method: " + request.getMethod());
		System.out.println("Remote User: " + request.getRemoteUser());
		System.out.println("Request URI: " + request.getRequestURI()); 
		System.out.println("Context Path: " + request.getContextPath()); 
		System.out.println("Servlet Path: " + request.getServletPath()); 
		System.out.println("Path Info: " + request.getPathInfo());
		System.out.println("Path Trans: " + request.getPathTranslated());
		System.out.println("Query String: " + request.getQueryString());
	}
	
	// Retourne la racine du projet.
	public String get_root() {
		String root = getServletContext().getRealPath("/");
		root = root.substring(0,root.indexOf(".metadata")-1).concat(this.getServletContext().getContextPath()).concat("/");
		root = Toolbox.parse_filename(root);
		return root;
	}

}
