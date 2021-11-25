public class TestAddress extends Address
{
    String address1;
    String address2;
    String c;
    String s;
    int zCode;

    public TestAddress(String addressOne, String addressTwo, String city, String state, int zipCode)
    {
        this.address1 = addressOne;
        this.address2 = addressTwo;
        this.c = city;
        this.s = state;
        this.zCode = zipCode;
    }

    @Override
    public String toString()
    {
        return String.format("%s,%s %s, %s %s", 
        address1, address2 == null ? "" : " " + address2 + ",", c, s, zCode);
    }
}
