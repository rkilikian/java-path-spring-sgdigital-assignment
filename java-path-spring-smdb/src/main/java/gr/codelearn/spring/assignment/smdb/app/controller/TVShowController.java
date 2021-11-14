package gr.codelearn.spring.assignment.smdb.app.controller;

import gr.codelearn.spring.assignment.smdb.app.domain.TVShow;
import gr.codelearn.spring.assignment.smdb.app.service.BaseService;
import gr.codelearn.spring.assignment.smdb.app.service.TVShowService;
import gr.codelearn.spring.assignment.smdb.app.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tvshows")
public class TVShowController extends AbstractController<TVShow>{
    private final TVShowService tvShowService;
    private final String searchToken = "tvshows";

    @Override
    public BaseService<TVShow, Long> getBaseService() {
        return tvShowService;
    }

    @Override
    public String getSearchToken() {
        return this.searchToken;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<TVShow>> get(@PathVariable("id") final Long id) {
        return ResponseEntity.ok(ApiResponse.<TVShow>builder().data(tvShowService.findLazy(id)).searchToken(searchToken).build());
    }

    @Override
    @GetMapping
    public ResponseEntity<ApiResponse<List<TVShow>>> findAll() {
        return ResponseEntity.ok(ApiResponse.<List<TVShow>>builder().data(tvShowService.findAllLazy()).searchToken(searchToken).build());
    }
}
