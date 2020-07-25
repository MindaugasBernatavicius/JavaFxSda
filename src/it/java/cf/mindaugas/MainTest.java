package cf.mindaugas;

import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.framework.junit5.Stop;

import static org.testfx.assertions.api.Assertions.assertThat;

@ExtendWith(ApplicationExtension.class)
class MainTest {

    private final Main main = new Main();
    private Stage stage;

    @Start // given, called with @BeforeEach semantics
    private void start(Stage stage) {
        main.start(stage);
        this.stage = stage;
        stage.setScene(main.getScene());
        stage.show();
        stage.toFront();
    }

    @Stop // teardown, called with @After semantics
    private void stop() {
        stage.close();
        System.out.println("Is showing: "+ stage.isShowing());
    }

    @Test
    void when_appLoaded_buttonTextCorrect(FxRobot robot) {
        // given default application parameters
        // when, app started
        // then
        assertThat(robot.lookup(".button").queryButton()).hasText("Press me");
    }
}
