package com.zeek.learnspringwebflux;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liweibo03 <liweibo03@kuaishou.com>
 * Created on 2020-10-15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String id;

    @NotBlank
    @Size(min = 3, max = 5)
    private String name;

    @NotNull
    @Pattern(regexp = "[A-Z][a-z][0-9]")
    private String password;

    @NotNull
    private Integer age;

    @Max(10)
    @Min(1)
    private Integer level;

}

