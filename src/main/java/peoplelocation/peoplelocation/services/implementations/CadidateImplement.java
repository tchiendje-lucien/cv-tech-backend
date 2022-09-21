package peoplelocation.peoplelocation.services.implementations;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.dialect.PostgreSQL10Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import peoplelocation.peoplelocation.MessageReponse;
import peoplelocation.peoplelocation.dao.AttachementsRepository;
import peoplelocation.peoplelocation.dao.CandidatesRepository;
import peoplelocation.peoplelocation.dao.CdtPostesRepository;
import peoplelocation.peoplelocation.entites.AcademicLevels;
import peoplelocation.peoplelocation.entites.Attachements;
import peoplelocation.peoplelocation.entites.Candidates;
import peoplelocation.peoplelocation.entites.CdtPostes;
import peoplelocation.peoplelocation.entites.Postes;
import peoplelocation.peoplelocation.entites.Speciality;
import peoplelocation.peoplelocation.entites.Villes;
import peoplelocation.peoplelocation.entites.projection.CandidatesView;
import peoplelocation.peoplelocation.services.interfaces.CandidateService;

@Service
public class CadidateImplement implements CandidateService {

    @Autowired
    CandidatesRepository candidatesRepository;
    @Autowired
    CdtPostesRepository cdtPostesRepository;
    @Autowired
    AttachementsRepository attachementsRepository;
    public static String fileDirectry = System.getProperty("user.home") + "/cv-tech/documents/";

    @Override
    @Transactional
    public MessageReponse create_candidate(Candidates candidates, Attachements attachements, List<Postes> postes,
            MultipartFile cv_file) throws IOException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH.mm.ss");
        LocalDateTime now = LocalDateTime.now();
        if (!candidatesRepository.findByEmail(candidates.getEmail()).isEmpty()) {
            return new MessageReponse("Cette adresse Email est deja utlisée");
        }
        if (!candidatesRepository.findByFullname(candidates.getFullname()).isEmpty()) {
            return new MessageReponse("Ce nom est deja utilisé");
        }
        if (!candidatesRepository.findByPhone(candidates.getPhone()).isEmpty()) {
            return new MessageReponse("Ce numero de telephone est deja utilisé");
        }
        Long code = candidatesRepository.findAllMaxCodeCdt();
        candidates.setFullname(candidates.getFullname());
        candidates.setCodeCdt(String.valueOf(code + 1));
        candidates.setEmail(candidates.getEmail());
        candidates.setBirthDate(candidates.getBirthDate());
        candidates.setSexe(candidates.getSexe());
        candidates.setCivility(candidates.getCivility());
        candidates.setAdress(candidates.getAdress());
        candidates.setChildrenNum(candidates.getChildrenNum());
        candidates.setExprience_num(candidates.getExprience_num());
        candidates.setPhone(candidates.getPhone());
        candidates.setQuartier(candidates.getQuartier());
        candidates.setStates(candidates.getStates());
        candidates.setTypes(candidates.getTypes());
        candidates.setSpeciality(candidates.getSpeciality());
        candidates.setNationality(candidates.getNationality());
        candidates.setAcademicLevels(candidates.getAcademicLevels());
        candidates.setUsers(candidates.getUsers());
        candidates.setCreated_at(dtf.format(now));
        Candidates new_candidate = candidatesRepository.save(candidates);

        for (int i = 0; i < postes.size(); i++) {
            CdtPostes cdtPostes = new CdtPostes();
            System.out.println(postes.get(i));
            cdtPostes.setCandidates(new_candidate);
            cdtPostes.setPostes(postes.get(i));
            cdtPostesRepository.save(cdtPostes);
        }
        int index = cv_file.getOriginalFilename().lastIndexOf('.');
        String extension = cv_file.getOriginalFilename().substring(index + 1);
        // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH.mm.ss");
        // LocalDateTime now = LocalDateTime.now();
        String filename = "cv-tech_" + new_candidate.getFullname() + "_" + new_candidate.getOid() + "_"
                + dtf.format(now).toString() + "." + extension;
        byte[] bytes = cv_file.getBytes();
        String insPath = "C:/Users/l.tchiendje/Documents/cv-tech/documents/" + filename;
        Files.write(Paths.get(insPath), bytes);
        // cv_file.transferTo(new File(
        // "C:/Users/l.tchiendje/Documents/cv-tech/documents/" +
        // cv_file.getOriginalFilename()));

        attachements.setCv_file(filename);
        attachements.setCandidates(new_candidate);
        attachementsRepository.save(attachements);
        return new MessageReponse("Le candidat a été ajouté avec success");
    }

    @Override
    @Transactional
    public MessageReponse update_candidate_withFile(Candidates candidates, Attachements attachements,
            List<Postes> postes, MultipartFile cv_file) throws IOException {
        Optional<Candidates> get_candidate = candidatesRepository.findById(candidates.getOid());
        if (get_candidate.isPresent()) {
            get_candidate.get().setFullname(candidates.getFullname());
            get_candidate.get().setEmail(candidates.getEmail());
            get_candidate.get().setBirthDate(candidates.getBirthDate());
            get_candidate.get().setSexe(candidates.getSexe());
            get_candidate.get().setCivility(candidates.getCivility());
            get_candidate.get().setAdress(candidates.getAdress());
            get_candidate.get().setChildrenNum(candidates.getChildrenNum());
            get_candidate.get().setExprience_num(candidates.getExprience_num());
            get_candidate.get().setPhone(candidates.getPhone());
            get_candidate.get().setQuartier(candidates.getQuartier());
            get_candidate.get().setStates(candidates.getStates());
            get_candidate.get().setTypes(candidates.getTypes());
            get_candidate.get().setSpeciality(candidates.getSpeciality());
            get_candidate.get().setNationality(candidates.getNationality());
            get_candidate.get().setAcademicLevels(candidates.getAcademicLevels());
            get_candidate.get().setUsers(candidates.getUsers());
            Candidates new_candidate = candidatesRepository.save(get_candidate.get());

            cdtPostesRepository.deleteByCandidates(candidates);
            for (int i = 0; i < postes.size(); i++) {
                CdtPostes cdtPostes = new CdtPostes();
                System.out.println(postes.get(i));
                cdtPostes.setCandidates(new_candidate);
                cdtPostes.setPostes(postes.get(i));
                cdtPostesRepository.save(cdtPostes);
            }
            int index = cv_file.getOriginalFilename().lastIndexOf('.');
            String extension = cv_file.getOriginalFilename().substring(index + 1);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH.mm.ss");
            LocalDateTime now = LocalDateTime.now();
            String filename = "cv-tech_" + new_candidate.getFullname() + "_" + new_candidate.getOid() + "_"
                    + dtf.format(now).toString() + "." + extension;
            byte[] bytes = cv_file.getBytes();
            String insPath = "C:/Users/l.tchiendje/Documents/cv-tech/documents/" + filename;
            Files.write(Paths.get(insPath), bytes);
            // cv_file.transferTo(new File(
            // "C:/Users/l.tchiendje/Documents/cv-tech/documents/" +
            // cv_file.getOriginalFilename()));

            Optional<Attachements> get_attach = attachementsRepository.findByCandidates(candidates);
            get_attach.get().setCv_file(filename);
            attachementsRepository.save(get_attach.get());

            return new MessageReponse("Le candidat a été modifier avec success");
        } else {
            return new MessageReponse("Le candidat selectionner n'existe pas");
        }
    }

    @Override
    public List<CandidatesView> list_candidate() {
        return candidatesRepository.findAllCandidatesBy();
    }

    @Override
    public Candidates find_cadidate(Candidates candidates) {
        Optional<Candidates> get_candidate = candidatesRepository.findById(candidates.getOid());
        if (!get_candidate.isEmpty()) {
            return get_candidate.get();
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public MessageReponse update_candidate_withoutFile(Candidates candidates,
            List<Postes> postes) {
        // if (!candidatesRepository.findByEmail(candidates.getEmail()).isEmpty()) {
        // return new MessageReponse("Cette adresse Email est deja utlisée");
        // }
        // if (!candidatesRepository.findByFullname(candidates.getFullname()).isEmpty())
        // {
        // return new MessageReponse("Ce nom est deja utilisé");
        // }
        // if (!candidatesRepository.findByPhone(candidates.getPhone()).isEmpty()) {
        // return new MessageReponse("Ce numero de telephone est deja utilisé");
        // }
        Optional<Candidates> get_candidate = candidatesRepository.findById(candidates.getOid());
        if (get_candidate.isPresent()) {
            get_candidate.get().setFullname(candidates.getFullname());
            get_candidate.get().setEmail(candidates.getEmail());
            get_candidate.get().setBirthDate(candidates.getBirthDate());
            get_candidate.get().setSexe(candidates.getSexe());
            get_candidate.get().setCivility(candidates.getCivility());
            get_candidate.get().setAdress(candidates.getAdress());
            get_candidate.get().setChildrenNum(candidates.getChildrenNum());
            get_candidate.get().setExprience_num(candidates.getExprience_num());
            get_candidate.get().setPhone(candidates.getPhone());
            get_candidate.get().setQuartier(candidates.getQuartier());
            get_candidate.get().setStates(candidates.getStates());
            get_candidate.get().setTypes(candidates.getTypes());
            get_candidate.get().setSpeciality(candidates.getSpeciality());
            get_candidate.get().setNationality(candidates.getNationality());
            get_candidate.get().setAcademicLevels(candidates.getAcademicLevels());
            get_candidate.get().setUsers(candidates.getUsers());
            Candidates new_candidate = candidatesRepository.save(get_candidate.get());

            cdtPostesRepository.deleteByCandidates(candidates);
            for (int i = 0; i < postes.size(); i++) {
                CdtPostes cdtPostes = new CdtPostes();
                System.out.println(postes.get(i));
                cdtPostes.setCandidates(new_candidate);
                cdtPostes.setPostes(postes.get(i));
                cdtPostesRepository.save(cdtPostes);
            }
            return new MessageReponse("Le candidat a été modifier avec success");
        } else {
            return new MessageReponse("Le candidat selectionner n'existe pas");
        }
    }

    @Override
    public void downloadCV(String filename, HttpServletResponse response) {
        String folderPath = "C:/Users/l.tchiendje/Documents/cv-tech/documents/";
        System.out.println(folderPath + filename);
        try {
            BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
            try (FileInputStream fis = new FileInputStream(folderPath + filename)) {
                int len;
                byte[] buf = new byte[1024];
                while ((len = fis.read(buf)) > 0) {
                    bos.write(buf, 0, len);
                }
            }
            bos.close();
            response.flushBuffer();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public List<CdtPostes> filterCandatate(Postes postes, Villes villes, AcademicLevels academicLevels,
            Speciality speciality,
            Integer exprience_num) {
        System.out.print(postes);
        System.out.print(villes);
        System.out.print(academicLevels);
        System.out.print(exprience_num);

        // Filter by experience number
        if (postes == null & villes == null & academicLevels == null) {
            return candidatesRepository.filterByExp(exprience_num);
        }
        // Filter by postes
        if (villes == null & academicLevels == null & speciality == null & exprience_num == null) {
            return candidatesRepository.filterByPostes(postes);
        }
        if (academicLevels == null & exprience_num == null & speciality == null) {
            return candidatesRepository.filterByPostesAndVilles(postes, villes);
        }
        if (villes == null & speciality == null & exprience_num == null) {
            return candidatesRepository.filterByPostesAndAcaLevel(postes, academicLevels);
        }
        if (exprience_num == null & speciality == null) {
            return candidatesRepository.filterByPostesAndVilleAndAcaLevel(postes, villes, academicLevels);
        }
        if (villes == null & academicLevels == null & speciality == null) {
            return candidatesRepository.filterByPostesAndExp(postes, exprience_num);
        }
        if (villes == null & speciality == null) {
            return candidatesRepository.filterByPostesAndAcaLevelAndEpx(postes, academicLevels, exprience_num);
        }
        if (academicLevels == null & speciality == null) {
            return candidatesRepository.filterByPostesAndVillesAndExp(postes, villes, exprience_num);
        }

        if (villes == null & academicLevels == null & exprience_num == null) {
            return candidatesRepository.filterByPostesAndSpe(postes, speciality);
        }

        if (academicLevels == null & exprience_num == null) {
            return candidatesRepository.filterByPostesAndVilleAndSpe(postes, villes, speciality);
        }

        if (villes == null & exprience_num == null) {
            return candidatesRepository.filterByPostesAndAcaLvelAndSpe(postes, academicLevels, speciality);
        }

        if (exprience_num == null) {
            return candidatesRepository.filterByPostesAndVilleAndAcaLvelAndSpe(postes, villes, academicLevels,
                    speciality);
        }

        if (academicLevels == null) {
            return candidatesRepository.filterByPostesAndVilleAndSpecAndExp(postes, villes, speciality, exprience_num);
        }

        if (villes == null) {
            return candidatesRepository.filterByPostesAndAcaLevelAndSpecAndExp(postes, academicLevels, speciality,
                    exprience_num);
        }
        if (villes == null & academicLevels == null) {
            return candidatesRepository.filterByPostesAndSpecAndExp(postes, speciality, exprience_num);
        }

        // Filter by villes
        if (postes == null & academicLevels == null & exprience_num == null & speciality == null) {
            return candidatesRepository.filterByVille(villes);
        }
        if (postes == null & exprience_num == null & speciality == null) {
            return candidatesRepository.filterByVilleAndAcaLevel(villes, academicLevels);
        }
        if (postes == null & academicLevels == null & speciality == null) {
            return candidatesRepository.filterByVilleAndExp(villes, exprience_num);
        }
        if (postes == null & speciality == null) {
            return candidatesRepository.filterByVilleAndAcaLevelAndExp(villes, academicLevels, exprience_num);
        }

        if (postes == null & academicLevels == null & exprience_num == null) {
            return candidatesRepository.filterByVilleAndSpec(villes, speciality);
        }

        if (postes == null & exprience_num == null) {
            return candidatesRepository.filterByVilleAndAcaLevelAndSpec(villes, academicLevels, speciality);
        }

        if (postes == null & academicLevels == null) {
            return candidatesRepository.filterByVilleAndSpecAndExp(villes, speciality, exprience_num);
        }

        if (postes == null) {
            candidatesRepository.filterByVilleAndAcaLevelAndSpecAndExp(villes, academicLevels, speciality,
                    exprience_num);
        }

        // Filter by Academic level
        if (postes == null & villes == null & exprience_num == null & speciality == null) {
            return candidatesRepository.filterByAcaLevel(academicLevels);
        }
        if (postes == null & villes == null & speciality == null) {
            return candidatesRepository.filterByAcaLevelAndExp(academicLevels, exprience_num);
        }
        if (postes == null & villes == null & exprience_num == null) {
            return candidatesRepository.filterByAcaLevelAndSpec(academicLevels, speciality);
        }

        if (postes == null & villes == null) {
            return candidatesRepository.filterByAndAcaLevelAndSpecAndExp(academicLevels, speciality, exprience_num);
        }

        // Filter bu speciality
        if (postes == null & villes == null & academicLevels == null & exprience_num == null) {
            return candidatesRepository.filterBySpec(speciality);
        }

        if (postes == null & villes == null & academicLevels == null) {
            return candidatesRepository.filterBySpecAndExp(speciality, exprience_num);
        }

        // Filter by All
        if (villes != null & academicLevels != null & exprience_num != null & postes != null & speciality != null) {
            return candidatesRepository.filterAll(postes, villes, academicLevels, speciality, exprience_num);
        }
        return null;
    }

}
