package AngelusDaniel.controllers.docs;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import AngelusDaniel.data.dto.v1.PersonDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

public interface PersonControllerDocs {

  @Operation(
      summary = "Find a Person", 
      tags= {"People"},
      responses = {
        @ApiResponse(description = "Success", responseCode = "200", 
          content = @Content(
            mediaType = MediaType.APPLICATION_JSON_VALUE,
            schema = @Schema(implementation = PersonDTO.class))
            ),      
        @ApiResponse(description = "No Content", responseCode = "204"),
        @ApiResponse(description = "Bad Request", responseCode = "400"),
        @ApiResponse(description = "Unauthorized", responseCode = "401"),
        @ApiResponse(description = "Forbidden", responseCode = "403"),
        @ApiResponse(description = "Not Found", responseCode = "404"),
        @ApiResponse(description = "Internal Server Error", responseCode = "500")
      },
      description = "Find a specific person by ID"
      )
  PersonDTO findById(Long id);
  

  @Operation(
    summary = "Find all people", 
    tags= {"People"},
    responses = {
      @ApiResponse(description = "Success", responseCode = "200", content = {
        @Content(
          mediaType = MediaType.APPLICATION_JSON_VALUE,
          array = @ArraySchema(schema = @Schema(implementation = PersonDTO.class)))
      }),
      @ApiResponse(description = "No Content", responseCode = "204"),
      @ApiResponse(description = "Bad Request", responseCode = "400"),
      @ApiResponse(description = "Unauthorized", responseCode = "401"),
      @ApiResponse(description = "Forbidden", responseCode = "403"),
      @ApiResponse(description = "Not Found", responseCode = "404"),
      @ApiResponse(description = "Internal Server Error", responseCode = "500")
    },
    description = "Find all people in the database"
    )
  List<PersonDTO> findAll();

  @Operation(
      summary = "Create a Person", 
      tags= {"People"},
      responses = {
        @ApiResponse(description = "Success", responseCode = "200", 
          content = @Content(
            mediaType = MediaType.APPLICATION_JSON_VALUE,
            schema = @Schema(implementation = PersonDTO.class))
            ),      
        @ApiResponse(description = "No Content", responseCode = "204"),
        @ApiResponse(description = "Bad Request", responseCode = "400"),
        @ApiResponse(description = "Unauthorized", responseCode = "401"),
        @ApiResponse(description = "Forbidden", responseCode = "403"),
        @ApiResponse(description = "Not Found", responseCode = "404"),
        @ApiResponse(description = "Internal Server Error", responseCode = "500")
      },
      description = "Create a new person"
      )
  PersonDTO create(PersonDTO person);


  @Operation(
    summary = "Update a Person", 
    tags= {"People"},
    responses = {
      @ApiResponse(description = "Success", responseCode = "200", 
        content = @Content(
          mediaType = MediaType.APPLICATION_JSON_VALUE,
          schema = @Schema(implementation = PersonDTO.class))
          ),      
      @ApiResponse(description = "No Content", responseCode = "204"),
      @ApiResponse(description = "Bad Request", responseCode = "400"),
      @ApiResponse(description = "Unauthorized", responseCode = "401"),
      @ApiResponse(description = "Forbidden", responseCode = "403"),
      @ApiResponse(description = "Not Found", responseCode = "404"),
      @ApiResponse(description = "Internal Server Error", responseCode = "500")
    },
    description = "Update a aspecific person"
    )
  PersonDTO update(PersonDTO person);
  

  @Operation(
      summary = "Delete a Person", 
      tags= {"People"},
      responses = {
        @ApiResponse(description = "Success", responseCode = "200", 
          content = @Content(
            mediaType = MediaType.APPLICATION_JSON_VALUE,
            schema = @Schema(implementation = PersonDTO.class))
            ),      
        @ApiResponse(description = "No Content", responseCode = "204"),
        @ApiResponse(description = "Bad Request", responseCode = "400"),
        @ApiResponse(description = "Unauthorized", responseCode = "401"),
        @ApiResponse(description = "Forbidden", responseCode = "403"),
        @ApiResponse(description = "Not Found", responseCode = "404"),
        @ApiResponse(description = "Internal Server Error", responseCode = "500")
      },
      description = "Delete a specific person by ID"
      )
  void delete(Long id);

}