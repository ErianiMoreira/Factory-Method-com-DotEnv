
package br.com.jovencio.marlan.factorymethoddotenv.dao.conexoes.impl;

import br.com.jovencio.marlan.factorymethoddotenv.dao.conexoes.IBancoDadosConexao;
import io.github.cdimascio.dotenv.Dotenv;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author marlan
 */
public abstract class SQLiteConexao implements IBancoDadosConexao {

	private Logger log = LoggerFactory.getLogger( SQLiteConexao.class );

	@Override
	public Connection openConnection() throws SQLException {
		Dotenv env = Dotenv.load();
		String url = env.get( "jdbc_url" );
		if( url == null || url.isEmpty() || url.isBlank() ) {
			Path currentRelativePath = Paths.get( "" );
			String s = currentRelativePath.toAbsolutePath().toString();
			url = "jdbc:sqlite:" + s + "/src/main/resource/db/factory-method-dot-env.db";

		}

		log.info( "Driver Connected to '" + url + "'" );
		return null;
//		return DriverManager.getConnection( url );
	}

	@Override
	public void closeConnection( Connection connection ) throws SQLException {
		log.info( "Connection closed" );
//		connection.close();
	}

	protected long insert( String sql ) throws SQLException {
		log.info( sql );
		return 1l;
//		var con = openConnection();
//		var statement = con.createStatement();
//		statement.execute( sql );
//		var result = statement.executeQuery( "SELECT LAST_INSERT_ROWID()" );
//		var id = result.getInt( 1 );
//		closeConnection( con );
//		return id;
	}
}
