
package Controllers;
import Views.View;
import Models.Model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Extras.Extra;

public class Controller {
    View view;
    Model model;
    Extra extra;
    ActionListener ac = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == view.jb_limpiar)
                    limpiar();
            else if(e.getSource() == view.jb_guardar)
                guardar();
            else if(e.getSource() == view.jb_primero)
                primero();
            else if (e.getSource() == view.jb_anterior)
                anterior();
            else if (e.getSource() == view.jb_siguiente)
                siguiente();
            else if (e.getSource() == view.jb_ultimo)
                ultimo();
        }
    };

    public Controller(View view, Model model, Extra Extra) {
        this.view = view;
        this.model = model;
        this.view.jb_guardar.addActionListener(ac);
        this.view.jb_limpiar.addActionListener(ac);
        this.view.jb_primero.addActionListener(ac);
        this.view.jb_siguiente.addActionListener(ac);
        this.view.jb_anterior.addActionListener(ac);
        this.view.jb_ultimo.addActionListener(ac);
        Extra.Sletras(this.view.jtf_nombre);
        initComponents();
    }
    public void obtener(){
        model.setNombre(view.jtf_nombre.getText());
        model.setEmail(view.jtf_email.getText());
    }
    
     public void mostrar(){
        view.jtf_nombre.setText(model.getNombre());
        view.jtf_email.setText(model.getEmail());
    }
     
     public void limpiar(){
        view.jtf_nombre.setText("");
        view.jtf_email.setText("");
    }
     
     public void guardar(){
        obtener();
        model.writeFile();
    }
    
     public void primero(){
        model.primero();
        mostrar();
         
    }
     
     public void ultimo(){
        model.ultimo();
        mostrar();
    }
     
     public void siguiente(){
        model.siguiente();
        mostrar();
    }
     
     public void anterior(){
        model.anterior();
        mostrar();
    }
     
      private void initComponents(){
        view.setVisible(true);
        model.readFile();
        model.primero();
        mostrar();
    }

    
}
