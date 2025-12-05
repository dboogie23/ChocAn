package chocan;

import java.io.FileWriter;
import java.io.PrintWriter;

public class AccountingProcedure {

    private DataCenter sys;

    public AccountingProcedure(DataCenter sys)
    {
        this.sys = sys;
    }

    // Main entry point
    public void run()
    {
        writeMemberReports();
        writeProviderReports();
        writeSummaryReport();

        System.out.println("Accounting procedure completed.");
    }

    // MEMBER REPORTS
 
    private void writeMemberReports()
    {
        MemberServiceReport[] reports = sys.getAllMemberServiceReport();
        if (reports == null) return;

        for (MemberServiceReport msr : reports)
        {
            if (msr == null) continue;

            try
            {
                String fileName = msr.getName() + "_MemberReport.txt";
                PrintWriter out = new PrintWriter(new FileWriter(fileName));

                out.println("Member Name: " + msr.getName());
                out.println("Member Number: " + msr.getNumber());
                out.println("Address: " + msr.getAddress());
                out.println("City: " + msr.getCity());
                out.println("State: " + msr.getState());
                out.println("Zip: " + msr.getZipCode());
                out.println();
                out.println("Services Provided:");

                out.println(msr.getMonth() + "-" + msr.getDay() + "-" + msr.getYear() +
                            " | Service Code: " + msr.getServiceCode());
                out.println("Comments: " + msr.getComments());

                out.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    // PROVIDER REPORTS
    
    private void writeProviderReports()
    {
        ProviderForm[] forms = sys.getWeeklyProviderForm();
        if (forms == null) return;

        Provider[] providers = sys.getProviders();
        if (providers == null) return;

        for (Provider p : providers)
        {
            if (p == null) continue;

            try
            {
                String fileName = p.getFirstName() + "_" + p.getLastName() + "_ProviderReport.txt";
                PrintWriter out = new PrintWriter(new FileWriter(fileName));

                out.println("Provider Name: " + p.getFullName());
                out.println("Provider Number: " + p.getProviderNumber());
                out.println();
                out.println("Services Provided:");

                double totalFee = 0;
                int consultationCount = 0;

                for (ProviderForm f : forms)
                {
                    if (f == null) continue;

                    if (f.getProviderNumber().equals(p.getProviderNumber()))
                    {
                        consultationCount++;
                        totalFee += f.getFee();

                        out.println(f.getMonth() + "-" + f.getDay() + "-" + f.getYear()
                                + " | Member: " + f.getMemberName()
                                + " | Code: " + f.getServiceCode()
                                + " | Fee: " + f.getFee());
                    }
                }

                out.println();
                out.println("Total Consultations: " + consultationCount);
                out.println("Total Fee: " + totalFee);

                out.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

  
    // SUMMARY REPORT
  
    private void writeSummaryReport()
    {
        Provider[] providers = sys.getProviders();
        ProviderForm[] forms = sys.getWeeklyProviderForm();
        if (providers == null || forms == null) return;

        try
        {
            PrintWriter out = new PrintWriter(new FileWriter("SummaryReport.txt"));

            int totalProvidersSeen = 0;
            int totalConsultations = 0;
            double totalFee = 0;

            for (Provider p : providers)
            {
                if (p == null) continue;

                int providerConsults = 0;
                double providerFee = 0;

                for (ProviderForm f : forms)
                {
                    if (f == null) continue;

                    if (f.getProviderNumber().equals(p.getProviderNumber()))
                    {
                        providerConsults++;
                        providerFee += f.getFee();
                    }
                }

                if (providerConsults > 0)
                {
                    totalProvidersSeen++;
                    totalConsultations += providerConsults;
                    totalFee += providerFee;

                    out.println(p.getFullName() + " | Consults: " + providerConsults +
                                " | Fees: " + providerFee);
                }
            }

            out.println();
            out.println("Total Providers with Activity: " + totalProvidersSeen);
            out.println("Total Consultations: " + totalConsultations);
            out.println("Total Fees: " + totalFee);

            out.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
