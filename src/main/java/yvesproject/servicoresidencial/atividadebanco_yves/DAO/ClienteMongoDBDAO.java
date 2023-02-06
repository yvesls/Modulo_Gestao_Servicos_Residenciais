/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yvesproject.servicoresidencial.atividadebanco_yves.DAO;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.connection.Connection;

import yvesproject.servicoresidencial.atividadebanco_yves.DAO.conexao.DAOMongoDBConexao;
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.IClienteMongoDAO;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Cliente;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Pessoa;

/**
 *
 * @author Clínica Eng Software
 */
public class ClienteMongoDBDAO extends DAOMongoDBConexao implements IClienteMongoDAO {

	public String salvar(Cliente cliente, Pessoa pessoa) {
		try {
			conectar();
			MongoCollection<Document> coCliente = mongoClient.getDatabase("mongodb").getCollection("cliente");
			Document documentPessoa = new Document("_id", pessoa.getIdPessoa());
			documentPessoa.append("nome", pessoa.getNome());
			documentPessoa.append("telefone", pessoa.getTelefone());
			Document document = new Document("cpf", cliente.getCpf());
			document.append("pessoa", documentPessoa);
			coCliente.insertOne(document);
			return coCliente.find(document).first().get("_id").toString();
		} catch (MongoException e) {
			Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, e);
			return null;
		}
	}

	public boolean remover(String id) {
		conectar();
		try {
			MongoCollection<Document> coCliente = mongoClient.getDatabase("mongodb").getCollection("cliente");
			coCliente.deleteOne(Filters.eq("_id", new ObjectId(id)));
			return true;
		} catch (MongoException e) {
			Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, e);
			return false;
		}
	}

	public boolean atualizar(Cliente cliente, Pessoa pessoa) {
		conectar();
		try {
			MongoCollection<Document> coCliente = mongoClient.getDatabase("mongodb").getCollection("cliente");

			Document filter = new Document("_id", new ObjectId(cliente.getIdCliente()));
			Document documentPessoa = new Document();
			documentPessoa.append("nome", pessoa.getNome());
			documentPessoa.append("telefone", pessoa.getTelefone());
			Document document = new Document("cnpj", cliente.getCpf());
			document.append("pessoa", documentPessoa);
			Bson update = new Document("$set", document);
			coCliente.updateMany(filter, update);
			return true;
		} catch (MongoException e) {
			Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, e);
			return false;
		}
	}
	
	public ArrayList<Cliente> listarTodos() {
		ArrayList<Cliente> list = new ArrayList<Cliente>();
		Cliente cliente = null;
		Document doc = null;
		Document docInterno = null;

		conectar();
		MongoCollection<Document> coCliente = mongoClient.getDatabase("mongodb").getCollection("cliente");
		MongoCursor<Document> cursor = coCliente.find().iterator();

		try {
			while (cursor.hasNext()) {
				doc = cursor.next();
				docInterno = (Document) doc.get("pessoa");

				cliente = new Cliente((String) doc.get("_id"), (String) doc.get("cpf"),
						(String) docInterno.get("_id"));
				list.add(cliente);
			}
		} finally {
			cursor.close();
		}
		return list;
	}
	
	public ArrayList<Cliente> listarPorNome(String nome) {
		ArrayList<Cliente> list = new ArrayList<Cliente>();
		Cliente cliente = null;
		Document doc = null;
		Document docInterno = null;

		conectar();
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("nome", nome);
		MongoCollection<Document> coCliente = mongoClient.getDatabase("mongodb").getCollection("cliente");
		MongoCursor<Document> cursor = coCliente.find(searchQuery).iterator();

		try {
			while (cursor.hasNext()) {
				doc = cursor.next();
				docInterno = (Document) doc.get("pessoa");

				cliente = new Cliente((String) doc.get("_id"), (String) doc.get("cpf"),
						(String) docInterno.get("_id"));
				list.add(cliente);
			}
		} finally {
			cursor.close();
		}
		return list;
	}
	
	public Cliente listarPorId(String id) {
		Cliente cliente = null;
		Document doc = null;
		Document docInterno = null;

		conectar();
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("_id", new ObjectId(id));
		MongoCollection<Document> coCliente = mongoClient.getDatabase("mongodb").getCollection("cliente");
		MongoCursor<Document> cursor = coCliente.find(searchQuery).iterator();

		try {
			while (cursor.hasNext()) {
				doc = cursor.next();
				docInterno = (Document) doc.get("pessoa");

				cliente = new Cliente((String) doc.get("_id"), (String) doc.get("cpf"), (String) docInterno.get("_id"));
			}
		} finally {
			cursor.close();
		}
		return cliente;
	}
}
