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
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.IServicoMySQLDAO;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Servico;

/**
 *
 * @author Clínica Eng Software
 */
public class ServicoMySQLDAO extends DAOMySQLConexao implements IServicoMySQLDAO {
	
	@Override
	public int salvar(Servico servico) {
		PreparedStatement stmt = null;
		int idGerado = -1;
		ResultSet result = null;
		try {
			conectar();

			String sql = "INSERT INTO Servico (descricao, valor, idCliente, idPrestador, data) VALUES (?, ?, ?, ?, ?);";

			stmt = criarStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, servico.getDescricao());
			stmt.setDouble(2, servico.getValor());
			stmt.setInt(3, Integer.valueOf(servico.getIdCliente()) );
			stmt.setInt(4, Integer.valueOf(servico.getIdPrestador()));
			stmt.setString(5, servico.getData());
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
		String sql = "DELETE FROM servico WHERE idServico = " + Integer.valueOf(id) + ";";
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
	public boolean atualizar(Servico servico) {
		conectar();
		// para atualizar é necessário passar o id, então escolha o construtor que
		// possui esse parâmetro
		String sql = "UPDATE servico SET descricao=?, valor=?, data=? WHERE idServico = " + Integer.valueOf(servico.getIdServico()) + ";";
		PreparedStatement stmt = criarStatement(sql);
		try {
			stmt.setString(1, servico.getDescricao());
			stmt.setDouble(2, servico.getValor());
			stmt.setString(3, servico.getData());
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
	

	public Servico listarPorId(String id) {
		conectar();
		// a busca é feita a partir dos idPessoa então o objeto endereço necessita ser instanciado com esse atributo.
		ResultSet result = null;
		PreparedStatement stmt = null;
		Servico ser = new Servico();

		String sql = "SELECT idServico, descricao, valor, idCliente, idPrestador, data FROM servico WHERE idServico = " + id + ";";
		stmt = this.criarStatement(sql);

		try {
			result = stmt.executeQuery();
			while (result.next()) {
				ser = new Servico(result.getString("idServico"), result.getString("descricao"), result.getDouble("valor"),
						result.getString("idCliente"), result.getString("idPrestador"), result.getString("data"));
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		fechar();
		return ser;
	}
	
	public ArrayList<Servico> listarTodos() {
		conectar();
		ArrayList<Servico> listaServico = new ArrayList<>();
		ResultSet result = null;
		PreparedStatement stmt = null;
		Servico ser = new Servico();

		String sql = "SELECT idServico, descricao, valor, idCliente, idPrestador, data FROM servico;";
		stmt = this.criarStatement(sql);
		try {
			stmt.executeQuery();
			result = stmt.executeQuery();
			while (result.next()) {
				ser = new Servico(result.getString("idServico"), result.getString("descricao"), result.getDouble("valor"),
						result.getString("idCliente"), result.getString("idPrestador"), result.getString("data"));

				listaServico.add(ser);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		fechar();
		return listaServico;
	}

	public ArrayList<Servico> listarPorBairro(String bairro) {
		conectar();
		ArrayList<Servico> listaServico = new ArrayList<>();
		ResultSet result = null;
		PreparedStatement stmt = null;
		Servico ser = new Servico();

		String sql = "SELECT servico.idServico, servico.descricao, servico.valor, servico.idCliente, servico.idPrestador, servico.data FROM servico INNER JOIN cliente ON servico.idCliente = cliente.idCliente INNER JOIN endereco ON cliente.idCLiente = endereco.idCliente WHERE endereco.bairro = '" + bairro + "';";
		stmt = this.criarStatement(sql);
		try {
			stmt.executeQuery();
			result = stmt.executeQuery();
			while (result.next()) {
				ser = new Servico(result.getString("idServico"), result.getString("descricao"), result.getDouble("valor"),
						result.getString("idCliente"), result.getString("idPrestador"), result.getString("data"));

				listaServico.add(ser);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		fechar();
		return listaServico;
	}
	
	public ArrayList<Servico> listarPorMesAtual(String mesAnoAtual) {
		conectar();
		ArrayList<Servico> listaServico = new ArrayList<>();
		ResultSet result = null;
		PreparedStatement stmt = null;
		Servico ser = new Servico();
		String data = getMesAno(mesAnoAtual);

		String sql = "SELECT idServico, descricao, valor, idCliente, idPrestador, data FROM servico WHERE data LIKE '%" + data + "%';";
		stmt = this.criarStatement(sql);
		try {
			stmt.executeQuery();
			result = stmt.executeQuery();
			while (result.next()) {
				ser = new Servico(result.getString("idServico"), result.getString("descricao"), result.getDouble("valor"),
						result.getString("idCliente"), result.getString("idPrestador"), result.getString("data"));

				listaServico.add(ser);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		fechar();
		return listaServico;
	}
	
	private String getMesAno(String data) {
		String[] dts;
		dts = data.split("/");
		String mes = dts[1];
		dts = dts[2].split(" ");
		String ano = dts[0];
		return mes + "/" + ano;
	}
}
