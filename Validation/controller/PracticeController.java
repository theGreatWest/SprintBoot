package com.example.validation.controller;

import com.example.validation.model.PracticeAPI;
import com.example.validation.model.PracticeDTO;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j

@RestController
@RequestMapping("/api/practice")
public class PracticeController {

    @PostMapping("/date")
    public PracticeAPI<PracticeDTO> practice(
            @Valid @RequestBody PracticeAPI<PracticeDTO> api
    ){
        log.info("init : {}",api);

        PracticeDTO body = api.getData();

        PracticeAPI<PracticeDTO> response = PracticeAPI
                .<PracticeDTO>builder()
                .data(body)
                .resultCode(HttpStatus.OK.value())
                .resultMessage(HttpStatus.OK.getReasonPhrase())
                .build();

        return response;
    }
}
