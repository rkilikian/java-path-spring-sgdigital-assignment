package gr.codelearn.spring.assignment.smdb.app.controller;

import gr.codelearn.spring.assignment.smdb.app.base.AbstractLogComponent;
import gr.codelearn.spring.assignment.smdb.app.domain.BaseModel;
import gr.codelearn.spring.assignment.smdb.app.service.BaseService;
import gr.codelearn.spring.assignment.smdb.app.transfer.ApiResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public abstract class AbstractController <T extends BaseModel> extends AbstractLogComponent {
    protected abstract BaseService<T, Long> getBaseService();
    protected abstract String getSearchToken();

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<T>> get(@PathVariable("id") final Long id) {
        return ResponseEntity.ok(ApiResponse.<T>builder().data(getBaseService().find(id)).searchToken(getSearchToken()).build());
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<T>>> findAll() {
        return ResponseEntity.ok(ApiResponse.<List<T>>builder().data(getBaseService().findAll()).searchToken(getSearchToken()).build());
    }

    @PostMapping
    public ResponseEntity<ApiResponse<T>> create(@Valid @RequestBody final T entity) {
        return new ResponseEntity<>(ApiResponse.<T>builder().data(getBaseService().create(entity)).searchToken(getSearchToken()).build(),
                getNoCacheHeaders(), HttpStatus.CREATED);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody final T entity) {
        getBaseService().update(entity);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") final Long id) {
        getBaseService().deleteById(id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Valid @RequestBody final T entity) {
        if (getBaseService().exists(entity)) {
            getBaseService().delete(entity);
        }
    }

    protected HttpHeaders getNoCacheHeaders() {
        final HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        return headers;
    }

    protected HttpHeaders getDownloadHeaders(final String filename) {
        final HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=" + filename);
        return headers;
    }
}
