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
public class Endereco{
	private Object idEndereco;
	private Object idPessoa;
    private String logradouro;
    private int cep;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    
    public Endereco() {
    }
    
    public Endereco(Object idPessoa, String logradouro, int cep, int numero, String bairro, String cidade, String estado) {
    	this.idPessoa = idPessoa;
    	this.logradouro = logradouro;
    	this.cep = cep;
    	this.numero = numero;
    	this.bairro = bairro;
    	this.cidade = cidade;
    	this.estado = estado;
    }
    
    public Endereco(Object idEndereco, Object idPessoa, String logradouro, int cep, int numero, String bairro, String cidade, String estado) {
    	this.idEndereco = idEndereco;
    	this.idPessoa = idPessoa;
    	this.logradouro = logradouro;
    	this.cep = cep;
    	this.numero = numero;
    	this.bairro = bairro;
    	this.cidade = cidade;
    	this.estado = estado;
    }

	public Object getIdEndereco() {
		return idEndereco;
	}

	public Object getIdPessoa() {
		return idPessoa;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public int getCep() {
		return cep;
	}

	public int getNumero() {
		return numero;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}
}
