/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onmc;
import javafx.scene.control.Label;
import javafx.fxml.FXML;

/**
 *
 * @author Usuario
 */
public class VictoriaController {
    
    @FXML
    private Label vUsuario;
    
    public void initialize() {
        vUsuario.setText(InicioController.user);
    }
}