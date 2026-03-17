package mk.ukim.finki.wp.lab_emt.service;

import mk.ukim.finki.wp.lab_emt.model.domain.Accommodation;
import mk.ukim.finki.wp.lab_emt.model.dto.AccommodationRequestDto;

import java.util.List;

public interface AccommodationService {
    List<Accommodation> findAll();
    Accommodation findById(Long id);
    Accommodation create(AccommodationRequestDto dto);
    Accommodation update(Long id, AccommodationRequestDto dto);
    void deleteById(Long id);
    Accommodation markAsRented(Long id);
}