package com.mo.sololeveling.modle;

import com.mo.sololeveling.entity.Skills;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlayerRequestDto {

    private String username;
    private String email;
    private int age;
    private List<Skills> skills;

}
