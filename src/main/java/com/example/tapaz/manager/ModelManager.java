package com.example.tapaz.manager;

import com.example.tapaz.dto.ModelDto;
import com.example.tapaz.entity.Model;
import com.example.tapaz.exception.NotFoundException;
import com.example.tapaz.mapper.ModelMapper;
import com.example.tapaz.pagenation.ModelPageResponse;
import com.example.tapaz.repository.ModelRepository;
import com.example.tapaz.service.ModelService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ModelManager implements ModelService {
    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;
    @Override
    public ModelPageResponse getAll(int page, int count) {
        Page<Model>modelList=modelRepository.findAll(PageRequest.of(page, count));

        return new ModelPageResponse(modelList.getContent().stream().map(modelMapper::toModelDto).toList(),
                modelList.getTotalElements(),
                modelList.getTotalPages(),
                modelList.hasNext());
    }

    @Override
    public ModelDto getById(int id) {

        return modelRepository.findById(id).stream().map(modelMapper::toModelDto).findFirst().
                orElseThrow(()->new NotFoundException("daxil etdiyiniz melumata uygun istifadeci tapilmadi"));
    }

    @Override
    public Model saveModel(ModelDto modelDto) {

        return modelRepository.save(modelMapper.toModel(modelDto));
    }

    @Override
    public void deleteById(int id) {
        modelRepository.deleteById(id);

    }
}
