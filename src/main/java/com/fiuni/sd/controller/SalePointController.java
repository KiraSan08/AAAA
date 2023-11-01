package com.fiuni.sd.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fiuni.sd.dto.sale_point.SalePointDto;
import com.fiuni.sd.dto.sale_point.SalePointListDto;
import com.fiuni.sd.service.sale_point.ISalePointService;

@RestController
@RequestMapping("/api/salePoints")
public class SalePointController {

    @Autowired
    private ISalePointService salePointService;

    @GetMapping("/{id}")
    public SalePointDto getById(@PathVariable Integer id) {
        return salePointService.getById(id);
    }

    @GetMapping()
    public SalePointListDto getAll(@RequestParam(required = false, defaultValue = "0") Integer page,
                                   @RequestParam(required = false, defaultValue = "10") Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return salePointService.get(pageable);
    }

    @PostMapping()
    public SalePointDto save(@RequestBody SalePointDto salePointDto) {
        return salePointService.create(salePointDto);
    }

    @PutMapping("/{id}")
    public SalePointDto update(@PathVariable Integer id, @RequestBody SalePointDto salePointDto) {
        return salePointService.update(id, salePointDto);
    }

    @DeleteMapping("/{id}")
    public SalePointDto delete(@PathVariable Integer id) {
        return salePointService.delete(id);
    }
}
