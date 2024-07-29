package com.codingninjas.EVotingSystem.controllers;

import java.util.List;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.services.ElectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.services.ElectionChoiceService;

@RestController
//@RequestMapping("/electionChoice")
public class ElectionChoiceController {
@Autowired
ElectionChoiceService electionChoiceService;

@Autowired
ElectionService votingService;
	

//• POST "/add/electionChoice" (@RequestBody ElectionChoice electionChoice): It adds a election choice.
@PostMapping("/add/electionChoice")
public void save(@RequestBody ElectionChoice electionChoice) {
	ElectionChoice updatedElectionChoice = new ElectionChoice();
	Election election = votingService.findElectionByName(electionChoice.getElection().getName());
	updatedElectionChoice.setName(electionChoice.getName());
	updatedElectionChoice.setElection(election);
	electionChoiceService.save(updatedElectionChoice);
}
//• GET "/get/electionChoices": It fetches the list of all electionChoices from the database.
@GetMapping("/get/electionChoices")
public List<ElectionChoice> getAll(){
	return electionChoiceService.getAll();
}

	@PostMapping("/count/election/choices")
	public long getTotalNumberOfChoicesByElection(@RequestBody Election election) {
		Election updatedElection = votingService.findElectionByName(election.getName());
		return votingService.getTotalNumberOfChoicesByElection(updatedElection);
	}
	
}
