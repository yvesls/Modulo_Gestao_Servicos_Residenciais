/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yvesproject.servicoresidencial.atividadebanco_yves.DAO;

import org.bson.Document;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;

import yvesproject.servicoresidencial.atividadebanco_yves.DAO.conexao.DAOMongoDBConexao;
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.IServicoMongoDAO;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Cliente;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Prestador;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Servico;

/**
 *
 * @author Clínica Eng Software
 */
public class ServicoMongoDBDAO extends DAOMongoDBConexao implements IServicoMongoDAO {

	public String salvar(Servico servico, Cliente cliente, Prestador prestador) {
		try {
			conectar();
			MongoCollection<Document> coPrestador = mongoClient.getDatabase("mongodb").getCollection("servico");
			Document documentCliente = new Document("_id", cliente.getIdCliente());
			documentCliente.append("cpf", cliente.getCpf());
			Document documentPrestador = new Document("_id", prestador.getIdPrestador());
			documentPrestador.append("cnpj", prestador.getCnpj());
			Document document = new Document("descricao", servico.getDescricao());
			document.append("valor", servico.getValor());
			document.append("cliente", documentCliente);
			document.append("prestador", documentPrestador);
			document.append("data", servico.getData());
			coPrestador.insertOne(document);
			return coPrestador.find(document).first().get("_id").toString();
		} catch (MongoException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean remover() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean atualizar() {
		// TODO Auto-generated method stub
		return false;
	}

	public void buscar(int idServico) {
		// TODO Auto-generated method stub
		
	}

    
}
