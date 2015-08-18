package Fragments;

/**
 * Created by CJ-SERVER on 8/18/2015.
 */
public class DealerModel{

    private String firm_name;
    private String county;
    private String location;
    private String dealer_of;
    private String mobile;

    public DealerModel(String firm_name, String county, String location, String dealer_of, String mobile) {
        this.firm_name = firm_name;
        this.county = county;
        this.location = location;
        this.dealer_of = dealer_of;
        this.mobile = mobile;
    }



    public String getFirm_name() {
        return firm_name;
    }

    public void setFirm_name(String firm_name) {
        this.firm_name = firm_name;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDealer_of() {
        return dealer_of;
    }

    public void setDealer_of(String dealer_of) {
        this.dealer_of = dealer_of;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
