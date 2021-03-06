package com.patrickamaro.bookstoremanager.author.builder;

import com.patrickamaro.bookstoremanager.author.dto.AuthorDTO;
import lombok.Builder;

@Builder
public class AuthorDTOBuilder {

    @Builder.Default
    private final Long id = 1L;

    @Builder.Default
    private final String name = "Patrick";

    @Builder.Default
    private final Integer age = 19;

    public AuthorDTO buildAuthorDTO() {
      return new AuthorDTO(id, name, age);
    }
}
