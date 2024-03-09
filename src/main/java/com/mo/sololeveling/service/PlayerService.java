package com.mo.sololeveling.service;

import com.mo.sololeveling.entity.Player;
import com.mo.sololeveling.entity.Skills;
import com.mo.sololeveling.modle.PlayerRequestDto;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PlayerService {


    public ResponseEntity<String> createPlayer(final PlayerRequestDto playerRequestDto) throws BadRequestException {
        //TODO: checks to implement : unique username, email
        // email is given unique constraint either handle exception in catch or remove constraint.
        try {
            Player player = new Player();
            player.setEmail(playerRequestDto.getEmail());
            player.setUserName(playerRequestDto.getUsername());
            player.setPlayerRank("E");
            player.setStartDate(LocalDate.now());
            return ResponseEntity.ok("User created.");
        } catch (Exception e) {
            throw new BadRequestException("An Error occurred while uploading player data.");
        }
    }

    private void testSkill(Skills skill){
        //todo: challenging and the main part of the project
        // 1decide how many skills should be in the system
        // 2write a generic ai prompt for a small basic test
        // use gpt api/bard.
    }
}
