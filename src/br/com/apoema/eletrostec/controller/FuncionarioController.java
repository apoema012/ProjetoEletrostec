package br.com.apoema.eletrostec.controller;

import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.apoema.eletrostec.dao.CategoriaProdutoDao;
import br.com.apoema.eletrostec.dao.FuncionarioDao;
import br.com.apoema.eletrostec.dao.ProdutoDao;
import br.com.apoema.eletrostec.model.CategoriaProduto;
import br.com.apoema.eletrostec.model.Funcionario;
import br.com.apoema.eletrostec.model.Produto;

@Controller
public class FuncionarioController {

	@RequestMapping("/exibirLogin")
	public String exibirIncluirFuncionario(Funcionario funcionario) {

		return "funcionario/login";
	}
	
	
	@RequestMapping("/exibirFuncionario")
	public String exibirFuncionario(Funcionario funcionario) {

		return "funcionario/cadastroFuncionario";
	}
	
	@RequestMapping("incluirFuncionario")
	public String incluirFuncionario(Funcionario funcionario, Model model) {

		FuncionarioDao dao = new FuncionarioDao();
		dao.salvar(funcionario);
		model.addAttribute("mensagem", "Funcionário Incluído com Sucesso!");
		
		return "funcionario/cadastroFuncionario";
	}

	@RequestMapping("alterarFuncionario")
	public String alterarUsuario(Funcionario funcionario, Model model) {

		FuncionarioDao dao = new FuncionarioDao();
		dao.alterar(funcionario);
		model.addAttribute("msg", "Funcionário Alterado com Sucesso !");

		return "forward:listarFuncionario";
	}

	@RequestMapping("listarFuncionario")
	public String listarFuncionario(Funcionario funcionario, Model model) {

		FuncionarioDao dao = new FuncionarioDao();
		List<Funcionario> listaFuncionario = dao.listar();
		model.addAttribute("listaFuncionario", listaFuncionario);
		return "produto/testelista";
	}

	@RequestMapping("removerFuncionario")
	public String removerUsuario(Funcionario funcionario, Model model) {

		FuncionarioDao dao = new FuncionarioDao();
		dao.remover(funcionario);
		model.addAttribute("mensagem", "Funcionário Removido com Sucesso");

		return "forward:listarFuncionario";
	}
	
	@RequestMapping("principal")
	public String exibirPaginaPrincipal(Model model) {
		
		CategoriaProdutoDao dao = new CategoriaProdutoDao();
		List<CategoriaProduto> listaCategoriaProduto = dao.listar();
		
		ProdutoDao daoProduto = new ProdutoDao();
		List<Produto> listaProduto = daoProduto.listar();
		
		model.addAttribute("listaProduto", listaProduto);
		model.addAttribute("listaCategoriaProduto", listaCategoriaProduto);
		
		return "principal/index";
	}

	@RequestMapping("efetuarLogin")
	public String efetuarLogin(Funcionario funcionario, HttpSession session, Model model) {
		FuncionarioDao dao = new FuncionarioDao();
		Funcionario funcionarioLogado = dao.buscarFuncionario(funcionario);
		if (funcionarioLogado != null) {
			session.setAttribute("usuarioLogado", funcionarioLogado);
			return "produto/testelista";
		}
		model.addAttribute("msg", "Não foi encontrado um usuário com o login e senha informados.");
		return "funcionario/login";
	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "forward:exibirLogin";
	}
}