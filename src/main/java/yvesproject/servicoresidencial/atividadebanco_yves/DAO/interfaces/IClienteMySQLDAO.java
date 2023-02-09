/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces;
import java.util.ArrayList;

import yvesproject.servicoresidencial.atividadebanco_yves.model.Cliente;

/**
 *
 * @author Clínica Eng Software
 */
public interface IClienteMySQLDAO {
	public int salvar(Cliente cliente);
	public boolean remover(String id);
	public boolean atualizar(Cliente cliente);
	public Cliente listarPorId(String id);
	public ArrayList<Cliente> listarTodos();
    
}
