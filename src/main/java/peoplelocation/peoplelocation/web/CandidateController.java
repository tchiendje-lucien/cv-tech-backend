package peoplelocation.peoplelocation.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CandidateController {
    @Autowired
    CandidateService candidateService;
    @Autowired
    CandidatesRepository candidatesRepository;
    @Autowired
    AttachementsRepository attachementsRepository;
    @Autowired
    CdtPostesRepository cdtPostesRepository;

    @PostMapping(value = "add_candidate", consumes = { "multipart/form-data" })
    public MessageReponse add_candidate(@RequestPart("candidates") String candidates,
            @RequestPart("postes") String postes, @RequestPart("attachements") String attachements,
            @RequestPart("cv_file") MultipartFile cv_file)
            throws IOException {
        // System.out.println("Name : " + cv_file.getName());
        // System.out.println("Type : " + cv_file.getContentType());
        // System.out.println("Name : " + cv_file.getOriginalFilename());

        // System.out.println("Size : " + FilenameUtils.getExtension("test.txt"));
        // return null;
        return candidateService.create_candidate(
                new ObjectMapper().readValue(candidates, Candidates.class),
                new ObjectMapper().readValue(attachements, Attachements.class),
                new ObjectMapper().readValue(postes, new TypeReference<ArrayList<Postes>>() {
                }), cv_file);
    }

    @PutMapping(value = "update_candidate_withFile", consumes = { "multipart/form-data" })
    public MessageReponse update_candidate_withFile(@RequestPart("candidates") String candidates,
            @RequestPart("postes") String postes, @RequestPart("attachements") String attachements,
            @RequestPart("cv_file") MultipartFile cv_file)
            throws IOException {
        // System.out.println("Name : " + cv_file.getName());
        // System.out.println("Type : " + cv_file.getContentType());
        // System.out.println("Name : " + cv_file.getOriginalFilename());

        // System.out.println("Size : " + FilenameUtils.getExtension("test.txt"));
        // return null;
        return candidateService.update_candidate_withFile(
                new ObjectMapper().readValue(candidates, Candidates.class),
                new ObjectMapper().readValue(attachements, Attachements.class),
                new ObjectMapper().readValue(postes, new TypeReference<ArrayList<Postes>>() {
                }), cv_file);
    }

    @PutMapping(value = "update_candidate_withoutFile", consumes = { "multipart/form-data" })
    public MessageReponse update_candidate_withoutFile(@RequestPart("candidates") String candidates,
            @RequestPart("postes") String postes)
            throws JsonMappingException, JsonProcessingException {
        // System.out.println("Name : " + cv_file.getName());
        // System.out.println("Type : " + cv_file.getContentType());
        // System.out.println("Name : " + cv_file.getOriginalFilename());

        // System.out.println("Size : " + FilenameUtils.getExtension("test.txt"));
        // return null;
        return candidateService.update_candidate_withoutFile(
                new ObjectMapper().readValue(candidates, Candidates.class),
                new ObjectMapper().readValue(postes, new TypeReference<ArrayList<Postes>>() {
                }));
    }

    @GetMapping(path = "list_candidate")
    public List<CandidatesView> list_candidate() {
        return candidateService.list_candidate();
    }

    // @GetMapping(path = "list_candidate")
    // public List<Candidates> list_candidate() {
    // return candidatesRepository.findAll();
    // }

    @PostMapping(path = "find_cadidate")
    public Candidates find_cadidate(@RequestBody Candidates candidates) {
        return candidateService.find_cadidate(candidates);
    }

    @PostMapping(path = "/uploadCvFile", consumes = { "multipart/form-data" })
    public void uploadCvFile(@RequestPart("cv_file") MultipartFile cv_file, String nomFichier) {
        try {
            cv_file.transferTo(new File(
                    "C:/Users/l.tchiendje/Documents/cv-tech/documents/" + cv_file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping(path = "test")
    public List<CdtPostes> test() {
        return cdtPostesRepository.findAll();
    }

    @PostMapping(path = "downloadCV")
    public void downloadCV(@RequestBody String filename, HttpServletResponse response) {
        candidateService.downloadCV(filename, response);
    }

    @PostMapping(path = "filterCandidate")
    public List<CdtPostes> filterCandidate(@RequestBody ParemFilter paremFilter) {
        System.out.println(paremFilter.getExprience_num());
        // return null;
        return candidateService.filterCandatate(paremFilter.getPostes(),
                paremFilter.getVilles(),
                paremFilter.getAcademicLevels(), paremFilter.getSpeciality(), paremFilter.getExprience_num());
    }

    // @PostMapping(path = "filterByPostes")
    // public List<CdtPostes> testFilter(@RequestBody Postes postes, Villes villes)
    // {
    // return candidatesRepository.filterByPostesAndVilles(postes.getOid(),
    // villes.getOid());
    // }

}

class ParemFilter {
    private Postes postes;
    private Villes villes;
    private AcademicLevels academicLevels;
    private Speciality speciality;
    private Integer exprience_num;

    public ParemFilter() {
    }

    public ParemFilter(Postes postes, Villes villes, AcademicLevels academicLevels, Speciality speciality,
            Integer exprience_num) {
        this.postes = postes;
        this.villes = villes;
        this.academicLevels = academicLevels;
        this.speciality = speciality;
        this.exprience_num = exprience_num;
    }

    public Postes getPostes() {
        return postes;
    }

    public void setPostes(Postes postes) {
        this.postes = postes;
    }

    public Villes getVilles() {
        return villes;
    }

    public void setVilles(Villes villes) {
        this.villes = villes;
    }

    public AcademicLevels getAcademicLevels() {
        return academicLevels;
    }

    public void setAcademicLevels(AcademicLevels academicLevels) {
        this.academicLevels = academicLevels;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public Integer getExprience_num() {
        return exprience_num;
    }

    public void setExprience_num(Integer exprience_num) {
        this.exprience_num = exprience_num;
    }

    @Override
    public String toString() {
        return "ParemFilter [academicLevels=" + academicLevels + ", exprience_num=" + exprience_num + ", postes="
                + postes + ", speciality=" + speciality + ", villes=" + villes + "]";
    }

}
