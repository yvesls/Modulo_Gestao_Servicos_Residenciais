/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yvesproject.servicoresidencial.atividadebanco_yves.model;

/**
 *
 * @author Clínica Eng Software
 */
public class Cliente {
	private String idCliente;
    private int cpf;
    
    public Cliente() {
    }
    
    public Cliente(int cpf) {
    	this.cpf = cpf;
    }
    
    public Cliente(String idCliente, int cpf) {
    	this.idCliente = idCliente;
    	this.cpf = cpf;
    }

	public String getIdCliente() {
		return idCliente;
	}

	public int getCpf() {
		return cpf;
	}
}
