package com.fiuni.sd.service.presence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;

import com.fiuni.sd.dao.IPresenceDao;
import com.fiuni.sd.dao.IStudentDao;
import com.fiuni.sd.dto.presence.PresenceDto;
import com.fiuni.sd.dto.presence.PresenceListDto;
import com.fiuni.sd.dto.student.StudentDto;
import com.fiuni.sd.exception.ResourceNotFoundException;
import com.fiuni.sd.domain.PresenceDomain;
import com.fiuni.sd.domain.StudentDomain;
import com.fiuni.sd.service.base.BaseServiceImpl;

@Service
public class PresenceServiceImpl extends BaseServiceImpl<PresenceDto, PresenceDomain, PresenceListDto>
        implements IPresenceService {

    @Autowired
    private IPresenceDao presenceDao;

    @Autowired
    private IStudentDao studentDao;

    @Override
    public PresenceListDto get(Pageable pageable) {
        PresenceListDto result = new PresenceListDto();
        List<PresenceDto> list = new ArrayList<>();
        Page<PresenceDomain> pages = presenceDao.findAll(pageable);
        pages.forEach(presence -> {
            PresenceDto dto = convertDomainToDto(presence);
            list.add(dto);
        });
        result.setPresences(list);
        result.setPage(pages.getNumber());
        result.setTotalPages(pages.getTotalPages());
        result.setTotal((int) presenceDao.count());
        result.set_hasPrev(pages.hasPrevious());
        result.set_hasNext(pages.hasNext());
        return result;
    }

    @Override
    public PresenceDto getById(Integer id) {
        return presenceDao.findById(id).map(this::convertDomainToDto)
                .orElseThrow(() -> new ResourceNotFoundException("Presence", "id", id));
    }

    @Override
    public PresenceDto create(PresenceDto dto) {
        // Verifica si el estudiante con el ID proporcionado existe
        Optional<StudentDomain> existingStudent = studentDao.findById(dto.getStudent().getId());

        if (existingStudent.isPresent()) {
            // El estudiante existe, crea la presencia y asígnale el estudiante existente
            PresenceDomain presence = convertDtoToDomain(dto);
            presence.setStudent(existingStudent.get());
            PresenceDomain createdPresence = presenceDao.save(presence);
            return convertDomainToDto(createdPresence);
        } else {
            // El estudiante no existe, muestra un mensaje de error o realiza la acción
            // adecuada
            throw new ResourceNotFoundException("Student", "id", dto.getStudent().getId());
        }
    }

    @Override
    public PresenceDto update(Integer id, PresenceDto dto) {
        PresenceDto currentPresence = presenceDao.findById(id).map(this::convertDomainToDto)
                .orElseThrow(() -> new ResourceNotFoundException("Presence", "id", id));

        currentPresence.setId(currentPresence.getId());

        // Actualizar la relación con StudentDomain
        if (dto.getStudent() != null) {
            currentPresence.setStudent(dto.getStudent());
        } else {
            currentPresence.setStudent(currentPresence.getStudent());
        }

        // Actualizar otros campos en PresenceDto si es necesario
        currentPresence.setIsPresent(dto.getIsPresent() == null ? currentPresence.getIsPresent() : dto.getIsPresent());
        currentPresence.setNotes(dto.getNotes() == null ? currentPresence.getNotes() : dto.getNotes());

        return convertDomainToDto(presenceDao.save(convertDtoToDomain(currentPresence)));
    }

    @Override
    public PresenceDto delete(Integer id) {
        PresenceDto dto = presenceDao.findById(id).map(this::convertDomainToDto)
                .orElseThrow(() -> new ResourceNotFoundException("Presence", "id", id));
        presenceDao.deleteById(id);
        return dto;
    }

    @Override
    protected PresenceDto convertDomainToDto(PresenceDomain domain) {
        PresenceDto dto = new PresenceDto();

        dto.setId(domain.getId());

        // Convertir StudentDomain a StudentDto
        StudentDto studentDto = convertStudentDomainToDto(domain.getStudent());
        dto.setStudent(studentDto);

        dto.setIsPresent(domain.getIsPresent());
        dto.setNotes(domain.getNotes());

        return dto;
    }

    private StudentDto convertStudentDomainToDto(StudentDomain studentDomain) {
        StudentDto studentDto = new StudentDto();

        // Convierte Long a Integer
        studentDto.setId(studentDomain.getId() != null ? studentDomain.getId().intValue() : null);

        // Otros mapeos de propiedades si es necesario

        return studentDto;
    }

    @Override
    protected PresenceDomain convertDtoToDomain(PresenceDto dto) {
        PresenceDomain domain = new PresenceDomain();

        domain.setId(dto.getId());

        // Busca y asigna el estudiante existente por su ID
        StudentDomain student = studentDao.findById(dto.getStudent().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", dto.getStudent().getId()));
        domain.setStudent(student);

        domain.setIsPresent(dto.getIsPresent());
        domain.setNotes(dto.getNotes());

        return domain;
    }
}
