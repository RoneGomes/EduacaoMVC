package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OngDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Ong ong) {

		// Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar na base
		// de dados

		String sql = "INSERT INTO ong (nome_ONG,cnpj,nome_adm,cidade,estado,telefone,email,descricao,linkDoacao,linkAluno)" + " VALUES(?,?,?,?,?,?,?,?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = EduacaoConexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, ong.getNomeInstituicao());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(2, ong.getCnpj());
			// Adiciona o valor do terceiro parâmetro da sql
			pstm.setString(3, ong.getNomeAdm() );
			pstm.setString(4, ong.getCidade() );
			pstm.setString(5, ong.getEstado() );
			pstm.setString(6, ong.getTelefone());
			pstm.setString(7, ong.getEmail() );
			pstm.setString(8, ong.getDescricao() );
			pstm.setString(9, ong.getLinkDoacao() );
			pstm.setString(10, ong.getLinkAluno() );

			// Executa a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fecha as conexões
			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	}

	public void removeBYId(int id) {
		String sql = "DELETE FROM ong WHERE id = ?";

		try {
			conn = EduacaoConexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}
	
	
	public Ong searchBYId(int id) {
		ResultSet rset = null;
		Ong ong = new Ong();
		String sql = "SELECT *FROM ong WHERE id = ?";

		try {
			conn = EduacaoConexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				
				ong.setId(rset.getInt("id"));
				
				ong.setNomeInstituicao(rset.getString("nome_ONG"));
				ong.setCnpj(rset.getString("cnpj"));
				ong.setNomeAdm(rset.getString("nome_adm"));
				ong.setCidade(rset.getString("cidade"));
				ong.setEstado(rset.getString("estado"));
				ong.setTelefone(rset.getString("telefone"));
				ong.setEmail(rset.getString("email"));
				ong.setDescricao(rset.getString("descricao"));
				ong.setLinkDoacao(rset.getString("linkDoacao"));
				ong.setLinkAluno(rset.getString("linkAluno"));

			
				
			}

			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		return ong;
	}

	public void update(Ong ong) {
		String sql = "UPDATE ong SET nome_ONG = ?, cnpj = ? , nome_adm = ? ,cidade=?,estado=?,telefone=?,email=?,descricao=?,linkDoacao=?,linkAluno=?"+ "WHERE id = ?";
		
		try {

			conn = EduacaoConexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			
		
			
			
			pstm.setString(1, ong.getNomeInstituicao());
			pstm.setString(2, ong.getCnpj());
			pstm.setString(3, ong.getNomeAdm());
			pstm.setString(4, ong.getCidade());
			pstm.setString(5, ong.getEstado());
			pstm.setString(6, ong.getTelefone());
			pstm.setString(7, ong.getEmail());
			pstm.setString(8, ong.getDescricao());
			pstm.setString(9, ong.getLinkDoacao());
			pstm.setString(10, ong.getLinkAluno());
			pstm.setInt(11, ong.getId());
			
			
			

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fecha as conexões
			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	}

	public List<Ong> getOngs() {

		String sql = "SELECT * FROM ogn";

		List<Ong> ogns = new ArrayList<Ong>();

		
		ResultSet rset = null;

		try {
			conn = EduacaoConexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Ong ong = new Ong();
				
				
				
                ong.setId(rset.getInt("id"));
				
				ong.setNomeInstituicao(rset.getString("nome_ONG"));
				ong.setCnpj(rset.getString("cnpj"));
				ong.setNomeAdm(rset.getString("nome_adm"));
				ong.setNomeAdm(rset.getString("id"));
				ong.setCidade(rset.getString("cidade"));
				ong.setEstado(rset.getString("estado"));
				ong.setTelefone(rset.getString("telefone"));
				ong.setEmail(rset.getString("email"));
				ong.setDescricao(rset.getString("descricao"));
				ong.setLinkDoacao(rset.getString("linkDoacao"));
				ong.setLinkAluno(rset.getString("linkAluno"));

				
			
				ogns.add(ong);
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {

				if (rset != null) {

					rset.close();
				}

				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		return ogns;
	}

}

