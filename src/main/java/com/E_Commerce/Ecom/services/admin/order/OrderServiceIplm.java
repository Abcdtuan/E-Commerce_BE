package com.E_Commerce.Ecom.services.admin.order;

import com.E_Commerce.Ecom.dto.AnalyticResponse;
import com.E_Commerce.Ecom.dto.OrderDto;
import com.E_Commerce.Ecom.entity.Order;
import com.E_Commerce.Ecom.enums.OrderStatus;
import com.E_Commerce.Ecom.repository.OrderRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service("adminOrderService")
@RequiredArgsConstructor

public class OrderServiceIplm implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public List<OrderDto> getAllOrders(){
        List<Order> orderList = orderRepository.findAllByOrderStatusIn(List.of(OrderStatus.PLACED, OrderStatus.SHIPPED, OrderStatus.DELIVERED));

        return orderList.stream().map(Order::getOrderDto).collect(Collectors.toList());
    }

    @Override
    public OrderDto changeOrderStatus(Long id, String status) {
         Optional<Order> optionalOrder = orderRepository.findById(id);
         if(optionalOrder.isPresent()) {
             Order order = optionalOrder.get();
             if(Objects.equals(status, "Shipped")) {
                 order.setOrderStatus(OrderStatus.SHIPPED);
             } else if (Objects.equals(status, "Delivered")) {
                 order.setOrderStatus(OrderStatus.DELIVERED);
             }
             return orderRepository.save(order).getOrderDto();
         }
         return null;
    }

    public AnalyticResponse calculateAnalytic() {

        LocalDate currentDate = LocalDate.now();
        LocalDate previousMonthDate = currentDate.minusMonths(1);

        Long currentMonthOrders = getTotalOrdersForMonth(currentDate.getMonthValue(), currentDate.getYear());
        Long previousMonthOrders = getTotalOrdersForMonth(previousMonthDate.getMonthValue(), previousMonthDate.getYear());

        Long currentMonthEarnings = getTotalEarningsForMonth(currentDate.getMonthValue(), currentDate.getYear());
        Long previousMonthEarnings = getTotalEarningsForMonth(previousMonthDate.getMonthValue(), previousMonthDate.getYear());

        Long placed = orderRepository.countByOrderStatus(OrderStatus.PLACED);
        Long shipped = orderRepository.countByOrderStatus(OrderStatus.SHIPPED);
        Long delivered = orderRepository.countByOrderStatus(OrderStatus.DELIVERED);

        return new AnalyticResponse(placed, shipped, delivered, currentMonthOrders, previousMonthOrders, currentMonthEarnings, previousMonthEarnings);
    }

    public Long getTotalOrdersForMonth(int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        Date startOfMonth = calendar.getTime();

        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);

        Date endOfMonth = calendar.getTime();

        List<Order> orders = orderRepository.findByDateBetweenAndOrderStatus(startOfMonth, endOfMonth, OrderStatus.DELIVERED);

        return (long) orders.size();
    }
    public Long getTotalEarningsForMonth(int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        Date startOfMonth = calendar.getTime();

        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);

        Date endOfMonth = calendar.getTime();

        List<Order> orders = orderRepository.findByDateBetweenAndOrderStatus(startOfMonth, endOfMonth, OrderStatus.DELIVERED);

        Long sum = 0L;
        for (Order order : orders) {
            sum += order.getAmount();
        }
        return sum;
    }
}
