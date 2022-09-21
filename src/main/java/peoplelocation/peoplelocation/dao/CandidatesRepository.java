package peoplelocation.peoplelocation.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import peoplelocation.peoplelocation.entites.AcademicLevels;
import peoplelocation.peoplelocation.entites.Candidates;
import peoplelocation.peoplelocation.entites.CdtPostes;
import peoplelocation.peoplelocation.entites.Postes;
import peoplelocation.peoplelocation.entites.Speciality;
import peoplelocation.peoplelocation.entites.Villes;
import peoplelocation.peoplelocation.entites.projection.CandidatesView;

@RepositoryRestResource
@CrossOrigin("*")
public interface CandidatesRepository extends JpaRepository<Candidates, Long> {
        Optional<Candidates> findByFullname(String fullname);

        Optional<Candidates> findByPhone(String phone);

        Optional<Candidates> findByEmail(String email);

        List<CandidatesView> findAllCandidatesBy();

        // Filter by postes
        @Query(value = "select c from CdtPostes c where c.postes = :poste")
        List<CdtPostes> filterByPostes(@Param("poste") Postes poste);

        @Query(value = "select c from CdtPostes c where c.postes = :poste and c.candidates.villes = :ville")
        List<CdtPostes> filterByPostesAndVilles(@Param("poste") Postes poste, @Param("ville") Villes ville);

        @Query(value = "select c from CdtPostes c where c.postes = :poste and c.candidates.academicLevels = :adLevel")
        List<CdtPostes> filterByPostesAndAcaLevel(@Param("poste") Postes poste,
                        @Param("adLevel") AcademicLevels adLevel);

        @Query(value = "select c from CdtPostes c where c.postes = :poste and c.candidates.villes = :ville and c.candidates.academicLevels = :adLevel")
        List<CdtPostes> filterByPostesAndVilleAndAcaLevel(@Param("poste") Postes poste, @Param("ville") Villes ville,
                        @Param("adLevel") AcademicLevels adLevel);

        @Query(value = "select c from CdtPostes c where c.postes = :poste and c.candidates.exprience_num >= :exp")
        List<CdtPostes> filterByPostesAndExp(@Param("poste") Postes poste, @Param("exp") Integer exp);

        @Query(value = "select c from CdtPostes c where c.postes = :poste and c.candidates.academicLevels = :adLevel and c.candidates.exprience_num >= :exp")
        List<CdtPostes> filterByPostesAndAcaLevelAndEpx(@Param("poste") Postes poste,
                        @Param("adLevel") AcademicLevels adLevel,
                        @Param("exp") Integer exp);

        @Query(value = "select c from CdtPostes c where c.postes = :poste and c.candidates.villes = :ville and c.candidates.exprience_num >= :exp")
        List<CdtPostes> filterByPostesAndVillesAndExp(@Param("poste") Postes poste, @Param("ville") Villes ville,
                        @Param("exp") Integer exp);

        @Query(value = "select c from CdtPostes c where c.postes = :poste and c.candidates.speciality = :spe")
        List<CdtPostes> filterByPostesAndSpe(@Param("poste") Postes poste, @Param("spe") Speciality spe);

        @Query(value = "select c from CdtPostes c where c.postes = :poste and c.candidates.villes = :ville and c.candidates.speciality = :spe")
        List<CdtPostes> filterByPostesAndVilleAndSpe(@Param("poste") Postes poste, @Param("ville") Villes ville,
                        @Param("spe") Speciality spe);

        @Query(value = "select c from CdtPostes c where c.postes = :poste and c.candidates.academicLevels = :adLevel and c.candidates.speciality = :spe")
        List<CdtPostes> filterByPostesAndAcaLvelAndSpe(@Param("poste") Postes poste,
                        @Param("adLevel") AcademicLevels adLevel, @Param("spe") Speciality spe);

        @Query(value = "select c from CdtPostes c where c.postes = :poste and c.candidates.villes = :ville and c.candidates.academicLevels = :adLevel and c.candidates.speciality = :spe")
        List<CdtPostes> filterByPostesAndVilleAndAcaLvelAndSpe(@Param("poste") Postes poste,
                        @Param("ville") Villes ville, @Param("adLevel") AcademicLevels adLevel,
                        @Param("spe") Speciality spe);

        @Query(value = "select c from CdtPostes c where c.postes = :poste and c.candidates.villes = :ville and c.candidates.speciality = :spe and c.candidates.exprience_num >= :exp")
        List<CdtPostes> filterByPostesAndVilleAndSpecAndExp(@Param("poste") Postes poste, @Param("ville") Villes ville,
                        @Param("spe") Speciality spe, @Param("exp") Integer exp);

        @Query(value = "select c from CdtPostes c where c.postes = :poste and c.candidates.academicLevels = :adLevel and c.candidates.speciality = :spe and c.candidates.exprience_num >= :exp")
        List<CdtPostes> filterByPostesAndAcaLevelAndSpecAndExp(@Param("poste") Postes poste,
                        @Param("adLevel") AcademicLevels adLevel,
                        @Param("spe") Speciality spe, @Param("exp") Integer exp);

        @Query(value = "select c from CdtPostes c where c.postes = :poste and c.candidates.speciality = :spe and c.candidates.exprience_num >= :exp")
        List<CdtPostes> filterByPostesAndSpecAndExp(@Param("poste") Postes poste,
                        @Param("spe") Speciality spe, @Param("exp") Integer exp);

        // Filter by villes
        @Query(value = "select c from CdtPostes c where c.candidates.villes = :ville")
        List<CdtPostes> filterByVille(@Param("ville") Villes ville);

        @Query(value = "select c from CdtPostes c where c.candidates.villes = :ville and c.candidates.academicLevels = :adLevel")
        List<CdtPostes> filterByVilleAndAcaLevel(@Param("ville") Villes ville,
                        @Param("adLevel") AcademicLevels adLevel);

        @Query(value = "select c from CdtPostes c where c.candidates.villes = :ville and c.candidates.exprience_num >= :exp")
        List<CdtPostes> filterByVilleAndExp(@Param("ville") Villes ville, @Param("exp") Integer exp);

        @Query(value = "select c from CdtPostes c where c.candidates.villes = :ville and c.candidates.academicLevels = :adLevel and c.candidates.exprience_num >= :exp")
        List<CdtPostes> filterByVilleAndAcaLevelAndExp(@Param("ville") Villes ville,
                        @Param("adLevel") AcademicLevels adLevel,
                        @Param("exp") Integer exp);

        @Query(value = "select c from CdtPostes c where c.candidates.villes = :ville and c.candidates.speciality = :spe")
        List<CdtPostes> filterByVilleAndSpec(@Param("ville") Villes ville,
                        @Param("spe") Speciality spe);

        @Query(value = "select c from CdtPostes c where c.candidates.villes = :ville and c.candidates.academicLevels = :adLevel and c.candidates.speciality = :spe")
        List<CdtPostes> filterByVilleAndAcaLevelAndSpec(@Param("ville") Villes ville,
                        @Param("adLevel") AcademicLevels adLevel,
                        @Param("spe") Speciality spe);

        @Query(value = "select c from CdtPostes c where c.candidates.villes = :ville and c.candidates.speciality = :spe and c.candidates.exprience_num >= :exp")
        List<CdtPostes> filterByVilleAndSpecAndExp(@Param("ville") Villes ville,
                        @Param("spe") Speciality spe, @Param("exp") Integer exp);

        @Query(value = "select c from CdtPostes c where c.candidates.villes = :ville and c.candidates.academicLevels = :adLevel and c.candidates.speciality = :spe and c.candidates.exprience_num >= :exp")
        List<CdtPostes> filterByVilleAndAcaLevelAndSpecAndExp(@Param("ville") Villes ville,
                        @Param("adLevel") AcademicLevels adLevel,
                        @Param("spe") Speciality spe, @Param("exp") Integer exp);

        // Filer by Academic Level
        @Query(value = "select c from CdtPostes c where c.candidates.academicLevels = :adLevel")
        List<CdtPostes> filterByAcaLevel(@Param("adLevel") AcademicLevels adLevel);

        @Query(value = "select c from CdtPostes c where c.candidates.academicLevels = :adLevel and c.candidates.exprience_num >= :exp")
        List<CdtPostes> filterByAcaLevelAndExp(@Param("adLevel") AcademicLevels adLevel, @Param("exp") Integer exp);

        @Query(value = "select c from CdtPostes c where c.candidates.academicLevels = :adLevel and c.candidates.speciality = :spe")
        List<CdtPostes> filterByAcaLevelAndSpec(@Param("adLevel") AcademicLevels adLevel,
                        @Param("spe") Speciality spe);

        @Query(value = "select c from CdtPostes c where c.candidates.academicLevels = :adLevel and c.candidates.speciality = :spe and c.candidates.exprience_num >= :exp")
        List<CdtPostes> filterByAndAcaLevelAndSpecAndExp(@Param("adLevel") AcademicLevels adLevel,
                        @Param("spe") Speciality spe, @Param("exp") Integer exp);

        // Filter by Speciality
        @Query(value = "select c from CdtPostes c where c.candidates.speciality = :spe")
        List<CdtPostes> filterBySpec(@Param("spe") Speciality spe);

        @Query(value = "select c from CdtPostes c where c.candidates.speciality = :spe and c.candidates.exprience_num >= :exp")
        List<CdtPostes> filterBySpecAndExp(@Param("spe") Speciality spe, @Param("exp") Integer exp);

        // Filter by experience number
        @Query(value = "select c from CdtPostes c where c.candidates.exprience_num >= :exp")
        List<CdtPostes> filterByExp(@Param("exp") Integer exp);

        // Filter by All
        @Query(value = "select c from CdtPostes c where c.postes = :poste and c.candidates.villes = :ville and c.candidates.academicLevels = :adLevel and c.candidates.speciality = :spe and c.candidates.exprience_num >= :exp")
        List<CdtPostes> filterAll(@Param("poste") Postes poste, @Param("ville") Villes ville,
                        @Param("adLevel") AcademicLevels adLevel, @Param("spe") Speciality spe,
                        @Param("exp") Integer exp);

        @Query(value = "select max(c.codeCdt) from Candidates c")
        Long findAllMaxCodeCdt();
}