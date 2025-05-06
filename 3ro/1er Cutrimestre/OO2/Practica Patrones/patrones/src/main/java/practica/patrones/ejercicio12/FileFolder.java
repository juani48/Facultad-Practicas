package practica.patrones.ejercicio12;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileFolder extends FileSystemComponent{
	
	private List<File> files;
	
	public FileFolder(String name, LocalDate creation) {
		super(name, creation, 32);
		this.files = new ArrayList<>();
	}

	public List<File> getFiles(){ return this.files; }
	
	public int size() { return this.getSize() + this.getFiles().stream().mapToInt(x -> x.getSize()).sum(); }

	@Override
	public FileSystemComponent largestFile() {
		FileSystemComponent file = this.getFiles().stream().sorted( (x,y) -> x.largestFile(y) ).findFirst().get();
		if( file == null || this.getSize() > file.getSize()) {
			return this;
		}
		else {
			return file;
		}
	}

	@Override
	public FileSystemComponent newestFile() {
		FileSystemComponent file = this.getFiles().stream().sorted( (x,y) -> x.newestFile(y) ).findFirst().orElse(null);
		if( file == null || this.getCreation().isAfter(file.getCreation())) {
			return this;
		}
		else {
			return file;
		}
	}

	@Override
	public FileSystemComponent search(String name) {
		if(this.getName().equals(name)) {
			return this;
		}
		return this.getFiles().stream().filter(x -> x.search(name) != null).findFirst().orElse(null);
	}

	@Override
	public List<FileSystemComponent> searchAll(String name) {
		List<FileSystemComponent> list = new ArrayList<>();
		if(this.getName().equals(name)) {
			list.add(this);
		}
		list.addAll(this.getFiles().stream().filter(x -> x.search(name) != null).toList());
		return list;
	}

	@Override
	public String tableOfContents() {
		return "/" + this.getName() + this.getFiles().stream().map(x -> x.tableOfContents()).toString();
	}
}
