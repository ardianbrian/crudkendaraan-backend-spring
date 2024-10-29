package kendaraan.technical_test.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kendaraan.technical_test.models.VehicleRegistration;
import kendaraan.technical_test.services.VehicleRegistrationService;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleRegistrationController {
    
    @Autowired
    private VehicleRegistrationService service;

    @GetMapping
    public List<VehicleRegistration> getAllVehicle() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleRegistration> getVehicleById(@PathVariable String id) {
        return service.findById(id)
            .map(vehicle -> ResponseEntity.ok(vehicle))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<VehicleRegistration> createVehicle(@RequestBody VehicleRegistration vehicleRegistration) {
        VehicleRegistration createdVehicle = service.save(vehicleRegistration);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVehicle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleRegistration> updatedVehicle(
        @PathVariable Long id,  // Change the type to Long
        @RequestBody VehicleRegistration vehicleRegistration) {

        // Set the id directly as it's already a Long
        vehicleRegistration.setId(id);
        VehicleRegistration updatedVehicle = service.save(vehicleRegistration);
        
        return ResponseEntity.ok(updatedVehicle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
}
