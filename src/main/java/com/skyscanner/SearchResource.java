package com.skyscanner;

import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("/search")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SearchResource {
    private final List<SearchResult> searchResults;

    public SearchResource(List<SearchResult> searchResults) {
        this.searchResults = List.copyOf(searchResults);
    }

    @POST
    public List<SearchResult> search(Search search) {
        if (search == null || search.getCity() == null || search.getCity().isBlank()) {
            throw new BadRequestException("A non-empty city is required.");
        }
        String city = search.getCity().trim();
        return searchResults.stream()
                .filter(result -> city.equalsIgnoreCase(result.getCity()))
                .collect(Collectors.toList());
    }
}
