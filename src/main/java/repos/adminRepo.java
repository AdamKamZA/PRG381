package repos;

import org.springframework.data.jpa.repository.JpaRepository;

import models.admins;

public interface adminRepo extends JpaRepository<admins, Integer> {
    
}
