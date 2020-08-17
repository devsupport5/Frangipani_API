package com.ui.spring.springboot2jpacrudexample.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ui.spring.springboot2jpacrudexample.beans.CurrencyDTO;
import com.ui.spring.springboot2jpacrudexample.exception.ResourceNotFoundException;
import com.ui.spring.springboot2jpacrudexample.model.Currency;
import com.ui.spring.springboot2jpacrudexample.service.CurrencyService;

@CrossOrigin
@RestController
@RequestMapping("/api/currency")
public class CurrencyController {

	@Autowired
	CurrencyService currencyService;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@GetMapping("/currencys")
	public List<CurrencyDTO> getAllCurrencys() {
		List<Currency> currencies = currencyService.getAllCurrencys();
		return currencies.stream().map(this::convertToDto).collect(Collectors.toList());
	}
	
	@GetMapping("/currencys/activeList")
	public List<CurrencyDTO> getActiveListCurrencys() {
		List<Currency> currencies = currencyService.getActiveCurrencys();
		return currencies.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	@GetMapping("/currencys/{id}")
	public ResponseEntity<CurrencyDTO> getCurrencyById(@PathVariable(value = "id") Long CurrencyId) {
		Currency currency = currencyService.getCurrencyById(CurrencyId).get();
		return ResponseEntity.ok().body(convertToDto(currency));
	}

	@PostMapping("/currencys")
	public Currency createCurrency(@Valid @RequestBody CurrencyDTO currencyDTO) {
		return currencyService.createCurrency(convertToEntity(currencyDTO));
	}

	@PutMapping("/currencys/{id}")
	public ResponseEntity<Currency> updateCurrency(@PathVariable(value = "id") Long currencyId,
			@Valid @RequestBody Currency CurrencyDetails) throws ResourceNotFoundException {
		Currency Currency = currencyService.getCurrencyById(currencyId)
				.orElseThrow(() -> new ResourceNotFoundException("Currency not found for this id :: " + currencyId));

		Currency.setId(CurrencyDetails.getId());
		Currency.setCurrencyName(CurrencyDetails.getCurrencyName());
		Currency.setCurrencySymbol(CurrencyDetails.getCurrencySymbol());
		final Currency updatedCurrency = currencyService.updateCurrency(CurrencyDetails);
		return ResponseEntity.ok(updatedCurrency);
	}

	@DeleteMapping("/currencys/{id}")
	public Map<String, Boolean> deleteCurrency(@PathVariable(value = "id") Long CurrencyId)
			throws ResourceNotFoundException {
		Currency Currency = currencyService.getCurrencyById(CurrencyId)
				.orElseThrow(() -> new ResourceNotFoundException("Currency not found for this id :: " + CurrencyId));

		currencyService.deleteCurrency(Currency);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	public CurrencyDTO convertToDto(Currency Currency) {
		CurrencyDTO CurrencyDTO = modelMapper.map(Currency, CurrencyDTO.class);
		return CurrencyDTO;
	}
	
	public Currency  convertToEntity(CurrencyDTO CurrencyDTO) {
		Currency Currency = modelMapper.map(CurrencyDTO, Currency.class);
		return Currency;
	}
	
	 
}
