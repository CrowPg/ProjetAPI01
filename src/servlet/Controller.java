package servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	// Gère l'appel des page JSP.
	private void redirect(HttpServletRequest request, HttpServletResponse response) {
		// Déclaration des variables.
		String root = this.get_root();
		String main = "/WEB-INF/main.jsp";
		String page = request.getParameter("page");
		
		if (page == null) {
			page = "index";
		}
		page = "/WEB-INF/jsp/" + page + ".jsp";
		String filename_page = root.concat("WebContent/").concat(page.substring(1)).replace('/',File.separatorChar).replace('\\',File.separatorChar);
		File file_page =  new File(filename_page);
		if(file_page.exists() == false) {
			page = "/WEB-INF/jsp/error.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(main);
		request.setAttribute("page",page);
		try {
			rd.forward(request, response);
		}
		catch (IOException e) {
			
		} 
		catch (ServletException e) {
			
		}
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
		root = root.replace('/',File.separatorChar).replace('\\',File.separatorChar);
		return root;
	}

}
