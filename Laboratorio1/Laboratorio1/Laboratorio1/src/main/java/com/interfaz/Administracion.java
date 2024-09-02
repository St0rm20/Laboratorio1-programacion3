package com.interfaz;

import com.controller.laboratorio1.AdministradorController;
import com.controller.laboratorio1.ClubController;
import com.example.laboratorio1.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.time.LocalDate;



public class Administracion extends Application {
    private AdministradorController adminController;
    private ClubController clubController;

    @Override
    public void start(Stage primaryStage) {

        // Configuración de la escena de inicio de sesión
        GridPane gridInicioAdministrador = new GridPane();
        gridInicioAdministrador.setAlignment(Pos.CENTER);
        gridInicioAdministrador.setHgap(10);
        gridInicioAdministrador.setVgap(10);
        gridInicioAdministrador.setPadding(new Insets(10, 10, 10, 10));

        Label nombreLabel = new Label("Nombre:");
        Label idLabel = new Label("ID:");
        TextField nombreField = new TextField();
        TextField idField = new TextField();

        Button iniciarSesion = new Button("Iniciar sesión");
        iniciarSesion.setStyle("-fx-background-color: #92DB48; -fx-text-fill: white; -fx-font-size: 14px;");

        gridInicioAdministrador.add(nombreLabel, 0, 0);
        gridInicioAdministrador.add(nombreField, 1, 0);
        gridInicioAdministrador.add(idLabel, 0, 1);
        gridInicioAdministrador.add(idField, 1, 1);
        gridInicioAdministrador.add(iniciarSesion, 1, 2);

        Scene escenaAdministrador = new Scene(gridInicioAdministrador, 300, 200);

        // Configuración de la escena de administración
        GridPane gridPaneAdministrar = new GridPane();
        gridPaneAdministrar.setAlignment(Pos.CENTER);
        gridPaneAdministrar.setHgap(10);
        gridPaneAdministrar.setVgap(10);
        gridPaneAdministrar.setPadding(new Insets(10, 10, 10, 10));

        Button agregarEntrenador = new Button("Agregar Entrenador");
        agregarEntrenador.setStyle("-fx-background-color:blue; -fx-text-fill:white; -fx-font-size: 14px;");
        Button agregarDeporte= new Button("Agregar Deporte");
        agregarDeporte.setStyle("-fx-background-color:blue; -fx-text-fill: white; -fx-font-size: 14px;");
        Button programarEntrenamiento = new Button("Programar Entrenamiento");
        programarEntrenamiento.setStyle("-fx-background-color:blue; -fx-text-fill:white; -fx-font-size: 14px;");
        Button cancelarEntrenamiento = new Button("Cancelar Entrenamiento");
        cancelarEntrenamiento.setStyle("-fx-background-color: blue; -fx-text-fill:white; -fx-font-size: 14px;");
        Button cambiarFechaEntrenamiento = new Button("Cambiar Fecha Entrenamiento");
        cambiarFechaEntrenamiento.setStyle("-fx-background-color:blue; -fx-text-fill:white; -fx-font-size: 14px;");

        gridPaneAdministrar.add(agregarDeporte,1,2);
        gridPaneAdministrar.add(agregarEntrenador, 0, 0);
        gridPaneAdministrar.add(programarEntrenamiento, 0, 1);
        gridPaneAdministrar.add(cancelarEntrenamiento, 1, 0);
        gridPaneAdministrar.add(cambiarFechaEntrenamiento, 1, 1);

        Scene escenaAdministrar = new Scene(gridPaneAdministrar, 400, 300);


        //Grids para agegarUnEntrenador
        GridPane gridPaneAgregarEntrenador= new GridPane();
        gridPaneAgregarEntrenador.setAlignment(Pos.CENTER);
        gridPaneAgregarEntrenador.setVgap(10);
        gridPaneAgregarEntrenador.setHgap(10);
        gridPaneAgregarEntrenador.setPadding(new Insets(10,10,10,10));
        // Botones y entradas necesarias
        Label nombreCoachLabel= new Label("Nombre entrenador");
        TextField nombreCoachfield= new TextField();
        Label especialidadLabel= new Label("Ingrese la Especialidad");
        TextField especialidadEntrenadorField= new TextField();
        Button volverAgregarEntrenador =new Button("volver");
        volverAgregarEntrenador.setStyle("-fx-background-color: red; -fx-text-fill: white; -fx-font-size: 14px");
        Button confirmarAgregado= new Button("Añadir");
        confirmarAgregado.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-font-size: 14px");
        gridPaneAgregarEntrenador.add(nombreCoachLabel,0,0);
        gridPaneAgregarEntrenador.add(nombreCoachfield,1,0);
        gridPaneAgregarEntrenador.add(especialidadLabel,0,1);
        gridPaneAgregarEntrenador.add(especialidadEntrenadorField,1,1);
        gridPaneAgregarEntrenador.add(volverAgregarEntrenador,0,2);
        gridPaneAgregarEntrenador.add(confirmarAgregado,1,2);

        Scene escenaAgregarEntrenador= new Scene(gridPaneAgregarEntrenador,300,200);

        volverAgregarEntrenador.setOnAction(e->{
            primaryStage.setScene(escenaAdministrar);
        });

        confirmarAgregado.setOnAction(e->{
            try{
                String nombreEntrenador= nombreCoachfield.getText().trim();
                String especialidadEntrenador= especialidadEntrenadorField.getText().trim();
                if(nombreEntrenador.isEmpty()||especialidadEntrenador.isEmpty()){
                    throw new IllegalArgumentException("Datos no validos");
                }

                Entrenador entrenador =new Entrenador(nombreEntrenador,"",especialidadEntrenador);
                clubController.getClub().agregarEntrenador(entrenador);
            }catch (Exception ex) {
                System.out.println("Error al programar el entrenamiento: " + ex.getMessage());
            }
            primaryStage.setScene(escenaAgregarEntrenador);
        });

        agregarEntrenador.setOnAction(e->{
            primaryStage.setScene(escenaAgregarEntrenador);
        });


        // grids para agregar un deporte
        GridPane gridPaneAgregarDeporte= new GridPane();
        gridPaneAgregarDeporte.setAlignment(Pos.CENTER);
        gridPaneAgregarDeporte.setHgap(10);
        gridPaneAgregarDeporte.setVgap(10);
        gridPaneAgregarDeporte.setPadding(new Insets(10,10,10,10));

        // botones y entradas de la ventanna agrgarDeporte
        Label nombreDeporteLabelA= new Label("Nombre Deporte:");
        TextField nombreDeporteFieldA= new TextField();
        Label descripcionLabel= new Label("Descripcion");
        TextField descripcionField= new TextField();
        Label nivelDificultadLabel= new Label("Oprima el nivel de dificultad");
        ComboBox<NivelDificultad> nivelDificultadComboBox= new ComboBox<>();
        nivelDificultadComboBox.getItems().setAll(NivelDificultad.values());
        nivelDificultadComboBox.setPromptText("Seleccione nivel de dificultad");
        Button volverAgregarDeporte= new Button("Volver");
        Button confirmarAgregadoDeporte= new Button("Añadir");
        confirmarAgregadoDeporte.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-font-size:14px");
        volverAgregarDeporte.setStyle("-fx-background-color:red; -fx-text-fill: white;-fx-font-size: 14px");
        gridPaneAgregarDeporte.add(nombreDeporteLabelA,0,0);
        gridPaneAgregarDeporte.add(nombreDeporteFieldA,1,0);
        gridPaneAgregarDeporte.add(descripcionLabel,0,2);
        gridPaneAgregarDeporte.add(descripcionField,1,2);
        gridPaneAgregarDeporte.add(nivelDificultadLabel,0,3);
        gridPaneAgregarDeporte.add(nivelDificultadComboBox,1,3);
        gridPaneAgregarDeporte.add(volverAgregarDeporte,0,4);
        gridPaneAgregarDeporte.add(confirmarAgregadoDeporte,1,4);
        Scene escenaAgregarDeporte = new Scene(gridPaneAgregarDeporte,400,400);

        confirmarAgregadoDeporte.setOnAction(e->{
            try{
                String nombreDeporte= nombreDeporteFieldA.getText().trim();
                String descripcion= descripcionField.getText().trim();
                NivelDificultad nivelDificultad= nivelDificultadComboBox.getValue();
                if (nombreDeporte.isEmpty()||descripcion.isEmpty()||nivelDificultad.equals(null)){
                    throw new IllegalArgumentException("Datos no validos");
                }
                Deporte deporte = new Deporte(nombreDeporte,descripcion,nivelDificultad);
                clubController.getClub().agregarDeporte(deporte);
            }catch (Exception ex){
                return;
            }
        });


        volverAgregarDeporte.setOnAction(e->{
            primaryStage.setScene(escenaAdministrar);
        });
        agregarDeporte.setOnAction(e->{
            primaryStage.setScene(escenaAgregarDeporte);
        });

        // Configuración de la escena para programar entrenamiento
        GridPane gridPaneProgramarEntrenamiento = new GridPane();
        gridPaneProgramarEntrenamiento.setAlignment(Pos.CENTER);
        gridPaneProgramarEntrenamiento.setHgap(10);
        gridPaneProgramarEntrenamiento.setVgap(10);
        gridPaneProgramarEntrenamiento.setPadding(new Insets(10, 10, 10, 10));

        Label fechaEntrenamientoLabel = new Label("Fecha Entrenamiento:");
        DatePicker fechaEntrenamientoPicker = new DatePicker();
        Label duracionEntrenamientoLabel = new Label("Duración Entrenamiento:");
        TextField duracionEntrenamientoField = new TextField();
        Label estadoEntrenamientoLabel = new Label("Estado Entrenamiento:");
        TextField estadoEntrenamientoField = new TextField();
        Label nombreDeporteLabel = new Label("Nombre Deporte:");
        TextField nombreDeporteField = new TextField();
        Label nombreEntrenadorLabel = new Label("Nombre Entrenador:");
        TextField nombreEntrenadorField = new TextField();
        Button volverProgramar = new Button("Volver");
        volverProgramar.setStyle("-fx-background-color: #E1201D; -fx-text-fill:white; -fx-font-size: 14px;");
        Button confirmarEntrenamiento = new Button("Confirmar Entrenamiento");
        confirmarEntrenamiento.setStyle("-fx-background-color: green; -fx-text-fill:white; -fx-font-size:14px;");

// Añadir los elementos al GridPane en sus respectivas posiciones
        gridPaneProgramarEntrenamiento.add(nombreDeporteLabel, 0, 0);
        gridPaneProgramarEntrenamiento.add(nombreDeporteField, 1, 0);
        gridPaneProgramarEntrenamiento.add(nombreEntrenadorLabel, 0, 1);
        gridPaneProgramarEntrenamiento.add(nombreEntrenadorField, 1, 1);
        gridPaneProgramarEntrenamiento.add(fechaEntrenamientoLabel, 0, 2);
        gridPaneProgramarEntrenamiento.add(fechaEntrenamientoPicker, 1, 2);
        gridPaneProgramarEntrenamiento.add(duracionEntrenamientoLabel, 0, 3);
        gridPaneProgramarEntrenamiento.add(duracionEntrenamientoField, 1, 3);
        gridPaneProgramarEntrenamiento.add(estadoEntrenamientoLabel, 0, 4);
        gridPaneProgramarEntrenamiento.add(estadoEntrenamientoField, 1, 4);
        gridPaneProgramarEntrenamiento.add(volverProgramar, 0, 5);
        gridPaneProgramarEntrenamiento.add(confirmarEntrenamiento, 1, 5);

        Scene escenaProgramarEntrenamiento = new Scene(gridPaneProgramarEntrenamiento, 400, 300);

        volverProgramar.setOnAction(e -> primaryStage.setScene(escenaAdministrar));

        primaryStage.setScene(escenaProgramarEntrenamiento);


        confirmarEntrenamiento.setOnAction(e -> {
            try {
                // Validar y obtener datos del formulario
                LocalDate fecha = fechaEntrenamientoPicker.getValue();
                int duracion = Integer.parseInt(duracionEntrenamientoField.getText());
                boolean estado = Boolean.parseBoolean(estadoEntrenamientoField.getText());
                String nombreDeporte = nombreDeporteField.getText();
                String nombreEntrenador = nombreEntrenadorField.getText();

                Deporte deporteSeleccionado = null;
                Entrenador entrenadorSeleccionado = null;

                if (clubController != null) {
                    // Buscar el deporte seleccionado
                    for (Deporte deporte : clubController.getClub().getDeportes()) {
                        if (deporte.getNombre().equals(nombreDeporte)) {
                            deporteSeleccionado = deporte;
                            // Buscar el entrenador dentro del deporte seleccionado
                            for (Entrenador entrenador : deporteSeleccionado.getEntrenadores()) {
                                if (entrenador.getNombre().equals(nombreEntrenador)) {
                                    entrenadorSeleccionado = entrenador;
                                    break;
                                }
                            }
                            break;
                        }
                    }

                    // Verificar que ambos, deporte y entrenador, fueron seleccionados
                    if (deporteSeleccionado == null || entrenadorSeleccionado == null) {
                        throw new IllegalArgumentException("Deporte o Entrenador no encontrados.");
                    }

                    // Crear el objeto Entrenamiento
                    Entrenamiento entrenamiento = new Entrenamiento(fecha, duracion, estado, entrenadorSeleccionado, deporteSeleccionado);

                    // Programar el entrenamiento usando el controlador
                    adminController.programarEntrenamiento(deporteSeleccionado, entrenadorSeleccionado, fecha, estado, duracion);
                } else {
                    System.out.println("ClubController no está inicializado.");
                }

                primaryStage.setScene(escenaAdministrar);

            } catch (Exception ex) {
                System.out.println("Error al programar el entrenamiento: " + ex.getMessage());
            }
        });

        programarEntrenamiento.setOnAction(e -> primaryStage.setScene(escenaProgramarEntrenamiento));

        // Escena para cambiar fecha
        GridPane gridPaneCambiarFecha = new GridPane();
        gridPaneCambiarFecha.setAlignment(Pos.CENTER);
        gridPaneCambiarFecha.setHgap(10);
        gridPaneCambiarFecha.setVgap(10);
        gridPaneCambiarFecha.setPadding(new Insets(10, 10, 10, 10));

        Label fechaActual = new Label("Fecha actual:");
        DatePicker fechaActualPicker = new DatePicker();
        Label actualizarFecha = new Label("Programar nueva fecha:");
        DatePicker actualizarFechaPicker = new DatePicker();
        Label seleccionarEntrenamiento = new Label("Seleccionar Entrenamiento:");
        TextField seleccionarEntrenamientoField = new TextField();
        Button volverFecha = new Button("Volver");
        volverFecha.setStyle("-fx-background-color: #E1201D; -fx-text-fill:white; -fx-font-size: 14px;");
        gridPaneCambiarFecha.add(fechaActual, 0, 0);
        gridPaneCambiarFecha.add(fechaActualPicker, 1, 0);
        gridPaneCambiarFecha.add(seleccionarEntrenamiento, 0, 1);
        gridPaneCambiarFecha.add(seleccionarEntrenamientoField, 1, 1);
        gridPaneCambiarFecha.add(actualizarFecha, 0, 2);
        gridPaneCambiarFecha.add(actualizarFechaPicker, 1, 2);
        gridPaneCambiarFecha.add(volverFecha, 1, 3);

        Scene escenaCambiarFechaEntrenamiento = new Scene(gridPaneCambiarFecha, 300, 200);

        volverFecha.setOnAction(e -> primaryStage.setScene(escenaAdministrar));
        cambiarFechaEntrenamiento.setOnAction(e -> primaryStage.setScene(escenaCambiarFechaEntrenamiento));

        // Escena para cancelar entrenamiento
        GridPane gridPaneCancelar = new GridPane();
        gridPaneCancelar.setAlignment(Pos.CENTER);
        gridPaneCancelar.setHgap(10);
        gridPaneCancelar.setVgap(10);
        gridPaneCancelar.setPadding(new Insets(10, 10, 10, 10));
        Button volverCancelar = new Button("Volver");
        volverCancelar.setStyle("-fx-background-color: #E1201D; -fx-text-fill:white; -fx-font-size: 14px;");
        Label fechaLabel = new Label(" Fecha entrenamiento:");
        DatePicker fechaPicker = new DatePicker();
        Label nombreEntrenador = new Label("Nombre Entrenador:");
        TextField nombreEntrenadorFieldC= new TextField();
        gridPaneCancelar.add(nombreEntrenador, 0, 0);
        gridPaneCancelar.add(nombreEntrenadorFieldC, 1, 0);
        gridPaneCancelar.add(fechaLabel, 0, 1);
        gridPaneCancelar.add(fechaPicker, 1, 1);
        gridPaneCancelar.add(volverCancelar, 1, 2);


        Scene escenaCancelarEntrenamiento = new Scene(gridPaneCancelar, 300, 200);

        volverCancelar.setOnAction(e -> primaryStage.setScene(escenaAdministrar));
        cancelarEntrenamiento.setOnAction(e -> {
            try{
                //Validar y obtnerDatos
                LocalDate fechaEntrenamiento = fechaPicker.getValue();
                String nameEntrenador= nombreEntrenadorField.getText().trim();
                if(nameEntrenador.isEmpty()|| fechaEntrenamiento.isBefore(LocalDate.now())){
                    throw new IllegalArgumentException("Datos ivalidos");
                }
                //
                Entrenador entrenadorSeleccionado=null;
                if(clubController!=null){
                    //Buscamos el entrenamiento
                    for(Deporte deporte: clubController.getClub().getDeportes() ){
                        for(Entrenador entrenador: deporte.getEntrenadores()){
                            if(entrenador.getNombre().equals(nameEntrenador)){
                                entrenadorSeleccionado = entrenador;
                                break;
                            }
                        }
                        break;
                    }

                }
            }catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
            primaryStage.setScene(escenaCancelarEntrenamiento);});

        // Acción del botón Iniciar sesión
        iniciarSesion.setOnAction(e -> {
            try {
                String nombre = nombreField.getText().trim();
                String id = idField.getText().trim();
                if (nombre.isEmpty() || id.isEmpty()|| id.length()<9) {
                    throw new IllegalArgumentException(" Datos Ingresados no validos.");
                }

                // Crear Administrador y controlador
                Administrador admin = new Administrador(nombre, id);
                Club club = new  Club(admin);
                adminController = new AdministradorController(admin);
                clubController = new ClubController(club); // Inicializa ClubController aquí

                System.out.println("Administrador creado: " + admin.getNombre() + ", ID: " + admin.getId());

                // Cambiar a la escena de administración
                primaryStage.setScene(escenaAdministrar);

            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        });

        primaryStage.setTitle("Administración");
        primaryStage.setScene(escenaAdministrador);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
