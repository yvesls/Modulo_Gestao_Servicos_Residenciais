package yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces;

import java.util.ArrayList;

import yvesproject.servicoresidencial.atividadebanco_yves.model.Cliente;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Pessoa;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Prestador;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Servico;

public interface IServicoMongoDAO {
	public String salvar(Servico servico, Cliente cliente, Prestador prestador, Pessoa pessoaCliente, Pessoa pessoaPrestador);
	public boolean remover(String id);
	public boolean atualizar(Servico servico, Cliente cliente, Prestador prestador, Pessoa pessoaCliente, Pessoa pessoaPrestador);
	public ArrayList<Servico> listarTodos();
	public ArrayList<Servico> listarPorBairro(String bairro);
	public ArrayList<Servico> listarPorMesAtual(String mesAnoAtual);
}
