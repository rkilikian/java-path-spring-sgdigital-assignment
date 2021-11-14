package gr.codelearn.spring.assignment.smdb.app.bootstrap;

import gr.codelearn.spring.assignment.smdb.app.base.AbstractLogComponent;
import gr.codelearn.spring.assignment.smdb.app.domain.*;
import gr.codelearn.spring.assignment.smdb.app.service.*;
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
                Contributor.builder().id(5L).firstName("Marion").lastName("Cotillard").birthDate(LocalDate.of(1975, 9, 30)).build(),
                Contributor.builder().id(6L).firstName("Andy").lastName("Samberg").birthDate(LocalDate.of(1978, 8, 18)).build(),
                Contributor.builder().id(7L).firstName("Aaron").lastName("Paul").birthDate(LocalDate.of(1979, 8, 27)).build(),
                Contributor.builder().id(8L).firstName("Bryan").lastName("Cranston").birthDate(LocalDate.of(1956, 3, 07)).build(),
                Contributor.builder().id(9L).firstName("Elliot").lastName("Page").birthDate(LocalDate.of(1987, 2, 21)).build()
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
        Contributor seventhContributor = contributorService.findByFullName("Elliot Page");
        Film thirdFilm = Film.builder().id(3L).title("Inception").genre("Action").releaseYear(Year.of(2010)).rating(8.8).plotSummary("A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O., but his tragic past may doom the project and his team to disaster.").build();
        filmService.addFilmContributor(thirdFilm, fifthContributor, actorContributorType);
        filmService.addFilmContributor(thirdFilm, sixthContributor, actressContributorType);
        filmService.addFilmContributor(thirdFilm, seventhContributor, actorContributorType);
        filmService.create(thirdFilm);
    }

    private void generateTVShows() {
        // first tv show and contributors
        Contributor firstContributor = contributorService.findByFullName("Andy Samberg");
        ContributorType actorContributorType = contributorTypeService.findByDescription("Actor");
        TVShow firstTVShow = TVShow.builder().id(1L).title("Brooklyn Nine-Nine").genre("Comedy").releaseYear(Year.of(2013)).rating(8.4).plotSummary("Comedy series following the exploits of Det. Jake Peralta and his diverse, lovable colleagues as they police the NYPD's 99th Precinct.").episodesCount(153).seasonsCount(8).build();
        tvShowService.addTVShowContributor(firstTVShow, firstContributor, actorContributorType);
        tvShowService.create(firstTVShow);

        // second tv show and contributors
        Contributor secondContributor = contributorService.findByFullName("Aaron Paul");
        Contributor thirdContributor = contributorService.findByFullName("Bryan Cranston");
        TVShow secondTVShow = TVShow.builder().id(2L).title("Breaking Bad").genre("Drama").releaseYear(Year.of(2008)).rating(9.4).plotSummary("A high school chemistry teacher diagnosed with inoperable lung cancer turns to manufacturing and selling methamphetamine in order to secure his family's future.").episodesCount(62).seasonsCount(5).build();
        tvShowService.addTVShowContributor(secondTVShow, secondContributor, actorContributorType);
        tvShowService.addTVShowContributor(secondTVShow, thirdContributor, actorContributorType);
        tvShowService.create(secondTVShow);

        // third tv show and contributors
        Contributor fourthContributor = contributorService.findByFullName("Aaron Paul");
        TVShow thirdTVShow = TVShow.builder().id(3L).title("BoJack Horseman").genre("Animation").releaseYear(Year.of(2014)).rating(8.7).plotSummary("BoJack Horseman was the star of the hit television show \"Horsin' Around\" in the '80s and '90s, but now he's washed up, living in Hollywood, complaining about everything, and wearing colorful sweaters.").episodesCount(77).seasonsCount(6).build();
        tvShowService.addTVShowContributor(thirdTVShow, fourthContributor, actorContributorType);
        tvShowService.create(thirdTVShow);

        // fourth tv show and contributors
        Contributor fifthContributor = contributorService.findByFullName("Elliot Page");
        TVShow fourthTVShow = TVShow.builder().id(4L).title("The Umbrella Academy").genre("Action").releaseYear(Year.of(2019)).rating(8.0).plotSummary("A family of former child heroes, now grown apart, must reunite to continue to protect the world.").episodesCount(30).seasonsCount(3).build();
        tvShowService.addTVShowContributor(fourthTVShow, fifthContributor, actorContributorType);
        tvShowService.create(fourthTVShow);
    }

}
