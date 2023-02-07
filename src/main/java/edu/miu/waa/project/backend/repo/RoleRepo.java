package edu.miu.waa.project.backend.repo;

import edu.miu.waa.project.backend.domain.Role;
import edu.miu.waa.project.backend.enumSet.RoleType;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepo extends CrudRepository<Role,Long> {

//    Role findByRole(String role);

    Role findByRole(RoleType role);
}
