package com.codingninjas.EVotingSystem.controllers;

import java.util.List;

import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.entities.User;
import com.codingninjas.EVotingSystem.services.ElectionService;
import com.codingninjas.EVotingSystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.Vote;
import com.codingninjas.EVotingSystem.repositories.ElectionRepository;
import com.codingninjas.EVotingSystem.services.VoteService;

@RestController
//@RequestMapping("/votes")
public class VoteController {
@Autowired
VoteService voteService;

@Autowired
ElectionService votingService;

@Autowired
UserService userService;

//    • GET "/get/votes": It fetches the list of all votes from the database.
   @GetMapping("/get/votes")
   public List<Vote> getAll() {
	   return voteService.getAll();
   }
	
	
//    • POST "/add/vote" (@RequestBody Vote vote): It register a new vote into the database.
@PostMapping("/add/vote")
public void saveVote(@RequestBody Vote vote) {
    Vote updatedVote = new Vote();
    User user = userService.findUserByName(vote.getUser().getName());
    Election election = votingService.findElectionByName(vote.getElection().getName());
    ElectionChoice electionChoice = votingService.findElectionChoiceByNameAndElection(vote.getElectionChoice().getName(),election);
    updatedVote.setElection(election);
    updatedVote.setElectionChoice(electionChoice);
    updatedVote.setUser(user);
    voteService.saveVote(updatedVote);
}
//    • GET "/count/votes": It fetches the count of total votes from the database.
 @GetMapping("/count/votes")
public long getCountOfAllVotes() {
	 return voteService.getCountOfAllVotes();
 }
//    • POST "/count/election/votes" (@RequestBody Election election): It returns the count of total votes by-election in long.
 @PostMapping("/count/election/votes")
 public long getCountByElection(@RequestBody Election election) {
	 
	return voteService.getCountByElection(election);
	 
 }
 
 
 
 
 
 
}
