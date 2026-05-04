package mk.ukim.finki.wp.lab_emt.web;

import mk.ukim.finki.wp.lab_emt.model.domain.Host;
import mk.ukim.finki.wp.lab_emt.model.dto.HostStatsDto;
import mk.ukim.finki.wp.lab_emt.repository.HostRepository;
import mk.ukim.finki.wp.lab_emt.service.HostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hosts")
public class HostController {

    private final HostService hostService;
    private final HostRepository hostRepository;

    public HostController(HostService hostService, HostRepository hostRepository) {
        this.hostService = hostService;
        this.hostRepository = hostRepository;
    }

    //    @GetMapping("/{id}/stats")
//    public ResponseEntity<HostStatsDto> getHostStats(@PathVariable Long id) {
//        return ResponseEntity.ok(hostService.getHostStats(id));
//    }
    @GetMapping
    public ResponseEntity<List<Host>> findAll() {
        return ResponseEntity.ok(hostRepository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Host> findById(@PathVariable Long id) {
        return hostRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}