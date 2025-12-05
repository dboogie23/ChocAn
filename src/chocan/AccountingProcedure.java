package chocan;

import java.io.FileWriter;
import java.io.PrintWriter;

public class AccountingProcedure {

    private DataCenter sys;

    public AccountingProcedure(DataCenter sys)
    {
        this.sys = sys;
    }

    public void run()
    {
        writeProviderReport();
        writeSummaryReport();
    }

    private void writeProviderReport()
    {
        Provider[] providers = sys.getProviders();
        ServiceRecord[] records = sys.getServiceRecords();

        if (providers == null || records == null) return;

        for (Provider p : providers)
        {
            if (p == null) continue;

            try
            {
                PrintWriter out = new PrintWriter(new FileWriter(p.getProviderNumber() + "_Report.txt"));
                double total = 0;

                for (ServiceRecord r : records)
                {
                    if (r == null) continue;

                    if (r.getProviderNumber().equals(p.getProviderNumber()))
                    {
                        out.println(r.getDate() + " " + r.getMemberNumber() + " " + r.getServiceCode() + " $" + r.getFee());
                        total += r.getFee();
                    }
                }

                out.println("Total: $" + total);
                out.close();
            }
            catch(Exception e) {}
        }
    }

    private void writeSummaryReport()
    {
        ServiceRecord[] records = sys.getServiceRecords();
        if (records == null) return;

        try
        {
            PrintWriter out = new PrintWriter(new FileWriter("SummaryReport.txt"));
            double total = 0;

            for (ServiceRecord r : records)
            {
                total += r.getFee();
            }

            out.println("Total Fees: $" + total);
            out.close();
        }
        catch(Exception e) {}
    }
}
