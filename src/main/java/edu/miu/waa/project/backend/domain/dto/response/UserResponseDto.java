package edu.miu.waa.project.backend.domain.dto.response;

import edu.miu.waa.project.backend.domain.dto.PropertyDto;
import edu.miu.waa.project.backend.enumSet.RoleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.RoleStatus;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    private long id;
    private String name;

    private String email;
    private RoleType role;

    private List<PropertyDto> properties;


}
