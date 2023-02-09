/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces;

import java.util.ArrayList;

import yvesproject.servicoresidencial.atividadebanco_yves.model.Prestador;

/**
 *
 * @author Clínica Eng Software
 */
public interface IPrestadorMySQLDAO {
    
    public int salvar(Prestador prestador);
    public boolean remover(String id);
    public boolean atualizar(Prestador prestador);
    public Prestador listarPorId(String id);
    public ArrayList<Prestador> listarTodos();
}
