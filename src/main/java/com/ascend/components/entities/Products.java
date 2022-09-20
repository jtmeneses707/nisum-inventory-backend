package com.ascend.components.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Products {

    @Id
    String UPC;

    String ProdName;

    String Brand;

    String ProdDesc;

    String Category;

    float PricePerUnit;

    String ImageURL;

    int AvailableStock;

    int ReservedStock;

    int ShippedStock;

    public String getUPC() {
        return UPC;
    }

    public void setUPC(String UPC) {
        this.UPC = UPC;
    }

    public String getProdName() {
        return ProdName;
    }

    public void setProdName(String prodName) {
        ProdName = prodName;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getProdDesc() {
        return ProdDesc;
    }

    public void setProdDesc(String prodDesc) {
        ProdDesc = prodDesc;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public float getPricePerUnit() {
        return PricePerUnit;
    }

    public void setPricePerUnit(float pricePerUnit) {
        PricePerUnit = pricePerUnit;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }

    public int getAvailableStock() {
        return AvailableStock;
    }

    public void setAvailableStock(int availableStock) {
        AvailableStock = availableStock;
    }

    public int getReservedStock() {
        return ReservedStock;
    }

    public void setReservedStock(int reservedStock) {
        ReservedStock = reservedStock;
    }

    public int getShippedStock() {
        return ShippedStock;
    }

    public void setShippedStock(int shippedStock) {
        ShippedStock = shippedStock;
    }

    @Override
    public String toString() {
        return "Products{" +
            "UPC='" + UPC + '\'' +
            ", ProdName='" + ProdName + '\'' +
            ", Brand='" + Brand + '\'' +
            ", ProdDesc='" + ProdDesc + '\'' +
            ", Category='" + Category + '\'' +
            ", PricePerUnit=" + PricePerUnit +
            ", ImageURL='" + ImageURL + '\'' +
            ", AvailableStock=" + AvailableStock +
            ", ReservedStock=" + ReservedStock +
            ", ShippedStock=" + ShippedStock +
            '}';
    }
}
