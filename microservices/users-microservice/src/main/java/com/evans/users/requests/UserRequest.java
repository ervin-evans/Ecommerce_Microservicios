package com.evans.users.requests;

import com.evans.users.models.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserRequest {

    private UUID id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String name;

    @NotBlank(message = "El apellido paterno es obligatorio")
    @Size(min = 3, max = 50, message = "El apellido paterno debe tener entre 3 y 50 caracteres")
    private String surname;

    @NotBlank(message = "El apellido materno es obligatorio")
    @Size(min = 3, max = 50, message = "El apellido materno debe tener entre 3 y 50 caracteres")
    private String lastname;

    @NotBlank(message = "El username es obligatorio")
    @Size(min = 3, max = 50, message = "El username debe tener entre 3 y 50 caracteres")
    private String username;

    @NotBlank(message = "El password es obligatorio")
    @Size(min = 6, max = 50, message = "El password debe tener al menos 6 caracteres")
    private String password;

    @NotBlank(message = "El e-mail es obligatorio")
    @Email(message = "El e-mail debe tener un formato valido")
    private String email;

    private String imageProfile = "default_image_profile.png";
}
