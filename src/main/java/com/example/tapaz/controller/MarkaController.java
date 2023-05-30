package com.example.tapaz.controller;
import com.example.tapaz.dto.MarkaDto;
import com.example.tapaz.entity.Marka;
import com.example.tapaz.manager.MarkaManager;
import com.example.tapaz.pagenation.MarkaPageResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/marka")
public class MarkaController {

    public final MarkaManager markaManager;

    public MarkaController(MarkaManager markaManager) {
        this.markaManager = markaManager;
    }

    @GetMapping
    public MarkaPageResponse getAll(int page, int count){
        return markaManager.getAll(page, count);
    }
    @GetMapping("/{id}")
    public MarkaDto getById(@PathVariable int id){
        return markaManager.getById(id);
    }


    @PostMapping("/post/")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void saveMarka(@RequestBody @Valid Marka marka){
        markaManager.saveMarka(new MarkaDto(marka.getName()));
    }
    @DeleteMapping("/delete/{id}")
    public void deleteMarka(@PathVariable int id){
        markaManager.deleteById(id);
    }
}
