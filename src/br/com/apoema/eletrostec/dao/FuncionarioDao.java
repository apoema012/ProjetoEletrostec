package br.com.apoema.eletrostec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.apoema.eletrostec.model.Funcionario;
import br.com.apoema.eletrostec.util.ConnectionFactory;

public class FuncionarioDao {

	// CRIANDO A VAIRAVEL QUE IRAR RECEBER A CONEXAO
	private Connection conexao;
	// CRIANDO O METODO DA CONEXAO
	public FuncionarioDao() {
		try {
			this.conexao = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	    public void salvar(Funcionario funcionario) {

		try {
		    String sql = "INSERT INTO funcionario (cpf, nome, email, senha, telefone, funcao) VALUES (?,?,?,?,?,?)";
		    PreparedStatement stmt =  conexao.prepareStatement(sql);
		    stmt.setString(1, funcionario.getCpf());
		    stmt.setString(2, funcionario.getNome());
		    stmt.setString(3, funcionario.getEmail());
		    stmt.setString(4, funcionario.getSenha()); 
		    stmt.setString(5, funcionario.getTelefone());
		    stmt.setString(6,  funcionario.getFuncao());
		    stmt.execute();
		   
		   
		} catch (SQLException e) {
		    throw new RuntimeException(e);
		}
	    }
	    
	    public void alterar(Funcionario funcionario) {

	    	String sql = "UPDATE funcionario SET cpf = ? , nome = ? , email = ? , senha = ? , telefone = ? , funcao = ? WHERE cpf = ?";

	    	try {

	    	    PreparedStatement stmt = conexao.prepareStatement(sql);
	    	    stmt.setString(1, funcionario.getCpf());
	    	    stmt.setString(2, funcionario.getNome());
	    	    stmt.setString(3, funcionario.getEmail());
	    	    stmt.setString(4, funcionario.getSenha());
	    	    stmt.setString(5, 	funcionario.getTelefone());
	    	    stmt.setString(6, 	funcionario.getFuncao());
	    	    stmt.execute();
	    	    stmt.close();
	    	    
	    	} catch (SQLException e) {
	    	    throw new RuntimeException(e);
	    	}
	        }

	        public void remover(Funcionario funcionario) {

	    	try {
	    	    PreparedStatement stmt = conexao.prepareStatement("DELETE FROM funcionario WHERE id = ?");
	    	    stmt.setInt(1, funcionario.getId());
	    	    stmt.execute();
	    	    stmt.close();
	    	   
	    	} catch (SQLException e) {
	    	    throw new RuntimeException(e);
	    	}
	        }
	    
	    public List<Funcionario> listar() {

	    	try {

	    	    List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
	    	    PreparedStatement stmt = this.conexao.prepareStatement("SELECT * FROM funcionario ORDER BY nome");

	    	    ResultSet rs = stmt.executeQuery();

	    	    while (rs.next()) {
	    		listaFuncionario.add(montarObjeto(rs));
	    	    }

	    	    rs.close();
	    	    stmt.close();
	    	    

	    	    return listaFuncionario;

	    	} catch (SQLException e) {
	    	    throw new RuntimeException(e);
	    	}
	        }
	    
	   
	    public Funcionario buscarPorCpf(String string) {

	    	try {
	    	    PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM funcionario WHERE cpf = ?");
	    	    stmt.setString(1, string);
	    	    ResultSet rs = stmt.executeQuery();

	    	    Funcionario funcionario = null;
	    	    if (rs.next()) {
	    	    	funcionario = montarObjeto(rs);
	    	    }

	    	    rs.close();
	    	    stmt.close();
	    	   
	    	    return funcionario;
	    	} catch (SQLException e) {
	    	    throw new RuntimeException(e);
	    	}
	        }

	    
		private Funcionario montarObjeto(ResultSet rs) throws SQLException {
			Funcionario funcionario = new Funcionario();
			funcionario.setCpf(rs.getString("cpf"));
			funcionario.setNome(rs.getString("nome"));
			funcionario.setEmail(rs.getString("email"));
			funcionario.setSenha(rs.getString("senha"));
			funcionario.setTelefone(rs.getString("telefone"));
			funcionario.setFuncao(rs.getString("funcao"));
			
			
			return funcionario;
		}

		
		public Funcionario buscarFuncionario(Funcionario funcionario) {
			try {
			
			PreparedStatement stmt = this.conexao.prepareStatement("select * from funcionario where email = ? and senha = ?");
			stmt.setString(1, funcionario.getEmail());
			stmt.setString(2, funcionario.getSenha());
			ResultSet rs = stmt.executeQuery();
			
			
			Funcionario funcionarioConsultado = null;
			if (rs.next()) {
			funcionarioConsultado = montarObjeto(rs);
			}
			
			rs.close();
		
			return funcionarioConsultado;
			} catch (SQLException e) {
			throw new RuntimeException(e);
			}
			}
		
		public void close() throws SQLException{
			conexao.close();
		}
}

