/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paul_Testing;

/**
 *
 * @author Paul's Laptop
 */
public class Entry {
    private String path;
    private boolean isLocal;

    public Entry(String path, boolean isLocal) {
        this.path = path;
        this.isLocal = isLocal;
    }

    public String getPath() {
        return path;
    }

    public boolean isLocal() {
        return isLocal;
    }
}

public class LocalEntry extends Entry {
    private int size;

    public LocalEntry(String path) {
        super(path, isLocal);
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}

public class RemoteEntry extends Entry {
    private LaserficheRepository repository;

    public RemoteEntry(String path, boolean isLocal, LaserficheRepository repository) {
        super(path, isLocal);
        this.repository = repository;
    }

    public LaserficheRepository getRepository() {
        return repository;
    }
}