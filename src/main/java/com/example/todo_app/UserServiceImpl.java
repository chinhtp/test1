package com.example.todo_app;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserServiceImpl implements UserService {

    // Tạm dùng List trong RAM. Sau này thay bằng Repository (DB).
    private final List<User> users = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User getById(Long id) {
        return users.stream()
            .filter(u -> u.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> new UserNotFoundException("User id=" + id + " không tồn tại"));
    }

    @Override
    public User create(User user) {
        user.setId(counter.incrementAndGet());
        users.add(user);
        return user;
    }

    @Override
    public User update(Long id, User user) {
        User existing = getById(id);  // tự throw nếu không có
        existing.setName(user.getName());
        existing.setEmail(user.getEmail());
        return existing;
    }

    @Override
    public void delete(Long id) {
        getById(id);  // tự throw nếu không có
        users.removeIf(u -> u.getId().equals(id));
    }
}