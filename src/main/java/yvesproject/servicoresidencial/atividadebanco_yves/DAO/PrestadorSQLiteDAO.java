/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yvesproject.servicoresidencial.atividadebanco_yves.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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

			String sql = "INSERT INTO Prestador (idPrestador, cnpj) VALUES (?, ?);";

			stmt = criarStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1,(int) prestador.getIdPrestador());
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
	public boolean remover() {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public boolean atualizar(Prestador prestador) {
		conectar();
		// para atualizar é necessário passar o id, então escolha o construtor que
		// possui esse parâmetro
		String sql = "UPDATE Prestador SET cnpj=? WHERE idCliente = '" + prestador.getIdPrestador() + "';";
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
}
