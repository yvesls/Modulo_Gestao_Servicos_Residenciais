package yvesproject.servicoresidencial.atividadebanco_yves.DAO;

import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.DAOAbstractFactory;
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.IClienteMongoDAO;
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.IClienteMySQLDAO;
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.IEnderecoMongoDAO;
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.IEnderecoMySQLDAO;
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.IPessoaMongoDAO;
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.IPessoaMySQLDAO;
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.IPrestadorMongoDAO;
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.IPrestadorMySQLDAO;
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.IServicoMongoDAO;
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.IServicoMySQLDAO;

public class DAOSingleton {
	private static DAOSingleton singleton;
	private DAOAbstractFactory daoAbstractFactory;
	private IClienteMySQLDAO clienteMySQLDAO;
	private IEnderecoMySQLDAO enderecoMySQLDAO;
	private IPessoaMySQLDAO pessoaMySQLDAO;
	private IPrestadorMySQLDAO prestadorMySQLDAO;
	private IServicoMySQLDAO servicoMySQLDAO;
	private IClienteMongoDAO clienteMongoDAO;
	private IEnderecoMongoDAO enderecoMongoDAO;
	private IPessoaMongoDAO pessoaMongoDAO;
	private IPrestadorMongoDAO prestadorMongoDAO;
	private IServicoMongoDAO servicoMongoDAO;

	private DAOSingleton() {
	}

	private void configurar(DAOAbstractFactory daoAbstractFactory) {
		this.clienteMySQLDAO = daoAbstractFactory.getClienteMySQLDAO();
		this.enderecoMySQLDAO = daoAbstractFactory.getEnderecoMySQLDAO();
		this.pessoaMySQLDAO = daoAbstractFactory.getPessoaMySQLDAO();
		this.prestadorMySQLDAO = daoAbstractFactory.getPrestadorMySQLDAO();
		this.servicoMySQLDAO = daoAbstractFactory.getServicoMySQLDAO();
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

	public IClienteMySQLDAO getClienteMySQLDAO() {
		return clienteMySQLDAO;
	}

	public IEnderecoMySQLDAO getEnderecoMySQLDAO() {
		return enderecoMySQLDAO;
	}

	public IPessoaMySQLDAO getPessoaMySQLDAO() {
		return pessoaMySQLDAO;
	}

	public IPrestadorMySQLDAO getPrestadorMySQLDAO() {
		return prestadorMySQLDAO;
	}

	public IServicoMySQLDAO getServicoMySQLDAO() {
		return servicoMySQLDAO;
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
