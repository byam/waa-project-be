package edu.miu.waa.project.backend.domain.dto.response;

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

    private List<PropertyUserResponseDto> properties;

}
