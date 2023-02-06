package yvesproject.servicoresidencial.atividadebanco_yves.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.conexao.DAOSQLiteConexao;
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.IClienteSQLiteDAO;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Cliente;

/**
 *
 * @author Clínica Eng Software
 */
public class ClienteSQLiteDAO extends DAOSQLiteConexao implements IClienteSQLiteDAO {

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
	public boolean atualizar(Cliente cliente) {
		conectar();
		// para atualizar é necessário passar o id, então escolha o construtor que possui esse parâmetro
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

	@Override
	public boolean remover(int idCliente) {
		// deixar por último pois, como posso excluir um cliente depois de excluir a pessoa da qual ele é? 
		// deeria excluir a pessoa e o cliente automaticamente.
		return true;
	}
    
}
