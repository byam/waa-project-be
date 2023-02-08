package edu.miu.waa.project.backend.repo;

import edu.miu.waa.project.backend.domain.Inquiry;
import edu.miu.waa.project.backend.domain.Offer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InquiryRepo extends CrudRepository<Inquiry, Long> {
    List<Inquiry> findAllByUserId(long userId);

}
