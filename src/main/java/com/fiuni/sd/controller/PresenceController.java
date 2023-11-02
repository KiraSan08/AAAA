package com.fiuni.sd.controller;
import org.springframework.beans.factory.annotation.Value;

import com.fiuni.sd.dto.presence.PresenceDto;
import com.fiuni.sd.dto.presence.PresenceListDto;
import com.fiuni.sd.service.presence.IPresenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.PageRequest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/presences")
public class PresenceController {
    
    @Autowired
    private IPresenceService presenceService;

    @Value("${pagination.size:10}")
    private Integer pageSize;

    @GetMapping("/page/{page}")
    public PresenceListDto get(@PathVariable Integer page) {
        return presenceService.get(PageRequest.of(page, pageSize));

    }

    @GetMapping("/{id}")
    public ResponseEntity<PresenceDto> getById(@PathVariable(value = "id") final Integer id) {
        try {
            PresenceDto presence = presenceService.getById(id);
            return ResponseEntity.ok(presence);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public PresenceDto save(@RequestBody PresenceDto presenceDto) {
        return presenceService.create(presenceDto);

    }

    @PutMapping("/{id}")
    public ResponseEntity<PresenceDto> update(@PathVariable(value = "id") final Integer id,
            @RequestBody @Valid final PresenceDto presenceDto) {
        return ResponseEntity.ok(presenceService.update(id, presenceDto));
    }

    @DeleteMapping("/{id}")
    public PresenceDto delete(@PathVariable Integer id) {
        return presenceService.delete(id);
    }

    
}
