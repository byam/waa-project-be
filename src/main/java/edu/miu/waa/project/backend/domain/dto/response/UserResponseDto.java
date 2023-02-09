package edu.miu.waa.project.backend.domain.dto.response;

import edu.miu.waa.project.backend.domain.dto.PropertyDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    private long id;
    private String name;

    private String email;

    private List<PropertyDto> properties;
    private List<PropertyDto> favourites;

}
