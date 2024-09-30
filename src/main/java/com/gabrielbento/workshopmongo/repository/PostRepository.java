package com.gabrielbento.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gabrielbento.workshopmongo.domain.Post;
import com.gabrielbento.workshopmongo.domain.User;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}
