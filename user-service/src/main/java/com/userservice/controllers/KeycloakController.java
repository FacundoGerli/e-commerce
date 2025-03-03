package com.userservice.controllers;

import com.userservice.dto.UserDTO;
import com.userservice.service.IKeycloakUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/keycloak/user")
public class KeycloakController {
    @Autowired
    private IKeycloakUserService keycloakService;

    //-1 Crear usuario
    @PreAuthorize("permitAll()")
    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserDTO request) {
        String response = keycloakService.createUser(request);
        return ResponseEntity.ok(response);

    }
    //-2 Buscar usuario
    @GetMapping("/find/{userId}")
    public ResponseEntity<?> searchUserByUsername(@PathVariable String userId) {
        return ResponseEntity.ok(keycloakService.findUsersByUsername(userId));
    }

    //-3 Buscar todos
    @GetMapping("/findAll")
    public ResponseEntity<?> findAllUsers() {
        return ResponseEntity.ok(keycloakService.findAllUsers());
    }

    //-4 Eliminar usuario
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable String userId) {
        keycloakService.deleteUserByID(userId);
        return ResponseEntity.noContent().build();
    }
}
