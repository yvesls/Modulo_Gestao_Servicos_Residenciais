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

	public IEnderecoMySQLDAO getEnderecoMySQLDAO();

	public IPessoaMySQLDAO getPessoaMySQLDAO();

	public IServicoMySQLDAO getServicoMySQLDAO();

	public IClienteMySQLDAO getClienteMySQLDAO();

	public IPrestadorMySQLDAO getPrestadorMySQLDAO();

	public IEnderecoMongoDAO getEnderecoMongoDAO();

	public IPessoaMongoDAO getPessoaMongoDAO();

	public IServicoMongoDAO getServicoMongoDAO();

	public IClienteMongoDAO getClienteMongoDAO();

	public IPrestadorMongoDAO getPrestadorMongoDAO();

}
