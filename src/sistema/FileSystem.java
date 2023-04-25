package sistema;

import java.util.ArrayList;
import java.util.List;

public class FileSystem {
    private Directory root;
    private Directory currentDirectory;
    private List<Directory> directoryHistory;
    
    public FileSystem() {
        this.root = new Directory("/");
        this.currentDirectory = this.root;
        this.directoryHistory = new ArrayList<>();
        this.directoryHistory.add(this.currentDirectory);
    }
    
    
    
    // Getters y Setters
    
    public Directory getRoot() {
		return root;
	}





	public void setRoot(Directory root) {
		this.root = root;
	}





	public Directory getCurrentDirectory() {
		return currentDirectory;
	}





	public void setCurrentDirectory(Directory currentDirectory) {
		this.currentDirectory = currentDirectory;
	}





	public List<Directory> getDirectoryHistory() {
		return directoryHistory;
	}





	public void setDirectoryHistory(List<Directory> directoryHistory) {
		this.directoryHistory = directoryHistory;
	}





	// Funciones
    public void cd(String dirName) {
        if (dirName.equals("..")) {
            if (this.currentDirectory != this.root) {
                this.currentDirectory = this.directoryHistory.get(this.directoryHistory.size() - 2);
                this.directoryHistory.remove(this.directoryHistory.size() - 1);
            }
        } else {
            Directory newDir = this.currentDirectory.getDirectory(dirName);
            System.out.println("-cd "+ dirName);
            if (newDir != null) {
                this.currentDirectory = newDir;
                this.directoryHistory.add(this.currentDirectory);
            } else {
                System.out.println("Directory not found");
            }
        }
    }
    
    public void touch(String fileName) {
        File newFile = new File(fileName);
        this.currentDirectory.addFile(newFile);
        System.out.println("Archivo creado con exito!!");
    }
    
    public void ls() {
    	List<File> files = currentDirectory.getFiles();
        List<Directory> subdirs = currentDirectory.getDirectories();

        System.out.println("Archivos:");
        for (File file : files) {
            System.out.println(file.getName());
        }

        System.out.println("Carpetas:");
        for (Directory subdir : subdirs) {
            System.out.println(subdir.getName());
        }
    }
    
    public void mkdir(String dirName) {
        Directory newDir = new Directory(dirName);
        this.currentDirectory.addDirectory(newDir);
        System.out.println("Carpeta creada con exito!!");
    }
    
    public void pwd() {
        System.out.println(this.currentDirectory.getPath());
    }
}