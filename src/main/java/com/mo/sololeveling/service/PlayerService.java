package com.mo.sololeveling.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mo.sololeveling.entity.Player;
import com.mo.sololeveling.modle.PlayerRequestDto;
import com.mo.sololeveling.modle.SkillTest;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class PlayerService {

    private final GeminiService geminiService;


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

    public List<SkillTest> testSkill(String skill){

        try {
            String geminiPrompt = readFileContent("src/main/resources/geminiPrompt.txt");
            geminiPrompt = geminiPrompt + skill;
            String LLMResponse = geminiService.getCompletion(geminiPrompt);
            ObjectMapper mapper = new ObjectMapper();
            try {
                return mapper.readValue(LLMResponse, new TypeReference<>() {
                });

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String readFileContent(String filePath) throws IOException {
        byte[] fileBytes = Files.readAllBytes(Paths.get(filePath));
        return new String(fileBytes);
    }
}
