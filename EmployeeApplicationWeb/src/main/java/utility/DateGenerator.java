package utility;

import exceptions.FileFormatException;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static constants.FileConstants.*;
import static constants.ErrorMessagesConstants.*;

public class DateGenerator {

    public static Date formatDate(String givenDate) throws FileFormatException {
        return givenDate.contains(EMPTY_DATE) ? new Date() : generateDateFormatter(givenDate);
    }

    public static Date generateDateFormatter(String givenDate) throws FileFormatException {
        List<String> dateFormats = new ArrayList<>();
        List<String> dateTimeFormats = new ArrayList<>();
        dateFormats.add("yyyy-MM-dd");
        dateFormats.add("dd-MM-yy");
        dateFormats.add("dd-MM-yyyy");
        dateFormats.add("MM-dd-yyyy");
        dateFormats.add("MM-dd-yy");
        dateFormats.add("MM/dd/yyyy");
        dateFormats.add("dd/MM/yyyy");
        dateFormats.add("dd/MM/yy");
        dateFormats.add("yyyy/MM/dd");
        dateFormats.add("yyyy/dd/MM");
        dateFormats.add("yyyy-dd-MM");
        dateFormats.add("dd MMMM yyyy");
        dateTimeFormats.add("yyyy-MM-dd'T'HH:mm:ss'Z'");
        dateTimeFormats.add("yyyy-MM-dd'T'HH:mm.ss'Z'");
        dateTimeFormats.add("yyyy-MM-dd'T'HH:mm:ss");
        dateTimeFormats.add("yyyy-MM-dd' 'HH:mm:ss");
        dateTimeFormats.add("yyyy/MM/dd HH:mm:ss.SSS");
        dateTimeFormats.add("dd-MM-yyyy HH:mm:ss.SSS");
        dateTimeFormats.add("yyyy-MM-dd HH:mm:ss.SSS");
        dateTimeFormats.add("yyyy-MM-dd HH:mm:ss[.SSS]S");
        dateTimeFormats.add("ddMMMyyyy:HH:mm:ss.SSS[ Z]");
        dateTimeFormats.add("yyyy-MM-dd'T'HH:mm:ssXXX");
        dateTimeFormats.add("yyyy-MM-dd'T'HH:mm:ssX");
        dateTimeFormats.add("yyyy-MM-dd HH:mm:ss z");
        dateTimeFormats.add("EEEEE MMMMM yyyy HH:mm:ss.SSSZ");
        dateTimeFormats.add("dd-M-yyyy hh:mm:ss");
        dateTimeFormats.add("dd MMMM yyyy zzzz");
        dateTimeFormats.add("E, dd MMM yyyy HH:mm:ss z");

   for (String dateFormat: dateFormats) {
           try {
               DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat);
               LocalDate dateTime = LocalDate.parse(givenDate, dateTimeFormatter);
               return Date.from(dateTime.atStartOfDay(ZoneId.systemDefault()).toInstant());
           } catch (DateTimeParseException e) {
               System.out.println(DATE_FORMAT_EXCEPTION);
           }
   }
   for (String dateTimeFormat:dateTimeFormats){
       try {
           DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateTimeFormat);
           LocalDateTime dateTime = LocalDateTime.parse(givenDate, dateTimeFormatter);
           return Date.from(dateTime.toInstant(ZoneOffset.UTC));
       }catch(DateTimeParseException e){
           System.out.println(DATE_TIME_FORMAT_EXCEPTION);
       }
   }
   throw new FileFormatException(UNSUPPORTED_DATE_FORMAT_EXCEPTION + givenDate);
    }
}
