
/*
 *
 *  Copyright (C) 2019.  PSEU - Palestine Polytechnic University - All Rights Reserved
 *  * SPDX-License-Identifier: Apache-2.0
 *
 */

/*
 * Created by Basel.Altamimi on 8/4/2019.
 */

package Forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainForm extends JFrame {
    int count =0 ;
    ArrayList<Integer>arr = new ArrayList<>() ;
    public MainForm() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application on JForm exit
        this.setTitle("Main Form");
        this.setSize(600, 200);
        this.setLayout(new FlowLayout(FlowLayout.RIGHT));
        this.setVisible(true);

        JButton b1 = new JButton("Show Calender 1"); // Button 1 (Create Calender 1)
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                showNewCalender();
            }
        });

        JButton b2 = new JButton("Show Calender 2"); // Button 2 (Create Calender 2)
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                showNewCalender();
            }
        });


        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panel.add(b1);
        panel.add(b2);

        this.add(panel);
    }

    /**
     * Create and show new calender object
     * Todo: This method logs the object HashCode in a text file, after refactoring the code; show warning message if the HashCode of Calender1 doesn't equal Calender2 HashCode
     */

    private void showNewCalender() {
        int hash_code  = 0 ;
        int old_arr_size = arr.size() ;
        int new_size= arr.size();

        NewCalender sc =   NewCalender.getCalender();
        sc.frameCreation();
        if(count== 0 ) {
            arr.add(sc.hashCode());
        }
        else
        {
            for(int i=0 ;i<arr.size() ;i++)
            {
                if (sc.hashCode() == arr.get(i))
                {
                    break ;
                }
                else
                {
                    arr.add(sc.hashCode());

                    new_size=arr.size();

                }
            }

        }

        if (new_size>old_arr_size ||arr.size()== 1)
        Util.Logger.log("Object HC: " + sc.hashCode()); // Log Calender hash code
    }


}
