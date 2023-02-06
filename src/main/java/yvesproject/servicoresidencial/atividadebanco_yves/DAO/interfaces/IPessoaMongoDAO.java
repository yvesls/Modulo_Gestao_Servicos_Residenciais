package yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces;

import java.util.ArrayList;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Pessoa;

public interface IPessoaMongoDAO {
	public String salvar(Pessoa pessoa);
	public boolean remover(String id);
	public boolean atualizar(Pessoa pessoa);
	public ArrayList<Pessoa> listarTodos();
	public Pessoa listarPorId(String id);
}
