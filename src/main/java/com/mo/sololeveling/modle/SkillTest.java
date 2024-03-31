package com.mo.sololeveling.modle;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SkillTest {
    private String question;
    private List<String> options;
    private String correctAnswer;
    private int weightage;
    private String level;
}