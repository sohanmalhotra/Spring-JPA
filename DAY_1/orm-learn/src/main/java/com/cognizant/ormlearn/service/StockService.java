package com.cognizant.ormlearn.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;

@Service
public class StockService {

	@Autowired
	StockRepository stockRepository;

	@Transactional
	public void getAllFbSeptService() {
		List<Stock> allFbSept = stockRepository.getAllFbSept("FB");
		for (Stock s : allFbSept) {
			System.out.println(s.toString());
		}
	}

	@Transactional
	public void getAllGoogleService() {
		List<Stock> list = stockRepository.getAllGoogle("GOOGL");
		for (Stock s : list) {
			System.out.println(s.toString());
		}
	}

	@Transactional
	public void getTopThreeService() {
		Pageable sortedByVolume = PageRequest.of(0, 3, Sort.by("volume").descending());
		List<Stock> list = stockRepository.getAllTopThree(sortedByVolume);
		for (Stock s : list) {
			System.out.println(s.toString());
		}
	}

	@Transactional
	public void getLeastNetflixService() {
		Pageable sortedByStockOpen = PageRequest.of(0, 3, Sort.by("stockOpen").ascending());
		List<Stock> list = stockRepository.getLeastThreeNetflix("NFLX", sortedByStockOpen);
		for (Stock s : list) {
			System.out.println(s.toString());
		}

	}

}
