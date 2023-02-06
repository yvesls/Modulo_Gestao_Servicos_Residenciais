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
public class DAOSQLiteFactory implements DAOAbstractFactory {

    @Override
    public IEnderecoSQLiteDAO getEnderecoSQLiteDAO() {
        return new EnderecoSQLiteDAO(); 
    }

    @Override
    public IPessoaSQLiteDAO getPessoaSQLiteDAO() {
        return new PessoaSQLiteDAO(); 
    }

    @Override
    public IServicoSQLiteDAO getServicoSQLiteDAO() {
        return new ServicoSQLiteDAO(); 
    }

    @Override
    public IClienteSQLiteDAO getClienteSQLiteDAO() {
        return new ClienteSQLiteDAO(); 
    }

    @Override
    public IPrestadorSQLiteDAO getPrestadorSQLiteDAO() {
         return new PrestadorSQLiteDAO(); 
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
