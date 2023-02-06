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
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.IPessoaMongoDAO;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Pessoa;

/**
 *
 * @author Clínica Eng Software
 */
public class PessoaMongoDBDAO extends DAOMongoDBConexao implements IPessoaMongoDAO {

	public Object salvar(Pessoa pessoa) {
		try {
			conectar();
			MongoCollection<Document> coPessoa = mongoClient.getDatabase("mongodb").getCollection("pessoa");
			Document document = new Document("nome", pessoa.getNome());
			document.append("telefone", pessoa.getTelefone());
			coPessoa.insertOne(document);
			return coPessoa.find(document).first().get("_id");
		} catch (MongoException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean remover() {
		
		return false;
	}

	public boolean atualizar() {
		// TODO Auto-generated method stub
		return false;
	}

	public void buscar(int idPessoa) {
		// TODO Auto-generated method stub

	}

}
