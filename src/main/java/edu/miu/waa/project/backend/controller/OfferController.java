package edu.miu.waa.project.backend.controller;

import edu.miu.waa.project.backend.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/offers")
public class OfferController {

    private final OfferService offerService;
}
