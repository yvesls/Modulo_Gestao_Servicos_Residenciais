/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces;

import yvesproject.servicoresidencial.atividadebanco_yves.model.Cliente;

/**
 *
 * @author Clínica Eng Software
 */
public interface IClienteSQLiteDAO {
	
    public int salvar(Cliente cliente);
    
    public boolean remover(int idCliente);
    
    public boolean atualizar(Cliente cliente);
    
}
