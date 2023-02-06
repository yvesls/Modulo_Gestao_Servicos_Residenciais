/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces;

import java.util.ArrayList;

import yvesproject.servicoresidencial.atividadebanco_yves.model.Servico;

/**
 *
 * @author Clínica Eng Software
 */
public interface IServicoSQLiteDAO {
    
    public int salvar(Servico servico);
    public boolean remover(String id);
    public boolean atualizar(Servico Servico);
    public ArrayList<Servico> listarTodos();
	public ArrayList<Servico> listarPorBairro(String bairro);
	public ArrayList<Servico> listarPorMesAtual(String mesAnoAtual);
}
