package com.cegeka.switchfully.security.external.authentication;

import com.cegeka.switchfully.security.authorization.Role;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Service
public class FakeAuthenticationService {

    private List<ExternalAuthenticaton> externalAuthenticatons = newArrayList(
            ExternalAuthenticaton.externalAuthenticaton().withUsername("ZWANETTA").withPassword("WORST").withRoles(newArrayList(Role.CIVILIAN.name())),
            ExternalAuthenticaton.externalAuthenticaton().withUsername("JMILLER").withPassword("THANKS").withRoles(newArrayList(Role.PRIVATE.name())),
            ExternalAuthenticaton.externalAuthenticaton().withUsername("UNCLE").withPassword("SAM").withRoles(newArrayList(Role.HUMAN_RELATIONSHIPS.name())),
            ExternalAuthenticaton.externalAuthenticaton().withUsername("GENNY").withPassword("RALLY").withRoles(newArrayList(Role.GENERAL.name()))
    );

    public ExternalAuthenticaton getUser(String username, String password) {
        return externalAuthenticatons.stream()
                .filter(externalAuthenticaton -> externalAuthenticaton.getUsername().equals(username))
                .filter(externalAuthenticaton -> externalAuthenticaton.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }
}
