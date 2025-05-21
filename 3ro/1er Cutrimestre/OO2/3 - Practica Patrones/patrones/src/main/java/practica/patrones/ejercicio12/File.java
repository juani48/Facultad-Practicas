package practica.patrones.ejercicio12;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class File extends FileSystemComponent{
	
	public File(String name, LocalDate creation, int size) {
		super(name, creation, size);
	}
	
	public int size() { return this.getSize(); }

	@Override
	public FileSystemComponent largestFile() {
		return this;
	}
	

	@Override
	public FileSystemComponent newestFile() {
		return this;
	}

	@Override
	public FileSystemComponent search(String name) {
		if (this.getName().equals(name)) {
			return this;
		}
		else {
			return null;
		}
	}

	@Override
	public List<FileSystemComponent> searchAll(String name) {
		List<FileSystemComponent> list = new ArrayList<>();
		if (this.getName().equals(name)) {
			list.add(this);
		}
		return null;
	}

	@Override
	public String tableOfContents() {
		return "/" + this.getName(); 
	}
}
