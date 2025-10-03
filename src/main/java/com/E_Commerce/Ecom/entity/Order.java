package com.E_Commerce.Ecom.entity;

import com.E_Commerce.Ecom.dto.CartItemsDto;
import com.E_Commerce.Ecom.dto.OrderDto;
import com.E_Commerce.Ecom.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderDescription;

    private OrderStatus orderStatus;

    private Date date;

    private  String address;

    private String paymentMethod;

    private String phone;

    private Long amount;

    private Long totalAmount;

    private Long discount;

    private UUID trackingId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "coupon_id", referencedColumnName = "id")
    private Coupon coupon;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
    private List<CartItems> cartItems;

    public OrderDto getOrderDto(){
        OrderDto orderDto = new OrderDto();
        orderDto.setId(id);
        orderDto.setOrderDescription(orderDescription);
        orderDto.setOrderStatus(orderStatus);
        orderDto.setDate(date);
        orderDto.setAddress(address);
        orderDto.setPhone(phone);
        orderDto.setAmount(amount);
        orderDto.setDiscount(discount);
        orderDto.setTrackingId(trackingId);
        orderDto.setUserName(user.getName());
        if(coupon != null){
            orderDto.setCouponName(coupon.getName());
        }

        return orderDto;

    }




}
