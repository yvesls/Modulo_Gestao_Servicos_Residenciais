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
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.IServicoSQLiteDAO;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Servico;

/**
 *
 * @author Clínica Eng Software
 */
public class ServicoSQLiteDAO extends DAOSQLiteConexao implements IServicoSQLiteDAO {

	@Override
	public int salvar(Servico servico) {
		PreparedStatement stmt = null;
		int result = -1;
		try {
			conectar();

			String sql = "INSERT INTO Servico (descricao, valor, idCliente, idPrestador, data) VALUES (?, ?, ?, ?, ?);";

			stmt = criarStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, servico.getDescricao());
			stmt.setDouble(2, servico.getValor());
			stmt.setInt(3, Integer.valueOf(servico.getIdCliente()) );
			stmt.setInt(4, Integer.valueOf(servico.getIdPrestador()));
			stmt.setDate(5, servico.getData());
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean atualizar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void buscar(int idServico) {
		// TODO Auto-generated method stub
		
	}

    
}
