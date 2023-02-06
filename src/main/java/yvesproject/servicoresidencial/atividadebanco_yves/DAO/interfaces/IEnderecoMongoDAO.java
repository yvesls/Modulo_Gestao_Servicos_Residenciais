package yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces;

import java.util.ArrayList;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Endereco;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Pessoa;

public interface IEnderecoMongoDAO {
	public String salvar(Endereco endereco, Pessoa pessoa);
	public boolean remover(String id);
	public boolean atualizar(Endereco endereco, Pessoa pessoa);
	public ArrayList<Endereco> listarTodos();
}
