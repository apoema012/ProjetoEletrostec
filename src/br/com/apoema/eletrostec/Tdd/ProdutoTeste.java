package br.com.apoema.eletrostec.Tdd;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import br.com.apoema.eletrostec.dao.CategoriaProdutoDao;

import br.com.apoema.eletrostec.dao.ProdutoDao;
import br.com.apoema.eletrostec.model.CategoriaProduto;
import br.com.apoema.eletrostec.model.Produto;


public class ProdutoTeste {

	@Test
	public void testeInserirProduto() throws SQLException {

		
		ProdutoDao dao = new ProdutoDao();
		CategoriaProdutoDao daocategoria = new CategoriaProdutoDao();
		Produto produto = new Produto();
		CategoriaProduto categoriaProduto = new CategoriaProduto();
		
		
		categoriaProduto = daocategoria.buscarPorId(1);

		produto.setNome("garrafa termica");
		produto.setCodigo(065);
		produto.setCategoriaProduto(categoriaProduto);
		produto.setDescricao("pratica");
		produto.setPreco(35);
		produto.setFabricante("Santa joana");
		produto.setQtdEstoque(210);
		produto.setImagem("imagem");

	
		
		int qtdInicio = dao.listar().size();  
		dao.salvar(produto);
		int qtdFim = dao.listar().size(); 
		dao.close();
		Assert.assertEquals(qtdInicio + 1, qtdFim);
	}
	@Test
	public void removerProdutoTeste()throws SQLException{
		
		ProdutoDao dao = new ProdutoDao();
		Produto produtoPesquisa = new Produto();
		produtoPesquisa = dao.buscarPorId(31);
		dao.remover(produtoPesquisa);
		produtoPesquisa = dao.buscarPorId(31);
		dao.close();
		Assert.assertEquals(null,produtoPesquisa);
		
		
	}
	
	@Test
	public void alterarFuncionarioTest()throws SQLException{
		
		ProdutoDao dao = new ProdutoDao();
		Produto produtoPesquisa = new Produto();
		CategoriaProduto categoriaProduto = new CategoriaProduto();
		CategoriaProdutoDao daocategoria = new CategoriaProdutoDao();
		produtoPesquisa = dao.buscarPorNome("caixa de som");
		categoriaProduto = daocategoria.buscarPorId(1);
		
		dao.alterar(produtoPesquisa);
		produtoPesquisa.setNome("mouse 2");
		produtoPesquisa.setCategoriaProduto(categoriaProduto);
		produtoPesquisa.setPreco(20);
		produtoPesquisa.setFabricante("sansung");
		produtoPesquisa.setQtdEstoque(10);
		produtoPesquisa.setImagem("imagem");
		
		
		produtoPesquisa = dao.buscarPorNome("caixa de som");
		dao.salvar(produtoPesquisa);
		dao.close();
		Assert.assertEquals(produtoPesquisa ,produtoPesquisa);
		
		
	}
	
}


	

