package edu.miu.waa.project.backend.repo;

import edu.miu.waa.project.backend.domain.Inquiry;
import edu.miu.waa.project.backend.domain.Offer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InquiryRepo extends CrudRepository<Inquiry, Long> {
    List<Inquiry> findAllByUserId(long userId);

    @Query("select i from Inquiry i join i.property p join p.owner u where u.id=:ownerId")
    List<Offer> findAllByOwnerId(@Param("ownerId") long ownerId);

}
