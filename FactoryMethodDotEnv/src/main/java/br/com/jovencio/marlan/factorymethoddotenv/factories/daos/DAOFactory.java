
package br.com.jovencio.marlan.factorymethoddotenv.factories.daos;

import br.com.jovencio.marlan.factorymethoddotenv.dao.usuario.IUsuarioDAO;
import br.com.jovencio.marlan.factorymethoddotenv.factories.daos.impl.PostgresDAOFactory;
import br.com.jovencio.marlan.factorymethoddotenv.factories.daos.impl.SQLiteDAOFactory;
import io.github.cdimascio.dotenv.Dotenv;
import java.util.List;

/**
 *
 * @author marlan
 */
public abstract class DAOFactory {

	private static final List<DAOFactory> factories = List.of( //
			new SQLiteDAOFactory(), //
			new PostgresDAOFactory()//
	);

	public abstract String getDatabase();

	public abstract void updateDatabase() throws Exception;

	public static DAOFactory getDAOFactory() throws Exception {
		Dotenv dotenv = Dotenv.configure().load();
		var optionalFactory = factories.stream().filter( f -> f.getDatabase().equals( dotenv.get( "DATABASE" ) ) ).findFirst();
		if( optionalFactory.isEmpty() ) {
			throw new Exception( "ENV 'DATABASE' não fornecida ou DAOFactory não implementada para o banco informado" );
		}
		var factory = optionalFactory.get();
		factory.updateDatabase();
		return optionalFactory.get();
	}

	public abstract IUsuarioDAO getUsuarioDAO();

}
