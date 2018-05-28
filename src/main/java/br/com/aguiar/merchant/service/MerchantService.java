package br.com.aguiar.merchant.service;

import br.com.aguiar.merchant.model.Merchant;
import br.com.aguiar.merchant.repository.MerchantRepository;
import br.com.aguiar.merchant.service.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MerchantService {

    private MerchantRepository merchantRepository;

    public MerchantService(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    public Merchant get(UUID id) {
        return merchantRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Merchant not found"));
    }

    public Merchant save(Merchant merchant) {
        return merchantRepository.save(merchant);
    }

    public void update(Merchant merchant) {
        merchantRepository.save(merchant);
    }

    public void delete(UUID id) {
        merchantRepository.delete(merchantRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Merchant not found before delete")));
    }
}
