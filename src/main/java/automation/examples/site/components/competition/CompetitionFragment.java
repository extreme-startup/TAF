package automation.examples.site.components.competition;

import automation.examples.site.components.Fragment;

public interface CompetitionFragment extends Fragment {

    void provideDetailsForCompetitionCreation(String title, String description, String category);

    void submitCompetitionCreation();

    void discardCompetitionCreation();

}
