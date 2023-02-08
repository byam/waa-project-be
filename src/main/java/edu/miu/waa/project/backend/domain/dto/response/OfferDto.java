package edu.miu.waa.project.backend.domain.dto.response;

import edu.miu.waa.project.backend.enumSet.OfferStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfferDto {
    private long id;
    private String message;
    private OfferStatus offerStatus;
    private Double price;

}
