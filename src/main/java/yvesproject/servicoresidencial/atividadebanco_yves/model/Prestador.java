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
	private Object idPrestador;
	private String cnpj;
	
	public Prestador() {
    }
	
	public Prestador(String cnpj) {
		this.cnpj = cnpj;
	}

	public Prestador(Object idPrestador, String cnpj) {
		this.idPrestador = idPrestador;
		this.cnpj = cnpj;
	}

	public Object getIdPrestador() {
		return idPrestador;
	}

	public String getCnpj() {
		return cnpj;
	}
}
