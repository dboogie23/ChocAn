package chocan;

public class ServiceRecord {

    private String providerNumber;
    private String memberNumber;
    private String serviceCode;
    private String date;
    private double fee;

    public ServiceRecord(String providerNumber, String memberNumber, String serviceCode, String date, double fee)
    {
        this.providerNumber = providerNumber;
        this.memberNumber = memberNumber;
        this.serviceCode = serviceCode;
        this.date = date;
        this.fee = fee;
    }

    public String getProviderNumber() { return providerNumber; }
    public String getMemberNumber() { return memberNumber; }
    public String getServiceCode() { return serviceCode; }
    public String getDate() { return date; }
    public double getFee() { return fee; }

    public String getInfo()
    {
        return providerNumber + "|" + memberNumber + "|" + serviceCode + "|" + date + "|" + fee;
    }
}
