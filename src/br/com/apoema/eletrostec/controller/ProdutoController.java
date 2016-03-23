package br.com.apoema.eletrostec.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.apoema.eletrostec.dao.CategoriaProdutoDao;
import br.com.apoema.eletrostec.dao.ProdutoDao;
import br.com.apoema.eletrostec.model.CategoriaProduto;
import br.com.apoema.eletrostec.model.Produto;
import br.com.apoema.eletrostec.util.Util;

@Controller
public class ProdutoController {

	@RequestMapping("/exibirIncluirProduto")
	public String exibirIncluirProduto(Model model) {
		
		CategoriaProdutoDao dao = new CategoriaProdutoDao();
		List<CategoriaProduto> listaCategoriaProduto = dao.listar();
		model.addAttribute("listaCategoriaProduto", listaCategoriaProduto);

		return "produto/cadastroProduto";
	}

	@RequestMapping("incluirProduto")
	public String incluirProduto(Produto produto, @RequestParam("file") MultipartFile file, Model model) {

		if (Util.fazerUploadImagem(file)) {
			produto.setImagem(Calendar.getInstance().getTime() + " - " + file.getOriginalFilename());
		}

		ProdutoDao dao = new ProdutoDao();
		dao.salvar(produto);
		model.addAttribute("mensagem", "Produto incluído com Sucesso");
		return "forward:listarProduto";
	}

	@RequestMapping("/exibirAlterarProduto")
	public String exibirAlterarProduto(Model model, Produto produto) {

		CategoriaProdutoDao dao1 = new CategoriaProdutoDao();
		List<CategoriaProduto> listaCategoriaProduto = dao1.listar();
		model.addAttribute("listaCategoriaProduto", listaCategoriaProduto);
		
		ProdutoDao dao2 = new ProdutoDao();
		Produto produtoPreenchido = dao2.buscarPorId(produto.getId());
		model.addAttribute("p", produtoPreenchido);

		return "produto/alterarProduto";
	}

	@RequestMapping("alterarProduto")
	public String alterarProduto(Produto produto, Model model) {

		ProdutoDao dao = new ProdutoDao();
		dao.alterar(produto);
		model.addAttribute("mensagem", "Produto Alterado com Sucesso");

		return "forward:listarProduto";
	}

	@RequestMapping("listarProduto")
	public String listarProduto(Model model) {

		ProdutoDao dao = new ProdutoDao();
		List<Produto> listaProduto = dao.listar();
		model.addAttribute("listaProduto", listaProduto);
		return "produto/testelista";
	}

	@RequestMapping("removerProduto")
	public String removerProduto(Produto produto, Model model) {

		ProdutoDao dao = new ProdutoDao();
		dao.remover(produto);
		model.addAttribute("mensagem", "Produto Removido com Sucesso");

		return "forward:listarProduto";
	}
	
	@RequestMapping("visualizarProduto")
	public String visualizarProduto(@RequestParam("id") int id, Model model) {

		ProdutoDao dao = new ProdutoDao();
		Produto produto = dao.buscarPorId(id);
		model.addAttribute("produto", produto);

		return "telas/visualizarProduto";
	}
}
