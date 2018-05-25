package br.com.aguiar.merchant.controller;

import br.com.aguiar.merchant.model.Merchant;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@Controller
@RequestMapping("/merchants")
public class MerchantController {

    @GetMapping("/{id}")
    public ResponseEntity<Merchant> getMerchant(@PathVariable(value = "id") UUID id) {
        Merchant body = new Merchant();
        body.setId(id);
        body.setName("Test");
        return ResponseEntity.ok(body);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Merchant merchant) {
        throw new RuntimeException("bla");
//        URI uriLocation = URI.create("localhost:8080"+"/merchants"+"/uuid");
//        return ResponseEntity.created(uriLocation).build();
    }

}
