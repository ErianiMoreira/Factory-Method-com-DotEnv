
package br.com.jovencio.marlan.factorymethoddotenv.factories.daos.impl;

import br.com.jovencio.marlan.factorymethoddotenv.dao.usuario.IUsuarioDAO;
import br.com.jovencio.marlan.factorymethoddotenv.dao.usuario.impl.UsuarioPostgresDAO;
import br.com.jovencio.marlan.factorymethoddotenv.factories.daos.DAOFactory;

/**
 *
 * @author marlan
 */
public class PostgresDAOFactory extends DAOFactory {

	@Override
	public String getDatabase() {
		return "postgres";
	}

	@Override
	public void updateDatabase() throws Exception {
		getUsuarioDAO().createTable();
	}

	@Override
	public IUsuarioDAO getUsuarioDAO() {
		return new UsuarioPostgresDAO();
	}

}
