package com.codingninjas.EVotingSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.repositories.ElectionChoiceRepository;

@Service
public class ElectionChoiceService {
	@Autowired
	ElectionChoiceRepository electionChoiceRepository;

	public void save(ElectionChoice electionChoice) {
		electionChoiceRepository.save(electionChoice);
		
	}

	public List<ElectionChoice> getAll() {
		// TODO Auto-generated method stub
		return electionChoiceRepository.findAll();
	}
}
