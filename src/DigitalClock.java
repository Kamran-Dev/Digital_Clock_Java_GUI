import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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

        // create frame

        frame = new JFrame();
        frame.setSize(350, 200);
        frame.setTitle(" Digital clock");
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocation(500, 150); // location on the screen
        frame.setLayout(new FlowLayout());

        frame.getContentPane().setBackground(Color.orange);

        // icon of frame
        image = new ImageIcon("wall-clock.png");
        frame.setIconImage(image.getImage());


        // time and day format
        timeLabel = new JLabel();
        dayLabel = new JLabel();
        dateLabel = new JLabel();
        timeFormat = new SimpleDateFormat(" kk : mm : ss a ");
        dayFormat = new SimpleDateFormat(" EEEE ");
        dateFormat = new SimpleDateFormat(" dd - MMMMM - y ");


        myFont = new Font("MV", Font.ITALIC, 20);

        timeLabel.setFont(myFont);
        timeLabel.setForeground(Color.BLACK);
        timeLabel.setBackground(Color.white);
        timeLabel.setOpaque(true);
        frame.add(timeLabel);

        dayLabel.setFont(myFont);
        frame.add(dayLabel);

        dateLabel.setFont(myFont);
        frame.add(dateLabel);

        // border of timelabel
        Border border2 = BorderFactory.createLineBorder(Color.GREEN, 3, true);
        Border border1 = BorderFactory.createLineBorder(Color.YELLOW, 6, true);
        Border border3 = BorderFactory.createCompoundBorder(border1, border2);
        timeLabel.setBorder(border3);
        dayLabel.setBorder(border3);
        dateLabel.setBorder(border3);

        dayLabel.setHorizontalTextPosition(JLabel.CENTER);
        dayLabel.setVerticalTextPosition(JLabel.CENTER);

        updateTime();
    }


    public void updateTime() {

        while(true) {
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time); // set the time to the Label as a text

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(dayFormat.format(Calendar.getInstance().getTime())); // set the time to the Label as a text

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(dateFormat.format(Calendar.getInstance().getTime()));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}







