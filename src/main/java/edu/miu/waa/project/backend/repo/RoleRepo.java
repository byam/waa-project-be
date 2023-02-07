package edu.miu.waa.project.backend.repo;

import edu.miu.waa.project.backend.domain.Role;
import edu.miu.waa.project.backend.enumSet.RoleValue;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepo extends CrudRepository<Role,Long> {

//    Role findByRole(String role);

    Role findByRole(RoleValue role);
}
