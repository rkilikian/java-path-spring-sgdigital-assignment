package gr.codelearn.spring.assignment.smdb.app.controller;

import gr.codelearn.spring.assignment.smdb.app.domain.Film;
import gr.codelearn.spring.assignment.smdb.app.service.BaseService;
import gr.codelearn.spring.assignment.smdb.app.service.FilmService;
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
@RequestMapping("/films")
public class FilmController extends AbstractController<Film>{
    private final FilmService filmService;
    private final String searchToken = "films";

    @Override
    public BaseService<Film, Long> getBaseService() {
        return filmService;
    }

    @Override
    public String getSearchToken() {
        return this.searchToken;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Film>> get(@PathVariable("id") final Long id) {
        return ResponseEntity.ok(ApiResponse.<Film>builder().data(filmService.findLazy(id)).searchToken(searchToken).build());
    }

    @Override
    @GetMapping
    public ResponseEntity<ApiResponse<List<Film>>> findAll() {
        return ResponseEntity.ok(ApiResponse.<List<Film>>builder().data(filmService.findAllLazy()).searchToken(searchToken).build());
    }
}
