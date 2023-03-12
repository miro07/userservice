package userservice.entities.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class ProductDto {



    private Long productId;

    private LocalDateTime publishDate;

    private LocalDate modelDate;

    private BigDecimal rentCost;

    private BigDecimal price;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDateTime publishDate) {
        this.publishDate = publishDate;
    }

    public LocalDate getModelDate() {
        return modelDate;
    }

    public void setModelDate(LocalDate modelDate) {
        this.modelDate = modelDate;
    }

    public BigDecimal getRentCost() {
        return rentCost;
    }

    public void setRentCost(BigDecimal rentCost) {
        this.rentCost = rentCost;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }



}
