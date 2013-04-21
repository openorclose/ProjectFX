package gui.accountpanel.statusbar;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.Label;

public class BlinkingLabel extends Label {
    private Node instance;
    public BlinkingLabel (String text) {
        super (text);
        getStyleClass ().add ("blinkinglabel");
        new Thread (new BlinkingThread ()).start ();
        instance = this;
    }
    private class BlinkingThread implements Runnable {
        private static final int SECONDS_TO_DISPLAY_AFTER_BLINK = 2;
        private static final int SECONDS_TO_BLINK = 2;
        private static final int DELAY = 100;
        public void run() {
            try {
                for (int i = 0; i < getIterations(); i++) {
                    setVisible (!isVisible());
                    Thread.sleep (DELAY);
                }
                setVisible (true);
                Thread.sleep (SECONDS_TO_DISPLAY_AFTER_BLINK * 1000);
                Platform.runLater (new Runnable () {
                    @Override
                    public void run () {
                        Controller.remove (instance);
                    }
                });
            } catch (InterruptedException ignored) {
            }
        }

        private int getIterations() {
            return SECONDS_TO_BLINK * getIterationsPerSecond();
        }
        private int getIterationsPerSecond() {
            return (int) 1000. / DELAY;
        }
    }
}
