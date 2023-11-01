package com.fiuni.sd.controller;

import javax.validation.Valid;
import com.fiuni.sd.dto.user.UserDto;
import com.fiuni.sd.dto.user.UserListDto;
import com.fiuni.sd.service.user.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired private IUserService resourceService;

    @GetMapping()
    public UserListDto get(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
		return resourceService.get(PageRequest.of(page, size));
	}

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable(value = "id") final Integer id) {
		try {
			UserDto user = resourceService.getById(id);
			return ResponseEntity.ok(user);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
    @PostMapping()
    public ResponseEntity<UserDto> create(@RequestBody @Valid final UserDto userDto) {
		try {
			return ResponseEntity.ok(resourceService.create(userDto));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable(value = "id") final Integer id,
			@RequestBody @Valid final UserDto userDto) {
		return ResponseEntity.ok(resourceService.update(id, userDto));
	}

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDto> delete(@PathVariable final Integer id) {
		try {
			return ResponseEntity.ok(resourceService.delete(id));
		} catch (Exception ex) {
			return ResponseEntity.noContent().build();
		}
	}
}