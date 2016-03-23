package br.com.apoema.eletrostec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.apoema.eletrostec.model.Contato;
import br.com.apoema.eletrostec.util.ConnectionFactory;

public class ContatoDao {
	
	private Connection connection;

	public ContatoDao () {
		
		try {
		    this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
		    throw new RuntimeException(e);
		}
	    }

		    public void salvar(Contato contato) {

			try {
			    String sql = "INSERT INTO contato ( nome, email, mensagem) VALUES (?,?,?)";
			    PreparedStatement stmt = connection.prepareStatement(sql);
			    stmt.setString(1, contato.getNome());
			    stmt.setString(2, contato.getEmail());
			    stmt.setString(3, contato.getMensagem());
			    
			    
			    stmt.execute();
			    stmt.close();
			    connection.close();
			} catch (SQLException e) {
			    throw new RuntimeException(e);
			}
		    }

		    public List<Contato> listar() {

		    	try {

		    	    List<Contato> listaContato = new ArrayList<Contato>();
		    	    PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM contato ORDER BY nome");

		    	    ResultSet rs = stmt.executeQuery();

		    	    while (rs.next()) {
		    		listaContato.add(montarObjeto(rs));
		    	    }

		    	    rs.close();
		    	    stmt.close();
		    	

		    	    return listaContato;

		    	} catch (SQLException e) {
		    	    throw new RuntimeException(e);
		    	}
		        }
		    
		    public void remover(Contato contato) {

		    	try {
		    	    PreparedStatement stmt = connection.prepareStatement("DELETE FROM contato WHERE id = ?");
		    	    stmt.setInt(1, contato.getId());
		    	    stmt.execute();
		    	    stmt.close();
		    	   
		    	} catch (SQLException e) {
		    	    throw new RuntimeException(e);
		    	}
		        }
		    
		    private Contato montarObjeto(ResultSet rs) throws SQLException {
				Contato contato = new Contato();
				contato.setId(rs.getInt("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setMensagem(rs.getString("mensagem"));
			
				return contato;
			}
	
			}
