package com.clone.reddit.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.clone.reddit.exceptions.SpringRedditException;
import com.clone.reddit.mapper.SubredditMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clone.reddit.dto.SubredditDto;
import com.clone.reddit.model.Subreddit;
import com.clone.reddit.repository.SubredditRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class SubredditService {

	private final SubredditRepository subredditRepository;
	private final SubredditMapper subredditMapper;

	@Transactional
	public SubredditDto save(SubredditDto subredditDto) {
		Subreddit save = subredditRepository.save(subredditMapper.mapDtoToSubreddit(subredditDto));
		subredditDto.setId(save.getId());
		return subredditDto;
	}
	
	@Transactional(readOnly = true)
	public List<SubredditDto> getAll() {
		return subredditRepository.findAll()
				.stream()
				.map(subredditMapper::mapSubredditToDto)
				.collect(Collectors.toList());
		
	}


	public SubredditDto getSubreddit(Long id) {
		Subreddit sub = subredditRepository.findById(id)
				.orElseThrow(() -> new SpringRedditException("Subreddit not found"));

		return subredditMapper.mapSubredditToDto(sub);
	}
}
