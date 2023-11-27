
package br.com.jovencio.marlan.factorymethoddotenv.dao.conexoes;

import java.sql.Connection;

/**
 *
 * @author marlan
 */
public interface IBancoDadosConexao {

	public Connection openConnection() throws Exception;

	public void closeConnection( Connection connection ) throws Exception;

}
