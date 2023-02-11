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

import io.github.cdimascio.dotenv.Dotenv;

/**
 *
 * @author Clínica Eng Software
 */
public class DAOMongoDBConexao {
	protected MongoClientURI mClient;
	protected MongoClient mongoClient;

	protected void conectar() {
		Dotenv dotenv = Dotenv.load();
        String url = dotenv.get("CAMINHO_BANCO_DADOS_MONGODB");
        if(url == null){
            url = ("CAMINHO_BANCO_DADOS_MONGODB");
        }
    	try {
			mClient = new MongoClientURI(url);
			mongoClient = new MongoClient(mClient);
			
		} catch (MongoException e) {
			Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, e);
		}
	}
}
