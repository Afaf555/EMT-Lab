package mk.ukim.finki.wp.lab_emt.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mk.ukim.finki.wp.lab_emt.model.dto.AccommodationRequestDto;
import mk.ukim.finki.wp.lab_emt.model.dto.AccommodationResponseDto;
import mk.ukim.finki.wp.lab_emt.service.AccommodationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accommodations")
@RequiredArgsConstructor
@Tag(name = "Accommodations", description = "API for managing accommodations")
public class AccommodationController {
    private final AccommodationService accommodationService;

    @GetMapping
    @Operation(summary = "Get all accommodations")
    public ResponseEntity<List<AccommodationResponseDto>> findAll() {
        List<AccommodationResponseDto> accommodations=accommodationService.findAll()
                .stream()
                .map(AccommodationResponseDto::from)
                .toList();
        return ResponseEntity.ok(accommodations);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get accommodation by id")
    public ResponseEntity<AccommodationResponseDto> findById(@PathVariable Long id) {
      return accommodationService.findById(id)
              .map(AccommodationResponseDto::from)
              .map(ResponseEntity::ok)
              .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    @Operation(summary = "Create a new accommodation")
    public ResponseEntity<AccommodationResponseDto> create(
            @Valid @RequestBody AccommodationRequestDto dto) {
        AccommodationResponseDto response = AccommodationResponseDto
                .from(accommodationService.create(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing accommodation")
    public ResponseEntity<AccommodationResponseDto> update(
            @PathVariable Long id,
            @Valid @RequestBody AccommodationRequestDto dto) {
        return accommodationService.update(id, dto)
                .map(AccommodationResponseDto::from)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete accommodation by id")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        accommodationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/rent")
    @Operation(summary = "Mark accommodation as rented")
    public ResponseEntity<AccommodationResponseDto> markAsRented(
            @PathVariable Long id) {
        return accommodationService.markAsRented(id)
                .map(AccommodationResponseDto::from)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
