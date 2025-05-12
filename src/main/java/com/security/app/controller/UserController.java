package com.security.app.controller;

import com.security.app.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    private final Map<Integer, UserDTO> users = new HashMap<>();

    public UserController() {
        users.put(1, new UserDTO(1, "nithin28", "nithinu2810@gmail.com", "123"));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(new ArrayList<>(users.values()));
    }

    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO) {
        if (users.containsKey(userDTO.getId())) {
            return ResponseEntity.badRequest().body("User with this ID already exists");
        }
        users.put(userDTO.getId(), userDTO);
        return ResponseEntity.ok("User Created Successfully");
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id) {
        UserDTO user = users.get(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Integer id, @RequestBody UserDTO userDTO) {
        if (!users.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }
        users.put(id, userDTO);
        return ResponseEntity.ok("User Updated Successfully");
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        if (users.remove(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("User Deleted Successfully");
    }
}
