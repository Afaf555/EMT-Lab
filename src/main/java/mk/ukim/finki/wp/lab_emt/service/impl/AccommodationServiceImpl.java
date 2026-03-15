package mk.ukim.finki.wp.lab_emt.service.impl;

import mk.ukim.finki.wp.lab_emt.model.domain.Accommodation;
import mk.ukim.finki.wp.lab_emt.model.domain.Condition;
import mk.ukim.finki.wp.lab_emt.model.domain.Host;
import mk.ukim.finki.wp.lab_emt.model.dto.AccommodationRequestDto;
import mk.ukim.finki.wp.lab_emt.model.exception.AccommodationNotFoundException;
import mk.ukim.finki.wp.lab_emt.model.exception.HostNotFoundException;
import mk.ukim.finki.wp.lab_emt.repository.AccommodationRepository;
import mk.ukim.finki.wp.lab_emt.repository.HostRepository;
import mk.ukim.finki.wp.lab_emt.service.AccommodationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AccommodationServiceImpl implements AccommodationService {
    private final AccommodationRepository accommodationRepository;
    private final HostRepository hostRepository;

    public AccommodationServiceImpl(AccommodationRepository accommodationRepository, HostRepository hostRepository) {
        this.accommodationRepository = accommodationRepository;
        this.hostRepository = hostRepository;
    }

    @Override
    public List<Accommodation> findAll() {
        return accommodationRepository.findAll();
    }

    @Override
    public Optional<Accommodation> findById(Long id) {
        return accommodationRepository.findById(id);
    }

    @Override
    public Accommodation create(AccommodationRequestDto dto) {
        Host host=hostRepository.findById(dto.hostId()).orElseThrow(()->new HostNotFoundException(dto.hostId()));
        Accommodation accommodation=new Accommodation(dto.name(),dto.category(),host,dto.numRooms());
        return accommodationRepository.save(accommodation);
    }

    @Override
    public Optional<Accommodation> update(Long id, AccommodationRequestDto dto) {
        Accommodation accommodation=accommodationRepository.findById(id).orElseThrow(()->new AccommodationNotFoundException(id));
        Host host=hostRepository.findById(dto.hostId()).orElseThrow(()->new HostNotFoundException(dto.hostId()));
        accommodation.setName(dto.name());
        accommodation.setCategory(dto.category());
        accommodation.setNumRooms(dto.numRooms());
        accommodation.setHost(host);
        return Optional.of(accommodationRepository.save(accommodation));
    }

    @Override
    public void deleteById(Long id) {
    if(!accommodationRepository.existsById(id)) {
        throw new AccommodationNotFoundException(id);
    }
    accommodationRepository.deleteById(id);
    }

    @Override
    public Optional<Accommodation> markAsRented(Long id) {
        Accommodation accommodation=accommodationRepository.findById(id).orElseThrow(()->new AccommodationNotFoundException(id));
        accommodation.setRented(true);
        accommodation.setCondition(Condition.GOOD);
        return Optional.of(accommodationRepository.save(accommodation));
    }
}
