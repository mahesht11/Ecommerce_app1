package com.ecom.order.service;

import com.ecom.order.dto.CartItemRequest;
import com.ecom.order.entity.CartItem;
import com.ecom.order.repository.CartItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{

    private final CartItemRepository cartItemRepository;

    @Override
    public boolean addToCart(String userId, CartItemRequest request) {
        return false;
    }

    @Override
    public boolean deleteItemFromCart(String userId, String productId) {
        CartItem cartItem = cartItemRepository.findByUserIdAndProductId(userId, productId);

        if (cartItem != null){
            cartItemRepository.delete(cartItem);
            return true;
        }
        return false;
    }

    @Override
    public List<CartItem> getCart(String userId) {
        return cartItemRepository.findByUserId(userId);
    }
}
