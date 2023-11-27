
package br.com.jovencio.marlan.factorymethoddotenv;

import br.com.jovencio.marlan.factorymethoddotenv.factories.daos.DAOFactory;
import br.com.jovencio.marlan.factorymethoddotenv.model.entity.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author marlan
 */
public class FactoryMethodDotEnv {

	public static void main( String[] args ) throws Exception {
		/*
		 * .env para SQLite:
		 *
		 * DATABASE="SQLite"
		 *
		 *
		 * ...
		 *
		 * .env para Postgres:
		 *
		 * DATABASE="postgres" jdbc_url="jdbc:postgresql://localhost:5432/{database}"
		 *
		 * jdbc_user="{username}"
		 *
		 * jdbc_password="{password}"
		 */

		Logger log = LoggerFactory.getLogger( FactoryMethodDotEnv.class );
		var inserted = DAOFactory.getDAOFactory().getUsuarioDAO().insert( new Usuario( "Marlan Tonoli Jovencio", "marlan.jovencio", "password" ) );
		log.info( "{\"inserted\":" + inserted + "}" );

		var geted = DAOFactory.getDAOFactory().getUsuarioDAO().get( inserted.getId() );
		log.info( "{\"geted\":" + geted + "}" );

		geted.setNome( "Novo Nome" );
		DAOFactory.getDAOFactory().getUsuarioDAO().update( geted );
		var updated = DAOFactory.getDAOFactory().getUsuarioDAO().get( geted.getId() );
		log.info( "{\"updated\":" + updated + "}" );

		DAOFactory.getDAOFactory().getUsuarioDAO().delete( updated.getId() );
	}
}
