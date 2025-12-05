package chocan;

public class ProviderReport {

    private String providerName;
    private String providerNumber;
    private int consultationCount;
    private double totalFee;

    public ProviderReport(String providerName, String providerNumber)
    {
        this.providerName = providerName;
        this.providerNumber = providerNumber;
    }

    public void addConsultation(double fee)
    {
        consultationCount++;
        totalFee += fee;
    }

    public String getProviderName() { return providerName; }
    public String getProviderNumber() { return providerNumber; }
    public int getConsultationCount() { return consultationCount; }
    public double getTotalFee() { return totalFee; }

    public String getSummary()
    {
        return providerName + " " + providerNumber + " " +
               consultationCount + " $" + totalFee;
    }
}
