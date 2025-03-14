package com.userservice.keycloak;

import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientBuilderImpl;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;

public class KeycloakProvider {
    private static final String SERVER_URL = "http://localhost:9090";
    private static final String REALM_NAME = "ecommerce-realm-dev";
    private static final String REALM_MASTER = "master";
    private static final String ADMIN_CLI = "admin-cli";
    //  @Value("${keycloak.username}")
    private static final String USER_CONSOLE = "admin";
    //@Value("${keycloak.password}")
    private static final String USER_PASSWORD = "admin";
    //@Value("${jwt.auth.secret-key}")
    private static final String CLIENT_SECRET = "vCDfIFBLVX7pA6wWa2sQlvyQX3u2a2B8";

    public static RealmResource getRealmResource (){
        Keycloak keycloak = KeycloakBuilder.builder()
                .realm(REALM_MASTER)
                .serverUrl(SERVER_URL)
                .clientId(ADMIN_CLI)
                .username(USER_CONSOLE)
                .password(USER_PASSWORD)
                .clientSecret(CLIENT_SECRET)
                .resteasyClient(new ResteasyClientBuilderImpl()
                        .connectionPoolSize(10)
                        .build())
                .build();
        return keycloak.realm(REALM_NAME);
    }

    public static UsersResource getUsersResource(){
        RealmResource realmResource = getRealmResource();
        return realmResource.users();
    }
}
