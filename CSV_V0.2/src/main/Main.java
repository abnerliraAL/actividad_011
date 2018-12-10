
package main;
import Views.View;
import Models.Model;
import Controllers.Controller;
import Extras.Extra;


public class Main {

   
    public static void main(String[] args) {
    
    View view = new View();
        Model model = new Model();
        Extra extra = new Extra();
        Controller controller = new Controller(view,model,extra);
    }
    
}
