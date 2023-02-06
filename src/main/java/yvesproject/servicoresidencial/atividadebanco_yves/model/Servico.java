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
	private Object idServico;
	private String descricao;
	private double valor;
	private Object idCliente;
	private Object idPrestador;
	private Date data;

	public Servico() {
	}
	
	public Servico(String descricao, double valor, Object idCliente, Object idPrestador) {
		this.descricao = descricao;
		this.valor = valor;
		this.idCliente = idCliente;
		this.idPrestador = idPrestador;
		long millis = System.currentTimeMillis();
		this.data = new Date(millis);
	}

	public Servico(Object idServico, String descricao, double valor, Object idCliente, Object idPrestador) {
		this.idServico = idServico;
		this.descricao = descricao;
		this.valor = valor;
		this.idCliente = idCliente;
		this.idPrestador = idPrestador;
		long millis = System.currentTimeMillis();
		this.data = new Date(millis);
	}

	public Object getIdServico() {
		return idServico;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getValor() {
		return valor;
	}

	public Object getIdCliente() {
		return idCliente;
	}

	public Object getIdPrestador() {
		return idPrestador;
	}

	public Date getData() {
		return data;
	}
}
