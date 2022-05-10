package com.clone.reddit.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.clone.reddit.dto.SubredditDto;
import com.clone.reddit.model.Post;
import com.clone.reddit.model.Subreddit;

@Mapper(componentModel = "spring")
public interface SubredditMapper {

	//Creates DTO from Original class
	//Copy only the values that are on DTO from original Class.
    @Mapping(target = "numberOfPosts", expression = "java(mapPosts(subreddit.getPosts()))")
    SubredditDto mapSubredditToDto(Subreddit subreddit);
    
    //Counts the number of posts to be added to SubredditDTO above.
    default Integer mapPosts(List<Post> numberOfPosts) {
        return numberOfPosts.size();
    }
    
    //Creates Original class from DTO
    @InheritInverseConfiguration
    @Mapping(target = "posts", ignore = true)
    Subreddit mapDtoToSubreddit(SubredditDto subredditDto);
}
