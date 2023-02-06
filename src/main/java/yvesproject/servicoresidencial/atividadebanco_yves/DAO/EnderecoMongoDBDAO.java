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

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.connection.Connection;

import yvesproject.servicoresidencial.atividadebanco_yves.DAO.conexao.DAOMongoDBConexao;
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.IEnderecoMongoDAO;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Endereco;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Pessoa;

/**
 *
 * @author Clínica Eng Software
 */
public class EnderecoMongoDBDAO extends DAOMongoDBConexao implements IEnderecoMongoDAO {

	public String salvar(Endereco endereco, Pessoa pessoa) {
		try {
			conectar();
			MongoCollection<Document> coEndereco = mongoClient.getDatabase("mongodb").getCollection("endereco");
			Document documentPessoa = new Document("_id", pessoa.getIdPessoa());
			documentPessoa.append("nome", pessoa.getNome());
			documentPessoa.append("telefone", pessoa.getTelefone());
			Document document = new Document("pessoa", documentPessoa);
			document.append("logradouro", endereco.getLogradouro());
			document.append("cep", endereco.getCep());
			document.append("numero", endereco.getNumero());
			document.append("bairro", endereco.getBairro());
			document.append("cidade", endereco.getCidade());
			document.append("estado", endereco.getEstado());
			coEndereco.insertOne(document);
			return coEndereco.find(document).first().get("_id").toString();
		} catch (MongoException e) {
			Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, e);
			return null;
		}
	}

	public boolean remover(String id) {
		conectar();
		try {
			MongoCollection<Document> coEndereco = mongoClient.getDatabase("mongodb").getCollection("endereco");
			coEndereco.deleteOne(Filters.eq("_id", new ObjectId(id)));
			return true;
		} catch (MongoException e) {
			Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, e);
			return false;
		}
	}

	public boolean atualizar(Endereco endereco, Pessoa pessoa) {
		conectar();
		try {
			MongoCollection<Document> coEndereco = mongoClient.getDatabase("mongodb").getCollection("endereco");

			Document filter = new Document("_id", new ObjectId(endereco.getIdEndereco()));
			Document documentPessoa = new Document();
			documentPessoa.append("nome", pessoa.getNome());
			documentPessoa.append("telefone", pessoa.getTelefone());
			Document document = new Document("pessoa", documentPessoa);
			document.append("logradouro", endereco.getLogradouro());
			document.append("cep", endereco.getCep());
			document.append("numero", endereco.getNumero());
			document.append("bairro", endereco.getBairro());
			document.append("cidade", endereco.getCidade());
			document.append("estado", endereco.getEstado());
			Bson update = new Document("$set", document);
			coEndereco.updateMany(filter, update);
			return true;
		} catch (MongoException e) {
			Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, e);
			return false;
		}
	}

	public ArrayList<Endereco> listarTodos() {
		ArrayList<Endereco> list = new ArrayList<Endereco>();
		Endereco endereco = null;
		Document doc = null;
		Document docInterno = null;

		conectar();
		MongoCollection<Document> coEndereco = mongoClient.getDatabase("mongodb").getCollection("endereco");
		MongoCursor<Document> cursor = coEndereco.find().iterator();

		try {
			while (cursor.hasNext()) {
				doc = cursor.next();
				docInterno = (Document) doc.get("pessoa");

				endereco = new Endereco((String) doc.get("_id"),(String) docInterno.get("_id"), (String) doc.get("logradouro"),
						(int) doc.get("cep"),(int) doc.get("numero"), (String) doc.get("bairro"),(String) doc.get("cidade"),
						(String) doc.get("estado"));
				list.add(endereco);
			}
		} finally {
			cursor.close();
		}
		return list;
	}
}
