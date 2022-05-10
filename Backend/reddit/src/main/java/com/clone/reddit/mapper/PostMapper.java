package com.clone.reddit.mapper;

import com.clone.reddit.dto.PostRequest;
import com.clone.reddit.dto.PostResponse;
import com.clone.reddit.model.Post;
import com.clone.reddit.model.Subreddit;
import com.clone.reddit.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper {
    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "description", source = "postRequest.description")
    @Mapping(target = "subreddit", source = "subreddit")
    @Mapping(target = "voteCount", constant = "0")
    @Mapping(target = "user", source = "user")
    Post map(PostRequest postRequest, Subreddit subreddit, User user);

    @Mapping(target = "id", source = "postId")
    @Mapping(target = "subredditName", source = "subreddit.name")
    @Mapping(target = "userName", source = "user.username")
//    @Mapping(target = "commentCount", expression = "java(commentCount(post))")
//    @Mapping(target = "duration", expression = "java(getDuration(post))")
//    @Mapping(target = "upVote", expression = "java(isPostUpVoted(post))")
//    @Mapping(target = "downVote", expression = "java(isPostDownVoted(post))")
     PostResponse mapToDto(Post post);
}
