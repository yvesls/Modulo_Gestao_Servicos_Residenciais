package yvesproject.servicoresidencial.atividadebanco_yves.DAO;

import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.DAOAbstractFactory;
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.IClienteMongoDAO;
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.IClienteSQLiteDAO;
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.IEnderecoMongoDAO;
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.IEnderecoSQLiteDAO;
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.IPessoaMongoDAO;
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.IPessoaSQLiteDAO;
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.IPrestadorMongoDAO;
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.IPrestadorSQLiteDAO;
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.IServicoMongoDAO;
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.IServicoSQLiteDAO;

public class DAOSingleton {
	private static DAOSingleton singleton;
	private DAOAbstractFactory daoAbstractFactory;
	private IClienteSQLiteDAO clienteSqliteDAO;
	private IEnderecoSQLiteDAO enderecoSqliteDAO;
	private IPessoaSQLiteDAO pessoaSqliteDAO;
	private IPrestadorSQLiteDAO prestadorSqliteDAO;
	private IServicoSQLiteDAO servicoSqliteDAO;
	private IClienteMongoDAO clienteMongoDAO;
	private IEnderecoMongoDAO enderecoMongoDAO;
	private IPessoaMongoDAO pessoaMongoDAO;
	private IPrestadorMongoDAO prestadorMongoDAO;
	private IServicoMongoDAO servicoMongoDAO;

	private DAOSingleton() {
	}

	private void configurar(DAOAbstractFactory daoAbstractFactory) {
		this.clienteSqliteDAO = daoAbstractFactory.getClienteSQLiteDAO();
		this.enderecoSqliteDAO = daoAbstractFactory.getEnderecoSQLiteDAO();
		this.pessoaSqliteDAO = daoAbstractFactory.getPessoaSQLiteDAO();
		this.prestadorSqliteDAO = daoAbstractFactory.getPrestadorSQLiteDAO();
		this.servicoSqliteDAO = daoAbstractFactory.getServicoSQLiteDAO();
		this.clienteMongoDAO = daoAbstractFactory.getClienteMongoDAO();
		this.enderecoMongoDAO = daoAbstractFactory.getEnderecoMongoDAO();
		this.pessoaMongoDAO = daoAbstractFactory.getPessoaMongoDAO();
		this.prestadorMongoDAO = daoAbstractFactory.getPrestadorMongoDAO();
		this.servicoMongoDAO = daoAbstractFactory.getServicoMongoDAO();
	}

	public static void configurarSingleton(DAOAbstractFactory daoAbstractFactory) {
		if (singleton == null) {
			singleton = new DAOSingleton();
		}
		singleton.configurar(daoAbstractFactory);
	}

	public static DAOSingleton getInstance() {
		return singleton;
	}

	public IClienteSQLiteDAO getClienteSqliteDAO() {
		return clienteSqliteDAO;
	}

	public IEnderecoSQLiteDAO getEnderecoSqliteDAO() {
		return enderecoSqliteDAO;
	}

	public IPessoaSQLiteDAO getPessoaSqliteDAO() {
		return pessoaSqliteDAO;
	}

	public IPrestadorSQLiteDAO getPrestadorSqliteDAO() {
		return prestadorSqliteDAO;
	}

	public IServicoSQLiteDAO getServicoSqliteDAO() {
		return servicoSqliteDAO;
	}

	public IClienteMongoDAO getClienteMongoDAO() {
		return clienteMongoDAO;
	}

	public IEnderecoMongoDAO getEnderecoMongoDAO() {
		return enderecoMongoDAO;
	}

	public IPessoaMongoDAO getPessoaMongoDAO() {
		return pessoaMongoDAO;
	}

	public IPrestadorMongoDAO getPrestadorMongoDAO() {
		return prestadorMongoDAO;
	}

	public IServicoMongoDAO getServicoMongoDAO() {
		return servicoMongoDAO;
	}
}
