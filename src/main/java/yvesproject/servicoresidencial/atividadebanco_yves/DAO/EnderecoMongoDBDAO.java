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
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean remover(Endereco endereco) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean atualizar(Endereco endereco) {
		// TODO Auto-generated method stub
		return false;
	}

	public Endereco buscar(Endereco endereco) {
		// TODO Auto-generated method stub
		return null;
	}
}
