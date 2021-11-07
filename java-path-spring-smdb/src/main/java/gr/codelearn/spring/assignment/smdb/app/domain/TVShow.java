package gr.codelearn.spring.assignment.smdb.app.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class TVShow  extends BaseModel {
    private String title;
    private String genre;
    private Date releaseDate;
    private float rating;
    private String plotSummary;
    private int episodesCount;
    private int seasonsCount;
    private Set<TVShowContributor> contributors = new HashSet<TVShowContributor>();
}
