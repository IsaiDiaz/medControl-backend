package bo.edu.ucb.med_control.medControl.dao;


import bo.edu.ucb.med_control.medControl.entity.SeUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SeUserRepository extends JpaRepository<SeUser, Integer>{

    @Query("SELECT u FROM SeUser u WHERE u.username = :username")
    SeUser findByUsername(@Param("username") String username);
}