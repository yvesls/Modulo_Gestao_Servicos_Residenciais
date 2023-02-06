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
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.IClienteMongoDAO;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Cliente;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Pessoa;

/**
 *
 * @author Clínica Eng Software
 */
public class ClienteMongoDBDAO extends DAOMongoDBConexao implements IClienteMongoDAO {

    public Object salvar(Cliente cliente, Pessoa pessoa) {
    	try {
			conectar();
			MongoCollection<Document> coCliente = mongoClient.getDatabase("mongodb").getCollection("cliente");
			Document documentPessoa = new Document("_id", pessoa.getIdPessoa());
			documentPessoa.append("nome", pessoa.getNome());
			documentPessoa.append("telefone", pessoa.getTelefone());
			Document document = new Document("cpf", cliente.getCpf());
			document.append("pessoa", documentPessoa);
			coCliente.insertOne(document);
			return coCliente.find(document).first().get("_id");
		} catch (MongoException e) {
			e.printStackTrace();
			return null;
		}
    }

    public boolean remover(int idCliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean atualizar(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
