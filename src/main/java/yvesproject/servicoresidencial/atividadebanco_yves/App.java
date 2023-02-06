package yvesproject.servicoresidencial.atividadebanco_yves;

import yvesproject.servicoresidencial.atividadebanco_yves.DAO.DAOMongoDBFactory;
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.DAOAbstractFactory;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Pessoa;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Prestador;

public class App {
    
    public static void main(String[] args) {
    	
    	DAOAbstractFactory factory = new DAOMongoDBFactory();
    	Object result = factory.getPrestadorMongoDAO().salvar(new Prestador("12309349302"), new Pessoa("63e05e3422dffe182cf87d71" ,"Jeremilson Martins", "29392019203"));
    	System.out.println(result);
    }
}
