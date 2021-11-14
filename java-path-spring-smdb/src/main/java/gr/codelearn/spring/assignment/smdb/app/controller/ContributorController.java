package gr.codelearn.spring.assignment.smdb.app.controller;

import gr.codelearn.spring.assignment.smdb.app.domain.Contributor;
import gr.codelearn.spring.assignment.smdb.app.service.BaseService;
import gr.codelearn.spring.assignment.smdb.app.service.ContributorService;
import gr.codelearn.spring.assignment.smdb.app.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contributors")
@RequiredArgsConstructor
public class ContributorController extends AbstractController<Contributor> {
    private final ContributorService contributorService;
    private final String searchToken = "contributors";

    @Override
    public BaseService<Contributor, Long> getBaseService() {
        return contributorService;
    }

    @Override
    public String getSearchToken() {
        return this.searchToken;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Contributor>> get(@PathVariable("id") final Long id) {
        return ResponseEntity.ok(ApiResponse.<Contributor>builder().data(contributorService.findLazy(id)).searchToken(searchToken).build());
    }

    @GetMapping(headers = "findByFirstName")
    public ResponseEntity<ApiResponse<List<Contributor>>> findByFirstName(@RequestParam String firstName) {
        return ResponseEntity.ok(ApiResponse.<List<Contributor>>builder().data(contributorService.findByFirstName(firstName.toLowerCase())).searchToken(searchToken).build());
    }

    @GetMapping(headers = "findByLastName")
    public ResponseEntity<ApiResponse<List<Contributor>>> findByLastName(@RequestParam String lastName) {
        return ResponseEntity.ok(ApiResponse.<List<Contributor>>builder().data(contributorService.findByLastName(lastName.toLowerCase())).searchToken(searchToken).build());
    }

    @GetMapping(headers = "findByFullName")
    public ResponseEntity<ApiResponse<Contributor>> findByFullName(@RequestParam String firstName, @RequestParam String lastName) {
        String fullName = firstName.concat(" " + lastName);
        return ResponseEntity.ok(ApiResponse.<Contributor>builder().data(contributorService.findByFullName(fullName)).searchToken(searchToken).build());
    }

    @Override
    @GetMapping
    public ResponseEntity<ApiResponse<List<Contributor>>> findAll() {
        return ResponseEntity.ok(ApiResponse.<List<Contributor>>builder().data(contributorService.findAllLazy()).searchToken(searchToken).build());
    }

}
