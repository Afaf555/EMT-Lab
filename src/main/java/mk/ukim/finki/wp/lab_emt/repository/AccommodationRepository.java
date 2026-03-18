package mk.ukim.finki.wp.lab_emt.repository;

import mk.ukim.finki.wp.lab_emt.model.domain.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
    List<Accommodation> findAllByIsRented(boolean isRented);
    List<Accommodation> findAllByHostId(Long hostId);
}