package com.cegeka.switchfully.security.authorization;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.*;

public enum Feature {
    ARMY_INFO(Role.GENERAL, Role.PRIVATE),
    JOIN_ARMY(Role.CIVILIAN),
    PROMOTE_PRIVATE(Role.HUMAN_RELATIONSHIPS),
    DISCHARGE_SOLDIER(Role.HUMAN_RELATIONSHIPS),
    NUKE_M_ALL(Role.GENERAL);

    private Collection<Role> roles;

    Feature(Role ... role) {
        this.roles = asList(role);
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public static Collection<Feature> getFeaturesFor(String role) {
        return Arrays.stream(Feature.values())
                .filter(feature ->
                        feature.getRoles()
                                .stream()
                                .anyMatch(r -> r.name().equals(role)))
                .collect(toList());
    }
}
