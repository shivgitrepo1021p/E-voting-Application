package com.codingninjas.EVotingSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.services.ElectionService;

@RestController
//@RequestMapping("/election")
public class ElectionController {
@Autowired
ElectionService electionService;
//• POST "/winner/election" (@RequestBody Election election): It retrieves the ElectionChoice for a specific election as the winner.

@PostMapping("/winner/election")
public ElectionChoice getWinner(@RequestBody Election election) {
	Election updatedElec = electionService.findElectionByName(election.getName());
	return electionService.findElectionChoiceWithMaxVotes(updatedElec);
}


//• GET "/get/elections": It retrieves the list of all elections.

@GetMapping("/get/elections")
public List<Election> getAll(){
	return electionService.getAll();
}

//• POST "/add/election" (@RequestBody Election election): It creates a new election.
@PostMapping("/add/election")
public void addElection(@RequestBody Election election) {
	electionService.save(election);
}

}
