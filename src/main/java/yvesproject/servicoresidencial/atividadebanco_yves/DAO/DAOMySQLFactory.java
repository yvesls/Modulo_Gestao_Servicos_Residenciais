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
public class DAOMySQLFactory implements DAOAbstractFactory {

    @Override
    public IEnderecoMySQLDAO getEnderecoSQLiteDAO() {
        return new EnderecoMySQLDAO(); 
    }

    @Override
    public IPessoaMySQLDAO getPessoaSQLiteDAO() {
        return new PessoaMySQLDAO(); 
    }

    @Override
    public IServicoMySQLDAO getServicoSQLiteDAO() {
        return new ServicoMySQLDAO(); 
    }

    @Override
    public IClienteMySQLDAO getClienteSQLiteDAO() {
        return new ClienteMySQLDAO(); 
    }

    @Override
    public IPrestadorMySQLDAO getPrestadorSQLiteDAO() {
         return new PrestadorMySQLDAO(); 
    }

	@Override
	public IEnderecoMongoDAO getEnderecoMongoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPessoaMongoDAO getPessoaMongoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IServicoMongoDAO getServicoMongoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IClienteMongoDAO getClienteMongoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPrestadorMongoDAO getPrestadorMongoDAO() {
		// TODO Auto-generated method stub
		return null;
	}
}
