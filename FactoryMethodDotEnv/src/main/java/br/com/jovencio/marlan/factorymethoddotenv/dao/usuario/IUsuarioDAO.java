
package br.com.jovencio.marlan.factorymethoddotenv.dao.usuario;

import br.com.jovencio.marlan.factorymethoddotenv.model.entity.Usuario;

/**
 *
 * @author marlan
 */
public interface IUsuarioDAO {

	public void createTable() throws Exception;

	public Usuario insert( Usuario usuario ) throws Exception;

	public Usuario get( long id ) throws Exception;

	public void update( Usuario usuario ) throws Exception;

	public void delete( long id ) throws Exception;

}
