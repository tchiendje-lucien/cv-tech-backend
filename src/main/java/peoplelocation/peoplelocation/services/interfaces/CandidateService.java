package peoplelocation.peoplelocation.services.interfaces;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import peoplelocation.peoplelocation.MessageReponse;
import peoplelocation.peoplelocation.entites.AcademicLevels;
import peoplelocation.peoplelocation.entites.Attachements;
import peoplelocation.peoplelocation.entites.Candidates;
import peoplelocation.peoplelocation.entites.CdtPostes;
import peoplelocation.peoplelocation.entites.Postes;
import peoplelocation.peoplelocation.entites.Speciality;
import peoplelocation.peoplelocation.entites.Villes;
import peoplelocation.peoplelocation.entites.projection.CandidatesView;

public interface CandidateService {
        MessageReponse create_candidate(Candidates candidates, Attachements attachements, List<Postes> postes,
                        MultipartFile cv_file) throws IOException;

        MessageReponse update_candidate_withFile(Candidates candidates, Attachements attachements, List<Postes> postes,
                        MultipartFile cv_file) throws IOException;

        MessageReponse update_candidate_withoutFile(Candidates candidates, List<Postes> postes);

        List<CandidatesView> list_candidate();

        List<CdtPostes> filterCandatate(Postes postes, Villes villes, AcademicLevels academicLevels, Speciality speciality, Integer exprience_num);

        Candidates find_cadidate(Candidates candidates);

        void downloadCV(String filename, HttpServletResponse response);
}
