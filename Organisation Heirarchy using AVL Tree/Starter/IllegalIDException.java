// If given id is not present in the organization 
// Performing operations which are not allowed (e.g. deleting root)
public class IllegalIDException extends Exception{  
    IllegalIDException(String s){  
        super(s);  
    }  
}
