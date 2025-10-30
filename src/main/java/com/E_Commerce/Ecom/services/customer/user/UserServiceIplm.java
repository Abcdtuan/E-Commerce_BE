package com.E_Commerce.Ecom.services.customer.user;

import com.E_Commerce.Ecom.dto.ChangePasswordRequest;
import com.E_Commerce.Ecom.dto.UserDto;
import com.E_Commerce.Ecom.entity.User;
import com.E_Commerce.Ecom.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceIplm implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserDto getUserById(Long id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            UserDto userDto = new UserDto();
            userDto.setName(user.get().getName());
            userDto.setEmail(user.get().getEmail());
            return userDto;
        }
        return null;
    }

    public UserDto changePassword(ChangePasswordRequest request) {
        Optional<User> optionalUser = userRepository.findById(request.getUserId());

        if (optionalUser.isEmpty()) {
            throw new RuntimeException("Không tìm thấy người dùng");
        }

        User user = optionalUser.get();

        if (!passwordEncoder.matches(request.getOldPassword(), user.getPassword())) {
            throw new RuntimeException("Mật khẩu cũ không chính xác");
        }

        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        userRepository.save(user);

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());

        return userDto;
    }
}
