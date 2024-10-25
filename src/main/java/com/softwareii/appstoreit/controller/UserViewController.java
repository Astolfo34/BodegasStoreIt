package com.softwareii.appstoreit.controller;
import com.softwareii.appstoreit.Main;
import com.softwareii.appstoreit.exceptions.*;
import com.softwareii.appstoreit.model.Mercancia;
import com.softwareii.appstoreit.model.Sector;
import com.softwareii.appstoreit.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class UserViewController {
        //---------instancias necesarias de la aplicacion para administrar las ventanas de forma profesional----
        private Main application;
        public void setApplication(Main appMainEjecutor){
                this.application = appMainEjecutor;
        }
        //---------fin de instancias necesarias para administrar la aplicacion----------------------------------

        @FXML
        void initialize(){
                modelFactoryController = ModelFactoryController.getInstance();

        }
        /**
         * METODO DE ALERTA Y OTROS METODOS ESPECIFICOS---------------------------------------|°|---------------------
         * @param alertType
         * @param title
         * @param message
         */
        private void showAlert(Alert.AlertType alertType, String title, String message) {
                Alert alert = new Alert(alertType);
                alert.setTitle(title);
                alert.setContentText(message);
                alert.showAndWait();
        }

        private boolean validarDatosMercanciaValidos() {
                if(!txtFechaMercancia.getText().isEmpty() || !txt_ID_Mercancia.getText().isEmpty()
                || !txtDuenoMercancia.getText().isEmpty() || !txtNombreMercancia.getText().isEmpty()){
                        return true;
                }
                return false;
        }

        // Método para verificar si la cadena es un número
        private boolean esNumero(String cadena) {
                if (cadena == null || cadena.isEmpty()) {
                        return false;
                }
                for (char c : cadena.toCharArray()) {
                        if (!Character.isDigit(c)) {
                                return false;  // Retorna falso si encuentra un carácter que no es un dígito
                        }
                }
                return true;
        }

        //-------------------------------------------------------FIN DE METODOS ESPECIFICOS  |^|  -----------------
        private ModelFactoryController modelFactoryController;
        @FXML
        private Button btnActualizarMercancia;

        @FXML
        private Button btnAgregarMercancia;

        @FXML
        private Button btnBuscarMercancia_id;

        @FXML
        private Button btnEliminarCuentaUsuario;

        @FXML
        private Button btnEliminarMercancia;

        @FXML
        private Button btnGenerarFactura;

        @FXML
        private Button btnGuardarCambiosUsuario;

        @FXML
        private Button btnSalirCerrarSesion;

        @FXML
        private Button btnActualizarUsuario;

        @FXML
        private Label lbl_IndicacionFactura;

        @FXML
        private TextField txtBuscarMercancia_id;

        @FXML
        private TextField txtContrasenaUsuario;

        @FXML
        private Label txtDescripcionMercancia;

        @FXML
        private TextField txtDuenoMercancia;

        @FXML
        private TextField txtFechaMercancia;

        @FXML
        private TextField txtIdCliente;

        @FXML
        private TextField txtNombreCliente;

        @FXML
        private TextField txtNombreMercancia;

        @FXML
        private TextField txtRutaDeFacturaGenerada;

        @FXML
        private TextField txtUsuario;

        @FXML
        private TextArea txtVistaPreviaFactura;

        @FXML
        private TextField txt_ID_Mercancia;

        @FXML
        private ImageView img_imagenDecorativa;

        @FXML
        private TextArea txtInformacionMercancia;

        @FXML
        private Button btnRecogerMercancia;


        @FXML
        void actualizar_mercancia_btn(ActionEvent event) {
                Mercancia mercanciaParaActualizar = new Mercancia();

                if(validarDatosMercanciaValidos()){

                        mercanciaParaActualizar.setNombre(txtNombreMercancia.getText());
                        mercanciaParaActualizar.setDueño(txtDuenoMercancia.getText());
                        mercanciaParaActualizar.setId(Integer.parseInt(txt_ID_Mercancia.getText()));
                        mercanciaParaActualizar.setFecha(txtFechaMercancia.getText());

                        modelFactoryController.actualizarMercanciaEnModelo(mercanciaParaActualizar);
                        showAlert(Alert.AlertType.INFORMATION,"MERCANCIA ACTUALIZADA", "la mercancia ha sido actualizada con exito");
                        limpiarDatosMercancia();
                }
        }
        @FXML
        public void recogerMercanciaDeBodega(ActionEvent event){

        }
        @FXML
        void agregar_mercancia_btn(ActionEvent event) {
                Mercancia mercanciaAcrear = new Mercancia();

                if (       txt_ID_Mercancia.getText().isEmpty()   || txtFechaMercancia.getText().isEmpty()
                        || txtNombreMercancia.getText().isEmpty() || txtDuenoMercancia.getText().isEmpty()) {
                        showAlert(Alert.AlertType.ERROR,"CAMPOS VACIDOS", "por vavor verifique que no hayan campos vacidos");
                        return;
                }
                mercanciaAcrear.setFecha(txtFechaMercancia.getText());
                mercanciaAcrear.setId(Integer.parseInt(txt_ID_Mercancia.getText()));
                mercanciaAcrear.setDueño(txtDuenoMercancia.getText());
                mercanciaAcrear.setNombre(txtNombreMercancia.getText());
                modelFactoryController.agregarMercancia(mercanciaAcrear);

                showAlert(Alert.AlertType.CONFIRMATION,"MERCANCIA AGREGADA","la mercancia ha sido registrada" +
                        " y queda pendiente a ser ubicada por el agente de ventas");
                limpiarDatosMercancia();
        }

        /**------------------------------------------------------------------------------------------inicio buscar mercancia
         * evento que dado una cadena, sea de numeros, en el caso de un codigo. o de carateres en caso de un nombre, valida
         * que tipo de dato es y lo agrega como atributo correspondiente al objeto correspondiente para buscar
         * @param event
         */
        @FXML
        void buscar_mercancia_nombre_btn(ActionEvent event) throws MercanciaExceptions {
                String name_o_id_MercanciaBuscada = txtBuscarMercancia_id.getText();
                Mercancia mercanciaBuscada = new Mercancia();

                        if (name_o_id_MercanciaBuscada.isEmpty()) {
                                showAlert(Alert.AlertType.ERROR, "EL CAMPO NO PUEDE ESTAR VACIDO", "ingrese un nombre o un id valido o existente");
                                limpiarDatosMercancia();
                                return;
                        }
                        if(esNumero(name_o_id_MercanciaBuscada)){
                                int idMercanciaBuscada = Integer.parseInt(name_o_id_MercanciaBuscada);
                                mercanciaBuscada.setId(idMercanciaBuscada);
                                Mercancia mercanciaEncontrada = modelFactoryController.buscarMercanciaEnBodega(mercanciaBuscada);
                                mostrarDatosMercancia(mercanciaEncontrada);
                        }else{
                                mercanciaBuscada.setNombre(name_o_id_MercanciaBuscada);
                                Mercancia mercanciaEncontrada = modelFactoryController.buscarMercanciaEnBodega(mercanciaBuscada);
                                mostrarDatosMercancia(mercanciaEncontrada);
                        }
        }



        private void limpiarDatosMercancia() {
                txt_ID_Mercancia.setText("");
                txtFechaMercancia.setText("");
                txtNombreMercancia.setText("");
                txtDuenoMercancia.setText("");
                txtInformacionMercancia.setText("");
                txtBuscarMercancia_id.setText("");
        }

        private void mostrarDatosMercancia(Mercancia mercanciaEncontrada) {
                txtBuscarMercancia_id.setText("");
                System.out.println("fecha de mercancia encontrada: "+mercanciaEncontrada.getFecha());
                txtNombreMercancia.setText(mercanciaEncontrada.getNombre());
                txtDuenoMercancia.setText(mercanciaEncontrada.getDueño());
                txt_ID_Mercancia.setText((mercanciaEncontrada.getId())+"");
                txtFechaMercancia.setText(mercanciaEncontrada.getFecha());
                if(mercanciaEncontrada.getUbicacion()==null)
                {mercanciaEncontrada.setUbicacion(new Sector("pendiente por asignar",0,0));}
                txtInformacionMercancia.setText(ModelFactoryController.ORGANIZAR_TO_STRING((mercanciaEncontrada.getUbicacion().toString())));
        }
        //---------------------------------------------------------------------------------------------------fin buscar mercancia
        @FXML
        void eliminar_mercancia_btn(ActionEvent event) {
                int id_mercanciParaBorrar =Integer.parseInt(txt_ID_Mercancia.getText());
                modelFactoryController.eliminarMercancia(id_mercanciParaBorrar);
                limpiarDatosMercancia();

        }

        @FXML
        void salirAlLoginAction(){
                Stage stage = application.getPrimaryStage();
                stage.close();
                application.mostrarVentanaPrincipal();
        }

        @FXML
        void actualizarUsuario_Action(ActionEvent event) {

        }
        @FXML
        void eliminarUsuario_Action(ActionEvent event) {

        }

        @FXML
        void guardarUsuario_Action(ActionEvent event) {

        }


    }


