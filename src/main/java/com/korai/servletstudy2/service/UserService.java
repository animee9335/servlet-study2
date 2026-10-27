package com.korai.servletstudy2.service;

import com.korai.servletstudy2.exception.DuplicatedException;
import com.korai.servletstudy2.model.User;
import com.korai.servletstudy2.repository.UserRepository;

import java.util.List;

public class UserService {
    private static UserService instance;
    private UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService(UserRepository.getInstance());
        }
        return instance;
    }

    public void register(User user) throws DuplicatedException {
        if (isDuplicateUsername(user.getUsername())) {
            throw new DuplicatedException("이미 존재하는 사용자이름입니다.");
        }
        userRepository.insert(user);
    }

    // 유저명 중복 검사
    public boolean isDuplicateUsername(String username) {
        return userRepository.findByUsername(username) != null;
    }

    // 복사된 리스트를 가져옴
    public List<User> getUserAll() {
        return userRepository.findAll();
    }

}
