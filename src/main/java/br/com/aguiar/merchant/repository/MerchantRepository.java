package br.com.aguiar.merchant.repository;

import br.com.aguiar.merchant.model.Merchant;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MerchantRepository extends CrudRepository<Merchant, UUID> {
}
