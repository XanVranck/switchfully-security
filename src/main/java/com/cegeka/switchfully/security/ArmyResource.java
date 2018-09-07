package com.cegeka.switchfully.security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = ArmyResource.ARMY_RESOURCE_PATH)
public class ArmyResource {

    public static final String ARMY_RESOURCE_PATH = "/armies";

    @RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE ,path = "/{country}")
    @PreAuthorize("hasAnyRole('PRIVATE', 'GENERAL')")
    public ArmyInfoDto getDeployedArmyInfo(@PathVariable(value = "country") String country){
        return ArmyInfoDto.armyInfoDto()
                .withCountry(country)
                .withNumberOfTroops(2000)
                .withxCoordinateOfBase(15)
                .withyCoordinateOfBase(20);
    }

    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize("hasRole('CIVILIAN')")
    public void joinArmy(){
        //TODO
    }

    @RequestMapping(method = RequestMethod.POST, path = "/promote/{name}")
    @PreAuthorize("hasRole('HUMAN_RELATIONSHIPS')")
    public void promotePrivate(@PathVariable(value = "name") String name){
        //TODO
    }

    @RequestMapping(method = RequestMethod.POST, path = "/discharge/{name}")
    @PreAuthorize("hasRole('HUMAN_RELATIONSHIPS')")
    public void dischargeSoldier(@PathVariable(value = "name") String name){
        //TODO
    }

    @RequestMapping(method = RequestMethod.GET, path = "/nuke")
    @PreAuthorize("hasRole('GENERAL')")
    public String launchNukes(){
        return "The world ends. Not with a bang but a whimper";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/tanks")
    @PreAuthorize("hasAnyRole('GENERAL', 'PRIVATE', 'CIVILIAN')")
    public String getTanksInfo(){
        return "all tanks";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/tanks")
    @PreAuthorize("hasAnyRole('PRIVATE')")
    public void addTanks(){
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/tanks")
    @PreAuthorize("hasAnyRole('GENERAL')")
    public void blowUpTanksAndEnjoyTheFireworks(){
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/tanks")
    @PreAuthorize("hasAnyRole('GENERAL', 'PRIVATE')")
    public void addNewTanks(){
    }
}
