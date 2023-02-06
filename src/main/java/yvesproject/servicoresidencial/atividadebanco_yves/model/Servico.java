/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yvesproject.servicoresidencial.atividadebanco_yves.model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

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
	private String data;
	private String idPessoaCliente;
	private String idPessoaPrestador;

	public Servico() {
	}
	
	public Servico(String descricao, double valor, String idCliente, String idPrestador) {
		this.descricao = descricao;
		this.valor = valor;
		this.idCliente = idCliente;
		this.idPrestador = idPrestador;
		LocalDateTime data = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataFormatada = data.format(formato);
		this.data = dataFormatada;
	}

	public Servico(String idServico, String descricao, double valor, String idCliente, String idPrestador) {
		this.idServico = idServico;
		this.descricao = descricao;
		this.valor = valor;
		this.idCliente = idCliente;
		this.idPrestador = idPrestador;
		LocalDateTime data = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataFormatada = data.format(formato);
		this.data = dataFormatada;
	}
	
	public Servico(String idServico, String descricao, double valor, String idCliente, String idPrestador, String data) {
		this.idServico = idServico;
		this.descricao = descricao;
		this.valor = valor;
		this.idCliente = idCliente;
		this.idPrestador = idPrestador;
		this.data = data;
	}
	
	public Servico(String idServico, String descricao, double valor, String idCliente, String idPrestador, String data,
			String idPessoaCliente, String idPessoaPrestador) {
		super();
		this.idServico = idServico;
		this.descricao = descricao;
		this.valor = valor;
		this.idCliente = idCliente;
		this.idPrestador = idPrestador;
		this.data = data;
		this.idPessoaCliente = idPessoaCliente;
		this.idPessoaPrestador = idPessoaPrestador;
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

	public String getData() {
		return data;
	}
}
