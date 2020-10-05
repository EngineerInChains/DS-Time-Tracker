import java.time.LocalDateTime;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

public class Clock extends Observable {
  private static Clock runningClock;
  private Timer timer;
  private TimerTask timerTask;
  private LocalDateTime date;
  private int interval = 1;


  //Singleton:
  public static Clock newClock(){
    if (runningClock == null){
      runningClock = new Clock();
    }
    return runningClock;
  }

  private Clock(){
    timerTask = new TimerTask(){
      @Override
      public void run() {
        updateTime();
      }
    };
    timer.schedule(timerTask, 0, interval*1000);
  }

  private void updateTime(){
    date = LocalDateTime.now();
    setChanged();
    notifyObservers(date);
  }


}
