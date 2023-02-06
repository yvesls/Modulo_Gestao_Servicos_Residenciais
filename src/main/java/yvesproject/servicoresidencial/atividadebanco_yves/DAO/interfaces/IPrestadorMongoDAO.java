package yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces;

import yvesproject.servicoresidencial.atividadebanco_yves.model.Pessoa;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Prestador;

public interface IPrestadorMongoDAO {
	public Object salvar(Prestador prestador, Pessoa pessoa);
}
