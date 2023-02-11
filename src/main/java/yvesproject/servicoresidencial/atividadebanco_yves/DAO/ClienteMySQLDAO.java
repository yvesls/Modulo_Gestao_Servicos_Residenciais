package yvesproject.servicoresidencial.atividadebanco_yves.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.conexao.DAOMySQLConexao;
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.IClienteMySQLDAO;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Cliente;

/**
 *
 * @author Clínica Eng Software
 */
public class ClienteMySQLDAO extends DAOMySQLConexao implements IClienteMySQLDAO {

	@Override
	public int salvar(Cliente cliente) {
		PreparedStatement stmt = null;
		int result = -1;
		try {
			conectar();

			String sql = "INSERT INTO Cliente (idCliente, cpf) VALUES (?, ?);";

			stmt = criarStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, Integer.valueOf(cliente.getIdCliente()));
			stmt.setString(2, cliente.getCpf());
			result = stmt.executeUpdate();
			if (result == 1) {
				result = Integer.valueOf(cliente.getIdCliente());
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
		return result;
	}

	@Override
	public boolean remover(String id) {
		conectar();
		String sql = "DELETE FROM cliente WHERE idCliente = " + id + ";";
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
	public boolean atualizar(Cliente cliente) {
		conectar();
		// para atualizar é necessário passar o id, então escolha o construtor que
		// possui esse parâmetro
		String sql = "UPDATE Cliente SET cpf=? WHERE idCliente = '" + cliente.getIdCliente() + "';";
		PreparedStatement stmt = criarStatement(sql);
		try {
			stmt.setString(1, cliente.getCpf());
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

	public Cliente listarPorId(String id) {
		conectar();
		// a busca é feita a partir dos idPessoa então o objeto endereço necessita ser
		// instanciado com esse atributo.
		ResultSet result = null;
		PreparedStatement stmt = null;
		Cliente cli = new Cliente();

		String sql = "SELECT idCliente, cpf FROM cliente WHERE idCliente = " + id + ";";
		stmt = this.criarStatement(sql);

		try {
			stmt.executeQuery();
			result = stmt.executeQuery();
			while (result.next()) {
				cli = new Cliente(result.getString("idCliente"), result.getString("cpf"));
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		fechar();
		return cli;
	}

	public ArrayList<Cliente> listarTodos() {
		conectar();
		ArrayList<Cliente> listaCliente = new ArrayList<>();
		ResultSet result = null;
		PreparedStatement stmt = null;
		Cliente cliente = new Cliente();

		String sql = "SELECT idCliente, cpf FROM cliente;";
		stmt = this.criarStatement(sql);
		try {
			stmt.executeQuery();
			result = stmt.executeQuery();
			while (result.next()) {
				cliente = new Cliente(result.getString("idCliente"), result.getString("cpf"));

				listaCliente.add(cliente);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		fechar();
		return listaCliente;
	}
}
