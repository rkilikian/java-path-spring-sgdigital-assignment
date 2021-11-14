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

    @Override
    @GetMapping
    public ResponseEntity<ApiResponse<List<Contributor>>> findAll() {
        return ResponseEntity.ok(ApiResponse.<List<Contributor>>builder().data(contributorService.findAllLazy()).searchToken(searchToken).build());
    }

}
