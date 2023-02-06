/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces;

import yvesproject.servicoresidencial.atividadebanco_yves.model.Prestador;

/**
 *
 * @author Clínica Eng Software
 */
public interface IPrestadorSQLiteDAO {
    
    public int salvar(Prestador prestador);
    
    public boolean remover();
    
    public boolean atualizar(Prestador prestador);
    
}
