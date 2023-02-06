/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yvesproject.servicoresidencial.atividadebanco_yves.model;

import java.sql.Date;

/**
 *
 * @author Clínica Eng Software
 */
public class Servico {
	private String idServico;
	private String descricao;
	private double valor;
	private String idCliente;
	private String idPrestador;
	private Date data;

	public Servico() {
	}
	
	public Servico(String descricao, double valor, String idCliente, String idPrestador) {
		this.descricao = descricao;
		this.valor = valor;
		this.idCliente = idCliente;
		this.idPrestador = idPrestador;
		long millis = System.currentTimeMillis();
		this.data = new Date(millis);
	}

	public Servico(String idServico, String descricao, double valor, String idCliente, String idPrestador) {
		this.idServico = idServico;
		this.descricao = descricao;
		this.valor = valor;
		this.idCliente = idCliente;
		this.idPrestador = idPrestador;
		long millis = System.currentTimeMillis();
		this.data = new Date(millis);
	}

	public String getIdServico() {
		return idServico;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getValor() {
		return valor;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public String getIdPrestador() {
		return idPrestador;
	}

	public Date getData() {
		return data;
	}
}
