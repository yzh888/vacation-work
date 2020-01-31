package learn;

/**
 * @author zh_yan
 * @ClassName Phone
 * @Description TODO
 * @Date 2020/1/12
 * @Version 1.0
 **/
public class Phone {
    private Integer id;
    private String brand;
    private Double price;

    public Phone(Integer id,String brand, Double price) {
        this.id=id;
        this.brand=brand;
        this.price=price;
    }

    public Integer getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Phone() {

    }
    //省略getter/setter
}
