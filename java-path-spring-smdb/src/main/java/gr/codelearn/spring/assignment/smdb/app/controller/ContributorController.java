package gr.codelearn.spring.assignment.smdb.app.controller;

import gr.codelearn.spring.assignment.smdb.app.domain.Contributor;
import gr.codelearn.spring.assignment.smdb.app.service.BaseService;
import gr.codelearn.spring.assignment.smdb.app.service.ContributorService;
import gr.codelearn.spring.assignment.smdb.app.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contributors")
@RequiredArgsConstructor
public class ContributorController extends AbstractController<Contributor> {
    private final ContributorService contributorService;

    @Override
    public BaseService<Contributor, Long> getBaseService() {
        return contributorService;
    }

//    @Override
//    @GetMapping("/{id}")
//    public ResponseEntity<ApiResponse<Contributor>> get(@PathVariable("id") final Long id) {
//        return ResponseEntity.ok(ApiResponse.<Contributor>builder().data(contributorService.findLazy(id)).build());
//    }

}
