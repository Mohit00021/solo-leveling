package com.mo.sololeveling.controller;

import com.mo.sololeveling.modle.PlayerRequestDto;
import com.mo.sololeveling.modle.SkillTest;
import com.mo.sololeveling.service.PlayerService;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/player")
public class PlayerController {
    private final PlayerService playerService;


    @PostMapping(path = "/create")
    public ResponseEntity<String> createPlayer(@RequestBody PlayerRequestDto playerRequestDto) throws BadRequestException {
        return playerService.createPlayer(playerRequestDto);
    }

    @GetMapping(path = "/skillTest")
    public ResponseEntity<List<SkillTest>> testSkill(@RequestParam String skillName){
       List<SkillTest> response = playerService.testSkill(skillName);
        return !response.isEmpty() ? ResponseEntity.ok(response) : ResponseEntity.internalServerError().build();
    }
}
