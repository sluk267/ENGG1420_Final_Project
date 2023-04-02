/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proccess;

/**
 *
 * @author Jacob
 */
public class Entries {
    private String name;
    private String type;
    private String path;
    private String repositoryID;
    private String entryID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getRepositoryID() {
        return repositoryID;
    }

    public void setRepositoryID(String repositoryID) {
        this.repositoryID = repositoryID;
    }

    public String getEntryID() {
        return entryID;
    }

    public void setEntryID(String entryID) {
        this.entryID = entryID;
    }
    
   // constructors for remote and local entries
    Entries(String type, String path){
        this.type = type;
        this.path = path;
    }
    Entries(String type, String repositoryID, String entryID){
        this.type = type;
        this.repositoryID = repositoryID;
        this.entryID = entryID;
    }
}