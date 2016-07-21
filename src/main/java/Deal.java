import java.math.BigDecimal;

class Deal {
    private BigDecimal purchasePrice;
    private BigDecimal sellingPrice;

    Deal(BigDecimal purchasePrice, BigDecimal sellingPrice) {
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
    }

    BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    BigDecimal gain() {
        return sellingPrice.subtract(purchasePrice);
    }
}
