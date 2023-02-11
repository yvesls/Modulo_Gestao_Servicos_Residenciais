/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces;

import java.util.ArrayList;

import yvesproject.servicoresidencial.atividadebanco_yves.model.Endereco;

/**
 *
 * @author Clínica Eng Software
 */
public interface IEnderecoMySQLDAO {
    
    public int salvar(Endereco endereco);
    public boolean remover(String id);
    public boolean atualizar(Endereco endereco);
    public Endereco listarPorId(String id);
    public ArrayList<Endereco> listarTodos();
    
}
