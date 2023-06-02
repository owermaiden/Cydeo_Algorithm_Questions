package B_Medium_Data_Structures.Different_Formatted_Dates;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DifferentFormattedDates {

    /*
Different Formatted Dates
An application needs to convert a collection of dates into a single common date format.
All input dates will be valid, but only date in the following format should be included in the output,
where YYYY, MM, and DD are numbers representing the year, month, and day, respectively:
YYYY/MM/DD
MM/DD/YYYY
DD-MM-YYYY
All output dates must be in the format YYYYMMDD. Complete the transformDates() method to accept a list of input dates
and return a list of acceptable and formatted output dates.

     */

    public static void main(String[] args) {
        List<String> dates = List.of("2023/03/25", "12/31/2022", "28/03/2023","23-03-2023");
        System.out.println("transformDates(dates) = " + transformDates(dates));
    }

    public static List<String> transformDates(List<String> dates){
        List<String> outputDates = new ArrayList<>();

        for (String inputDate : dates) {
            try {
                LocalDate date = null;
                if (inputDate.matches("\\d{4}/\\d{2}/\\d{2}")) {
                    date = LocalDate.parse(inputDate, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
                } else if (inputDate.matches("\\d{2}/\\d{2}/\\d{4}")) {
                    date = LocalDate.parse(inputDate, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
                } else if (inputDate.matches("\\d{2}-\\d{2}-\\d{4}")) {
                    date = LocalDate.parse(inputDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                }
                if (date != null) {
                    String formattedDate = date.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
                    outputDates.add(formattedDate);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return outputDates;
    }

}
