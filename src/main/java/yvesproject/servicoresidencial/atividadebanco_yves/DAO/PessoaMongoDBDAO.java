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
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.IPessoaMongoDAO;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Pessoa;

/**
 *
 * @author Clínica Eng Software
 */
public class PessoaMongoDBDAO extends DAOMongoDBConexao implements IPessoaMongoDAO {

	public String salvar(Pessoa pessoa) {
		try {
			conectar();
			MongoCollection<Document> coPessoa = mongoClient.getDatabase("mongodb").getCollection("pessoa");
			Document document = new Document("nome", pessoa.getNome());
			document.append("telefone", pessoa.getTelefone());
			coPessoa.insertOne(document);

			return (String) coPessoa.find(document).first().get("_id");
		} catch (MongoException e) {
			Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, e);
			return null;
		}
	}

	public boolean remover(String id) {
		conectar();
		try {
			MongoCollection<Document> coPessoa = mongoClient.getDatabase("mongodb").getCollection("pessoa");
			coPessoa.deleteOne(Filters.eq("_id", new ObjectId(id)));
			return true;
		} catch (MongoException e) {
			Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, e);
			return false;
		}
	}

	public boolean atualizar(Pessoa pessoa) {
		conectar();
		try {
			MongoCollection<Document> coPessoa = mongoClient.getDatabase("mongodb").getCollection("pessoa");

			Document filter = new Document("_id", new ObjectId(pessoa.getIdPessoa()));
			Document documentPessoa = new Document();
			documentPessoa.append("nome", pessoa.getNome());
			documentPessoa.append("telefone", pessoa.getTelefone());
			Bson update = new Document("$set", documentPessoa);
			coPessoa.updateMany(filter, update);
			return true;
		} catch (MongoException e) {
			Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, e);
			return false;
		}
	}

	public ArrayList<Pessoa> listarTodos() {
		ArrayList<Pessoa> list = new ArrayList<Pessoa>();
		Pessoa pessoa = null;
		Document doc = null;

		conectar();
		MongoCollection<Document> coPessoa = mongoClient.getDatabase("mongodb").getCollection("pessoa");
		MongoCursor<Document> cursor = coPessoa.find().iterator();

		try {
			while (cursor.hasNext()) {
				doc = cursor.next();

				pessoa = new Pessoa((String) doc.get("_id"), (String) doc.get("nome"),
						(String) doc.get("telefone"));
				list.add(pessoa);
			}
		} finally {
			cursor.close();
		}
		return list;
	}
	
	public Pessoa listarPorId(String id) {
		Pessoa pessoa = null;
		Document doc = null;

		conectar();
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("_id",new ObjectId(id));
		MongoCollection<Document> coPessoa = mongoClient.getDatabase("mongodb").getCollection("pessoa");
		MongoCursor<Document> cursor = coPessoa.find(searchQuery).iterator();

		try {
			while (cursor.hasNext()) {
				doc = cursor.next();

				pessoa = new Pessoa((String) doc.get("_id"), (String) doc.get("nome"),
						(String) doc.get("telefone"));
			}
		} finally {
			cursor.close();
		}
		return pessoa;
	}
}
