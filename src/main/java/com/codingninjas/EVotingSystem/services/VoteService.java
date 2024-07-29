package com.codingninjas.EVotingSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.Vote;
import com.codingninjas.EVotingSystem.repositories.ElectionRepository;
import com.codingninjas.EVotingSystem.repositories.VoteRepository;

@Service
public class VoteService {
@Autowired
VoteRepository voteRepository;

@Autowired
ElectionRepository electionRepository;

	public List<Vote> getAll() {
		
		return voteRepository.findAll();
		
	}

	public void saveVote(Vote vote) {
		voteRepository.save(vote);
		
	}

	public long getCountOfAllVotes() {
		List<Vote> listVotes = voteRepository.findAll();
		return (long)listVotes.size();
	}

	public long getCountByElection(Election election) {

		return voteRepository.countVotesByElection(election);
	}

}
