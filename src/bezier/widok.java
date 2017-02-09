/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bezier;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

public class widok extends JFrame{   
    int N = 4;
    Point2d [] P = new Point2d[N]; 
    
    JPanel panel = new JPanel(){
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            
            for(int i=0; i<N; ++i) g.fillOval(P[i].intX(), P[i].intY(), 5, 5);
            
            for(double t=0; t<=1; t = t + 0.0001){

                double sumaX = 0;
                double sumaY = 0;
                
                for(int i = 0; i<N; ++i){
                    double b = beren(N-1, i, t);
                    sumaX += P[i].x * b;
                    sumaY += P[i].y * b;
                }

                g.drawOval( (int)Math.round(sumaX), (int)Math.round(sumaY), 1, 1);
            }
               
            //g.fillOval( (int)Math.round( cam.x), (int)Math.round( cam.y), 10, 10);
        }
        
        public void repaint(Graphics g){
            
        }
    };
    
    int fa(int n) {
        int fact = 1; // this  will be the result
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
    
    int newton(int n, int k){
        return fa(n)/(fa(k)*fa(n-k));
    }
    
    double beren(int n, int i, double t){
        if( i < 0 || i > n) return 0.0;
        return (double)newton(n,i)*Math.pow(t, i)*Math.pow( (1-t), n-i);

    }
    
    

    
    public widok() throws InterruptedException{
        super("Grafika3D");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,1000);
        add(panel);
        setResizable(false);

        P[0] = new Point2d(50, 50);
        P[2] = new Point2d(50,200);
        P[3] = new Point2d(200,50);
        P[1] = new Point2d(200,200);

        setVisible(true);
        
        repaint();

        
        
    }

}
