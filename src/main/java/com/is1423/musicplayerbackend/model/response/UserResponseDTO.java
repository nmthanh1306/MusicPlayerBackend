package com.is1423.musicplayerbackend.model.response;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {


    private Long id;

    @NotBlank
    private String userName;

    @NotBlank
    private String password;

    private String role;

}
