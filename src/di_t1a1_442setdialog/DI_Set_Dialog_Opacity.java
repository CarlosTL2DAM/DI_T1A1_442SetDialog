/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di_t1a1_442setdialog;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author usuario
 */
public class DI_Set_Dialog_Opacity extends Application {

    @Override
    public void start(Stage primaryStage) {

        //Escogemos el titulo de nuestra ventana
        primaryStage.setTitle("Dialog");
        //Seleccionamos el nodo raiz que sea de tipo group de layout
        Group root = new Group();
        //Seleccionamos la escena principal ,con sus distintos argumentos
        Scene scene = new Scene(root, 400, 300, Color.WHITE);

        //Seleccionamos la escena principal en nuestra ventana
        primaryStage.setScene(scene);
        //Mostramos la ventana
        primaryStage.show();

        //Definimos una nueva ventana de clase MyDialog (después se define la clase)
        Stage myDialog = new MyDialog(primaryStage);
        //Definimos que se corresponda el tamaño de la escena con la de su contenido
        myDialog.sizeToScene();
        //Mostramos la ventana de clase myDialog
        myDialog.show();

    }

    //Creammos la clase MyDialog que extiende de Stage
    class MyDialog extends Stage {

        public MyDialog(Stage owner) {
            //Provoca que tenga atributos de la clase padre
            super();
            //Especifica que este cuadro de dialogo pertence a la Stage padre
            initOwner(owner);
            //Escogemos el titulo
            setTitle("title");
            //Escogemos la opacidad
            setOpacity(.90);
            //Escogemos un layout para esta nueva ventana
            Group root = new Group();
            //Escogemos una escena
            Scene scene = new Scene(root, 250, 150, Color.WHITE);
            //Le asigamos la escena a la ventana
            setScene(scene);

            //Creamos un GridPane con padding y hueco horizontal y vertical de 5
            GridPane gridpane = new GridPane();
            gridpane.setPadding(new Insets(5));
            gridpane.setHgap(5);
            gridpane.setVgap(5);

            //Incluimos una etiqueta y la posicionamos en el gridpane
            Label userNameLbl = new Label("User Name: ");
            gridpane.add(userNameLbl, 0, 1);

            //Incluimos una etiqueta y la añadimos al gridPane
            Label passwordLbl = new Label("Password: ");
            gridpane.add(passwordLbl, 0, 2);
            
            //Incluimos un TextField y la añadimos al gridPane
            final TextField userNameFld = new TextField("Admin");
            gridpane.add(userNameFld, 1, 1);

            //Incluimos una campo de contraseña y con un texto por defecto y la añadimos al gridPane
            final PasswordField passwordFld = new PasswordField();
            passwordFld.setText("password");
            gridpane.add(passwordFld, 1, 2);

            //Añadimos un botón con con un evento que al pulsarlo se cierre la ventana
            Button login = new Button("Change");
            login.setOnAction(new EventHandler<ActionEvent>() {

                public void handle(ActionEvent event) {
                    close();
                }
            });
            
            //Situamos el botón en el gridPane con una alineación
            gridpane.add(login, 1, 3);
            GridPane.setHalignment(login, HPos.RIGHT);
            
            //Añadimos el gridPane a el layout root
            root.getChildren().add(gridpane);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
