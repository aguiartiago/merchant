package br.com.aguiar.merchant.controller;

import br.com.aguiar.merchant.model.Merchant;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import br.com.aguiar.merchant.service.MerchantService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@Controller
@RequestMapping("/merchants")
public class MerchantController {

    private MerchantService merchantService;

    public MerchantController(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Merchant> get(@PathVariable(value = "id") UUID id) {
        Merchant merchantFound = merchantService.get(id);
        return ResponseEntity.ok().body(merchantFound);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Merchant merchant) {
        Merchant merchantSaved = merchantService.save(merchant);
        URI uriLocation = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(merchantSaved.getId()).toUri();
        return ResponseEntity.created(uriLocation).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable(value = "id") UUID id, @RequestBody Merchant merchant) {
        merchant.setId(id);
        merchantService.update(merchant);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Merchant> delete(@PathVariable(value = "id") UUID id) {
        merchantService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
