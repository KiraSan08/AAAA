package com.fiuni.sd.controller;

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

    @GetMapping()
    public PresenceListDto get(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        return presenceService.get(PageRequest.of(page, size));
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
    public ResponseEntity<PresenceDto> delete(@PathVariable final Integer id) {
        try {
            return ResponseEntity.ok(presenceService.delete(id));
        } catch (Exception ex) {
            return ResponseEntity.noContent().build();
        }
    }
}
