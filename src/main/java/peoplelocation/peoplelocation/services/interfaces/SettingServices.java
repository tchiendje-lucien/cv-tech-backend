package peoplelocation.peoplelocation.services.interfaces;

import java.util.List;

import peoplelocation.peoplelocation.MessageReponse;
import peoplelocation.peoplelocation.entites.AcademicLevels;
import peoplelocation.peoplelocation.entites.Nationality;
import peoplelocation.peoplelocation.entites.Postes;
import peoplelocation.peoplelocation.entites.Quartiers;
import peoplelocation.peoplelocation.entites.Rules;
import peoplelocation.peoplelocation.entites.Speciality;
import peoplelocation.peoplelocation.entites.Types;
import peoplelocation.peoplelocation.entites.Villes;

public interface SettingServices {
    // Types services
    MessageReponse create_type(Types types);

    MessageReponse update_type(Types types);

    List<Types> list_type();

    // Specility services
    MessageReponse create_speciality(Speciality speciality);

    MessageReponse update_speciality(Speciality speciality);

    List<Speciality> list_speciality();

    // Postes Services
    MessageReponse create_poste(Postes postes);

    MessageReponse update_poste(Postes postes);

    List<Postes> list_poste();

    // Ville Services
    MessageReponse create_ville(Villes villes);

    MessageReponse update_ville(Villes villes);

    List<Villes> list_ville();

    // Quatier Services
    MessageReponse create_quartier(Quartiers quartiers);

    MessageReponse update_quartier(Quartiers quartiers);

    List<Quartiers> list_quartier();

    // Academic level services
    MessageReponse create_academicLevel(AcademicLevels academicLevels);

    MessageReponse update_academicLevel(AcademicLevels academicLevels);

    List<AcademicLevels> list_academicLevel();

    // Nationality services
    MessageReponse create_nationality(Nationality nationality);

    MessageReponse update_nationality(Nationality nationality);

    List<Nationality> list_nationality();

    // Rule service
    MessageReponse create_rule(Rules rules);

    MessageReponse update_rule(Rules rules);

    List<Rules> list_rule();

}
