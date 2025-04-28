package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexao {
	private static final String ARQUIVO_DB_PROPERTIES = "/db.properties";
	
	public static Connection getConexao() throws IOException, SQLException {
		Properties properties = new Properties();
		
		String url, senha, usuario;
		
		
		try(InputStream input = Conexao.class.getResourceAsStream(ARQUIVO_DB_PROPERTIES)){
			if(input == null) {
				throw new IOException("Arquivo de configuração não encontrado");
			}
			properties.load(input);
		}
		
		url = properties.getProperty("db.url");
		usuario = properties.getProperty("db.usuario");
		senha = properties.getProperty("db.senha");
		
		return DriverManager.getConnection(url, usuario, senha);
	}

}
