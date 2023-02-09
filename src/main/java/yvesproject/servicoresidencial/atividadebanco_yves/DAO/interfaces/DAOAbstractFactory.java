package yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Clínica Eng Software
 */
public interface DAOAbstractFactory {

	public IEnderecoMySQLDAO getEnderecoSQLiteDAO();

	public IPessoaMySQLDAO getPessoaSQLiteDAO();

	public IServicoMySQLDAO getServicoSQLiteDAO();

	public IClienteMySQLDAO getClienteSQLiteDAO();

	public IPrestadorMySQLDAO getPrestadorSQLiteDAO();

	public IEnderecoMongoDAO getEnderecoMongoDAO();

	public IPessoaMongoDAO getPessoaMongoDAO();

	public IServicoMongoDAO getServicoMongoDAO();

	public IClienteMongoDAO getClienteMongoDAO();

	public IPrestadorMongoDAO getPrestadorMongoDAO();

}
