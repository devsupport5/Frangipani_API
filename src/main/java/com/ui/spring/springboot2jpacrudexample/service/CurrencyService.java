package com.ui.spring.springboot2jpacrudexample.service;

import java.util.List;
import java.util.Optional;

import com.ui.spring.springboot2jpacrudexample.model.Currency;

public interface CurrencyService {
	
	List<Currency> getAllCurrencys();

	Optional<Currency> getCurrencyById(Long currencyId);

	Currency createCurrency(Currency currency);	

	Currency updateCurrency(Currency currency);

	void deleteCurrency(Currency currency);
	
}
