package edu.miu.waa.project.backend.controller;

import edu.miu.waa.project.backend.domain.dto.request.OfferStatusRequest;
import edu.miu.waa.project.backend.domain.dto.response.HttpResponse;
import edu.miu.waa.project.backend.domain.dto.response.OfferDto;
import edu.miu.waa.project.backend.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/offers")
public class OfferController {

    private final OfferService offerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OfferDto> findAll() {
        return offerService.findAll();
    }

    @PutMapping("/{id}")
    public HttpResponse update(@PathVariable long id, @RequestBody OfferStatusRequest request) {
        return offerService.updateStatus(id, request.getStatus());
    }
}
