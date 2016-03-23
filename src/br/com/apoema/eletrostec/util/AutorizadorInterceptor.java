package br.com.apoema.eletrostec.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

	@Override

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller)
			throws Exception {

		String uri = request.getRequestURI();
		
		if (uri.contains("css") || uri.contains("img")  || uri.contains("js")|| uri.contains("contato")
				|| uri.endsWith("principal") || uri.endsWith("efetuarLogin") || uri.endsWith("exibirLogin")|| uri.endsWith("exibirContato")
				|| uri.endsWith("incluirContato")|| uri.endsWith("visualizarProduto") || uri.endsWith("categoriaProduto") || uri.endsWith("visualizarProdutoCategoria")) {
			return true;
		}
		
		if (request.getSession().getAttribute("usuarioLogado") != null) {
			return true;
		}
		
		response.sendRedirect("principal/index");
		return false;
	}

}
