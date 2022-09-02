package com.example.saatcoding.requirement.Repository;

import com.example.saatcoding.requirement.main.Licence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LicenceRepository
        extends JpaRepository<Licence, Long>{

    @Query ("SELECT s FROM Licence s WHERE s.name = ?1 ")
    Optional<Licence> findLicenceByName (String name);
}
