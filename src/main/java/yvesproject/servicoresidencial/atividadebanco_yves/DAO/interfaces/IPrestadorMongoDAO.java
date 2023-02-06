package yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces;

import java.util.ArrayList;

import yvesproject.servicoresidencial.atividadebanco_yves.model.Pessoa;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Prestador;

public interface IPrestadorMongoDAO {
	public String salvar(Prestador prestador, Pessoa pessoa);
	public ArrayList<Prestador> listarTodos();
	public boolean atualizar(Prestador prestador, Pessoa pessoa);
	public boolean remover(String nome);
	public Prestador listarPorId(String id);
}
