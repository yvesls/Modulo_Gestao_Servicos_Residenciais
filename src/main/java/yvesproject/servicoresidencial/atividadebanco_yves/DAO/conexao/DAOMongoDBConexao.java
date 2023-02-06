/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yvesproject.servicoresidencial.atividadebanco_yves.DAO.conexao;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoSocketOpenException;

/**
 *
 * @author Clínica Eng Software
 */
public class DAOMongoDBConexao {
	protected MongoClientURI mClient;
	protected MongoClient mongoClient;

	protected void conectar() {
    	try {
			String url = "mongodb://localhost:27017";
			mClient = new MongoClientURI(url);
			mongoClient = new MongoClient(mClient);
			
		} catch (MongoSocketOpenException e) {
			e.printStackTrace();
		}
	}
}
