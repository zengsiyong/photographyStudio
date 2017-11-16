package pojo2;

import com.zengsy.pojo.Category;

import java.util.Date;
import java.util.List;

/**
 * Created by zengsy on 2017-10-09.
 * 这是约拍套餐表
 * 与Category是多对一的关系
 * 与ProductImage是一对多的关系
 * firstPdocutImage这个属性，是从productSingleImages集合中取出来的第一个，用于显示产品的默认图片
 * reviewCount，saleCount这两个字段，分别表示评价数量和销售数量，并不是在数据库中对应的字段
 * name: 产品名称
 * subTitle: 小标题
 * originalPrice: 原始价格
 * promotePrice: 优惠价格
 * stock: 库存
 * createDate: 创建日期

 本表的外键cid，指向分类表的id字段
 */
public class Product {
    private String name;
    private String subTitle;
    private float originalPrice;
    private float promotePrice;
    private int stock;
    private Date createDate;
    private Category category;
    private int id;
    private ProductImage firstProductImage;
    private List<ProductImage> productImages;
    private List<ProductImage> productSingleImages;
    private List<ProductImage> productDetailImages;
    private int reviewCount;
    private int saleCount;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSubTitle() {
        return subTitle;
    }
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
    public float getoriginalPrice() {
        return originalPrice;
    }
    public void setoriginalPrice(float originalPrice) {
        this.originalPrice = originalPrice;
    }
    public float getPromotePrice() {
        return promotePrice;
    }
    public void setPromotePrice(float promotePrice) {
        this.promotePrice = promotePrice;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String toString(){
        return name;
    }
    public ProductImage getFirstProductImage() {
        return firstProductImage;
    }
    public void setFirstProductImage(ProductImage firstProductImage) {
        this.firstProductImage = firstProductImage;
    }
    public List<ProductImage> getProductImages() {
        return productImages;
    }
    public void setProductImages(List<ProductImage> productImages) {
        this.productImages = productImages;
    }
    public List<ProductImage> getProductSingleImages() {
        return productSingleImages;
    }
    public void setProductSingleImages(List<ProductImage> productSingleImages) {
        this.productSingleImages = productSingleImages;
    }
    public List<ProductImage> getProductDetailImages() {
        return productDetailImages;
    }
    public void setProductDetailImages(List<ProductImage> productDetailImages) {
        this.productDetailImages = productDetailImages;
    }
    public int getReviewCount() {
        return reviewCount;
    }
    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }
    public int getSaleCount() {
        return saleCount;
    }
    public void setSaleCount(int saleCount) {
        this.saleCount = saleCount;
    }

}
