package yvesproject.servicoresidencial.atividadebanco_yves;

import yvesproject.servicoresidencial.atividadebanco_yves.DAO.DAOMySQLFactory;
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.DAOSingleton;
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.DAOAbstractFactory;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Cliente;

public class App {

	public static void main(String[] args) {

		DAOAbstractFactory factory = new DAOMySQLFactory();
		DAOSingleton.configurarSingleton(factory);
		
		//testando mongo
		// String result = factory.getPrestadorMongoDAO().salvar(new
		// Prestador("12309349302"), new Pessoa("63e05e3422dffe182cf87d71" ,"Jeremilson
		// Martins", "29392019203"));
		// System.out.println(result);
		// factory.getPrestadorMongoDAO().atualizar(new
		// Prestador("63e10c614bad902d246f5dd3", "11111777302"), new Pessoa("Jeremilson
		// Aurélio", "29392019203"));
		// factory.getPrestadorMongoDAO().remover("63e10c424bad904afc238838");

		// teste servico sql
		// ArrayList<Servico> servs =
		// DAOSingleton.getInstance().getServicoMySQLDAO().listarPorMesAtual("15/02/2023");
		// ArrayList<Servico> servs =
		// DAOSingleton.getInstance().getServicoMySQLDAO().listarPorBairro("Moema");
		// ArrayList<Servico> servs =
		// DAOSingleton.getInstance().getServicoMySQLDAO().listarTodos();
		// Servico serv =
		// DAOSingleton.getInstance().getServicoMySQLDAO().listarPorId("1");
		// int idNovo = DAOSingleton.getInstance().getServicoMySQLDAO().salvar(new
		// Servico("Reparo na pintura", 1555.0, "2", "46"));
		// DAOSingleton.getInstance().getServicoMySQLDAO().remover("33");
		// DAOSingleton.getInstance().getServicoMySQLDAO().atualizar(new
		// Servico("2","Lavagem de janelas e Reparo na pintura", 500, "2", "59"));

		// for(Servico serv : servs) { System.out.println(serv.toString());}
		// System.out.println(serv.toString());
		// System.out.println(idNovo);

		// teste prestador sql
		// int idNovo = DAOSingleton.getInstance().getPrestadorMySQLDAO().salvar(new
		// Prestador("2", "77.222.265/0001-14"));
		// DAOSingleton.getInstance().getPrestadorMySQLDAO().remover("2");
		// DAOSingleton.getInstance().getPrestadorMySQLDAO().atualizar(new
		// Prestador("31", "02.383.270/0001-90"));
		// Prestador serv =
		// DAOSingleton.getInstance().getPrestadorMySQLDAO().listarPorId("35");
		// ArrayList<Prestador> servs =
		// DAOSingleton.getInstance().getPrestadorMySQLDAO().listarTodos();

		// for(Prestador serv : servs) { System.out.println(serv.toString());}
		// System.out.println(serv.toString());
		// System.out.println(idNovo);

		// teste pessoa sql
		// int idNovo = DAOSingleton.getInstance().getPessoaMySQLDAO().salvar(new
		// Pessoa("Firimino Roberto", "(761) 562-8067"));
		// DAOSingleton.getInstance().getPessoaMySQLDAO().remover("61");
		// DAOSingleton.getInstance().getPessoaMySQLDAO().atualizar(new Pessoa("56",
		// "Roberto Firimino", "(761) 562-8067"));
		// Pessoa serv =
		// DAOSingleton.getInstance().getPessoaMySQLDAO().listarPorId("35");
		// ArrayList<Pessoa> servs =
		// DAOSingleton.getInstance().getPessoaMySQLDAO().listarPorNome("Jo");
		// ArrayList<Pessoa> servs =
		// DAOSingleton.getInstance().getPessoaMySQLDAO().listarTodos();

		// for(Pessoa serv : servs) { System.out.println(serv.toString());}
		// System.out.println(serv.toString());
		// System.out.println(idNovo);

		// teste endereco sql
		// int idNovo = DAOSingleton.getInstance().getEnderecoMySQLDAO().salvar(new
		// Endereco("2","Rua 2", 29200200, 6, "Alto Universitário", "Alegre", "Espírito
		// Santo"));
		// DAOSingleton.getInstance().getEnderecoMySQLDAO().atualizar(new
		// Endereco("31", "2","Rua 2", 29200200, 6, "Alto Universitário", "Alegre",
		// "ES"));
		// DAOSingleton.getInstance().getEnderecoMySQLDAO().remover(new Endereco("33",
		// "2"));
		// Endereco servr =
		// DAOSingleton.getInstance().getEnderecoMySQLDAO().listarPorId(new
		// Endereco("1", "1"));
		//ArrayList<Endereco> servs = DAOSingleton.getInstance().getEnderecoMySQLDAO().listarTodos();

		//for(Endereco serv : servs) { System.out.println(serv.toString());}
		// sSystem.out.println(servr.toString());
		// System.out.println(idNovo);
		
		// teste cliente sql
		//int idNovo = DAOSingleton.getInstance().getClienteMySQLDAO().salvar(new Cliente("33", "15182334443"));
		//DAOSingleton.getInstance().getClienteMySQLDAO().remover("33");
		//DAOSingleton.getInstance().getClienteMySQLDAO().atualizar(new Cliente("31", "15182399443"));
		//Cliente serv = DAOSingleton.getInstance().getClienteMySQLDAO().listarPorId("25");
		//ArrayList<Cliente> servs = DAOSingleton.getInstance().getClienteMySQLDAO().listarTodos();
		
		//for(Cliente serv : servs) { System.out.println(serv.toString());}
		//System.out.println(serv.toString());
		//System.out.println(idNovo);
		
	}
}
