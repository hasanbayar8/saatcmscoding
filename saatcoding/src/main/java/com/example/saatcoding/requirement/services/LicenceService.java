package com.example.saatcoding.requirement.services;

import com.example.saatcoding.requirement.Repository.LicenceRepository;
import com.example.saatcoding.requirement.main.Licence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LicenceService {
    private final LicenceRepository licenceRepository;
    public List<Licence> getLicence() {
        return licenceRepository.findAll();
    }
    public void addNewLicence(Licence licence) {
        Optional<Licence> licenceOptional = licenceRepository.
                findLicenceByName(licence.getName());
        if (licenceOptional.isPresent()) {
            throw new IllegalStateException("name taken");
        }
        licenceRepository.save(licence);
    }

    public void deleteLicence(Long licenceId) {
        boolean exists = licenceRepository.existsById(licenceId);
        if (!exists) {
            throw new IllegalStateException("licence with id " +
                    licenceId + " does not exists");
        }
        licenceRepository.deleteById(licenceId);
    }
}
