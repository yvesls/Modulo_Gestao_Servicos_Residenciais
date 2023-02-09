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
public class Pessoa {
	private String idPessoa;
    private String nome;
    private String telefone;
    
    public Pessoa() {
    }
    
    public Pessoa(String nome, String telefone) {
    	this.nome = nome;
    	this.telefone = telefone;
    }
    
    public Pessoa(String idPessoa, String nome, String telefone) {
    	this.idPessoa = idPessoa;
    	this.nome = nome;
    	this.telefone = telefone;
    }

	public String getIdPessoa() {
		return idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	@Override
	public String toString() {
		return "Pessoa [idPessoa=" + idPessoa + ", nome=" + nome + ", telefone=" + telefone + "]";
	}
}
