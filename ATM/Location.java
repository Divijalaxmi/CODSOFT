public class Location {
    private String country;
    private String zipCode;
    private String state;
    private String city;
    private String zone;
    private String address;

    public Location(String country,String zipcode, String state, String city, String zone, String address){
        this.country = country;
        this.zipCode = zipcode;
        this.state = state;
        this.city = city;
        this.zone = zone;
        this.address = address;
    }

    public void getLocation(){
        System.out.println(this.country);
        System.out.println(this.zipCode);
        System.out.println(this.state);
        System.out.println(this.city);
        System.out.println(this.zone);
        System.out.println(this.address);
    }

    public String getCountry(){
        return this.country;
    }

    public String getZipcode(){
        return this.zipCode;
    }

    public String getState(){
        return this.state;
    }

    public String getCity(){
        return this.city;
    }

    public String getZone(){
        return this.zone;
    }

    public String getAddress(){
        return this.address;
    }
}
