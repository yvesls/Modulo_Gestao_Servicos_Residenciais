/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yvesproject.servicoresidencial.atividadebanco_yves.DAO.conexao;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.connection.Connection;

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
			
		} catch (MongoException e) {
			Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, e);
		}
	}
}
