package com.openhospital.ecommerce.services;

import com.openhospital.ecommerce.beans.cart.Cart;
import com.openhospital.ecommerce.beans.cart.ProductCart;
import com.openhospital.ecommerce.beans.requestbody.PayInput;
import com.openhospital.ecommerce.beans.user.UserProfile;
import com.openhospital.ecommerce.constants.OrderStatus;
import com.openhospital.ecommerce.entities.Product;
import com.openhospital.ecommerce.entities.Purchase;
import com.openhospital.ecommerce.entities.Userdata;
import com.openhospital.ecommerce.repositories.ProductRepository;
import com.openhospital.ecommerce.repositories.PurchaseRepository;
import com.openhospital.ecommerce.repositories.UserdataRepository;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
@Configuration
@Service
public class EcommerceService {

	@Autowired
	UserdataRepository userdataRepository;

	@Autowired
	PurchaseRepository purchaseRepository;

	@Autowired
	ProductRepository productRepository;

	public Purchase insertOrder(UserProfile userProfile, Cart cart, PayInput payInput) {

		Purchase purchase = insertPurchase(cart, payInput);
		insertUserdata(userProfile, purchase);
		insertProducts(cart, purchase);

		return purchase;
	}

	public Purchase insertPurchase (Cart cart, PayInput payInput) {
		Integer purchaseId = purchaseRepository.getNextValSequence();

		Purchase purchase = new Purchase();

		purchase.setId(purchaseId);
		purchase.setPrice(cart.getTotal());
		purchase.setNote(payInput.getMessage().isBlank() ? null : payInput.getMessage());
		purchase.setPaymentMethod(payInput.getPaymentMethod());
		purchase.setStatus(OrderStatus.INITIALIZED.getCode());
		purchase.setInsertTimestamp(Instant.now());
		purchase.setUpdateTimestamp(Instant.now());

		purchaseRepository.save(purchase);
		purchaseRepository.flush();

		return purchase;
	}

	public void insertUserdata (UserProfile userProfile, Purchase purchase) {
		Integer userId = userdataRepository.getNextValSequence();

		Userdata userdata = new Userdata();

		userdata.setId(userId);
		userdata.setUserId(userProfile.getId());
		userdata.setName(userProfile.getName());
		userdata.setSurname(userProfile.getSurname());
		userdata.setTaxCode(userProfile.getTaxCode());
		userdata.setPhone(userProfile.getPhone());
		userdata.setCountry(userProfile.getCountry());
		userdata.setCity(userProfile.getCity());
		userdata.setProvince(userProfile.getProvince());
		userdata.setAddress(userProfile.getAddress());
		userdata.setAddressNumber(userProfile.getAddressNumber());
		userdata.setEmail(userProfile.getEmail());
		userdata.setPostCode(userProfile.getPostCode());
		userdata.setConsent1(userProfile.getConsent1());
		userdata.setConsent2(userProfile.getConsent2());
		userdata.setConsent3(userProfile.getConsent3());
		userdata.setInsertTimestamp(Instant.now());
		userdata.setUpdateTimestamp(Instant.now());
		userdata.setPurchase(purchase);

		userdataRepository.save(userdata);
		userdataRepository.flush();
	}

	public void insertProducts (Cart cart, Purchase purchase) {
		ArrayList<ProductCart> productsInCart = cart.getElements();
		for (ProductCart productCart : productsInCart) {
			Integer productId = productRepository.getNextValSequence();

			Product product = new Product();

			product.setId(productId);
			product.setPurchase(purchase);
			product.setProductType(productCart.getProductType());
			product.setProductCode(productCart.getProductCode());
			product.setProductDescription(productCart.getProductDescription());
			product.setCheckIn(productCart.getCheckIn());
			product.setPrice(productCart.getPrice());
			product.setProposalId(productCart.getProductProposalId().intValue());
			product.setReservationId(null); //reservation id is not available when the order is initialized
			product.setInsertTimestamp(Instant.now());
			product.setUpdateTimestamp(Instant.now());

			productRepository.save(product);
			productRepository.flush();
		}
	}


	public void updateOrder(Cart cart, Purchase purchase, OrderStatus orderStatus) {

		updatePurchase(purchase, orderStatus);
		//updateUserdata(userProfile, purchase);
		updateProducts(cart, purchase);
	}

	public void updatePurchase (Purchase purchase, OrderStatus orderStatus) {
		if (purchase.getPnr() == null && orderStatus.equals(OrderStatus.BOUGHT)) {
			do {
				String pnr = RandomStringUtils.random(10, true, true).toUpperCase();
				List<Purchase> purchaseList = purchaseRepository.findByPnr(pnr);

				if (purchaseList == null || purchaseList.isEmpty()) {
					purchase.setPnr(pnr);
				}
			} while(purchase.getPnr() == null);
		}

		purchase.setStatus(orderStatus.getCode());
		purchase.setUpdateTimestamp(Instant.now());

		purchaseRepository.save(purchase);
		purchaseRepository.flush();
	}

	public void updateProducts (Cart cart, Purchase purchase) {
		ArrayList<ProductCart> productsInCart = cart.getElements();
		for (ProductCart productCart : productsInCart) {
			List<Product> products = productRepository.findByPurchaseAndProposalId(purchase, productCart.getProductProposalId().intValue());

			if (products != null && !products.isEmpty()) {
				Product product = products.get(0);

				if (product.getReservationId() == null) {
					product.setReservationId(productCart.getReservationId().intValue());
				}

				product.setUpdateTimestamp(Instant.now());

				productRepository.save(product);
				productRepository.flush();
			}
		}
	}

	public Optional<Purchase> getPurchaseFromIdAndPnr (Integer purchaseOrderId, String pnr) {
		return purchaseRepository.findByIdAndPnr(purchaseOrderId, pnr);
	}

	public List<Userdata> getUserdataFromPurchase (Purchase purchase) {
		return userdataRepository.findByPurchase(purchase);
	}

	public List<Product> getProductFromPurchase (Purchase purchase) {
		return productRepository.findByPurchase(purchase);
	}

	public List<Purchase> getPurchaseFromUserId (Integer userId) {
		return purchaseRepository.getPurchasesByUserId(userId);
	}

}
