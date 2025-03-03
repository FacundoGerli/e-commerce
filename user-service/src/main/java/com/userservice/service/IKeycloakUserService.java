package com.userservice.service;

import com.userservice.dto.UserDTO;
import org.keycloak.representations.idm.UserRepresentation;

import java.util.List;

public interface IKeycloakUserService {
    List<UserRepresentation> findAllUsers();
    List<UserRepresentation> findUsersByUsername(String name);
    String createUser(UserDTO request);
    void deleteUserByID(String userId);
    void updateUser(String userId,UserDTO request);
}
