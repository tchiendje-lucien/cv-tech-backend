package peoplelocation.peoplelocation.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import peoplelocation.peoplelocation.MessageReponse;
import peoplelocation.peoplelocation.entites.AcademicLevels;
import peoplelocation.peoplelocation.entites.Nationality;
import peoplelocation.peoplelocation.entites.Postes;
import peoplelocation.peoplelocation.entites.Rules;
import peoplelocation.peoplelocation.entites.Speciality;
import peoplelocation.peoplelocation.entites.Types;
import peoplelocation.peoplelocation.entites.Villes;
import peoplelocation.peoplelocation.services.interfaces.SettingServices;

@RestController
@CrossOrigin("*")
public class SettingController {
    @Autowired
    SettingServices settingServices;

    @PostMapping(value = "add_academyLevel")
    public MessageReponse add_academyLivel(@RequestBody AcademicLevels academicLevels) {
        return settingServices.create_academicLevel(academicLevels);
    }

    @GetMapping(value = "list_academyLevel")
    public List<AcademicLevels> list_academyLivel() {
        return settingServices.list_academicLevel();
    }

    @PutMapping(value = "update_academyLevel")
    public MessageReponse update_academyLivel(@RequestBody AcademicLevels academicLevels) {
        return settingServices.update_academicLevel(academicLevels);
    }

    @PostMapping(value = "add_nationality")
    public MessageReponse add_nationality(@RequestBody Nationality nationality) {
        return settingServices.create_nationality(nationality);
    }

    @PutMapping(value = "update_nationality")
    public MessageReponse update_nationality(@RequestBody Nationality nationality) {
        return settingServices.update_nationality(nationality);
    }

    @GetMapping(value = "list_nationality")
    public List<Nationality> list_nationality() {
        return settingServices.list_nationality();
    }

    @PostMapping(value = "add_poste")
    public MessageReponse add_poste(@RequestBody Postes postes) {
        return settingServices.create_poste(postes);
    }

    @PutMapping(value = "update_poste")
    public MessageReponse update_poste(@RequestBody Postes postes) {
        return settingServices.update_poste(postes);
    }

    @GetMapping(value = "list_poste")
    public List<Postes> list_poste() {
        return settingServices.list_poste();
    }

    @PostMapping(value = "add_speciality")
    public MessageReponse add_speciality(@RequestBody Speciality speciality) {
        return settingServices.create_speciality(speciality);
    }

    @PutMapping(value = "update_speciality")
    public MessageReponse update_speciality(@RequestBody Speciality speciality) {
        return settingServices.update_speciality(speciality);
    }

    @GetMapping(value = "list_speciality")
    public List<Speciality> list_speciality() {
        return settingServices.list_speciality();
    }

    @PostMapping(value = "add_type")
    public MessageReponse add_type(@RequestBody Types types) {
        return settingServices.create_type(types);
    }

    @PutMapping(value = "update_type")
    public MessageReponse update_type(@RequestBody Types types) {
        return settingServices.update_type(types);
    }

    @GetMapping(value = "list_type")
    public List<Types> list_type() {
        return settingServices.list_type();
    }

    @PostMapping(value = "add_ville")
    public MessageReponse add_ville(@RequestBody Villes villes) {
        return settingServices.create_ville(villes);
    }

    @PutMapping(value = "update_ville")
    public MessageReponse update_ville(@RequestBody Villes villes) {
        return settingServices.update_ville(villes);
    }

    @GetMapping(value = "list_ville")
    public List<Villes> list_ville() {
        return settingServices.list_ville();
    }

    @PostMapping(value = "add_rule")
    public MessageReponse add_rule(@RequestBody Rules rules) {
        return settingServices.create_rule(rules);
    }

    @PutMapping(value = "update_rule")
    public MessageReponse update_rule(@RequestBody Rules rules) {
        return settingServices.update_rule(rules);
    }

    @GetMapping(value = "list_rule")
    public List<Rules> list_rule() {
        return settingServices.list_rule();
    }
}
