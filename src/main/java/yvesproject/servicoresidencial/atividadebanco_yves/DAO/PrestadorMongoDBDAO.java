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
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.IPrestadorMongoDAO;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Pessoa;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Prestador;

/**
 *
 * @author Clínica Eng Software
 */
public class PrestadorMongoDBDAO extends DAOMongoDBConexao implements IPrestadorMongoDAO {

	public String salvar(Prestador prestador, Pessoa pessoa) {
		try {
			conectar();
			MongoCollection<Document> coPrestador = mongoClient.getDatabase("mongodb").getCollection("prestador");
			Document documentPessoa = new Document("_id", pessoa.getIdPessoa());
			documentPessoa.append("nome", pessoa.getNome());
			documentPessoa.append("telefone", pessoa.getTelefone());
			Document document = new Document("cnpj", prestador.getCnpj());
			document.append("pessoa", documentPessoa);
			coPrestador.insertOne(document);
			return coPrestador.find(document).first().get("_id").toString();
		}catch(MongoException e) {
			Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, e);
			return null;
		}
	}

	public boolean remover(String id) {
		conectar();
		try {

			MongoCollection<Document> coPrestador = mongoClient.getDatabase("mongodb").getCollection("prestador");
			coPrestador.deleteOne(Filters.eq("_id", new ObjectId(id)));
			return true;
		} catch (MongoException e) {
			Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, e);
			return false;
		}
	}

	public boolean atualizar(Prestador prestador, Pessoa pessoa) {
		conectar();
		try {
			MongoCollection<Document> coPrestador = mongoClient.getDatabase("mongodb").getCollection("prestador");

			Document filter = new Document("_id", new ObjectId(prestador.getIdPrestador()));
			Document documentPessoa = new Document();
			documentPessoa.append("nome", pessoa.getNome());
			documentPessoa.append("telefone", pessoa.getTelefone());
			Document document = new Document("cnpj", prestador.getCnpj());
			document.append("pessoa", documentPessoa);
			Bson update = new Document("$set", document);
			coPrestador.updateMany(filter, update);
			return true;
		} catch (MongoException e) {
			Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, e);
			return false;
		}
	}

	public ArrayList<Prestador> listarTodos() {
		ArrayList<Prestador> list = new ArrayList<Prestador>();
		Prestador prestador = null;
		Document doc = null;
		Document docInterno = null;

		conectar();
		MongoCollection<Document> coPrestador = mongoClient.getDatabase("mongodb").getCollection("prestador");
		MongoCursor<Document> cursor = coPrestador.find().iterator();

		try {
			while (cursor.hasNext()) {
				doc = cursor.next();
				docInterno = (Document) doc.get("pessoa");

				prestador = new Prestador((String) doc.get("_id"), (String) doc.get("cnpj"),
						(String) docInterno.get("_id"));
				list.add(prestador);
			}
		} finally {
			cursor.close();
		}
		return list;
	}
	
	public ArrayList<Prestador> listarPorNome(String nome) {
		ArrayList<Prestador> list = new ArrayList<Prestador>();
		Prestador prestador = null;
		Document doc = null;
		Document docInterno = null;

		conectar();
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("nome", nome);
		MongoCollection<Document> coPrestador = mongoClient.getDatabase("mongodb").getCollection("prestador");
		MongoCursor<Document> cursor = coPrestador.find(searchQuery).iterator();

		try {
			while (cursor.hasNext()) {
				doc = cursor.next();
				docInterno = (Document) doc.get("pessoa");

				prestador = new Prestador((String) doc.get("_id"), (String) doc.get("cnpj"),
						(String) docInterno.get("_id"));
				list.add(prestador);
			}
		} finally {
			cursor.close();
		}
		return list;
	}
	
	public Prestador listarPorId(String id) {
		Prestador prestador = null;
		Document doc = null;
		Document docInterno = null;

		conectar();
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("_id",new ObjectId(id));
		MongoCollection<Document> coPrestador = mongoClient.getDatabase("mongodb").getCollection("prestador");
		MongoCursor<Document> cursor = coPrestador.find(searchQuery).iterator();

		try {
			while (cursor.hasNext()) {
				doc = cursor.next();
				docInterno = (Document) doc.get("pessoa");

				prestador = new Prestador((String) doc.get("_id"), (String) doc.get("cnpj"),
						(String) docInterno.get("_id"));
			}
		} finally {
			cursor.close();
		}
		return prestador;
	}
}
