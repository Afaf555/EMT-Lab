package mk.ukim.finki.wp.lab_emt.web;

import mk.ukim.finki.wp.lab_emt.model.dto.HostStatsDto;
import mk.ukim.finki.wp.lab_emt.service.HostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hosts")
public class HostController {

    private final HostService hostService;

    public HostController(HostService hostService) {
        this.hostService = hostService;
    }

    @GetMapping("/{id}/stats")
    public ResponseEntity<HostStatsDto> getHostStats(@PathVariable Long id) {
        return ResponseEntity.ok(hostService.getHostStats(id));
    }
}