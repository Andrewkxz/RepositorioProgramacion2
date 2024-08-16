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

    /*private boolean verificarVehiculo(String placa){
        Predicate<Vehiculo> placaIgual = vehiculo -> vehiculo.getPlaca().equals(placa);
        return vehiculos
                .stream()
                .filter(placaIgual)
                .findAny()
                .isPresent();
    }*/

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
}
