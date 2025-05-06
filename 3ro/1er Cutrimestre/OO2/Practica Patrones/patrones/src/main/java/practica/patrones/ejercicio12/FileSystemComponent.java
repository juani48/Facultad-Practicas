package practica.patrones.ejercicio12;

import java.time.LocalDate;
import java.util.List;

public abstract class FileSystemComponent {

	private String name;
	private LocalDate creation;
	private int size;
	
	public FileSystemComponent(String name, LocalDate creation, int size) {
		this.name = name; this.creation = creation; this.size = size;
	}

	public String getName() { return name; }
	public LocalDate getCreation() { return creation; }
	public int getSize() { return size; }
	
	public abstract int size();
	
	public abstract FileSystemComponent largestFile();
	
	protected int largestFile(FileSystemComponent file) {
		return Integer.compare(this.getSize(), file.getSize());
	}
	
	public abstract FileSystemComponent newestFile();
	
	protected int newestFile(FileSystemComponent file) {
		return this.getCreation().compareTo(file.getCreation());
	}
	
	public abstract FileSystemComponent search(String name);
	public abstract List<FileSystemComponent> searchAll(String name);
	public abstract String tableOfContents();
	
}
