package chocan;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;

public class ProviderDirectory {

    private HashMap<String, String> names = new HashMap<>();
    private HashMap<String, Double> fees = new HashMap<>();

    public ProviderDirectory()
    {
        names.put("100000", "Consultation");
        fees.put("100000", 45.00);

        names.put("200000", "Therapy Session");
        fees.put("200000", 30.00);

        names.put("300000", "Emergency Visit");
        fees.put("300000", 80.00);
    }

    public boolean isValidServiceCode(String code)
    {
        return names.containsKey(code);
    }

    public String getServiceName(String code)
    {
        return names.get(code);
    }

    public double getServiceFee(String code)
    {
        return fees.get(code);
    }

    public void writeDirectory(String fileName)
    {
        try
        {
            PrintWriter out = new PrintWriter(new FileWriter(fileName));

            for (String code : names.keySet())
            {
                out.println(code + " " + names.get(code) + " $" + fees.get(code));
            }

            out.close();
        }
        catch(Exception e) {}
    }
}
