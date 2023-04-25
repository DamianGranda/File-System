package sistema;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    private String name;
    private List<File> files;
    private List<Directory> directories;
    private Directory parent;
    
    public Directory(String name) {
        this.name = name;
        this.files = new ArrayList<>();
        this.directories = new ArrayList<>();
        this.parent = null;
    }
    
    //getters y setters
    
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
		this.name = name;
	}
    
    public List<File> getFiles() {
        return this.files;
    }
    
    public void setFiles(List<File> files) {
		this.files = files;
	}
    
    public List<Directory> getDirectories() {
        return this.directories;
    }
    
    public void setDirectories(List<Directory> directories) {
		this.directories = directories;
	}
    
    public Directory getParent() {
  		return parent;
  	}
    
    public void setParent(Directory parent) {
        this.parent = parent;
    }
    
    public String getPath() {
        if (this.parent == null) {
            return this.name;
        } else {
            return this.parent.getPath() + "/" + this.name;
        }
    }
    
    //Funciones
    public void addFile(File file) {
        this.files.add(file);
    }
    
    public void addDirectory(Directory directory) {
        directory.setParent(this);
        this.directories.add(directory);
    }
    

    
    public Directory getDirectory(String dirName) {
        for (Directory dir : this.directories) {
            if (dir.getName().equals(dirName)) {
                return dir;
            }
        }
        return null;
    }
    
}