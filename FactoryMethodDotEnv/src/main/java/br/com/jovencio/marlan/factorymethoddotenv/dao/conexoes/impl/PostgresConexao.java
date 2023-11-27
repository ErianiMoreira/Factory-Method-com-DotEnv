
package br.com.jovencio.marlan.factorymethoddotenv.dao.conexoes.impl;

import br.com.jovencio.marlan.factorymethoddotenv.dao.conexoes.IBancoDadosConexao;
import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author marlan
 */
public class PostgresConexao implements IBancoDadosConexao {

	private Logger log = LoggerFactory.getLogger( PostgresConexao.class );

	@Override
	public Connection openConnection() throws SQLException {
		Dotenv env = Dotenv.load();
		String url = env.get( "jdbc_url", "jdbc:postgresql://localhost:5432/factory-method-dotenv-db" );

		Properties props = new Properties();
		if( url.contains( "?" ) ) {
			var startOfParams = url.lastIndexOf( "?" );
			var paramsString = url.substring( startOfParams );

			while( paramsString.contains( "=" ) ) {
				String key, value;
				var indexOfEqual = paramsString.indexOf( "=" );
				key = paramsString.substring( 0, indexOfEqual );
				paramsString = paramsString.replace( key + "=", "" );
				if( paramsString.contains( "&" ) ) {
					var indexOfAnd = paramsString.indexOf( "&" );
					value = paramsString.substring( 0, indexOfAnd );
					paramsString = paramsString.replace( value + "&", "" );
				} else {
					value = paramsString;
				}
				props.setProperty( key, value );
			}
		} else {
			props.setProperty( "user", env.get( "jdbc_user", "app" ) );
			props.setProperty( "password", env.get( "jdbc_password", "mtj.123" ) );
			props.setProperty( "ssl", env.get( "jdbc_ssl", "false" ) );
		}

		log.info( "Driver Connected to '" + url + "'" );
		return null;
//		return DriverManager.getConnection( url );
	}

	@Override
	public void closeConnection( Connection connection ) throws Exception {
		log.info( "Connection closed" );
//		connection.close();
	}

	protected long insert( String sql ) throws SQLException {
		log.info( sql );
		return 1l;
//		var con = openConnection();
//		var statement = con.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );
//		statement.executeUpdate();
//		Long id = null;
//		try ( ResultSet generatedKeys = statement.getGeneratedKeys() ) {
//			if( generatedKeys.next() ) {
//				id = generatedKeys.getLong( 1 );
//			} else {
//				throw new SQLException( "Creating user failed, no ID obtained." );
//			}
//		}
//
//		return id;
	}
}
