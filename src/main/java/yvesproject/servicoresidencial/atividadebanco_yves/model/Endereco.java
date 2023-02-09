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
	private String idEndereco;
	private String idPessoa;
    private String logradouro;
    private int cep;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    
    public Endereco() {
    }
    
    public Endereco(String idPessoa, String logradouro, int cep, int numero, String bairro, String cidade, String estado) {
    	this.idPessoa = idPessoa;
    	this.logradouro = logradouro;
    	this.cep = cep;
    	this.numero = numero;
    	this.bairro = bairro;
    	this.cidade = cidade;
    	this.estado = estado;
    }
    
    public Endereco(String idEndereco, String idPessoa, String logradouro, int cep, int numero, String bairro, String cidade, String estado) {
    	this.idEndereco = idEndereco;
    	this.idPessoa = idPessoa;
    	this.logradouro = logradouro;
    	this.cep = cep;
    	this.numero = numero;
    	this.bairro = bairro;
    	this.cidade = cidade;
    	this.estado = estado;
    }
    
    public Endereco(String idEndereco, String idPessoa) {
    	this.idEndereco = idEndereco;
    	this.idPessoa = idPessoa;
    }

	public String getIdEndereco() {
		return idEndereco;
	}

	public String getIdPessoa() {
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

	@Override
	public String toString() {
		return "Endereco [idEndereco=" + idEndereco + ", idPessoa=" + idPessoa + ", logradouro=" + logradouro + ", cep="
				+ cep + ", numero=" + numero + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + "]";
	}
}
