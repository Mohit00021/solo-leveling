package com.mo.sololeveling.controller;

import com.mo.sololeveling.modle.PlayerRequestDto;
import com.mo.sololeveling.service.PlayerService;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@Controller
public class PlayerController {
    private final PlayerService playerService;
//    String baseUrl = "/player";


    @PostMapping(path = "/player/create")
    public ResponseEntity<String> createPlayer(@RequestBody PlayerRequestDto playerRequestDto) throws BadRequestException {
        return playerService.createPlayer(playerRequestDto);
    }
}
