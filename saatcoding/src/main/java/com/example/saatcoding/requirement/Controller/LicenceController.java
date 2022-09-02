package com.example.saatcoding.requirement.Controller;

import com.example.saatcoding.requirement.main.Licence;
import com.example.saatcoding.requirement.services.LicenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/licence")
@RequiredArgsConstructor
public class LicenceController {
    private final LicenceService licenceService;

    @GetMapping
    public List<Licence> getLicence() {
        return licenceService.getLicence();
    }

    @PostMapping
    public void registerNewLicence(@RequestBody Licence licence) {
        licenceService.addNewLicence(licence);
    }

    @DeleteMapping(path = "{licenceId}")
    public void deleteLicence (@PathVariable ("licenceId") Long licenceId) {
        licenceService.deleteLicence(licenceId);
    }
}
