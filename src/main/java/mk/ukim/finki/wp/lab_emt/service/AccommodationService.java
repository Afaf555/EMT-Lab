package mk.ukim.finki.wp.lab_emt.service;

import mk.ukim.finki.wp.lab_emt.model.domain.Accommodation;
import mk.ukim.finki.wp.lab_emt.model.dto.AccommodationRequestDto;

import java.util.List;
import java.util.Optional;

public interface AccommodationService {
    List<Accommodation> findAll();

    Optional<Accommodation> findById(Long id);

    Accommodation create(AccommodationRequestDto dto);

    Optional<Accommodation> update(Long id, AccommodationRequestDto dto);

    void deleteById(Long id);

    Optional<Accommodation> markAsRented(Long id);
}
