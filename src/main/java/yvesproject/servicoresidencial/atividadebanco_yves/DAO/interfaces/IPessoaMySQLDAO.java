/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces;

import java.util.ArrayList;

import yvesproject.servicoresidencial.atividadebanco_yves.model.Pessoa;


/**
 *
 * @author Clínica Eng Software
 */
public interface IPessoaMySQLDAO {
    
    public int salvar(Pessoa pessoa);
    public boolean remover(String pessoa);
    public boolean atualizar(Pessoa pessoa);
    public Pessoa listarPorId(String idPessoa);
    public ArrayList<Pessoa> listarTodos();
    public ArrayList<Pessoa> listarPorNome(String nome);
    
}
