package co.edu.uniquindio;

import java.util.Scanner;

/**
 * Clase principal, permite realizar operaciones como registrar propietarios, añadir usuarios a vehiculos y realizar calculos sobre los usuarios y propietarios registrados
 */ 

public class MainTransporte {
    public static void main(String[] args) {

        EmpresaTransporte empresa = new EmpresaTransporte();

        // Crea un objeto Scanner para leer entradas del usuario
        Scanner sc = new Scanner(System.in);

        boolean salir = false;
        while (!salir) {
            // Menú de opciones para el usuario

            System.out.println("Selecciona una de las siguientes opciones: ");
            System.out.println("1. Capturar datos de un propietario: ");
            System.out.println("2. Añadir un usuario a un vehículo de transporte: ");
            System.out.println("3. Calcular el total de pasajeros de un vehículo: ");
            System.out.println("4. Contar el numero de usuarios con peso mayor dado un numero: ");
            System.out.println("5. Contar el numero de usuarios de un mismo vehiculo: ");
            System.out.println("6. Calcular el total de propietarios mayores a 40 años: ");
            System.out.println("7. Calcular el total de usuarios dentro de un rango de edades: ");
            System.out.println("8. salir");
            System.out.println("opción a seleccionar: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                // Captura los datos del propietario y lo agrega a la empresa
                    Propietario propietario = capturarDatosPropietario();
                    if(propietario != null){
                        empresa.addPropietario(propietario);
                        System.out.println("Él propietario y su vehículo han sido registrados correctamente");
                    }
                    break;

                case 2:
                // Añade un usuario a un vehiculo de transporte
                    System.out.println("Ingresa la placa del vehículo: ");
                    String placaVehiculo = sc.nextLine();

                    Usuario usuario = capturarDatosUsuario();

                    if(empresa.addUsuarioAvehiculo(placaVehiculo, usuario)) {
                        empresa.addUsuario(usuario);
                        System.out.println("Él usuario ha sido registrado correctamente");
                    }
                    break;

                case 3:
                // Calcula el total de pasajeros en un vehiculo
                    System.out.println("Ingresa la placa del vehículo: ");
                    String placa = sc.nextLine();
                    String totalPasajeros = empresa.calcularTotalPasajeros(placa);
                    System.out.println(totalPasajeros);
                    break;

                case 4:
                // Cuenta el número de usuarios con un peso mayor a un valor dado
                    System.out.println("Ingresa un valor para el peso: ");
                    double peso = sc.nextDouble();
                    int usuariosConPesoMayor = empresa.usuariosConPesoMayor(peso);
                    System.out.println("El numero de usuarios con peso mayor a: " + peso + " es de: " + usuariosConPesoMayor);
                    break;

                case 5:
                // Cuenta el número de usuarios registrados en un vehiculo específico
                    System.out.println("Ingresa la placa del vehiculo para saber el numero de usuarios: ");
                    String placaUser = sc.nextLine();
                    int usuariosXvehiculo = empresa.usuariosPorVehiculo(placaUser);
                    System.out.println("el numero de usuarios del vehiculo con placa: " + placaUser + " es de: " + usuariosXvehiculo);
                    break;

                case 6:
                // Calcula el total de propietarios mayores a 40 años
                    int mayoresA40 = empresa.propietariosMayoresA40();
                    System.out.println("Él numero de propietarios mayores a 40 años es de: " + mayoresA40);
                    break;

                case 7:
                // Calcula el total de usuarios dentro de un rango de edades
                    System.out.println("Ingresa el valor de la edad minima: ");
                    int edadMinima = sc.nextInt();
                    System.out.println("Ingresa la edad maxima: ");
                    int edadMaxima = sc.nextInt();
                    int usuariosDentroDeRango = empresa.usuariosEnRangoEdad(edadMinima, edadMaxima);
                    System.out.println("El numero de usuarios en el rango de edad: " + edadMinima + " a " + edadMaxima + " es de: " + usuariosDentroDeRango);
                    break;

                case 8:
                // Opción para salir del programa
                    salir = true;
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no valida");
            }
        }
    }

    /**
     * Método que captura los datos de un propietario, incluyendo su vehículo.
     * @return un objeto de tipo Propietario con los datos capturados. o null si hay un error en la entrada.
     */
    private static Propietario capturarDatosPropietario() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresa el nombre del propietario: ");
        String nombre = sc.nextLine();
        System.out.println("Ingresa la cédula del propietario: ");
        String cedula = sc.nextLine();
        System.out.println("Ingresa la edad del propietario: ");
        int edad = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingresa el email del propietario: ");
        String email = sc.nextLine();
        System.out.println("Ingresa el celular del propietario: ");
        String celular = sc.nextLine();

        System.out.println("Ingresa el tipo de vehiculo ('carga' o 'transporte': ");
        String tipoVehiculo = sc.nextLine().toLowerCase();
        Vehiculo vehiculo = null;

        System.out.println("Ingresa la placa del vehículo: ");
        String placa = sc.nextLine();
        System.out.println("Ingresa el modelo del vehículo: ");
        String modelo = sc.nextLine();
        System.out.println("Ingresa la marca del vehículo: ");
        String marca = sc.nextLine();
        System.out.println("Ingresa el color del vehículo: ");
        String color = sc.nextLine();

        // Validación del tipo de vehiculo y captura de los datos específicos
        if(tipoVehiculo.equals("carga")) {
            System.out.println("Ingresa la capacidad del vehículo: ");
            double capacidad = sc.nextDouble();
            System.out.println("Ingresa el número de ejes del vehículo de carga: ");
            int ejes = sc.nextInt();

            vehiculo = new VehiculoCarga(placa, modelo, marca, color, capacidad, ejes);

        } else if(tipoVehiculo.equals("transporte")) {
            System.out.println("Ingresa el número máximo de pasajeros del vehículo: ");
            int maxPasajeros = sc.nextInt();
            sc.nextLine();

            vehiculo = new VehiculoTransporte(placa, modelo, marca, color, maxPasajeros);

        } else{
            System.out.println("Error: el tipo de vehículo debe ser 'carga' o 'transporte'");
            return null;
        }

        sc.nextLine();
        return new Propietario(nombre, cedula, edad, email, celular, vehiculo);
    }

    /**
     * Método que captura los datos de un usuario.
     * @return un objeto de tipo Usuario con los datos capturados
     */
    private static Usuario capturarDatosUsuario() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el nombre del usuario: ");
        String nombre = sc.nextLine();
        System.out.println("Ingresa la edad del usuario: ");
        int edad = sc.nextInt();
        System.out.println("Ingresa el peso del usuario: ");
        double peso = sc.nextDouble();
        sc.nextLine();

        return new Usuario(nombre, edad, peso, null);

    }
}
