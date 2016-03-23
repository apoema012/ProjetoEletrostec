package br.com.apoema.eletrostec.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.apoema.eletrostec.dao.ContatoDao;
import br.com.apoema.eletrostec.model.Contato;

@Controller
public class ContatoController {

	@RequestMapping("/exibirContato")
    public String exibirIncluirContato(Contato contato, Model model) {
		
		return "contato/IncluirContato";
		
		}
	
	@RequestMapping("incluirContato")
		public String incluirContato(Contato contato, Model model) {

			ContatoDao dao = new ContatoDao();
			dao.salvar(contato);
			model.addAttribute("mensagem", "Mensagem enviada com Sucesso");
			return "contato/IncluirContato";
		}
	
	@RequestMapping("listarContato")
	public String listarContato(Model model) {

		ContatoDao dao = new ContatoDao();
		List<Contato> listaContato = dao.listar();
		model.addAttribute("listaContato", listaContato);
		return "contato/listarContato";
	}
	
	@RequestMapping("removerContato")
	public String removerContato(Contato contato, Model model) {

		ContatoDao dao = new ContatoDao();
		dao.remover(contato);
		model.addAttribute("mensagem", "Mensagem Removida com Sucesso");

		return "forward:listarContato";
	}
	
    }

