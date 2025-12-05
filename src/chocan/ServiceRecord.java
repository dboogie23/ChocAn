package chocan;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ServiceRecord {

    private LocalDateTime currentDateTime;   
    private LocalDate dateOfService;        
    private String providerNumber;          
    private String memberNumber;            
    private String serviceCode;             
    private String comments;                

    public ServiceRecord(LocalDate dateOfService, String providerNumber,
                         String memberNumber, String serviceCode,
                         String comments, double fee) {

        this.currentDateTime = LocalDateTime.now();
        this.dateOfService = dateOfService;
        this.providerNumber = providerNumber;
        this.memberNumber = memberNumber;
        this.serviceCode = serviceCode;
        this.comments = (comments == null) ? "" : comments;
        this.fee = fee;
    }

    public LocalDateTime getCurrentDateTime() {
        return currentDateTime;
    }

    public LocalDate getDateOfService() {
        return dateOfService;
    }

    public String getProviderNumber() {
        return providerNumber;
    }

    public String getMemberNumber() {
        return memberNumber;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public String getComments() {
        return comments;
    }

    public double getFee() {
        return fee;
    }

    // Format for writing to files (used by Accounting Procedure)
    public String serialize() {
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
        DateTimeFormatter d = DateTimeFormatter.ofPattern("MM-dd-yyyy");

        return currentDateTime.format(dt) + "|" +
               dateOfService.format(d) + "|" +
               providerNumber + "|" +
               memberNumber + "|" +
               serviceCode + "|" +
               fee + "|" +
               comments;
    }

    @Override
    public String toString() {
        return serialize();
    }
}
