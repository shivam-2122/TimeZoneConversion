import java.util.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


public class TimeZoneConvert{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input form User of local time zone
        System.out.print("Enter your local time zone \n(e.g. Asia/Kolkata, Asia/Kuwait):");
        String localZone = sc.nextLine();
        ZoneId localZoneId = ZoneId.of(localZone);

        // Taking input from User for country time zone in which he is going  to Convert
        System.out.print("Enter the country time zone \n(e.g. America/New_York, Europe/London,):");
        String countryZone = sc.nextLine();
        ZoneId countryZoneId = ZoneId.of(countryZone);

        // Converting local time to another country time
        LocalDateTime localDateTime = LocalDateTime.now(localZoneId);
        LocalDateTime countryDateTime = localDateTime.atZone(localZoneId).withZoneSameInstant(countryZoneId).toLocalDateTime();

        // Formatting Date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String localTime = formatter.format(localDateTime);
        String countryTime = formatter.format(countryDateTime);

        // Showing output
        System.out.println("Local time (" + localZoneId + "): " + localTime);
        System.out.println("Country time (" + countryZoneId + "): " + countryTime);
    }
}