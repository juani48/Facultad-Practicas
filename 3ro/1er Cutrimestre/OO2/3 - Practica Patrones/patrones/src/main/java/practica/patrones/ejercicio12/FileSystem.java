package practica.patrones.ejercicio12;

public class FileSystem {

	private File file;
	
	public FileSystem(File file) { this.file = file; }

	public File getFile() { return file; }
	
	public int sized() {
		return this.file.size();
	}
	
}
