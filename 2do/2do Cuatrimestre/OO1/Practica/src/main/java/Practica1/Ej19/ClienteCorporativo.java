package Practica1.Ej19;
public class ClienteCorporativo extends Cliente {

	@SuppressWarnings("unused")
	private String nombreEmpresa;
	@SuppressWarnings("unused")
	private int cuit;
	
	public ClienteCorporativo(String direccion, String nombreEmpresa, int cuit) {
		super(direccion);
		this.nombreEmpresa = nombreEmpresa;
		this.cuit = cuit;
	}
	
}
