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
import yvesproject.servicoresidencial.atividadebanco_yves.DAO.interfaces.IServicoMongoDAO;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Cliente;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Endereco;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Pessoa;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Prestador;
import yvesproject.servicoresidencial.atividadebanco_yves.model.Servico;

/**
 *
 * @author Clínica Eng Software
 */
public class ServicoMongoDBDAO extends DAOMongoDBConexao implements IServicoMongoDAO {

	public String salvar(Servico servico, Cliente cliente, Prestador prestador, Pessoa pessoaCliente,
			Pessoa pessoaPrestador) {
		try {
			conectar();
			MongoCollection<Document> coServico = mongoClient.getDatabase("mongodb").getCollection("servico");
			Document documentPessoaCliente = new Document("_id", pessoaCliente.getIdPessoa());
			documentPessoaCliente.append("nome", pessoaCliente.getNome());
			documentPessoaCliente.append("telefone", pessoaCliente.getTelefone());
			Document documentPessoaPrestador = new Document("_id", pessoaPrestador.getIdPessoa());
			documentPessoaPrestador.append("nome", pessoaPrestador.getNome());
			documentPessoaPrestador.append("telefone", pessoaPrestador.getTelefone());
			Document documentCliente = new Document("_id", cliente.getIdCliente());
			documentCliente.append("cpf", cliente.getCpf());
			documentCliente.append("pessoa", documentPessoaCliente);
			Document documentPrestador = new Document("_id", prestador.getIdPrestador());
			documentPrestador.append("cnpj", prestador.getCnpj());
			documentPrestador.append("pessoa", documentPessoaPrestador);
			Document document = new Document("descricao", servico.getDescricao());
			document.append("valor", servico.getValor());
			document.append("cliente", documentCliente);
			document.append("prestador", documentPrestador);
			document.append("data", servico.getData());
			coServico.insertOne(document);
			return coServico.find(document).first().get("_id").toString();
		} catch (MongoException e) {
			Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, e);
			return null;
		}
	}

	public boolean remover(String id) {
		conectar();
		try {
			MongoCollection<Document> coServico = mongoClient.getDatabase("mongodb").getCollection("servico");
			coServico.deleteOne(Filters.eq("_id", new ObjectId(id)));
			return true;
		} catch (MongoException e) {
			Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, e);
			return false;
		}
	}

	public boolean atualizar(Servico servico, Cliente cliente, Prestador prestador, Pessoa pessoaCliente,
			Pessoa pessoaPrestador) {
		conectar();

		try {
			MongoCollection<Document> coServico = mongoClient.getDatabase("mongodb").getCollection("servico");
			Document filter = new Document("_id", new ObjectId(servico.getIdServico()));
			Document documentPessoaCliente = new Document("_id", pessoaCliente.getIdPessoa());
			documentPessoaCliente.append("nome", pessoaCliente.getNome());
			documentPessoaCliente.append("telefone", pessoaCliente.getTelefone());
			Document documentPessoaPrestador = new Document("_id", pessoaPrestador.getIdPessoa());
			documentPessoaPrestador.append("nome", pessoaPrestador.getNome());
			documentPessoaPrestador.append("telefone", pessoaPrestador.getTelefone());
			Document documentCliente = new Document("_id", cliente.getIdCliente());
			documentCliente.append("cpf", cliente.getCpf());
			documentCliente.append("pessoa", documentPessoaCliente);
			Document documentPrestador = new Document("_id", prestador.getIdPrestador());
			documentPrestador.append("cnpj", prestador.getCnpj());
			documentPrestador.append("pessoa", documentPessoaPrestador);
			Document document = new Document("descricao", servico.getDescricao());
			document.append("valor", servico.getValor());
			document.append("cliente", documentCliente);
			document.append("prestador", documentPrestador);
			document.append("data", servico.getData());
			Bson update = new Document("$set", document);
			coServico.updateMany(filter, update);
			return true;
		} catch (MongoException e) {
			Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, e);
			return false;
		}
	}

	public ArrayList<Servico> listarTodos() {
		ArrayList<Servico> list = new ArrayList<Servico>();
		Servico servico = null;
		Document doc = null;
		Document docInternoCliente = null;
		Document docInternoPrestador = null;
		Document docInternoPessoaCliente = null;
		Document docInterPessoaPrestador = null;

		conectar();
		MongoCollection<Document> coServico = mongoClient.getDatabase("mongodb").getCollection("servico");
		MongoCursor<Document> cursor = coServico.find().iterator();

		try {
			while (cursor.hasNext()) {
				doc = cursor.next();
				docInternoCliente = (Document) doc.get("cliente");
				docInternoPrestador = (Document) doc.get("prestador");
				docInternoPessoaCliente = (Document) docInternoCliente.get("pessoa");
				docInterPessoaPrestador = (Document) docInternoPrestador.get("pessoa");
				servico = new Servico((String) doc.get("_id"), (String) doc.get("descricao"), (double) doc.get("valor"),
						(String) docInternoCliente.get("_id"), (String) docInternoPrestador.get("_id"),
						(String) doc.get("data"), (String) docInternoPessoaCliente.get("_id"),
						(String) docInterPessoaPrestador.get("_id"));
				list.add(servico);
			}
		} finally {
			cursor.close();
		}
		return list;
	}

	public ArrayList<Servico> listarPorBairro(String bairro) {
		ArrayList<Servico> list = new ArrayList<Servico>();
		ArrayList<Endereco> listEndereco = new ArrayList<Endereco>();
		Servico servico = null;
		Endereco endereco = null;
		Document doc = null;
		Document docInterno = null;
		Document docInternoCliente = null;
		Document docInternoPrestador = null;
		Document docInternoPessoaCliente = null;
		Document docInterPessoaPrestador = null;

		conectar();
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("bairro", bairro);
		MongoCollection<Document> coEndereco = mongoClient.getDatabase("mongodb").getCollection("endereco");
		MongoCursor<Document> cursorEndereco = coEndereco.find(searchQuery).iterator();

		try {
			while (cursorEndereco.hasNext()) {
				doc = cursorEndereco.next();
				docInterno = (Document) doc.get("pessoa");

				endereco = new Endereco((String) doc.get("_id"), (String) docInterno.get("_id"),
						(String) doc.get("logradouro"), (int) doc.get("cep"), (int) doc.get("numero"),
						(String) doc.get("bairro"), (String) doc.get("cidade"), (String) doc.get("estado"));
				listEndereco.add(endereco);
			}
		} finally {
			cursorEndereco.close();
		}

		MongoCollection<Document> coServico = mongoClient.getDatabase("mongodb").getCollection("cliente");
		MongoCursor<Document> cursorServico = coServico.find().iterator();
		int i = 0;
		try {
			while (cursorServico.hasNext()) {
				doc = cursorServico.next();
				docInternoCliente = (Document) doc.get("cliente");
				docInternoPrestador = (Document) doc.get("prestador");
				docInternoPessoaCliente = (Document) docInternoCliente.get("pessoa");
				docInterPessoaPrestador = (Document) docInternoPrestador.get("pessoa");
				i++;
				if (listEndereco.get(i).getIdPessoa().equals((String) docInternoPessoaCliente.get("_id"))) {
					servico = new Servico((String) doc.get("_id"), (String) doc.get("descricao"),
							(double) doc.get("valor"), (String) docInternoCliente.get("_id"),
							(String) docInternoPrestador.get("_id"), (String) doc.get("data"),
							(String) docInternoPessoaCliente.get("_id"), (String) docInterPessoaPrestador.get("_id"));
					list.add(servico);
				}
			}
		} finally {
			cursorServico.close();
		}
		return list;
	}
	
	public ArrayList<Servico> listarPorMesAtual(String mesAnoAtual) {
		ArrayList<Servico> list = new ArrayList<Servico>();
		Servico servico = null;
		Document doc = null;
		Document docInternoCliente = null;
		Document docInternoPrestador = null;
		Document docInternoPessoaCliente = null;
		Document docInterPessoaPrestador = null;
		String[] mesAno = getMesAno(mesAnoAtual).split(" ");
		String mesAtual = mesAno[0];
		String anoAtual = mesAno[1];
		conectar();
		MongoCollection<Document> coServico = mongoClient.getDatabase("mongodb").getCollection("servico");
		MongoCursor<Document> cursor = coServico.find().iterator();

		try {
			while (cursor.hasNext()) {
				doc = cursor.next();
				docInternoCliente = (Document) doc.get("cliente");
				docInternoPrestador = (Document) doc.get("prestador");
				docInternoPessoaCliente = (Document) docInternoCliente.get("pessoa");
				docInterPessoaPrestador = (Document) docInternoPrestador.get("pessoa");
				String dataServico = (String) doc.get("data");
				String[] mesAnoServico = getMesAno(dataServico).split(" ");
				String mesServico = mesAnoServico[0];
				String anoServico = mesAnoServico[1];
				if(mesAtual.equals(mesServico) && anoAtual.equals(anoServico)) {
					servico = new Servico((String) doc.get("_id"), (String) doc.get("descricao"), (double) doc.get("valor"),
							(String) docInternoCliente.get("_id"), (String) docInternoPrestador.get("_id"),
							(String) doc.get("data"), (String) docInternoPessoaCliente.get("_id"),
							(String) docInterPessoaPrestador.get("_id"));
					list.add(servico);
				}
			}
		} finally {
			cursor.close();
		}
		
		return list;
	}
	
	private String getMesAno(String data) {
		String[] dts;
    	dts = data.split("/");
    	String mes = dts[1];
    	dts = dts[2].split(" ");
    	String ano = dts[0];
    	return mes + " " + ano;
	}
}
