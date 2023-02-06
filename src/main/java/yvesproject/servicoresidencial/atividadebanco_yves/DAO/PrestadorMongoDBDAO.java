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
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.IPrestadorMongoDAO;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Pessoa;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Prestador;

/**
 *
 * @author Clínica Eng Software
 */
public class PrestadorMongoDBDAO extends DAOMongoDBConexao implements IPrestadorMongoDAO {

	public Object salvar(Prestador prestador, Pessoa pessoa) {
		try {
			conectar();
			MongoCollection<Document> coPrestador = mongoClient.getDatabase("mongodb").getCollection("prestador");
			Document documentPessoa = new Document("_id", pessoa.getIdPessoa());
			documentPessoa.append("nome", pessoa.getNome());
			documentPessoa.append("telefone", pessoa.getTelefone());
			Document document = new Document("cnpj", prestador.getCnpj());
			document.append("pessoa", documentPessoa);
			coPrestador.insertOne(document);
			return coPrestador.find(document).first().get("_id");
		} catch (MongoException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean remover() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean atualizar(Prestador prestador) {
		// TODO Auto-generated method stub
		return false;
	}
}
