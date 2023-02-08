package edu.miu.waa.project.backend.domain.dto.response;

import edu.miu.waa.project.backend.domain.dto.PropertyDto;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class UserResponseDto {

    private long id;
    private String name;

    private String email;

    private PropertyDto properties;

    private PropertyDto favourites;
}
