package com.ecom.order.service;

import aj.org.objectweb.asm.commons.Remapper;
import com.ecom.order.dto.OrderResponse;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    OrderResponse createOrder(String userId);
}
