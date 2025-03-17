package unlp.oo2.practica.ejercicio1;

public class Tweet {
	
	private Tweet origen;
	private String texto;
	
	public Tweet(Tweet origen) {
		this.origen = origen;
		this.texto = "";
	}
	
	public Tweet(String texto){
		this.origen = null;
		if(texto.length() == 0) {
			texto = " ";
		}
		else if(texto.length() > 280){
			texto = texto.substring(0, 279);
		}
		this.texto = texto;
	}
	
}
