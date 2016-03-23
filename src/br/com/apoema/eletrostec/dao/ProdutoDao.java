package br.com.apoema.eletrostec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.apoema.eletrostec.model.Produto;
import br.com.apoema.eletrostec.util.ConnectionFactory;

public class ProdutoDao {

	// CRIANDO A VAIRAVEL QUE IRAR RECEBER A CONEXAO
			private Connection conexao;
			// CRIANDO O METODO DA CONEXAO
			public ProdutoDao() {
				try {
					this.conexao = new ConnectionFactory().getConnection();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}

			    public void salvar(Produto produto) {

				try {
				    String sql = "INSERT INTO produto (nome, codigo, categoriaprodutofk, descricao, preco, fabricante, qtdEstoque, imagem, especificacao) VALUES (?,?,?,?,?,?,?,?,?)";
				    PreparedStatement stmt =  conexao.prepareStatement(sql);
				    stmt.setString(1, produto.getNome());
				    stmt.setInt(2, produto.getCodigo());
				    stmt.setInt(3, produto.getCategoriaProduto().getId());
				    stmt.setString(4, produto.getDescricao());
				    stmt.setDouble(5, produto.getPreco());
				    stmt.setString(6, produto.getFabricante());
				    stmt.setInt(7, produto.getQtdEstoque());
				    stmt.setString(8, produto.getImagem());
				    stmt.setString(9, produto.getEspecificacao());
				    stmt.execute();
				    stmt.close();
				   
				} catch (SQLException e) {
				    throw new RuntimeException(e);
				}
			    }
			    
			    public void alterar(Produto produto) {

			    	String sql = "UPDATE produto SET nome = ?, codigo = ? , categoriaprodutofk = ? , descricao = ? , preco = ? , fabricante = ? , qtdEstoque = ?, especificacao = ?  WHERE id = ?";

			    	try {

			    	    PreparedStatement stmt = conexao.prepareStatement(sql);
			    	    stmt.setString(1, produto.getNome());
			    	    stmt.setInt(2, produto.getCodigo());
			    	    stmt.setInt(3, produto.getCategoriaProduto().getId());
			    	    stmt.setString(4, produto.getDescricao());
			    	    stmt.setDouble(5, produto.getPreco());
			    	    stmt.setString(6, produto.getFabricante());
			    	    stmt.setInt(7, produto.getQtdEstoque());
			    	    stmt.setString(8, produto.getEspecificacao());
			    	    stmt.setInt(9, produto.getId());
			    	    stmt.execute();
			    	    stmt.close();
			    	
			    	} catch (SQLException e) {
			    	    throw new RuntimeException(e);
			    	}
			        }

			        public void remover(Produto produto) {

			    	try {
			    	    PreparedStatement stmt = conexao.prepareStatement("DELETE FROM produto WHERE id = ?");
			    	    stmt.setLong(1, produto.getId());
			    	    stmt.execute();
			    	    stmt.close();
			    	
			    	} catch (SQLException e) {
			    	    throw new RuntimeException(e);
			    	}
			        }
			    
			    public List<Produto> listar() {

			    	try {

			    	    List<Produto> listaProduto = new ArrayList<Produto>();
			    	    PreparedStatement stmt = this.conexao.prepareStatement("SELECT * FROM produto ORDER BY nome");

			    	    ResultSet rs = stmt.executeQuery();

			    	    while (rs.next()) {
			    		listaProduto.add(montarObjeto(rs));
			    	    }

			    	    rs.close();
			    	    stmt.close();
			    	

			    	    return listaProduto;

			    	} catch (SQLException e) {
			    	    throw new RuntimeException(e);
			    	}
			        }
			    
			    public Produto buscarPorId(int id) {

			    	try {
			    	    PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM produto WHERE id = ?");
			    	    stmt.setInt(1, id);
			    	    ResultSet rs = stmt.executeQuery();

			    	    Produto produto = null;
			    	    if (rs.next()) {
			    		produto = montarObjeto(rs);
			    	    }

			    	    rs.close();
			    	    stmt.close();
			    	    
			    	    return produto;
			    	} catch (SQLException e) {
			    	    throw new RuntimeException(e);
			    	}
			        }
			    
			    public List<Produto> buscarPorCategoria(int id) {

			    	try {
			    	    PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM produto WHERE categoriaprodutofk = ?");
			    	    stmt.setInt(1, id);
			    	    ResultSet rs = stmt.executeQuery();

			    	    List<Produto> listaProduto = new ArrayList<Produto>();
			    	    while (rs.next()) {
			    	    	listaProduto.add(montarObjeto(rs));
			    	    }

			    	    rs.close();
			    	    stmt.close();
			    	    
			    	    return listaProduto;
			    	} catch (SQLException e) {
			    	    throw new RuntimeException(e);
			    	}
			        }
			    
			    public Produto buscarPorNome(String string) {

			    	try {
			    	    PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM produto WHERE nome = ?");
			    	    stmt.setString(1, string);
			    	    ResultSet rs = stmt.executeQuery();

			    	    Produto produto = null;
			    	    if (rs.next()) {
			    	    	produto = montarObjeto(rs);
			    	    }

			    	    rs.close();
			    	    stmt.close();
			    	   
			    	    return produto;
			    	} catch (SQLException e) {
			    	    throw new RuntimeException(e);
			    	}
			        }

				private Produto montarObjeto(ResultSet rs) throws SQLException {
					Produto produto = new Produto();
					produto.setId(rs.getInt("id"));
					produto.setNome(rs.getString("nome"));
					produto.setCodigo(rs.getInt("codigo"));
					produto.setDescricao(rs.getString("descricao"));
					produto.setPreco(rs.getFloat("preco"));
					produto.setFabricante(rs.getString("fabricante"));
					produto.setQtdEstoque(rs.getInt("qtdEstoque"));
					produto.setImagem(rs.getString("imagem"));
					produto.setEspecificacao(rs.getString("especificacao"));
					
					
					CategoriaProdutoDao dao = new CategoriaProdutoDao();
					produto.setCategoriaProduto(dao.buscarPorId(rs.getInt("categoriaprodutofk")));

					
					return produto;
				}
				
				public void close() throws SQLException{
					conexao.close();
				}

}
