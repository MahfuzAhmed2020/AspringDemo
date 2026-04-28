// package com.example.AspringDemo.controller;

// import java.util.HashMap;
// import java.util.Map;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// @RequestMapping("/api")
// public class HelloController {
// //localhost:8080/api/hello
//     @GetMapping("/hello")
//     public String hello() {
//         return "Hello, World! Welcome to AspringDemo.";
//     }
// // https://www.youtube.com/watch?v=EkhRs_PbWeE&list=LL&index=10
// //localhost:8080/api/helloJson
// //https://aspringdemo-1777413221940.azurewebsites.net/api/helloJson
//         @GetMapping("/helloJson")
//     public Map<String, String> helloJson() {
//         Map<String, String> response = new HashMap<>();
//         response.put("message", "Hello, World! Welcome to AspringDemo.");
//         response.put("timestamp", String.valueOf(System.currentTimeMillis()));
//         return response;
//     }
// }


package com.example.AspringDemo.controller;

import java.util.*;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

//localhost:8080/api/hello
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World! Welcome to AspringDemo.";
    }
// https://www.youtube.com/watch?v=EkhRs_PbWeE&list=LL&index=10
//localhost:8080/api/helloJson
//https://aspringdemo-1777413221940.azurewebsites.net/api/users/helloJson
        @GetMapping("/helloJson")
    public Map<String, String> helloJson() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, World! Welcome to AspringDemo.");
        response.put("timestamp", String.valueOf(System.currentTimeMillis()));
        return response;
    }






    // Fake DB (in-memory storage)
    private Map<Integer, User> users = new HashMap<>();
    private int currentId = 1;

    // ========================
    // CREATE
    // ========================
    /*curl --location 'https://aspringdemo-1777413221940.azurewebsites.net/api/users' \
--header 'Content-Type: application/json' \
--header 'Cookie: ARRAffinity=d742cc0af045e3ea5ed456765da5f70e4ca9f1fd3bb3d6f038b7858d3425f7e3; ARRAffinitySameSite=d742cc0af045e3ea5ed456765da5f70e4ca9f1fd3bb3d6f038b7858d3425f7e3' \
--data-raw '{
  "name": "RANDOM",
  "email": "RANDOM@gmail.com"
}'V */
    @PostMapping
    public User createUser(@RequestBody User user) {
        user.setId(currentId);
        users.put(currentId, user);
        currentId++;
        return user;
    }

    // ========================
    // READ ALL
    // ========================
    //https://aspringdemo-1777413221940.azurewebsites.net/api/users

    /*curl --location --request GET 'https://aspringdemo-1777413221940.azurewebsites.net/api/users' \
--header 'Content-Type: text/plain' \
--header 'Cookie: ARRAffinity=d742cc0af045e3ea5ed456765da5f70e4ca9f1fd3bb3d6f038b7858d3425f7e3; ARRAffinitySameSite=d742cc0af045e3ea5ed456765da5f70e4ca9f1fd3bb3d6f038b7858d3425f7e3' \
--data-raw '{
  "name": "Mahfuz",
  "email": "mahfuz@gmail.com"
}' */
    @GetMapping
    public Collection<User> getAllUsers() {
        return users.values();
    }

    // ========================
    // READ BY ID
    // ========================
    //https://aspringdemo-1777413221940.azurewebsites.net/api/users/1
    /*curl --location --request GET 'https://aspringdemo-1777413221940.azurewebsites.net/api/users/1' \
--header 'Content-Type: text/plain' \
--header 'Cookie: ARRAffinity=d742cc0af045e3ea5ed456765da5f70e4ca9f1fd3bb3d6f038b7858d3425f7e3; ARRAffinitySameSite=d742cc0af045e3ea5ed456765da5f70e4ca9f1fd3bb3d6f038b7858d3425f7e3' \
--data-raw '{
  "name": "Mahfuz",
  "email": "mahfuz@gmail.com"
}' */
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return users.get(id);
    }

    // ========================
    // UPDATE
    // ========================
    /*curl --location --request PUT 'https://aspringdemo-1777413221940.azurewebsites.net/api/users/4' \
--header 'Content-Type: application/json' \
--header 'Cookie: ARRAffinity=d742cc0af045e3ea5ed456765da5f70e4ca9f1fd3bb3d6f038b7858d3425f7e3; ARRAffinitySameSite=d742cc0af045e3ea5ed456765da5f70e4ca9f1fd3bb3d6f038b7858d3425f7e3' \
--data-raw '{
  "name": "UPDATED Mahfuz",
  "email": "mahfuz@gmail.com"
}' */
    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        if (users.containsKey(id)) {
            user.setId(id);
            users.put(id, user);
            return user;
        }
        return null;
    }

    // ========================
    // DELETE
    // ========================
    /*curl --location --request DELETE 'https://aspringdemo-1777413221940.azurewebsites.net/api/users/4' \
--header 'Content-Type: text/plain' \
--header 'Cookie: ARRAffinity=d742cc0af045e3ea5ed456765da5f70e4ca9f1fd3bb3d6f038b7858d3425f7e3; ARRAffinitySameSite=d742cc0af045e3ea5ed456765da5f70e4ca9f1fd3bb3d6f038b7858d3425f7e3' \
--data-raw '{
  "name": "UPDATED Mahfuz",
  "email": "mahfuz@gmail.com"
}' */
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        users.remove(id);
        return "User deleted with id: " + id;
    }
}