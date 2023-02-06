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
    private String cpf;
    private String idPessoaMongo;
    
    public Cliente() {
    }
    
    public Cliente(String cpf) {
    	this.cpf = cpf;
    }
    
    public Cliente(String idCliente, String cpf) {
    	this.idCliente = idCliente;
    	this.cpf = cpf;
    }
    
    public Cliente(String idCliente, String cpf, String idPessoaMongo) {
    	this.idCliente = idCliente;
    	this.cpf = cpf;
    	this.idPessoaMongo = idPessoaMongo;
    }

	public String getIdCliente() {
		return idCliente;
	}

	public String getCpf() {
		return cpf;
	}

	public String getIdPessoaMongo() {
		return idPessoaMongo;
	}
}
