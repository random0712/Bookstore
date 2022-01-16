package com.patrickamaro.bookstoremanager.author.controller;

import com.patrickamaro.bookstoremanager.author.builder.AuthorDTOBuilder;
import com.patrickamaro.bookstoremanager.author.dto.AuthorDTO;
import com.patrickamaro.bookstoremanager.author.service.AuthorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import static com.patrickamaro.bookstoremanager.utils.JsonConversionUtils.asJsonString;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class AuthorControllerTest {

    private static final String AUTHOR_API_URL_PATH = "/api/v1/authors";

    @Mock
    private AuthorService authorService;

    @InjectMocks
    private AuthorController authorController;

    private MockMvc mockMvc;

    private AuthorDTOBuilder authorDTOBuilder;

    @BeforeEach
    void setUp() {
        authorDTOBuilder = AuthorDTOBuilder.builder().build();
        mockMvc = MockMvcBuilders.standaloneSetup(authorController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((s, locale) -> new MappingJackson2JsonView())
                .build();
    }

    @Test
    void whenPOSTIsCalledThenStatusCreatedShouldBeReturned() throws Exception {
        AuthorDTO expectedCreatedAuthorDTO = authorDTOBuilder.buildAuthorDTO();

        Mockito.when(authorService.create(expectedCreatedAuthorDTO))
                .thenReturn(expectedCreatedAuthorDTO);

        mockMvc.perform(post(AUTHOR_API_URL_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(expectedCreatedAuthorDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(expectedCreatedAuthorDTO.getId().intValue())))
                .andExpect(jsonPath("$.age", is(expectedCreatedAuthorDTO.getAge())))
                .andExpect(jsonPath("$.name", is(expectedCreatedAuthorDTO.getName())));
    }

    @Test
    void whenPOSTIsCalledWithoutRequiredFieldsThenBadRequestShouldBeInformed() throws Exception {
        AuthorDTO expectedCreatedAuthorDTO = authorDTOBuilder.buildAuthorDTO();
        expectedCreatedAuthorDTO.setName(null);

        mockMvc.perform(post(AUTHOR_API_URL_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(expectedCreatedAuthorDTO)))
                .andExpect(status().isBadRequest());
    }
}
