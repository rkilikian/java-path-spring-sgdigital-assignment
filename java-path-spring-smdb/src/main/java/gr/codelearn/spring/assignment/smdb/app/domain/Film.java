package gr.codelearn.spring.assignment.smdb.app.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Film  extends BaseModel {
    private String title;
    private String genre;
    private Date releaseDate;
    private float rating;
    private String plotSummary;
    private final Set<FilmContributor> contributors = new HashSet<FilmContributor>();
}
