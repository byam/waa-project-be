package edu.miu.waa.project.backend.controller;

import edu.miu.waa.project.backend.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/offers")
public class OfferController {

    private final OfferService offerService;

//    @PostMapping
//    @ResponseStatus(HttpStatus.OK)
//    public void save(@RequestBody OfferDto offerDto){
//        offerService.save()
//
//    }
}
