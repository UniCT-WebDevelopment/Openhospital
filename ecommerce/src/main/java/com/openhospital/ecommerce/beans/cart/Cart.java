package com.openhospital.ecommerce.beans.cart;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

@Data
public class Cart implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -5367766395251501447L;
    private ArrayList<ProductCart> elements;
    protected String payment_type;
    protected String cartType;

    public Cart() {
        elements = new ArrayList<>();
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.valueOf(0);
        for (ProductCart productCart : elements) {
            total = total.add(productCart.getPrice());
        }

        return total;
    }

    public int getTotalElements() {
        return elements.size();
    }

    public ProductCart getProductCartByProposalId(BigDecimal proposalId) {
        return elements.stream().filter(tempProductCart -> proposalId.equals(tempProductCart.getProductProposalId())).findFirst().orElse(null);
    }

}
