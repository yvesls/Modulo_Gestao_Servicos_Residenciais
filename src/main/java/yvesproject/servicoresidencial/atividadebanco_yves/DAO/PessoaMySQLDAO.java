/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yvesproject.servicoresidencial.atividadebanco_yves.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import yvesproject.servicoresidencial.atividadebanco_yves.DAO.conexao.DAOMySQLConexao;
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.IPessoaMySQLDAO;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Pessoa;

/**
 *
 * @author Clínica Eng Software
 */
public class PessoaMySQLDAO extends DAOMySQLConexao implements IPessoaMySQLDAO {

	@Override
	public int salvar(Pessoa pessoa) {
		PreparedStatement stmt = null;
		int idGerado = -1;
		ResultSet result = null;
		try {
			conectar();

			String sql = "INSERT INTO Pessoa (nome, telefone) VALUES (?, ?);";

			stmt = criarStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, "2765054329");
			stmt.executeUpdate();
			result = stmt.getGeneratedKeys();
			if (result.next()) {
				idGerado = result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		fechar();
		return idGerado;
	}

	@Override
	public boolean remover(String id) {
		conectar();
		String sql = "DELETE FROM pessoa WHERE idPessoa = " + Integer.valueOf(id) + ";";
		PreparedStatement stmt = this.criarStatement(sql);
		try {
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		fechar();
		return true;
	}

	@Override
	public boolean atualizar(Pessoa pessoa) {
		conectar();
		// para atualizar é necessário passar o id, então escolha o construtor que possui esse parâmetro
		String sql = "UPDATE pessoa SET nome=?, telefone=? WHERE idPessoa = " +  Integer.valueOf(pessoa.getIdPessoa()) + ";";
		PreparedStatement stmt = criarStatement(sql);
		try {
			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getTelefone());
			stmt.executeUpdate();
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return true;	
	}
    
	public ArrayList<Pessoa> listarPorNome(String nome) {
		conectar();
		ArrayList<Pessoa> listaPessoa = new ArrayList<>();
		ResultSet result = null;
		PreparedStatement stmt = null;
		Pessoa pessoa = new Pessoa();

		String sql = "SELECT idPessoa, nome, telefone FROM pessoa WHERE nome LIKE '%" + nome + "%';";
		stmt = this.criarStatement(sql);
		try {
			stmt.executeQuery();
			result = stmt.executeQuery();
			while (result.next()) {
				pessoa = new Pessoa(result.getString("idPessoa"), result.getString("nome"), result.getString("telefone"));

				listaPessoa.add(pessoa);
			}
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fechar();
		return listaPessoa;
	}

	@Override
	public Pessoa listarPorId(String id) {
		conectar();
		ResultSet result = null;
		PreparedStatement stmt = null;
		Pessoa pessoa = new Pessoa();

		String sql = "SELECT idPessoa, nome, telefone FROM pessoa WHERE idPessoa = " +  Integer.valueOf(id) + ";";
		stmt = this.criarStatement(sql);
		try {
			stmt.executeQuery();
			result = stmt.executeQuery();
			while (result.next()) {
				pessoa = new Pessoa(result.getString("idPessoa"), result.getString("nome"), result.getString("telefone"));
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		fechar();
		return pessoa;
	}
	
	public ArrayList<Pessoa> listarTodos() {
		conectar();
		ArrayList<Pessoa> listaPessoa = new ArrayList<>();
		ResultSet result = null;
		PreparedStatement stmt = null;
		Pessoa pessoa = new Pessoa();

		String sql = "SELECT idPessoa, nome, telefone FROM pessoa;";
		stmt = this.criarStatement(sql);
		try {
			stmt.executeQuery();
			result = stmt.executeQuery();
			while (result.next()) {
				pessoa = new Pessoa(result.getString("idPessoa"), result.getString("nome"), result.getString("telefone"));
				listaPessoa.add(pessoa);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		fechar();
		return listaPessoa;
	}
}
