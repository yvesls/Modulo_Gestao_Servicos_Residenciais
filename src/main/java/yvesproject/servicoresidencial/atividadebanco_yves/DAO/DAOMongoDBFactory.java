/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
	public IEnderecoMySQLDAO getEnderecoMySQLDAO() {
		return null;
	}

	@Override
	public IPessoaMySQLDAO getPessoaMySQLDAO() {
		return null;
	}

	@Override
	public IServicoMySQLDAO getServicoMySQLDAO() {
		return null;
	}

	@Override
	public IClienteMySQLDAO getClienteMySQLDAO() {
		return null;
	}

	@Override
	public IPrestadorMySQLDAO getPrestadorMySQLDAO() {
		return null;
	}
}
