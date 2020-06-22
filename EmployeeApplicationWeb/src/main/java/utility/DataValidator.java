package utility;

import exceptions.FileFormatException;

import java.util.Arrays;
import java.util.List;

public class DataValidator {

    public static final String NUMBER_REGEX = "^[0-9]+$";

    public static void validateFileContent(List<String>content) throws FileFormatException {
        if(content.isEmpty() || content.contains(null) || content.size()!=4 ){
            throw new FileFormatException("Content is empty or has inavlid characters");
        }
        if(!content.get(0).matches(NUMBER_REGEX) || !content.get(1).matches(NUMBER_REGEX)){
            throw new FileFormatException("EmpId or ProjectId is not number or it is empty");
        }
    }
}
