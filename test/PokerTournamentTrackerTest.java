import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class PokerTournamentTrackerTest {

    @Test
    public void dateTest() throws Exception{
        PokerTournamentTracker pokerTournamentTracker = new PokerTournamentTracker();
        Date date = pokerTournamentTracker.askForDate("12/10/2018");

        String expected = "";
        String actual = date.toString();

        Assert.assertEquals(expected, actual);
    }
}