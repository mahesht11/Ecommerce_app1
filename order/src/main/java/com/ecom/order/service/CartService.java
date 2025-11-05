package com.ecom.order.service;

import com.ecom.order.dto.CartItemRequest;
import com.ecom.order.entity.CartItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {

    boolean addToCart(String userId, CartItemRequest request);

    boolean deleteItemFromCart(String userId, String productId);

    List<CartItem> getCart(String userId);
}
