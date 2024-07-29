package com.codingninjas.EVotingSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.repositories.ElectionChoiceRepository;
import com.codingninjas.EVotingSystem.repositories.ElectionRepository;

@Service
public class ElectionService {
@Autowired
ElectionRepository electionRepository;

@Autowired
ElectionChoiceRepository electionChoiceRepository;
public List<Election> getAll() {
	// TODO Auto-generated method stub
	return electionRepository.findAll();
}

public void save(Election election) {
	electionRepository.save(election);
	
}



	public Election findElectionByName(String electionName) {
		return electionRepository.findByName(electionName).orElseThrow();
	}

	public ElectionChoice findElectionChoiceWithMaxVotes(Election updatedElec) {
	return electionChoiceRepository.findElectionChoiceWithMaxVotes(updatedElec.getId());
	}

	public ElectionChoice findElectionChoiceByNameAndElection(String name, Election election) {
		return electionChoiceRepository.findByNameAndElection(name,election).orElseThrow();

	}

	public long getTotalNumberOfChoicesByElection(Election updatedElection) {
		return electionChoiceRepository.countByElection(updatedElection);

	}
}
