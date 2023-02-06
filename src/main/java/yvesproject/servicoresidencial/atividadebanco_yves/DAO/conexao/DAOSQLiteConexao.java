/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yvesproject.servicoresidencial.atividadebanco_yves.DAO.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Clínica Eng Software
 */
public abstract class DAOSQLiteConexao {
    protected Connection conexao;
	protected boolean conectar() {
		
		String url = "jdbc:mysql://localhost:3306/ManutencaoResidencial?useTimezone=true&serverTimezone=UTC";
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			setConexao(DriverManager.getConnection(url, "root", "root"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	protected boolean fechar() {
		try {
			if(this.getConexao().isClosed() == false) {
				this.getConexao().close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	} 
	
	protected Statement criarStatement() {
		try {
			return this.getConexao().createStatement();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	protected PreparedStatement criarStatement(String pSQL, int RETURN_GENERATE_KEYS) {
		try {
			return this.getConexao().prepareStatement(pSQL, RETURN_GENERATE_KEYS);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	protected PreparedStatement criarStatement(String pSQL) {
		try {
			return this.getConexao().prepareStatement(pSQL);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	protected Connection getConexao() {
		return conexao;
	}

	protected void setConexao(Connection conexao) {
		this.conexao = conexao;
	}
}
