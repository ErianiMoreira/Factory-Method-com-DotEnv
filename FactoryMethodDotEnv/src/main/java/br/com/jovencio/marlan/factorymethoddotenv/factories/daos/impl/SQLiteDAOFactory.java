
package br.com.jovencio.marlan.factorymethoddotenv.factories.daos.impl;

import br.com.jovencio.marlan.factorymethoddotenv.dao.usuario.IUsuarioDAO;
import br.com.jovencio.marlan.factorymethoddotenv.dao.usuario.impl.UsuarioSQLiteDAO;
import br.com.jovencio.marlan.factorymethoddotenv.factories.daos.DAOFactory;

/**
 *
 * @author marlan
 */
public class SQLiteDAOFactory extends DAOFactory {

	@Override
	public String getDatabase() {
		return "SQLite";
	}

	@Override
	public IUsuarioDAO getUsuarioDAO() {
		return new UsuarioSQLiteDAO();
	}

	@Override
	public void updateDatabase() throws Exception {
		getUsuarioDAO().createTable();
	}

}
