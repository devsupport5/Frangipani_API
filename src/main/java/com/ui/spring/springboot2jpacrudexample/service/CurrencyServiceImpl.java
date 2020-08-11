package com.ui.spring.springboot2jpacrudexample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ui.spring.springboot2jpacrudexample.model.Currency;
import com.ui.spring.springboot2jpacrudexample.repository.CurrencyRepository;


@Service
public class CurrencyServiceImpl implements CurrencyService{

 
	@Autowired
	private CurrencyRepository  CurrencyRepository;
	
	@Override
	public List<Currency> getAllCurrencys() {
		return this.CurrencyRepository.findAll();
	}

	@Override
	public Optional<Currency> getCurrencyById(Long currencyId) {
		return this.CurrencyRepository.findById(currencyId);
	}

	@Override
	public Currency createCurrency(Currency currency) {
		return this.CurrencyRepository.save(currency);
	}

	@Override
	public Currency updateCurrency(Currency currency) {
		return this.CurrencyRepository.save(currency);
	}

	@Override
	public void deleteCurrency(Currency currency) {
		this.CurrencyRepository.delete(currency);
	}

	@Override
	public Currency getDefaultCurrency() {
		// TODO Auto-generated method stub
		System.out.println("size-----------------"+ this.CurrencyRepository.getDefaultCurrency().size());
		if(this.CurrencyRepository.getDefaultCurrency().size() > 0)
			return this.CurrencyRepository.getDefaultCurrency().get(0);
		else
			return new Currency();
	}

	 

}
