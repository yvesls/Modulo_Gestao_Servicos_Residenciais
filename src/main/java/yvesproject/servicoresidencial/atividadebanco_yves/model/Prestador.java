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
public class Prestador {
	private String idPrestador;
	private String cnpj;
	private String idPessoaMongo;
	
	public Prestador() {
    }
	
	public Prestador(String cnpj) {
		this.cnpj = cnpj;
	}

	public Prestador(String idPrestador, String cnpj) {
		this.idPrestador = idPrestador;
		this.cnpj = cnpj;
	}
	
	public Prestador(String idPrestador, String cnpj, String idPessoaMongo) {
		this.idPrestador = idPrestador;
		this.cnpj = cnpj;
		this.idPessoaMongo = idPessoaMongo;
	}

	public String getIdPrestador() {
		return idPrestador;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getIdPessoaMongo() {
		return idPessoaMongo;
	}
	
	
}
