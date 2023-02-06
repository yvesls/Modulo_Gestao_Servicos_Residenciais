/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces;

import yvesproject.servicoresidencial.atividadebanco_yves.model.Pessoa;


/**
 *
 * @author Clínica Eng Software
 */
public interface IPessoaSQLiteDAO {
    
    public int salvar(Pessoa pessoa);
    
    public boolean remover();
    
    public boolean atualizar();
    
    public void buscar(int idPessoa);
    
}
