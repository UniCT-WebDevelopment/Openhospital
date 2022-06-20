package com.openhospital.ecommerce.beans.cart;

import com.openhospital.ecommerce.utils.DateUtils;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@ToString
@Data
public class ProductCart implements Serializable {

    private static final long serialVersionUID = 9175043266960607063L;
    protected long id;
    protected BigDecimal productProposalId;
    private Instant checkIn;
    protected BigDecimal price;
    protected int quantity;
    protected BigDecimal maxQuantity;
    protected String productType;
    protected String productCode;
    protected String productDescription;
    protected BigDecimal reservationId;
    protected BigDecimal orderId;
    private Instant purchaseTime;

}
