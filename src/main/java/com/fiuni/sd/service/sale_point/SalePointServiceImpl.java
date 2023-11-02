package com.fiuni.sd.service.sale_point;

import java.util.ArrayList;
import java.util.List;

import com.fiuni.sd.dao.ISalePointDao;
import com.fiuni.sd.domain.SalePointDomain;
import com.fiuni.sd.dto.sale_point.SalePointDto;
import com.fiuni.sd.service.base.BaseServiceImpl;
import com.fiuni.sd.dto.sale_point.SalePointListDto;
import com.fiuni.sd.exception.ResourceNotFoundException;
import com.fiuni.sd.exception.UniqueConstraintViolationException;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

@Service
public class SalePointServiceImpl extends BaseServiceImpl<SalePointDto, SalePointDomain, SalePointListDto> implements ISalePointService {

    @Autowired
    private ISalePointDao salePointDao;

    @Override
    public SalePointListDto get(Pageable pageable) {
        SalePointListDto result = new SalePointListDto();
        List<SalePointDto> list = new ArrayList<>();
        Page<SalePointDomain> pages = salePointDao.findAll(pageable);
        pages.forEach(salePoint -> {
            SalePointDto dto = convertDomainToDto(salePoint);
            list.add(dto);
        });
        result.setSalePoints(list);
        result.setPage(pages.getNumber());
        result.setTotalPages(pages.getTotalPages());
        result.setTotal((int) salePointDao.count());
        result.set_hasPrev(pages.hasPrevious());
        result.set_hasNext(pages.hasNext());
        return result;
    }

    @Override
    public SalePointDto getById(Integer id) {
        return salePointDao.findById(id).map(this::convertDomainToDto).orElseThrow(() -> new ResourceNotFoundException("SalePoint", "id", id));
    }

    @Override
    public SalePointDto create(final SalePointDto dto) {
        try {
            return convertDomainToDto(salePointDao.save(convertDtoToDomain(dto)));
        } catch (DataIntegrityViolationException ex) {
            throw new UniqueConstraintViolationException("Unique constraint violation on some fields");
        }
    }

    @Override
    public SalePointDto update(Integer id, SalePointDto dto) {
        SalePointDto currentSalePoint = salePointDao.findById(id).map(this::convertDomainToDto).orElseThrow(() -> new ResourceNotFoundException("SalePoint", "id", id));
        SalePointDto modifiedSalePoint = new SalePointDto();
        modifiedSalePoint.setId(id);
        modifiedSalePoint.setInvoiceStampNumber(dto.getInvoiceStampNumber() == null? currentSalePoint.getInvoiceStampNumber() : dto.getInvoiceStampNumber());
        modifiedSalePoint.setInvoiceStampInitDate(dto.getInvoiceStampInitDate() == null? currentSalePoint.getInvoiceStampInitDate() : dto.getInvoiceStampInitDate());
        modifiedSalePoint.setInvoiceStampDueDate(dto.getInvoiceStampDueDate() == null? currentSalePoint.getInvoiceStampDueDate() : dto.getInvoiceStampDueDate());
        modifiedSalePoint.setLastInvoiceNumber(dto.getLastInvoiceNumber() == null? currentSalePoint.getLastInvoiceNumber() : dto.getLastInvoiceNumber());
        modifiedSalePoint.setPrefix(dto.getPrefix() == null? currentSalePoint.getPrefix() : dto.getPrefix());
        modifiedSalePoint.setEstablishmentNumber(dto.getEstablishmentNumber() == null? currentSalePoint.getEstablishmentNumber() : dto.getEstablishmentNumber());
        
        try {
            return convertDomainToDto(salePointDao.save(convertDtoToDomain(modifiedSalePoint)));
        } catch (DataIntegrityViolationException ex) {
            throw new UniqueConstraintViolationException("Unique constraint violation on some fields");
    }
    }

    @Override
    public SalePointDto delete(Integer id) {
        SalePointDto dto = salePointDao.findById(id).map(this::convertDomainToDto).orElseThrow(() -> new ResourceNotFoundException("SalePoint", "id", id));
        salePointDao.deleteById(id);
        return dto;
    }

    @Override
    public SalePointDto convertDomainToDto(SalePointDomain domain) {
        SalePointDto dto = new SalePointDto();
        dto.setId(domain.getId());
        dto.setInvoiceStampNumber(domain.getInvoiceStampNumber());
        dto.setInvoiceStampInitDate(domain.getInvoiceStampInitDate());
        dto.setInvoiceStampDueDate(domain.getInvoiceStampDueDate());
        dto.setLastInvoiceNumber(domain.getLastInvoiceNumber());
        dto.setPrefix(domain.getPrefix());
        dto.setEstablishmentNumber(domain.getEstablishmentNumber());
        return dto;
    }

    @Override
    public SalePointDomain convertDtoToDomain(SalePointDto dto) {
        SalePointDomain domain = new SalePointDomain();
        domain.setId(dto.getId());
        domain.setInvoiceStampNumber(dto.getInvoiceStampNumber());
        domain.setInvoiceStampInitDate(dto.getInvoiceStampInitDate());
        domain.setInvoiceStampDueDate(dto.getInvoiceStampDueDate());
        domain.setLastInvoiceNumber(dto.getLastInvoiceNumber());
        domain.setPrefix(dto.getPrefix());
        domain.setEstablishmentNumber(dto.getEstablishmentNumber());
        return domain;
    }
}