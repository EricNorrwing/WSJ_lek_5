package com.ericnorrwing.wsj_lek_5.controller;

import com.ericnorrwing.wsj_lek_5.model.User;
import org.apache.coyote.Request;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    private final List<User> userList= new ArrayList<>(
            List.of(
                    new User(0, "Benny", "123"),
                    new User(1, "Frida", "456")
            )
            );

    @GetMapping("/user")
    public ResponseEntity<List<User>> getUsers() {

        return ResponseEntity.ok(userList);
    }

    @PostMapping("/createUser/{name}")
    public ResponseEntity<User> createUser(@PathVariable String name) {
        User user = new User(userList.size(), name, "");
        userList.add(user);
        return ResponseEntity.status(201).body(user);
    }

    @DeleteMapping("/removeUser/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable int id) {

        if (id > userList.size() || id < 0) {
            return ResponseEntity.status(204).build();
        }

        User user = userList.get(id);

        userList.remove(id);
        return ResponseEntity.ok(user);
    }

}
