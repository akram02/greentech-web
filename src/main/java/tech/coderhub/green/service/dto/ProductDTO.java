package tech.coderhub.green.service.dto;

public class ProductDTO {
    private Long id;
    private String name;
    private String userName;
    private String location;
    private String category;

    public ProductDTO(Long id, String name, String userName, String location, String category) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.location = location;
        this.category = category;
    }

    public ProductDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
