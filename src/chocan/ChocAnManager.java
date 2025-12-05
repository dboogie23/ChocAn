package chocan;

public class ChocAnManager {

    private DataCenter sys;

    public ChocAnManager(DataCenter sys)
    {
        this.sys = sys;
    }

    // USER MANAGEMENT (Members)

    public void addMember(Member member)
    {
        sys.addMember(member.getFirstName(),
                      member.getLastName(),
                      member.getPhoneNumber(),
                      member.getAddress(),
                      member.getCity(),
                      member.getState(),
                      member.getZipCode(),
                      member.getEmail(),
                      member.getCard().getMemberNumber());
    }

    public boolean deleteMember(String memberNumber)
    {
        Member[] members = sys.getMembers();
        for (int i = 0; i < members.length; i++)
        {
            if (members[i].getCard().getMemberNumber().equals(memberNumber))
            {
                sys.members.remove(i); 
                return true;
            }
        }
        return false;
    }

    public boolean editMember(String memberNumber, String field, String newValue)
    {
        Member[] members = sys.getMembers();

        for (Member m : members)
        {
            if (m == null) continue;

            if (m.getCard().getMemberNumber().equals(memberNumber))
            {
                if (field.equals("name"))
                {
                    // Split name "First Last"
                    String[] parts = newValue.split(" ");
                    if (parts.length == 2)
                    {
                        m.setFirstName(parts[0]);
                        m.setLastName(parts[1]);
                    }
                }
                else if (field.equals("phone"))
                {
                    m.setNumber(newValue);
                }
                else if (field.equals("address"))
                {
                    m.setAddress(newValue);
                }
                else if (field.equals("city"))
                {
                    m.setCity(newValue);
                }
                else if (field.equals("state"))
                {
                    m.setState(newValue);
                }
                else if (field.equals("zip"))
                {
                    m.setZipCode(newValue);
                }
                else if (field.equals("email"))
                {
                    m.setEmail(newValue);
                }
                return true;
            }
        }
        return false;
    }

    // PROVIDER MANAGEMENT

    public void addProvider(Provider provider)
    {
        sys.providers.add(provider);
    }

    public boolean deleteProvider(String providerNumber)
    {
        Provider[] providers = sys.getProviders();

        for (int i = 0; i < providers.length; i++)
        {
            if (providers[i].getProviderNumber().equals(providerNumber))
            {
                sys.providers.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean editProvider(String providerNumber, String field, String newValue)
    {
        Provider[] providers = sys.getProviders();

        for (Provider p : providers)
        {
            if (p == null) continue;

            if (p.getProviderNumber().equals(providerNumber))
            {
                if (field.equals("name"))
                {
                    String[] parts = newValue.split(" ");
                    if (parts.length == 2)
                    {
                        p.setFirstName(parts[0]);
                        p.setLastName(parts[1]);
                    }
                }
                else if (field.equals("phone"))
                {
                    p.setNumber(newValue);
                }
                else if (field.equals("address"))
                {
                    p.setAddress(newValue);
                }
                else if (field.equals("city"))
                {
                    p.setCity(newValue);
                }
                else if (field.equals("state"))
                {
                    p.setState(newValue);
                }
                else if (field.equals("zip"))
                {
                    p.setZipCode(newValue);
                }

                return true;
            }
        }
        return false;
    }

    // ACCOUNTING PROCEDURE (Friday)

    public void runAccountingProcedure()
    {
        // This will eventually:
        // - Read service records
        // - Generate member reports
        // - Generate provider reports
        // - Generate summary report
        // - Create EFT file

        System.out.println("Running accounting procedure...");
    }

    // REPORT PRINTING 

    public void printMemberReport(Member member)
    {
        System.out.println("Printing member report for: " + member.getFullName());
    }

    public void printProviderReport(Provider provider)
    {
        System.out.println("Printing provider report for: " + provider.getFullName());
    }

    public void printSummaryReport()
    {
        System.out.println("Printing summary report...");
    }

}
