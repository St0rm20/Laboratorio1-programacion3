package com.interfaz;

import com.example.laboratorio1.Miembro;
import com.example.laboratorio1.TipoMiembro;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InicioSesion extends Application {

    private static final String FILE_NAME = "usuarios.txt";
    private List<Miembro> miembrosRegistrados = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        // Cargar datos de usuarios desde el archivo
        cargarDatos();

        // Configuración de la escena de Inicio de Sesión
        GridPane gridInicio = new GridPane();
        gridInicio.setHgap(10);
        gridInicio.setVgap(10);
        gridInicio.setPadding(new Insets(20, 20, 20, 20));
        gridInicio.setAlignment(Pos.CENTER);

        Label usuarioLabel = new Label("Ingrese su usuario:");
        usuarioLabel.setFont(new Font("Arial", 14));
        TextField usuario = new TextField();

        Label contraseniaLabel = new Label("Ingrese su contraseña:");
        contraseniaLabel.setFont(new Font("Arial", 14));
        PasswordField contraseniaField = new PasswordField();

        Button registrarse = new Button("Registrarse");
        registrarse.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px;");

        Button iniciarSesion = new Button("Iniciar Sesión");
        iniciarSesion.setStyle("-fx-background-color: #008CBA; -fx-text-fill: white; -fx-font-size: 14px;");

        gridInicio.add(usuarioLabel, 0, 0);
        gridInicio.add(usuario, 1, 0);
        gridInicio.add(contraseniaLabel, 0, 1);
        gridInicio.add(contraseniaField, 1, 1);
        gridInicio.add(registrarse, 0, 2);
        gridInicio.add(iniciarSesion, 1, 2);

        Scene escenaInicio = new Scene(gridInicio, 400, 300);

        primaryStage.setTitle("Inicio de Sesión");
        primaryStage.setScene(escenaInicio);
        primaryStage.show();

        // Configuración de la escena de Bienvenida
        GridPane gridPaneInicio = new GridPane();
        gridPaneInicio.setAlignment(Pos.CENTER);
        gridPaneInicio.setVgap(10);
        gridPaneInicio.setHgap(10);
        gridPaneInicio.setPadding(new Insets(10, 10, 10, 10));

        Scene escenaBienvenida = new Scene(gridPaneInicio, 400, 400);

        iniciarSesion.setOnAction(e -> {
            String nombreUsuario = usuario.getText().trim();
            String contrasenia = contraseniaField.getText().trim();

            if (nombreUsuario.isEmpty() || contrasenia.isEmpty()) {
                mostrarAlerta(Alert.AlertType.ERROR, "Error de Inicio de Sesión", "Por favor ingrese su usuario y contraseña.");
                return;
            }

            boolean usuarioValido = miembrosRegistrados.stream()
                    .anyMatch(m -> m.getNombre().equals(nombreUsuario) && m.getId().equals(contrasenia));

            if (usuarioValido) {
                primaryStage.setScene(escenaBienvenida);
            } else {
                mostrarAlerta(Alert.AlertType.ERROR, "Error de Inicio de Sesión", "Usuario o contraseña incorrectos.");
            }
        });

        // Configuración de la escena de Registro
        GridPane gridRegistro = new GridPane();
        gridRegistro.setHgap(10);
        gridRegistro.setVgap(10);
        gridRegistro.setPadding(new Insets(20, 20, 20, 20));
        gridRegistro.setAlignment(Pos.CENTER);

        Label nombreLabel = new Label("Ingrese su nombre:");
        nombreLabel.setFont(new Font("Arial", 14));
        TextField nombreField = new TextField();

        Label idLabel = new Label("Ingrese su ID:");
        idLabel.setFont(new Font("Arial", 14));
        TextField idField = new TextField();

        Label tipoMiembroLabel = new Label("Ingrese el tipo de miembro:");
        ComboBox<TipoMiembro> tipoMiembroComboBox = new ComboBox<>();
        tipoMiembroComboBox.getItems().setAll(TipoMiembro.values());

        Label correoElectronicoLabel = new Label("Ingrese su correo:");
        correoElectronicoLabel.setFont(new Font("Arial", 14));
        TextField correoElectronicoField = new TextField();

        Button volver = new Button("Volver");
        volver.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-font-size: 14px;");

        Button crearCuenta = new Button("Crear Cuenta");
        crearCuenta.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: black; -fx-font-size: 14px;");

        gridRegistro.add(nombreLabel, 0, 0);
        gridRegistro.add(nombreField, 1, 0);
        gridRegistro.add(idLabel, 0, 1);
        gridRegistro.add(idField, 1, 1);
        gridRegistro.add(correoElectronicoLabel, 0, 2);
        gridRegistro.add(correoElectronicoField, 1, 2);
        gridRegistro.add(tipoMiembroLabel, 0, 3);
        gridRegistro.add(tipoMiembroComboBox, 1, 3);
        gridRegistro.add(volver, 0, 4);
        gridRegistro.add(crearCuenta, 1, 4);

        Scene escenaRegistro = new Scene(gridRegistro, 400, 300);

        registrarse.setOnAction(e -> {
            primaryStage.setScene(escenaRegistro);
        });

        volver.setOnAction(e -> {
            primaryStage.setScene(escenaInicio);
        });

        crearCuenta.setOnAction(e -> {
            try {
                String nombreUsuario = nombreField.getText().trim();
                String idUsuario = idField.getText().trim();
                String correoElectronico = correoElectronicoField.getText().trim();
                TipoMiembro tipoMiembro = tipoMiembroComboBox.getValue();

                if (nombreUsuario.isEmpty() || idUsuario.isEmpty() || correoElectronico.isEmpty() || tipoMiembro == null) {
                    mostrarAlerta(Alert.AlertType.ERROR, "Error de Registro", "Por favor complete todos los campos.");
                    return;
                }

                Miembro miembro = new Miembro(nombreUsuario, idUsuario, correoElectronico, tipoMiembro);
                miembrosRegistrados.add(miembro);

                // Guardar datos de usuarios en el archivo
                guardarDatos();

                // Mostrar un mensaje de éxito o redirigir al usuario a otra escena
                mostrarAlerta(Alert.AlertType.INFORMATION, "Registro Exitoso", "Cuenta creada exitosamente. Ahora puede iniciar sesión.");
                primaryStage.setScene(escenaInicio);
            } catch (Exception ex) {
                mostrarAlerta(Alert.AlertType.ERROR, "Error de Registro", ex.getMessage());
            }
        });
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void guardarDatos() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Miembro miembro : miembrosRegistrados) {
                writer.write(miembro.toFileFormat());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    private void cargarDatos() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Miembro miembro = Miembro.fromFileFormat(line);
                miembrosRegistrados.add(miembro);
            }
        } catch (IOException e) {
            System.out.println("Error al cargar los datos: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
