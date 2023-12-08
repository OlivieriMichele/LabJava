package a01c.e2;

import javax.swing.*;
import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    
    private static final long serialVersionUID = -6218820567019985015L;
    private final Map<JButton,Pair<Integer,Integer>> cells = new HashMap<>();
    private final Logic logic = new LogicImpl();
    
    public GUI(int size) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(50*size, 50*size);
        
        JPanel panel = new JPanel(new GridLayout(size,size));
        this.getContentPane().add(panel);
        
        ActionListener al = e -> {
        	var button = (JButton)e.getSource();
        	if (logic.isFirst(cells.get(button))) {
                button.setText("*");
            } else {
                if (logic.isOk(cells.get(button))) {
                    logic.setInList(cells.get(button));
                    for (var entry : cells.entrySet()) {
                        if (logic.isInList(entry.getValue())) {
                            entry.getKey().setText("*");
                        }
                    }
                }
            }
        	button.setEnabled(false); 
        };
                
        for (int i=0; i<size; i++){
            for (int j=0; j<size; j++){
                final JButton jb = new JButton(" ");
                this.cells.put(jb,new Pair<>(j,i));
                jb.addActionListener(al);
                panel.add(jb);
            }
        }
        this.setVisible(true);
    }
    
}
