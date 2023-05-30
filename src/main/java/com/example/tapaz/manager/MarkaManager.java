package com.example.tapaz.manager;

import com.example.tapaz.dto.MarkaDto;
import com.example.tapaz.entity.Marka;
import com.example.tapaz.exception.NotFoundExceptionn;
import com.example.tapaz.mapper.MarkaMapper;
import com.example.tapaz.pagenation.MarkaPageResponse;
import com.example.tapaz.repository.MarkaRepository;
import com.example.tapaz.service.MarkaService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class MarkaManager implements MarkaService {
    private final MarkaRepository markaRepository;
    private final MarkaMapper markaMapper;

    @Override
    public MarkaPageResponse getAll(int page,int count) {
        Page<Marka>markalist=markaRepository.findAll(PageRequest.of(page, count));
        return new MarkaPageResponse(markalist.getContent().stream().map(markaMapper::toMarkaDto).toList(),
                markalist.getTotalElements(),
                markalist.getTotalPages(),
                markalist.hasNext());
    }

    @Override
    public MarkaDto getById(int id) {
        return markaRepository.findById(id).stream().map(markaMapper::toMarkaDto).
                findFirst().orElseThrow(()->new  NotFoundExceptionn("bu emeliyyata uygun netice tapilmadi"));
    }

    @Override
    public Marka saveMarka(MarkaDto markaDto) {
        return markaRepository.save(markaMapper.toMarka(markaDto));
    }

    @Override
    public void deleteById(int id) {
        markaRepository.deleteById(id);

    }
}
