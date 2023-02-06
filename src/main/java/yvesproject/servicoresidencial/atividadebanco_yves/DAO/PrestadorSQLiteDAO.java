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

import yvesproject.servicoresidencial.atividadebanco_yves.DAO.conexao.DAOSQLiteConexao;
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.IPrestadorSQLiteDAO;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Prestador;

/**
 *
 * @author Clínica Eng Software
 */
public class PrestadorSQLiteDAO extends DAOSQLiteConexao implements IPrestadorSQLiteDAO {

	@Override
	public int salvar(Prestador prestador) {
		PreparedStatement stmt = null;
		int result = -1;
		try {
			conectar();

			String sql = "INSERT INTO prestador de servico (idPrestador, cnpj) VALUES (?, ?);";

			stmt = criarStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, Integer.valueOf(prestador.getIdPrestador()));
			stmt.setString(2, prestador.getCnpj());
			result = stmt.executeUpdate();

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
		return result;
	}

	@Override
	public boolean remover(String id) {
		conectar();
		String sql = "DELETE FROM prestador de servico WHERE idPrestador = '" + id + "';";
		PreparedStatement stmt = this.criarStatement(sql);
		try {
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		fechar();
		return true;													// Tools | Templates.
	}

	@Override
	public boolean atualizar(Prestador prestador) {
		conectar();
		// para atualizar é necessário passar o id, então escolha o construtor que
		// possui esse parâmetro
		String sql = "UPDATE prestador de servico SET cnpj=? WHERE idPrestador = '" + prestador.getIdPrestador() + "';";
		PreparedStatement stmt = criarStatement(sql);
		try {
			stmt.setString(1, prestador.getCnpj());
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
	

	public Prestador listarPorId(String id) {
		conectar();
		// a busca é feita a partir dos idPessoa então o objeto endereço necessita ser instanciado com esse atributo.
		ResultSet result = null;
		PreparedStatement stmt = null;
		Prestador pres = new Prestador();

		String sql = "SELECT idPrestador, cnpj FROM prestador de servico WHERE idPrestador = '"
				+ id + ";";
		stmt = this.criarStatement(sql);

		try {
			stmt.executeQuery();
			result = stmt.executeQuery();
			while (result.next()) {
				pres = new Prestador(result.getString("idPrestador"), result.getString("cnpj"));
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		fechar();
		return pres;
	}
	
	public ArrayList<Prestador> listarTodos() {
		conectar();
		ArrayList<Prestador> listaPrestador = new ArrayList<>();
		ResultSet result = null;
		PreparedStatement stmt = null;
		Prestador pres = new Prestador();

		String sql = "SELECT idPrestador, cnpj FROM prestador;";
		stmt = this.criarStatement(sql);
		try {
			stmt.executeQuery();
			result = stmt.executeQuery();
			while (result.next()) {
				pres = new Prestador(result.getString("idCliente"), result.getString("cnpj"));

				listaPrestador.add(pres);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		fechar();
		return listaPrestador;
	}
}
