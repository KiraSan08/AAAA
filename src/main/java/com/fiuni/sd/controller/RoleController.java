package com.fiuni.sd.controller;

import javax.validation.Valid;
import com.fiuni.sd.dto.role.RoleDto;
import com.fiuni.sd.dto.role.RoleListDto;
import com.fiuni.sd.service.role.IRoleService;
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @GetMapping()
    public RoleListDto get(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        return roleService.get(PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDto> getById(@PathVariable(value = "id") final Integer id) {
        try {
            RoleDto role = roleService.getById(id);
            return ResponseEntity.ok(role);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<RoleDto> create(@RequestBody @Valid final RoleDto roleDto) {
        try {
            return ResponseEntity.ok(roleService.create(roleDto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDto> update(@PathVariable(value = "id") final Integer id,
            @RequestBody @Valid final RoleDto roleDto) {
        return ResponseEntity.ok(roleService.update(id, roleDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RoleDto> delete(@PathVariable final Integer id) {
        try {
            return ResponseEntity.ok(roleService.delete(id));
        } catch (Exception ex) {
            return ResponseEntity.noContent().build();
        }
    }
}
