package com.example.tapaz.controller;

import com.example.tapaz.dto.ModelDto;
import com.example.tapaz.entity.Model;
import com.example.tapaz.manager.ModelManager;
import com.example.tapaz.pagenation.ModelPageResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/models")


public class ModelController {
    public final ModelManager modelManager;

    public ModelController(ModelManager modelManager) {
        this.modelManager = modelManager;
    }

    @GetMapping
    public ModelPageResponse getAll(int page, int count){
        return modelManager.getAll(page, count);
    }
    @GetMapping("/{id}")
    public ModelDto getById(@PathVariable int id){
      return   modelManager.getById(id);
    }
    @PostMapping("/post")
    public void saveModel(@RequestBody @Valid Model model){
        modelManager.saveModel(new ModelDto(model.getName(),model.getMarka().getId()));
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id){
        modelManager.deleteById(id);
    }
}
