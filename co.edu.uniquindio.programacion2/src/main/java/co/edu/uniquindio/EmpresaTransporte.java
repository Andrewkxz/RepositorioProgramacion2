package co.edu.uniquindio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

public class EmpresaTransporte {
    private final Collection <Propietario> propietarios;
    private final Collection <VehiculoCarga> vehiculoCargas;
    private final Collection <VehiculoTransporte> vehiculoTransportes;
    private final Collection <Usuario> usuarios;

    public EmpresaTransporte() {
        this.propietarios = new ArrayList<>();
        this.vehiculoCargas = new ArrayList<>();
        this.vehiculoTransportes = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public void addPropietario(Propietario propietario) {
        propietarios.add(propietario);
        addVehiculo(propietario.getVehiculo());
    }

    public void addVehiculo(Vehiculo vehiculo) {
        if(vehiculo instanceof VehiculoTransporte) {
            vehiculoTransportes.add((VehiculoTransporte) vehiculo);
        } else if (vehiculo instanceof VehiculoCarga) {
            vehiculoCargas.add((VehiculoCarga) vehiculo);
        }
    }

    public void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public boolean addUsuarioAvehiculo(String placa, Usuario usuario) {
        for (VehiculoTransporte vehiculoTransporte : vehiculoTransportes) {
            if (vehiculoTransporte.getPlaca().equals(placa)) {
                if(vehiculoTransporte.getNumeroUsuarios() < vehiculoTransporte.getMaxPasajeros()){
                    vehiculoTransporte.addUsuario(usuario);
                    usuario.setVehiculo(vehiculoTransporte);
                    System.out.println("Se ha añadido el usuario: " + usuario.getNombre() + " al vehiculo con placa: " + vehiculoTransporte.getPlaca());
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

    public String calcularTotalPasajeros(String placa){
        for (VehiculoTransporte vehiculo : vehiculoTransportes) {
            if(vehiculo.getPlaca().equals(placa)){
                return "El total de pasajeros transportados en el vehículo con placa: '" + placa + "' es de: " + (vehiculo.getMaxPasajeros()*10);
            }
        }
        for (VehiculoCarga vehiculo : vehiculoCargas) {
            if(vehiculo.getPlaca().equals(placa)){
                return "El vehículo con placa '" + placa + "' es de carga, no de transporte.";
            }
        }
        return "No se ha encontrado un vehículo con placa: '" + placa + "'.";
    }

    public int usuariosConPesoMayor(double peso){
        int contador = 0;
        for (Usuario usuario : usuarios) {
            if(usuario.getPeso() > peso){
                contador++;
            }
        }
        return contador;
    }

    public int usuariosPorVehiculo(String placa){
        int contador = 0;
        for(Usuario usuario : usuarios){
            if(usuario.getVehiculo() != null && usuario.getVehiculo().getPlaca().equals(placa)){
                contador++;
            }
        }
        return contador;
    }

    public int propietariosMayoresA40(){
        int contador = 0;
        for (Propietario propietario : propietarios) {
            if(propietario.getEdad() > 40){
                contador++;
            }
        }
        return contador;
    }

    public int usuariosEnRangoEdad(int edadMinima, int edadMaxima){
        int contador = 0;
        for (Usuario usuario : usuarios) {
            if(usuario.getEdad() >= edadMinima && usuario.getEdad() <= edadMaxima){
                contador++;
            }
        }
        return contador;
    }

}
