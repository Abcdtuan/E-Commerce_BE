package com.E_Commerce.Ecom.services.auth;

import com.E_Commerce.Ecom.dto.SignupRequest;
import com.E_Commerce.Ecom.dto.UserDto;
import com.E_Commerce.Ecom.entity.Order;
import com.E_Commerce.Ecom.entity.User;
import com.E_Commerce.Ecom.enums.OrderStatus;
import com.E_Commerce.Ecom.enums.UserRole;
import com.E_Commerce.Ecom.repository.OrderRepository;
import com.E_Commerce.Ecom.repository.UserRepository;
import jakarta.annotation.PostConstruct;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class AuthServiceIplm implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final OrderRepository orderRepository;

    public AuthServiceIplm(UserRepository userRepository, PasswordEncoder passwordEncoder, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.orderRepository = orderRepository;
    }

    public UserDto createUser(SignupRequest signupRequest){

        User user = new User();
        user.setName(signupRequest.getName());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        user.setRole(UserRole.CUSTOMER);
        User createdUser = userRepository.save(user);


        Order order = new Order();
        order.setAmount(0L);
        order.setTotalAmount(0L);
        order.setDiscount(0L);
        order.setUser(createdUser);
        order.setOrderStatus(OrderStatus.PENDING);

        orderRepository.save(order);


        UserDto userDto = new UserDto();
        userDto.setId(createdUser.getId());


        return userDto;

    }

    @Override
    public boolean hasUserWithEmail(String email) {
        return userRepository.findFirstByEmail(email).isPresent();
    }

    @PostConstruct
    public void createAdmin(){
        User adminaccount =userRepository.findByRole(UserRole.ADMIN);
        if(null == adminaccount){
            User user = new User();
            user.setEmail("admin@gmail.com");
            user.setName("admin");
            user.setPassword(passwordEncoder.encode("admin"));
            user.setRole(UserRole.ADMIN);
            userRepository.save(user);
        }
    }
}
