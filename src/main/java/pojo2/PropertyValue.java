package pojo2;

/**
 * Created by zengsy on 2017-10-09.
 * 约拍套餐具体属性值表，存放属性值信息，如光圈大小是 1.8
 * 与Product是多对一的关系
 * 与Propety是多对一的关系
 * 实际运用中，一个属性值，需要同时关联Property和Product
 */
public class PropertyValue {
    private String value;
    private Product product;
    private Property property;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public Property getProperty() {
        return property;
    }
    public void setProperty(Property property) {
        this.property = property;
    }
}