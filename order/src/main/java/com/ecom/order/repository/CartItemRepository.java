package com.ecom.order.repository;

import com.ecom.order.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Long> {

    CartItem findByUserIdAndProductId(String userId, String productId);

    List<CartItem> findByUserId(String userId);
}
