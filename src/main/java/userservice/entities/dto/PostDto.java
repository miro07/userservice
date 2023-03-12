package userservice.entities.dto;


public class PostDto {


    private Long PostId;
    private String additionalAddress;
    private String address;
    private String city;
    private String country;
    private String description;
    private InstrumentDto product;
    private String region;
    private Long userID;
    private Long zip;

    public Long getPostId() {
        return PostId;
    }

    public void setPostId(Long postId) {
        PostId = postId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(InstrumentDto product) {
        this.product = product;
    }
    public String getAdditionalAddress() {
        return additionalAddress;
    }

    public void setAdditionalAddress(String additionalAddress) {
        this.additionalAddress = additionalAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getZip() {
        return zip;
    }

    public void setZip(Long zip) {
        this.zip = zip;
    }
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
