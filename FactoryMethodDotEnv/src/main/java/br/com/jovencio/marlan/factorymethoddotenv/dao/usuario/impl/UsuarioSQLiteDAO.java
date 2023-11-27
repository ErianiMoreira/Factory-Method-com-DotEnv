
package br.com.jovencio.marlan.factorymethoddotenv.dao.usuario.impl;

import br.com.jovencio.marlan.factorymethoddotenv.dao.conexoes.impl.SQLiteConexao;
import br.com.jovencio.marlan.factorymethoddotenv.dao.usuario.IUsuarioDAO;
import br.com.jovencio.marlan.factorymethoddotenv.model.entity.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author marlan
 */
public class UsuarioSQLiteDAO extends SQLiteConexao implements IUsuarioDAO {

	Logger log = LoggerFactory.getLogger( UsuarioSQLiteDAO.class );

	@Override
	public void createTable() throws Exception {
		var sql = new StringBuilder();

		sql.append( " create table if not exists usuarios( " );
		sql.append( "     id integer primary key AUTOINCREMENT, " );
		sql.append( "     nome text null, " );
		sql.append( "     username text not null, " );
		sql.append( "     password text not null " );
		sql.append( " ); " );

		log.info( sql.toString() );

//		var statement = openConnection().createStatement();
//		statement.execute( sql.toString() );
//		closeConnection( statement.getConnection() );
	}

	@Override
	public Usuario insert( Usuario usuario ) throws Exception {
		var sql = new StringBuilder();

		sql.append( " insert into usuarios( " );
		sql.append( "     nome, " );
		sql.append( "     username, " );
		sql.append( "     password " );
		sql.append( " ) " );
		sql.append( " values ( " );
		sql.append( "     '" ).append( usuario.getNome() ).append( "', " );
		sql.append( "     '" ).append( usuario.getUsername() ).append( "', " );
		sql.append( "     '" ).append( usuario.getPassword() ).append( "' " );
		sql.append( " ); " );

		var id = super.insert( sql.toString() );
		usuario.setId( id );
		return usuario;
	}

	@Override
	public Usuario get( long id ) throws Exception {
		var sql = new StringBuilder();
		sql.append( " select " );
		sql.append( "     u.id as id, " );
		sql.append( "     u.nome as nome, " );
		sql.append( "     u.username as username, " );
		sql.append( "     u.password as password " );
		sql.append( " from usuarios u " );
		sql.append( " where u.id = " ).append( id );
		sql.append( " ; " );

		log.info( sql.toString() );
//		var statement = openConnection().createStatement();
//		var result = statement.executeQuery( sql.toString() );
//		result.next();
		var usuario = new Usuario( id );
//		usuario.setId( result.getLong( "id" ) );
//		usuario.setNome( result.getString( "nome" ) );
//		usuario.setUsername( result.getString( "username" ) );
//		usuario.setPassword( result.getString( "password" ) );
//		closeConnection( statement.getConnection() );
//		if( Long.compare( usuario.getId(), 0l ) == 0 ) {
//			return null;
//		}
		return usuario;
	}

	@Override
	public void update( Usuario usuario ) throws Exception {
		var sql = new StringBuilder();

		sql.append( " update usuarios set " );
		sql.append( "     nome = '" ).append( usuario.getNome() ).append( "', " );
		sql.append( "     username = '" ).append( usuario.getUsername() ).append( "', " );
		sql.append( "     password = '" ).append( usuario.getUsername() ).append( "' " );
		sql.append( " where id = " ).append( usuario.getId() );
		sql.append( " ; " );

		log.info( sql.toString() );
//		var statement = openConnection().createStatement();
//		statement.executeUpdate( sql.toString() );
//		closeConnection( statement.getConnection() );
	}

	@Override
	public void delete( long id ) throws Exception {
		var sql = new StringBuilder();

		sql.append( " delete from usuarios " );
		sql.append( " where id = " ).append( id );
		sql.append( " ; " );

		log.info( sql.toString() );

//		var statement = openConnection().createStatement();
//		statement.executeUpdate( sql.toString() );
//		closeConnection( statement.getConnection() );
	}

}
