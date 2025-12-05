package chocan;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;

public class ProviderDirectory {

    private HashMap<String, ServiceInfo> services = new HashMap<>();

    public ProviderDirectory() {

        services.put("598470", new ServiceInfo("Dietitian Consultation", 45.99));
        services.put("883948", new ServiceInfo("Aerobics Exercise Session", 55.50));
        services.put("123456", new ServiceInfo("General Consultation", 40.00));
    }

    public boolean isValidServiceCode(String code) {
        return services.containsKey(code);
    }

    public String getServiceName(String code) {
        ServiceInfo si = services.get(code);
        return (si == null) ? null : si.name();
    }

    public double getServiceFee(String code) {
        ServiceInfo si = services.get(code);
        return (si == null) ? 0.0 : si.fee();
    }

    // Allows Provider to request a full directory printed to a file
    public void generateDirectoryFile(String path) {
        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            out.println("---- PROVIDER DIRECTORY ----");
            out.println("SERVICE CODE | SERVICE NAME | FEE");
            out.println("----------------------------------------------");

            for (String code : services.keySet()) {
                ServiceInfo si = services.get(code);
                out.println(code + " | " + si.name() + " | $" + si.fee());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Internal class to hold service data
    private record ServiceInfo(String name, double fee) {}
}
