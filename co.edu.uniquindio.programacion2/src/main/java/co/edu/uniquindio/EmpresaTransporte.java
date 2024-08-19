package co.edu.uniquindio;

import java.util.ArrayList;
import java.util.Collection;

public class EmpresaTransporte {
    // Colecciones para almacenar propietarios, vehículos de carga, vehículos de
    // transporte y usuario
    private final Collection<Propietario> propietarios;
    private final Collection<VehiculoCarga> vehiculoCargas;
    private final Collection<VehiculoTransporte> vehiculoTransportes;
    private final Collection<Usuario> usuarios;

    // Constructor que incializa las colecciones
    public EmpresaTransporte() {
        this.propietarios = new ArrayList<>();
        this.vehiculoCargas = new ArrayList<>();
        this.vehiculoTransportes = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    // Metodo para añadir propietario a la coleccio de propietario y su vehiculo
    // correspondiente
    public void addPropietario(Propietario propietario) {
        propietarios.add(propietario);
        addVehiculo(propietario.getVehiculo());
    }

    // metodo para añadir un vehiculo a la collecion se gun su tipo
    public void addVehiculo(Vehiculo vehiculo) {
        if (vehiculo instanceof VehiculoTransporte) {
            vehiculoTransportes.add((VehiculoTransporte) vehiculo);
        } else if (vehiculo instanceof VehiculoCarga) {
            vehiculoCargas.add((VehiculoCarga) vehiculo);
        }
    }

    // metodo añadir usuario a la collecion usuario
    public void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    // metodo asignar un usuario a un vehiculo de transporte, si hay espacio
    public boolean addUsuarioAvehiculo(String placa, Usuario usuario) {
        for (VehiculoTransporte vehiculoTransporte : vehiculoTransportes) {
            if (vehiculoTransporte.getPlaca().equals(placa)) {
                // verifica si hay espacio disponible
                if (vehiculoTransporte.getNumeroUsuarios() < vehiculoTransporte.getMaxPasajeros()) {
                    vehiculoTransporte.addUsuario(usuario);
                    usuario.setVehiculo(vehiculoTransporte);
                    System.out.println("Se ha añadido el usuario: " + usuario.getNombre() + " al vehiculo con placa: "
                            + vehiculoTransporte.getPlaca());
                    return true;
                } else {
                    System.out.println("Error: el vehículo con placa: " + placa + " se encuentra lleno");
                    return false;
                }

            }
        }
        System.out.println("Error: no se ha encontrado un el vehiculo con placa: " + placa);
        return false;
    }

    // metodo para calcular el total de pasajeros transportados en un vehiculo
    // especifico
    public String calcularTotalPasajeros(String placa) {
        for (VehiculoTransporte vehiculo : vehiculoTransportes) {
            if (vehiculo.getPlaca().equals(placa)) {
                return "El total de pasajeros transportados en el vehículo con placa: '" + placa + "' es de: "
                        + (vehiculo.getMaxPasajeros() * 10);
            }
        }
        for (VehiculoCarga vehiculo : vehiculoCargas) {
            if (vehiculo.getPlaca().equals(placa)) {
                return "El vehículo con placa '" + placa + "' es de carga, no de transporte.";
            }
        }
        return "No se ha encontrado un vehículo con placa: '" + placa + "'.";
    }
    // metodo para contar el numero de usuarios cuyo peso es mayor al especificado

    public int usuariosConPesoMayor(double peso) {
        int contador = 0;
        for (Usuario usuario : usuarios) {
            if (usuario.getPeso() > peso) {
                contador++;
            }
        }
        return contador;
    }

    // metodo para contar el numero de propietarios Mayores de 40 años
    public int usuariosPorVehiculo(String placa) {
        int contador = 0;
        for (Usuario usuario : usuarios) {
            if (usuario.getVehiculo() != null && usuario.getVehiculo().getPlaca().equals(placa)) {
                contador++;
            }
        }
        return contador;
    }

    // metodo contar el numero de propietarios ayores a 40 años
    public int propietariosMayoresA40() {
        int contador = 0;
        for (Propietario propietario : propietarios) {
            if (propietario.getEdad() > 40) {
                contador++;
            }
        }
        return contador;
    }

    // metodo para contar el numero de usuarios que estan dentro del rango de edad
    // especifico
    public int usuariosEnRangoEdad(int edadMinima, int edadMaxima) {
        int contador = 0;
        for (Usuario usuario : usuarios) {
            if (usuario.getEdad() >= edadMinima && usuario.getEdad() <= edadMaxima) {
                contador++;
            }
        }
        return contador;
    }

}
