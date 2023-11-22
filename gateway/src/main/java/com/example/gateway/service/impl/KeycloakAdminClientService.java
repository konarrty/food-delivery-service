package com.example.gateway.service.impl;

import com.example.gateway.config.KeycloakProvider;
import com.example.gateway.model.User;
import jakarta.ws.rs.core.Response;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service
public class KeycloakAdminClientService {
    @Value("${keycloak.realm}")
    public String realm;

    private final KeycloakProvider kcProvider;

    public KeycloakAdminClientService(KeycloakProvider keycloakProvider) {
        this.kcProvider = keycloakProvider;
    }

    public Response createKeycloakUser(User userDto) {
        UsersResource usersResource = kcProvider.getInstance("admin", "admin").realm("food-delivery-realm").users();
        CredentialRepresentation credentialRepresentation = createPasswordCredentials(userDto.getPassword());

        UserRepresentation user = new UserRepresentation();
        user.setUsername(userDto.getUsername());
        user.setFirstName("afrergf");
        user.setLastName("awertrergfe");
        user.setEmail("samkdwjnebhrwnfmkeqwljnh");
        user.setCredentials(Collections.singletonList(credentialRepresentation));
        user.setEnabled(true);

        Response response = usersResource.create(user);

        if (response.getStatus() == 201) {
            //If you want to save the user to your other database, do it here, for example:
//            User localUser = new User();
//            localUser.setFirstName(kcUser.getFirstName());
//            localUser.setLastName(kcUser.getLastName());
//            localUser.setEmail(user.getEmail());
//            localUser.setCreatedDate(Timestamp.from(Instant.now()));
//            String userId = response.getLocation().getPath().replaceAll(".*/([^/]+)$", "$1");
//            usersResource.get(userId).sendVerifyEmail();
//            userRepository.save(localUser);
        }

        return response;

    }

    private static CredentialRepresentation createPasswordCredentials(String password) {
        CredentialRepresentation passwordCredentials = new CredentialRepresentation();
        passwordCredentials.setTemporary(false);
        passwordCredentials.setType(CredentialRepresentation.PASSWORD);
        passwordCredentials.setValue(password);
        return passwordCredentials;
    }


}