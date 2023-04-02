
package Proccess;
/**
 *
 * @author Paul Posluszny
 * @since 2023/03/07
 * @args 
 * @version 1.1.0
 */
public class Access {
    
    //abstract class for the entries
    public abstract class Entry{
        private String id;
        private String path;
        
        // object constuctor with id and path args
        public Entry(String id, String path){
            this.id = id;
            this.path = path;
        }
        
        // get method for path
        public String getPath(){
            return path;
        }
        
        // get method for id
        public String getId() {
            return id;
        }
    }
     
    //class for local entries, builds from Entry class
    public class LocalEntry extends Entry {
        
        //calls the super constructor with id and path args
        public LocalEntry(String id, String path){
            super (id, path);
        }
    }
     
    //class for remote entries, extended from Entry class
    public class RemoteEntry extends Entry {
        private String repositoryId;
        
        //calls super contsructor with id and path args and initializes repoId
        public RemoteEntry(String id, String path, String repositoryId) {
            super (id, path);
            this.repositoryId = repositoryId;
            
        }
        
        // get method for getRepositoryId
        public String getRepositoryId() {
            return repositoryId;
        }
    }
}
    

