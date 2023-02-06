/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Clínica Eng Software
 */
public class DAOMongoDBFactory implements DAOAbstractFactory {

   @Override
    public IEnderecoMongoDAO getEnderecoMongoDAO() {
        return new EnderecoMongoDBDAO(); 
    }

    @Override
    public IPessoaMongoDAO getPessoaMongoDAO() {
        return new PessoaMongoDBDAO(); 
    }

    @Override
    public IServicoMongoDAO getServicoMongoDAO() {
        return new ServicoMongoDBDAO(); 
    }

    @Override
    public IClienteMongoDAO getClienteMongoDAO() {
        return new ClienteMongoDBDAO(); 
    }

    @Override
    public IPrestadorMongoDAO getPrestadorMongoDAO() {
         return new PrestadorMongoDBDAO(); 
    }

	@Override
	public IEnderecoSQLiteDAO getEnderecoSQLiteDAO() {
		return null;
	}

	@Override
	public IPessoaSQLiteDAO getPessoaSQLiteDAO() {
		return null;
	}

	@Override
	public IServicoSQLiteDAO getServicoSQLiteDAO() {
		return null;
	}

	@Override
	public IClienteSQLiteDAO getClienteSQLiteDAO() {
		return null;
	}

	@Override
	public IPrestadorSQLiteDAO getPrestadorSQLiteDAO() {
		return null;
	}
}
