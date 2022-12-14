package peoplelocation.peoplelocation.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import peoplelocation.peoplelocation.MessageReponse;
import peoplelocation.peoplelocation.dao.AcademicLevelsRepository;
import peoplelocation.peoplelocation.dao.CivilityRepository;
import peoplelocation.peoplelocation.dao.NationalityRepository;
import peoplelocation.peoplelocation.dao.PostesRepository;
import peoplelocation.peoplelocation.dao.RulesRepository;
import peoplelocation.peoplelocation.dao.SpecialityRepository;
import peoplelocation.peoplelocation.dao.TypesRepository;
import peoplelocation.peoplelocation.dao.VillesRepository;
import peoplelocation.peoplelocation.entites.AcademicLevels;
import peoplelocation.peoplelocation.entites.Civility;
import peoplelocation.peoplelocation.entites.Nationality;
import peoplelocation.peoplelocation.entites.Postes;
import peoplelocation.peoplelocation.entites.Rules;
import peoplelocation.peoplelocation.entites.Speciality;
import peoplelocation.peoplelocation.entites.Types;
import peoplelocation.peoplelocation.entites.Villes;
import peoplelocation.peoplelocation.services.interfaces.SettingServices;

@Service
public class SettingImplement implements SettingServices {

    @Autowired
    TypesRepository typesRepository;
    @Autowired
    SpecialityRepository specialityRepository;
    @Autowired
    PostesRepository postesRepository;
    @Autowired
    VillesRepository villesRepository;
    // @Autowired
    // QuartiersRepository quartiersRepository;
    @Autowired
    AcademicLevelsRepository academicLevelsRepository;
    @Autowired
    NationalityRepository nationalityRepository;
    @Autowired
    RulesRepository rulesRepository;
    @Autowired
    CivilityRepository civilityRepository;

    @Override
    public MessageReponse create_type(Types types) {
        if (!typesRepository.findByName(types.getName()).isEmpty()) {
            return new MessageReponse("Ce nom est deja utilis??");
        }
        typesRepository.save(types);
        return new MessageReponse("Enreigistrement effectu?? avec success");
    }

    @Override
    public MessageReponse update_type(Types types) {
        if (!typesRepository.findByName(types.getName()).isEmpty()) {
            return new MessageReponse("Ce nom est deja utilis??");
        }
        Optional<Types> get_types = typesRepository.findById(types.getOid());
        if (get_types.isPresent()) {
            get_types.get().setName(types.getName());
            typesRepository.save(get_types.get());
            return new MessageReponse("Modification effectuer avec success");
        } else {
            return new MessageReponse("Cet element n'existe pas");
        }
    }

    @Override
    public List<Types> list_type() {
        return typesRepository.findAll();
    }

    @Override
    public MessageReponse create_speciality(Speciality speciality) {
        if (!specialityRepository.findByName(speciality.getName()).isEmpty()) {
            return new MessageReponse("Ce nom est deja utilis??");
        }
        specialityRepository.save(speciality);
        return new MessageReponse("Enreigistrement effectu?? avec success");
    }

    @Override
    public MessageReponse update_speciality(Speciality speciality) {
        if (!specialityRepository.findByName(speciality.getName()).isEmpty()) {
            return new MessageReponse("Ce nom est deja utilis??");
        }
        Optional<Speciality> get_speciality = specialityRepository.findById(speciality.getOid());
        if (get_speciality.isPresent()) {
            get_speciality.get().setName(speciality.getName());
            specialityRepository.save(get_speciality.get());
            return new MessageReponse(("Modification effecut?? avec success"));
        } else {
            return new MessageReponse("Cet element n'existe pas");
        }
    }

    @Override
    public List<Speciality> list_speciality() {
        return specialityRepository.findAll();
    }

    @Override
    public MessageReponse create_poste(Postes postes) {
        if (!postesRepository.findByName(postes.getName()).isEmpty()) {
            return new MessageReponse("Ce nom est deja utilis??");
        }
        postesRepository.save(postes);
        return new MessageReponse("Enreigistrement effectu?? avec success");
    }

    @Override
    public MessageReponse update_poste(Postes postes) {
        if (!postesRepository.findByName(postes.getName()).isEmpty()) {
            return new MessageReponse("Ce nom est deja utilis??");
        }
        Optional<Postes> get_poste = postesRepository.findById(postes.getOid());
        if (get_poste.isPresent()) {
            get_poste.get().setName(postes.getName());
            postesRepository.save(get_poste.get());
            return new MessageReponse("Modification effectu?? avec success");
        } else {
            return new MessageReponse("Cet element n'existe pas");
        }
    }

    @Override
    public List<Postes> list_poste() {
        return postesRepository.findAll();
    }

    @Override
    public MessageReponse create_ville(Villes villes) {
        if (!villesRepository.findByName(villes.getName()).isEmpty()) {
            return new MessageReponse("Ce nom est deja utilis??");
        }
        villesRepository.save(villes);
        return new MessageReponse("Enreisgistrement effectu?? avec success");
    }

    @Override
    public MessageReponse update_ville(Villes villes) {
        if (!villesRepository.findByName(villes.getName()).isEmpty()) {
            return new MessageReponse("Ce nom est deja utilis??");
        }
        Optional<Villes> get_ville = villesRepository.findById(villes.getOid());
        if (get_ville.isPresent()) {
            get_ville.get().setName(villes.getName());
            villesRepository.save(get_ville.get());
            return new MessageReponse("Modification effectu?? avec success");
        } else {
            return new MessageReponse("Cet element n'existe pas");
        }
    }

    @Override
    public List<Villes> list_ville() {
        return villesRepository.findAll();
    }

    // @Override
    // public MessageReponse create_quartier(Quartiers quartiers) {
    // if (!quartiersRepository.findByName(quartiers.getName()).isEmpty()) {
    // return new MessageReponse("Ce nom est deja utilis??");
    // }
    // quartiersRepository.save(quartiers);
    // return new MessageReponse("Enreigistrement effectu?? avec success");
    // }

    // @Override
    // public MessageReponse update_quartier(Quartiers quartiers) {
    // if (!quartiersRepository.findByName(quartiers.getName()).isEmpty()) {
    // return new MessageReponse("Ce nom est deja utilis??");
    // }
    // Optional<Quartiers> get_quartier =
    // quartiersRepository.findById(quartiers.getOid());
    // if (get_quartier.isPresent()) {
    // get_quartier.get().setName(quartiers.getName());
    // quartiersRepository.save(get_quartier.get());
    // return new MessageReponse("Modification effectu?? avec success");
    // } else {
    // return new MessageReponse("Cet element n'existe pas");
    // }
    // }

    // @Override
    // public List<Quartiers> list_quartier() {
    // return quartiersRepository.findAll();
    // }

    @Override
    public MessageReponse create_academicLevel(AcademicLevels academicLevels) {
        if (!academicLevelsRepository.findByName(academicLevels.getName()).isEmpty()) {
            return new MessageReponse("Ce nom existe deja");
        }
        academicLevelsRepository.save(academicLevels);
        return new MessageReponse("Enreigistrement effectu?? avec success");
    }

    @Override
    public MessageReponse update_academicLevel(AcademicLevels academicLevels) {
        if (!academicLevelsRepository.findByName(academicLevels.getName()).isEmpty()) {
            return new MessageReponse("Ce nom existe deja");
        }
        Optional<AcademicLevels> get_academicLivele = academicLevelsRepository.findById(academicLevels.getOid());
        if (get_academicLivele.isPresent()) {
            get_academicLivele.get().setName(academicLevels.getName());
            return new MessageReponse("Enreigistrement effectu?? avec success");
        } else {
            return new MessageReponse("Cet element n'existe pas");
        }
    }

    @Override
    public List<AcademicLevels> list_academicLevel() {
        return academicLevelsRepository.findAll();
    }

    @Override
    public MessageReponse create_nationality(Nationality nationality) {
        if (!nationalityRepository.findByName(nationality.getName()).isEmpty()) {
            return new MessageReponse("Ce nom existe deja");
        }
        nationalityRepository.save(nationality);
        return new MessageReponse("Enreigistrement effectu?? avec success");
    }

    @Override
    public MessageReponse update_nationality(Nationality nationality) {
        if (!nationalityRepository.findByName(nationality.getName()).isEmpty()) {
            return new MessageReponse("Ce nom existe deja");
        }
        Optional<Nationality> get_nationality = nationalityRepository.findById(nationality.getOid());
        if (get_nationality.isPresent()) {
            get_nationality.get().setName(nationality.getName());
            nationalityRepository.save(get_nationality.get());
            return new MessageReponse("Modification effectu?? avec success");
        } else {
            return new MessageReponse("Cet element n'existe pas");
        }
    }

    @Override
    public List<Nationality> list_nationality() {
        return nationalityRepository.findAll();
    }

    @Override
    public MessageReponse create_rule(Rules rules) {
        if (!rulesRepository.findByName(rules.getName()).isEmpty()) {
            return new MessageReponse("Ce nom existe deja");
        }
        rulesRepository.save(rules);
        return new MessageReponse("Enreigistrement effectu?? avec success");
    }

    @Override
    public MessageReponse update_rule(Rules rules) {
        if (!rulesRepository.findByName(rules.getName()).isEmpty()) {
            return new MessageReponse("Ce nom existe deja");
        }
        Optional<Rules> get_rule = rulesRepository.findById(rules.getOid());
        if (get_rule.isPresent()) {
            get_rule.get().setName(rules.getName());
            rulesRepository.save(get_rule.get());
            return new MessageReponse("Modification effectu?? avec success");
        } else {
            return new MessageReponse("Cet element n'existe pas");
        }
    }

    @Override
    public List<Rules> list_rule() {
        return rulesRepository.findAll();
    }

    @Override
    public MessageReponse create_civility(Civility civility) {
        if (!civilityRepository.findByName(civility.getName()).isEmpty()) {
            return new MessageReponse("Ce nom existe deja");
        }
        civilityRepository.save(civility);
        return new MessageReponse("Enreigistrement effectu?? avec success");
    }

    @Override
    public MessageReponse update_civility(Civility civility) {
        if (!civilityRepository.findByName(civility.getName()).isEmpty()) {
            return new MessageReponse("Ce nom existe deja");
        }
        Optional<Civility> get_civility = civilityRepository.findById(civility.getOid());
        if (get_civility.isPresent()) {
            get_civility.get().setName(civility.getName());
            civilityRepository.save(get_civility.get());
            return new MessageReponse("Modification effectu?? avec success");
        } else {
            return new MessageReponse("Cet element n'existe pas");
        }
    }

    @Override
    public List<Civility> list_civility() {
        return civilityRepository.findAll();
    }

}
