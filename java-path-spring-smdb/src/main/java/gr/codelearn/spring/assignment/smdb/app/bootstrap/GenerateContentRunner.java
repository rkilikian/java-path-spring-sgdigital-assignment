package gr.codelearn.spring.assignment.smdb.app.bootstrap;

import gr.codelearn.spring.assignment.smdb.app.base.AbstractLogComponent;
import gr.codelearn.spring.assignment.smdb.app.domain.Contributor;
import gr.codelearn.spring.assignment.smdb.app.domain.ContributorType;
import gr.codelearn.spring.assignment.smdb.app.domain.Film;
import gr.codelearn.spring.assignment.smdb.app.domain.TVShow;
import gr.codelearn.spring.assignment.smdb.app.service.ContributorService;
import gr.codelearn.spring.assignment.smdb.app.service.ContributorTypeService;
import gr.codelearn.spring.assignment.smdb.app.service.FilmService;
import gr.codelearn.spring.assignment.smdb.app.service.TVShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GenerateContentRunner extends AbstractLogComponent implements CommandLineRunner {
    private final ContributorService contributorService;
    private final ContributorTypeService contributorTypeService;
    private final FilmService filmService;
    private final TVShowService tvShowService;

    @Override
    public void run(String... args) throws Exception {
        generateContributors();
        generateContributorTypes();
        generateFilms();
        generateTVShows();
    }

    private void generateContributors() {
        List<Contributor> contributors = List.of(
                Contributor.builder().id(1L).firstName("Timothée").lastName("Chalamet").birthDate(LocalDate.of(1995, 12, 27)).build(),
                Contributor.builder().id(2L).firstName("Leonardo").lastName("Di Caprio").birthDate(LocalDate.of(1974, 11, 11)).build(),
                Contributor.builder().id(3L).firstName("Martin").lastName("Scorsese").birthDate(LocalDate.of(1942, 11, 17)).build(),
                Contributor.builder().id(4L).firstName("Denis").lastName("Villeneuve").birthDate(LocalDate.of(1967, 10, 03)).build(),
                Contributor.builder().id(5L).firstName("Marion").lastName("Cotillard").birthDate(LocalDate.of(1975, 9, 30)).build()
        );

        contributorService.createAll(contributors);
    }

    private void generateContributorTypes () {
        List<ContributorType> contributorTypes = List.of(
                ContributorType.builder().id(1L).description("Actor").build(),
                ContributorType.builder().id(2L).description("Actress").build(),
                ContributorType.builder().id(3L).description("Director").build(),
                ContributorType.builder().id(4L).description("Producer").build()
        );

        contributorTypeService.createAll(contributorTypes);
    }

    private void generateFilms() {
        // first film and contributors
        Contributor firstContributor = contributorService.findByFullName("Leonardo Di Caprio");
        ContributorType actorContributorType = contributorTypeService.findByDescription("Actor");
        Contributor secondContributor = contributorService.findByFullName("Martin Scorsese");
        ContributorType directorContributorType = contributorTypeService.findByDescription("Director");
        Film firstFilm = Film.builder().id(1L).title("Shutter Island").genre("Thriller").releaseYear(Year.of(2010)).rating(8.2).plotSummary("In 1954, a U.S. Marshal investigates the disappearance of a murderer who escaped from a hospital for the criminally insane.").build();
        filmService.addFilmContributor(firstFilm, firstContributor, actorContributorType);
        filmService.addFilmContributor(firstFilm, secondContributor, directorContributorType);
        filmService.create(firstFilm);

        // second film and contributors
        Contributor thirdContributor = contributorService.findByFullName("Timothée Chalamet");
        Contributor fourthContributor = contributorService.findByFullName("Denis Villeneuve");
        Film secondFilm = Film.builder().id(2L).title("Dune").genre("Action").releaseYear(Year.of(2021)).rating(8.2).plotSummary("Feature adaptation of Frank Herbert's science fiction novel, about the son of a noble family entrusted with the protection of the most valuable asset and most vital element in the galaxy.").build();
        filmService.addFilmContributor(secondFilm, thirdContributor, actorContributorType);
        filmService.addFilmContributor(secondFilm, fourthContributor, directorContributorType);
        filmService.create(secondFilm);

        // third film and contributors
        Contributor fifthContributor = contributorService.findByFullName("Leonardo Di Caprio");
        Contributor sixthContributor = contributorService.findByFullName("Marion Cotillard");
        ContributorType actressContributorType = contributorTypeService.findByDescription("Actress");
        Film thirdFilm = Film.builder().id(3L).title("Inception").genre("Action").releaseYear(Year.of(2010)).rating(8.8).plotSummary("A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O., but his tragic past may doom the project and his team to disaster.").build();
        filmService.addFilmContributor(thirdFilm, fifthContributor, actorContributorType);
        filmService.addFilmContributor(thirdFilm, sixthContributor, actressContributorType);
        filmService.create(thirdFilm);
    }

    private void generateTVShows() {
        List<TVShow> tvShows = List.of(
                TVShow.builder().id(1L).title("Brooklyn Nine-Nine").genre("Comedy").releaseYear(Year.of(2013)).rating(8.4).plotSummary("Comedy series following the exploits of Det. Jake Peralta and his diverse, lovable colleagues as they police the NYPD's 99th Precinct.").episodesCount(153).seasonsCount(8).build()
        );

        tvShowService.createAll(tvShows);
    }

}
