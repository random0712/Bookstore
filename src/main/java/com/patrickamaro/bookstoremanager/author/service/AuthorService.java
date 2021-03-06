package com.patrickamaro.bookstoremanager.author.service;

import com.patrickamaro.bookstoremanager.author.dto.AuthorDTO;
import com.patrickamaro.bookstoremanager.author.entity.Author;
import com.patrickamaro.bookstoremanager.author.mapper.AuthorMapper;
import com.patrickamaro.bookstoremanager.author.repository.AuthorRepository;
import com.patrickamaro.bookstoremanager.exception.AuthorAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private final static AuthorMapper authorMapper = AuthorMapper.INSTANCE;

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public AuthorDTO create(AuthorDTO authorDTO) {
        verifyIfExists(authorDTO.getName());
        Author authorToCreate = authorMapper.toModel(authorDTO);
        Author createdAuthor = authorRepository.save(authorToCreate);
        return authorMapper.toDTO(createdAuthor);
    }

    private void verifyIfExists(String authorName) {
        authorRepository.findByName(authorName)
                .ifPresent(author -> {throw new AuthorAlreadyExistsException(author.getName()); });
    }
}
