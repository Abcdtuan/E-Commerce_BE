package com.E_Commerce.Ecom.services.customer.cart;

import com.E_Commerce.Ecom.dto.AddProductInCartDto;
import com.E_Commerce.Ecom.dto.CartItemsDto;
import com.E_Commerce.Ecom.dto.OrderDto;
import com.E_Commerce.Ecom.entity.CartItems;
import com.E_Commerce.Ecom.entity.Order;
import com.E_Commerce.Ecom.entity.Product;
import com.E_Commerce.Ecom.entity.User;
import com.E_Commerce.Ecom.enums.OrderStatus;
import com.E_Commerce.Ecom.repository.CartItemRepository;
import com.E_Commerce.Ecom.repository.OrderRepository;
import com.E_Commerce.Ecom.repository.ProductRepository;
import com.E_Commerce.Ecom.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartServiceIplm implements CartService {

    private final OrderRepository orderRepository;

    private final CartItemRepository cartItemRepository;

    private final UserRepository userRepository;

    private final ProductRepository productRepository;



    public ResponseEntity<?> addProductsToCart(AddProductInCartDto addProductInCartDto) {

        Order activeOrder = orderRepository.findByUserIdAndOrderStatus(addProductInCartDto.getUserId(), OrderStatus.PENDING);

        if (activeOrder == null) {
            Optional<User> optionalUser = userRepository.findById(addProductInCartDto.getUserId());
            if (optionalUser.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            }
            activeOrder = new Order();
            activeOrder.setUser(optionalUser.get());
            activeOrder.setOrderStatus(OrderStatus.PENDING);
            activeOrder.setAmount(0L);
            activeOrder.setTotalAmount(0L);
            activeOrder.setDiscount(0L);
            activeOrder.setCartItems(new ArrayList<>());

            activeOrder = orderRepository.save(activeOrder);
        }

        Optional<CartItems> cartItems = cartItemRepository.findByProductIdAndUserIdAndOrderId(
                addProductInCartDto.getProductId(),
                addProductInCartDto.getUserId(),
                activeOrder.getId()
        );

        if (cartItems.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Product already in cart");
        }

        Optional<Product> optionalProduct = productRepository.findById(addProductInCartDto.getProductId());
        if (optionalProduct.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }

        CartItems cartItems1 = new CartItems();
        cartItems1.setProduct(optionalProduct.get());
        cartItems1.setPrice(optionalProduct.get().getPrice());
        cartItems1.setQuantity(1L);
        cartItems1.setUser(activeOrder.getUser());
        cartItems1.setOrder(activeOrder);

        cartItemRepository.save(cartItems1);

        activeOrder.setTotalAmount(activeOrder.getTotalAmount() + cartItems1.getPrice());
        activeOrder.setAmount(activeOrder.getAmount() + cartItems1.getPrice());
        activeOrder.getCartItems().add(cartItems1);
        orderRepository.save(activeOrder);

        return ResponseEntity.status(HttpStatus.CREATED).body(cartItems1);
    }

    public OrderDto getCartByUserId(Long userId) {
        Order activeOrder = orderRepository.findByUserIdAndOrderStatus(userId, OrderStatus.PENDING);
        List<CartItemsDto> cartItems = activeOrder.getCartItems().stream().map(CartItems::getCartDto).collect(Collectors.toList());
        OrderDto orderDto = new OrderDto();
        orderDto.setId(activeOrder.getId());
        orderDto.setAmount(activeOrder.getAmount());
        orderDto.setDiscount(activeOrder.getDiscount());
        orderDto.setOrderStatus(activeOrder.getOrderStatus());
        orderDto.setTotalAmount(activeOrder.getTotalAmount());
        orderDto.setCartItems(cartItems);

        return orderDto;
    }



}
