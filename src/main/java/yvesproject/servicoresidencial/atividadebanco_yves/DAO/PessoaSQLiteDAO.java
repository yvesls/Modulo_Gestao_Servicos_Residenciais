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
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.IPessoaSQLiteDAO;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Pessoa;

/**
 *
 * @author Clínica Eng Software
 */
public class PessoaSQLiteDAO extends DAOSQLiteConexao implements IPessoaSQLiteDAO {

	@Override
	public int salvar(Pessoa pessoa) {
		PreparedStatement stmt = null;
		int result = -1;
		try {
			conectar();

			String sql = "INSERT INTO Pessoa (nome, telefone) VALUES (?, ?);";

			stmt = criarStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, "2765054329");
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
	public void buscar(int idPessoa) {
		// TODO Auto-generated method stub
		
	}
    
}
