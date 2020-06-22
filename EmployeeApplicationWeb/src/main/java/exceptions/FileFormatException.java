package exceptions;

import javax.servlet.ServletException;

public class FileFormatException extends ServletException {
    public FileFormatException(String errorMessage){
        super(errorMessage);
    }

}
