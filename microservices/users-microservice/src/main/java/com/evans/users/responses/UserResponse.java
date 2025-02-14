package com.evans.users.responses;


import com.evans.users.models.Role;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserResponse {
    private UUID id;
    private String name;
    private String surname;
    private String lastname;
    private String username;
    private String email;
    private boolean isActive;
    private String imageProfile;
    private List<Role> roles = new ArrayList<>();
}
