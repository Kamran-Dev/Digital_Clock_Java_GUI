import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Digital Clock. JAVA. IntelliJ IDEA.
 * @author     Kamran Rashidov
 * @version    1.0 (27.09.2021)
 * @GitHub:  https://github.com/Kamran-Dev
 */


public class DigitalClock {

    JFrame frame;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JButton button1;
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time;
    String day;
    String date;
    ImageIcon image;
    Font myFont;

    // clock method
    public void clock() {

        // get size of screen: width and height
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double widthOfScreen = screenSize.getWidth();
        double heightOfScreen = screenSize.getHeight();

        // coordinates of frame in the center of screen
        int xLoc = (((int)widthOfScreen / 2) - (250/2));
        int yLoc = (((int)heightOfScreen / 2) - (114/2));

        // settings of frame
        frame = new JFrame();
        frame.setSize(250, 114);
        frame.setTitle(" Digital clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(xLoc, yLoc); // location on the screen in the center
        frame.setLayout(new FlowLayout());
        frame.getContentPane().setBackground(new Color(122, 174,226));
        frame.setVisible(true);
        frame.setResizable(true);

        // icon of frame
        image = new ImageIcon("wall-clock.png");
        frame.setIconImage(image.getImage());


        // time and day format
        timeLabel = new JLabel();
        dayLabel = new JLabel();
        dateLabel = new JLabel();

        timeFormat = new SimpleDateFormat(" kk : mm : ss a ");
        dayFormat = new SimpleDateFormat(" E ");
        dateFormat = new SimpleDateFormat(" dd - MMM - y ");

        // font for time, day and date
        myFont = new Font("MV", Font.BOLD, 20);

        // settings of time label
        timeLabel.setFont(myFont);
        timeLabel.setBackground(new Color(255, 255,115));
        timeLabel.setForeground(Color.RED);
        timeLabel.setOpaque(true);
        frame.add(timeLabel);

        // setting of day label
        dayLabel.setFont(myFont);
        dayLabel.setBackground(Color.WHITE);
        dayLabel.setForeground(Color.BLACK);
        dayLabel.setOpaque(true);
        frame.add(dayLabel);

        // settings of date label
        dateLabel.setFont(myFont);
        dateLabel.setBackground(Color.WHITE);
        dateLabel.setForeground(Color.BLACK);
        dateLabel.setOpaque(true);
        frame.add(dateLabel);

        // creating borders for labels
        Border border2 = BorderFactory.createLineBorder(Color.BLACK, 2, false);
        timeLabel.setBorder(border2);
        dayLabel.setBorder(border2);
        dateLabel.setBorder(border2);

        updateTime();
    }

    /*
     *   Main thread is going to sleep 1000 milliseconds and then updated it.
     *   By this we will update our digital clock every second
     */
    public void updateTime() {

        while(true) {
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time); // set the time to the label as a text

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(dayFormat.format(Calendar.getInstance().getTime())); // set the day to the label as a text

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(dateFormat.format(Calendar.getInstance().getTime())); // set the date to the label as a text

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}







