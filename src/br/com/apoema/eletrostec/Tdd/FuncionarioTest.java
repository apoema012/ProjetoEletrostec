package br.com.apoema.eletrostec.Tdd;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;
import br.com.apoema.eletrostec.dao.FuncionarioDao;
import br.com.apoema.eletrostec.model.Funcionario;

public class FuncionarioTest {

			
	@Test
	public void alterarFuncionarioTest()throws SQLException{
		
		FuncionarioDao dao = new FuncionarioDao();
		Funcionario funcionarioPesquisa = new Funcionario();
		funcionarioPesquisa = dao.buscarPorCpf("123.456.789-88");
		Assert.assertEquals ("000.456.789-88",funcionarioPesquisa.getCpf());
		dao.alterar(funcionarioPesquisa);
		funcionarioPesquisa.setEmail("larissa@gmail.com");
		funcionarioPesquisa.setFuncao("adm");
		funcionarioPesquisa.setNome("Laissa costa da Cruz");
		funcionarioPesquisa.setSenha("0336");
		funcionarioPesquisa.setTelefone("9 12345698" );
		
		
		funcionarioPesquisa = dao.buscarPorCpf("000.456.789-88");
		dao.salvar(funcionarioPesquisa);
		dao.close();
		Assert.assertEquals(funcionarioPesquisa ,funcionarioPesquisa);
		
		
	}
	
}




	