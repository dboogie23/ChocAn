package chocan;

public class ChocAnManager {

    private DataCenter sys;

    public ChocAnManager(DataCenter sys)
    {
        this.sys = sys;
    }

    public void addMember(Member m)
    {
        sys.members.add(m);
    }

    public boolean deleteMember(String number)
    {
        for (int i = 0; i < sys.members.size(); i++)
        {
            if (sys.members.get(i).getCard().getMemberNumber().equals(number))
            {
                sys.members.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean editMember(String number, String field, String value)
    {
        for (Member m : sys.members)
        {
            if (m.getCard().getMemberNumber().equals(number))
            {
                if (field.equals("name"))
                {
                    String[] parts = value.split(" ");
                    m.setFirstName(parts[0]);
                    m.setLastName(parts[1]);
                }
                if (field.equals("phone")) m.setNumber(value);
                if (field.equals("address")) m.setAddress(value);
                if (field.equals("city")) m.setCity(value);
                if (field.equals("state")) m.setState(value);
                if (field.equals("zip")) m.setZipCode(value);
                if (field.equals("email")) m.setEmail(value);
                return true;
            }
        }
        return false;
    }

    public void addProvider(Provider p)
    {
        sys.providers.add(p);
    }

    public boolean deleteProvider(String number)
    {
        for (int i = 0; i < sys.providers.size(); i++)
        {
            if (sys.providers.get(i).getProviderNumber().equals(number))
            {
                sys.providers.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean editProvider(String number, String field, String value)
    {
        for (Provider p : sys.providers)
        {
            if (p.getProviderNumber().equals(number))
            {
                if (field.equals("name"))
                {
                    String[] parts = value.split(" ");
                    p.setFirstName(parts[0]);
                    p.setLastName(parts[1]);
                }
                if (field.equals("phone")) p.setNumber(value);
                if (field.equals("address")) p.setAddress(value);
                if (field.equals("city")) p.setCity(value);
                if (field.equals("state")) p.setState(value);
                if (field.equals("zip")) p.setZipCode(value);
                return true;
            }
        }
        return false;
    }

    public void runAccounting()
    {
        AccountingProcedure ap = new AccountingProcedure(sys);
        ap.run();
    }
}
