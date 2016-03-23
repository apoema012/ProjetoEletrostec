package br.com.apoema.eletrostec.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.apoema.eletrostec.model.CategoriaProduto;
import br.com.apoema.eletrostec.model.Produto;
import br.com.apoema.eletrostec.dao.CategoriaProdutoDao;
import br.com.apoema.eletrostec.dao.ProdutoDao;

@Controller
public class CategoriaProdutoController {

	@RequestMapping("/exibirIncluirCategoriaProduto")
	public String exibirIncluirCategoriaProduto() {

		return "categoriaProduto/incluirCategoriaProduto";
	}

	@RequestMapping("incluirCategoriaProduto")
	public String incluirCategoriaProduto(@Valid CategoriaProduto categoriaProduto, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "forward:exibirIncluirCategoriaProduto";
		}

		CategoriaProdutoDao dao = new CategoriaProdutoDao();
		dao.salvar(categoriaProduto);
		model.addAttribute("msg", "A categoria " + categoriaProduto.getDescricao() + " foi Inserida com Sucesso !");

		return "forward:listarCategoriaProduto";
	}

	@RequestMapping("/listarCategoriaProduto")
	public String listarCategoriaProduto(Model model) {

		CategoriaProdutoDao dao = new CategoriaProdutoDao();
		List<CategoriaProduto> listaCategoriaProduto = dao.listar();
		model.addAttribute("listaCategoriaProduto", listaCategoriaProduto);

		return "categoriaProduto/listarCategoriaProduto";
	}

	@RequestMapping("removerCategoriaProduto")
	public String removerCategoriaProduto(CategoriaProduto categoriaProduto, Model model) {

		CategoriaProdutoDao dao = new CategoriaProdutoDao();
		dao.remover(categoriaProduto);
		model.addAttribute("msg", "Categoria Removida com Sucesso !");

		return "forward:listarCategoriaProduto";
	}

	@RequestMapping("exibirAlterarCategoriaProduto")
	public String exibirAlterarCategoriaProduto(CategoriaProduto categoriaProduto, Model model) {

		CategoriaProdutoDao dao = new CategoriaProdutoDao();
		CategoriaProduto categoriaProdutoPreenchida = dao.buscarPorId(categoriaProduto.getId());
		model.addAttribute("categoria", categoriaProdutoPreenchida);

		return "categoriaProduto/alterarCategoriaProduto";
	}

	@RequestMapping("alterarCategoriaProduto")
	public String alterarCategoriaProduto(CategoriaProduto categoriaProduto, Model model) {

		CategoriaProdutoDao dao = new CategoriaProdutoDao();
		dao.alterar(categoriaProduto);
		model.addAttribute("msg", "Categoria de Produto Alterada com Sucesso !");

		return "forward:listarCategoriaProduto";
	}
	
	@RequestMapping("visualizarProdutoCategoria")
	public String visualizarProdutoCategoria(@RequestParam("id")int id, Model model) {

		ProdutoDao dao = new ProdutoDao();
		CategoriaProdutoDao daoCategoria = new CategoriaProdutoDao();
		List <CategoriaProduto> listaCategoria = daoCategoria.listar();
		List <Produto> lista = dao.buscarPorCategoria(id);
		model.addAttribute("listaProduto", lista);
		model.addAttribute("listaCategoriaProduto", listaCategoria);

		return "telas/categoriaProduto";
	}
	
	

}
