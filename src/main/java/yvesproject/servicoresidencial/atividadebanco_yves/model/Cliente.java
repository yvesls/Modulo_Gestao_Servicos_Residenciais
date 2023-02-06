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
	private Object idCliente;
    private int cpf;
    
    public Cliente() {
    }
    
    public Cliente(int cpf) {
    	this.cpf = cpf;
    }
    
    public Cliente(Object idCliente, int cpf) {
    	this.idCliente = idCliente;
    	this.cpf = cpf;
    }

	public Object getIdCliente() {
		return idCliente;
	}

	public int getCpf() {
		return cpf;
	}
}
