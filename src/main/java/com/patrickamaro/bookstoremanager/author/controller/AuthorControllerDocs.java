package com.patrickamaro.bookstoremanager.author.controller;

import com.patrickamaro.bookstoremanager.author.dto.AuthorDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Tag(name = "AuthorController", description = "Author management")
public interface AuthorControllerDocs {
    @Operation(summary = "Author creation operation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success author creation"),
            @ApiResponse(responseCode = "400", description = "Missing required fields, wrong field range value or author already registered on system")
    })
    public AuthorDTO create( AuthorDTO authorDTO);
}
