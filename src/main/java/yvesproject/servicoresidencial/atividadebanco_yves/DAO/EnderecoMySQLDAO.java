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
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.IEnderecoMySQLDAO;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Endereco;

/**
 *
 * @author Clínica Eng Software
 */
public class EnderecoMySQLDAO extends DAOMySQLConexao implements IEnderecoMySQLDAO {
	
	@Override
	public int salvar(Endereco endereco) {
		PreparedStatement stmt = null;
		int idGerado = -1;
		ResultSet result = null;
		try {
			conectar();

			String sql = "INSERT INTO Endereco (idCliente, logradouro, cep, numero, bairro, cidade, estado) VALUES (?, ?, ?, ?, ?, ?, ?);";

			stmt = criarStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, Integer.valueOf(endereco.getIdPessoa()));
			stmt.setString(2, endereco.getLogradouro());
			stmt.setInt(3, endereco.getCep());
			stmt.setInt(4, endereco.getNumero());
			stmt.setString(5, endereco.getBairro());
			stmt.setString(6, endereco.getCidade());
			stmt.setString(7, endereco.getEstado());
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
		String sql = "DELETE FROM Endereco WHERE idCliente = " + Integer.valueOf(id) + ";";
		PreparedStatement stmt = this.criarStatement(sql);
		try {
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

	@Override
	public boolean atualizar(Endereco endereco) {
		conectar();
		// para atualizar é necessário passar o id, então escolha o construtor que possui esse parâmetro
		String sql = "UPDATE endereco SET cep=?, numero=?, bairro=?, cidade=?, estado=? WHERE idEndereco = " + Integer.valueOf(endereco.getIdEndereco()) + " AND idCliente = " + Integer.valueOf(endereco.getIdPessoa()) + ";";
		PreparedStatement stmt = criarStatement(sql);
		try {
			stmt.setInt(1, endereco.getCep());
			stmt.setInt(2, endereco.getNumero());
			stmt.setString(3, endereco.getBairro());
			stmt.setString(4, endereco.getCidade());
			stmt.setString(5, endereco.getEstado());
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

	@Override
	public Endereco listarPorId(String id) {
		conectar();
		// a busca é feita a partir dos idPessoa então o objeto endereço necessita ser instanciado com esse atributo.
		ResultSet result = null;
		PreparedStatement stmt = null;
		Endereco end = new Endereco();

		String sql = "SELECT idEndereco, idCliente, logradouro, cep, numero, bairro, cidade, estado FROM endereco WHERE  idCliente = " + Integer.valueOf(id) + ";";
		stmt = this.criarStatement(sql);
		try {
			result = stmt.executeQuery();
			while (result.next()) {
				end = new Endereco(result.getString("idEndereco"), result.getString("idCliente"), result.getString("logradouro"), result.getInt("cep"),
					result.getInt("numero"), result.getString("bairro"), result.getString("cidade"), result.getString("estado"));
			}
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return end;
	}
	
	public ArrayList<Endereco> listarTodos() {
		conectar();
		ArrayList<Endereco> listaEndereco = new ArrayList<>();
		ResultSet result = null;
		PreparedStatement stmt = null;
		Endereco end = new Endereco();

		String sql = "SELECT idEndereco, idCliente, logradouro, cep, numero, bairro, cidade, estado FROM endereco;";
		stmt = this.criarStatement(sql);
		try {
			stmt.executeQuery();
			result = stmt.executeQuery();
			while (result.next()) {
				end = new Endereco(String.valueOf(result.getInt("idEndereco")), String.valueOf(result.getInt("idCliente")), result.getString("logradouro"), result.getInt("cep"),
						result.getInt("numero"), result.getString("bairro"), result.getString("cidade"), result.getString("estado"));
				listaEndereco.add(end);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		fechar();
		return listaEndereco;
	}
}
