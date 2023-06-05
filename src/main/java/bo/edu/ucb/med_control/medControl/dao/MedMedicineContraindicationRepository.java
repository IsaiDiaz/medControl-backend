package bo.edu.ucb.med_control.medControl.dao;


import bo.edu.ucb.med_control.medControl.entity.MedMedicineContraindication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedMedicineContraindicationRepository extends JpaRepository<MedMedicineContraindication, Integer>{}