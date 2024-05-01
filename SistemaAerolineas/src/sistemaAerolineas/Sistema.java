package sistemaAerolineas;

import tads.Lista;
import clases.Aerolinea;
import clases.Avion;
import clases.Cliente;
import clases.Pasaje;
import clases.Vuelo;

public class Sistema implements IObligatorio {

    private Lista<Aerolinea> listaAerolineas;
    private Lista<Avion> listaAviones;
    private Lista<Cliente> listaClientes;
    private Lista<Pasaje> listaPasajes;
    private Lista<Vuelo> listaVuelos;
    
    @Override
    public Retorno crearSistemaDeGestion() {
        listaAerolineas = new Lista();
        listaAviones = new Lista();
        listaClientes = new Lista();
        listaPasajes = new Lista();
        listaVuelos  = new Lista();
        return Retorno.ok();
    }

    @Override
    public Retorno crearAerolinea(String nombre, String pais, int cantMaxAviones) {
        Aerolinea aerolinea = new Aerolinea(nombre, pais, cantMaxAviones);
        
        if (cantMaxAviones <= 0) {
            return Retorno.error2();
        }
        if (listaAerolineas.existeElemento(aerolinea)) {
            return Retorno.error1();
        }
        listaAerolineas.agregarInicio(aerolinea);
        return Retorno.ok();
    }

    @Override
    public Retorno eliminarAerolinea(String nombre) {
        //En caso de que no exista una aerolínea con dicho nombre
        Aerolinea aBorrar = listaAerolineas.obtenerElemento(nombre);
        if(aBorrar == null) {
            return Retorno.error1();
        }
        //Si tiene aviones registrados
        if (!aBorrar.getAviones().esVacia()) {
            return Retorno.error2();
        }
        listaAerolineas.eliminarElemento(aBorrar);
        return Retorno.ok();
    }

    @Override
    public Retorno registrarAvion(String codigo, int capacidadMax, String nomAerolinea) {
        Avion avion = new Avion(codigo, capacidadMax, nomAerolinea);
        
        //En caso de que ya exista dicho código de avión en la aerolínea.
        if (listaAviones.existeElemento(avion)) {
            return Retorno.error1();
        }
        //Si la capacidad máxima es < que 9 pasajeros o no es múltiplo de 3.
        if (capacidadMax < 9 || (capacidadMax % 3) != 0) {
            return Retorno.error2();
        }
        //Si no existe la aerolínea
        if(!listaAerolineas.existeElemento(nomAerolinea)) {
            return Retorno.error3();
        }
        
        //buscar aerolinea para agragarle el avion a la lista de aviones
        //agregr el avion a la lista de aviones del sistema
        return Retorno.noImplementada();
    }

    @Override
    public Retorno eliminarAvion(String nomAerolinea, String codAvion) {
        //En caso de que no exista la aerolínea. 
        if(!listaAerolineas.existeElemento(nomAerolinea)) {
            return Retorno.error1();
        }
        return Retorno.noImplementada();
    }

    @Override
    public Retorno registrarCliente(String pasaporte, String nombre, int edad) {
        //En caso de que la edad sea < 0
        if (edad < 0) {
            return Retorno.error1();
        }
        //En caso de que el número de pasaporte sea <> a 7 caracteres.
        if (pasaporte.length() != 7) {
            return Retorno.error2();
        }
        //En caso de que ya exista un cliente con dicho pasaporte
        
        return Retorno.noImplementada();
    }

    @Override
    public Retorno crearVuelo(String codigoVuelo, String aerolinea, String codAvion, String paisDestino, int dia, int mes, int año, int cantPasajesEcon, int cantPasajesPClase) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno comprarPasaje(String pasaporteCliente, String codigoVuelo, int categoríaPasaje) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno devolverPasaje(String pasaporteCliente, String codigoVuelo) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno listarAerolineas() {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno listarAvionesDeAerolinea(String nombre) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno listarClientes() {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno listarVuelos() {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno vuelosDeCliente(String pasaporte) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno pasajesDevueltos(String nombreAerolinea) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno vistaDeVuelo(String codigoVuelo) {
        return Retorno.noImplementada();
    }

}
