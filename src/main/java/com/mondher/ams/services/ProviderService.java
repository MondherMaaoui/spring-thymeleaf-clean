package com.mondher.ams.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mondher.ams.entities.Provider;
import com.mondher.ams.repositories.ProviderRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProviderService {
	
	@Autowired // Spring va se charger de creer un objet qui implemente cette inteface
	ProviderRepository providerRepository ;
	
	public Provider addProvider(Provider provider) {
		
		return providerRepository.save(provider);
	}
	
	public List<Provider> listProvider(){
		return (List<Provider>) providerRepository.findAll();
	}
	
	public void deleteProvider(long id) {
		 providerRepository.deleteById(id);
	}
	
	public Provider findProviderById(Long id) {
	    return providerRepository.findById(id)
	            .orElseThrow(() -> new EntityNotFoundException("Provider with id " + id + " not found"));
	}

	
	public Provider updateProvider(long id, Provider updatedProvider) {
	    Optional<Provider> existingOptional = providerRepository.findById(id);
	    
	    if (existingOptional.isPresent()) {
	        Provider existing = existingOptional.get();
	        existing.setName(updatedProvider.getName());
	        existing.setAdresse(updatedProvider.getAdresse());
	        existing.setEmail(updatedProvider.getEmail());

	        return providerRepository.save(existing);
	    } else {
	        throw new EntityNotFoundException("Provider with id " + id + " not found");
	    }
	}


}
