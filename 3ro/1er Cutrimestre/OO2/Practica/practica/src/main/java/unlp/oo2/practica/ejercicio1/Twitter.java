package unlp.oo2.practica.ejercicio1;

import java.util.Map;

public class Twitter {
	
	private Map<String, Usuario> usuarios;
	
	public Twitter() {}
	
	private Map<String, Usuario> getUsuarios(){	return this.usuarios;}
	
	public void registrarUsuario(Usuario usuario) {
		this.getUsuarios().put(usuario.getScreenName(), usuario);
	}
	
	public void eliminarUsuario(String screenName) {
		Map<String, Usuario> map = this.getUsuarios();
		if(map.containsKey(screenName)) {
			map.get(screenName).eliminarTweets();
			map.remove(screenName);
		}
	}
	
	
}
