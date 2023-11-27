
package br.com.jovencio.marlan.factorymethoddotenv.model.entity;

/**
 *
 * @author marlan
 */
public class Usuario {

	private Long id;

	private String nome;

	private String username;

	private String password;

	public Usuario() {
	}

	public Usuario( long id ) {
		this.id = id;
	}

	public Usuario( String nome, String username, String password ) {
		this.nome = nome;
		this.username = username;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId( Long id ) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome( String nome ) {
		this.nome = nome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername( String username ) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword( String password ) {
		this.password = password;
	}

	@Override
	public String toString() {
		var s = new StringBuilder();

		s.append( "{" );
		s.append( "\"id\":" ).append( id ).append( "," );
		s.append( "\"nome\":\"" ).append( nome ).append( "\"," );
		s.append( "\"username\":\"" ).append( username ).append( "\"," );
		s.append( "\"password\":\"" ).append( password ).append( "\"" );
		s.append( "}" );
		return s.toString();
	}
}
