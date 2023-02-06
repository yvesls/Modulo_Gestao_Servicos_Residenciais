package yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces;

import java.util.ArrayList;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Cliente;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Pessoa;

public interface IClienteMongoDAO {
	public String salvar(Cliente cliente, Pessoa pessoa);
	public boolean remover(String id);
	public boolean atualizar(Cliente cliente, Pessoa pessoa);
	public ArrayList<Cliente> listarTodos();
	public ArrayList<Cliente> listarPorNome(String nome);
}
