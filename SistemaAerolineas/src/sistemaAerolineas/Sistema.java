package sistemaAerolineas;

import tads.Lista;
import clases.Aerolinea;
import clases.Avion;
import clases.Cliente;
import clases.Pasaje;
import clases.Vuelo;
import tads.Nodo;

public class Sistema implements IObligatorio {

    private Lista<Aerolinea> listaAerolineas;
    private Lista<Avion> listaAviones;
    private Lista<Cliente> listaClientes;
    private Lista<Pasaje> listaPasajes;
    private Lista<Vuelo> listaVuelos;
    
    @Override
    public Retorno crearSistemaDeGestion() {
        listaAerolineas = new Lista<Aerolinea>();
        listaAviones = new Lista<Avion>();
        listaClientes = new Lista<Cliente>();
        listaPasajes = new Lista<Pasaje>();
        listaVuelos  = new Lista<Vuelo>();
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
        listaAerolineas.agregarOrdenado(aerolinea);
        return Retorno.ok();
    }

    @Override
    public Retorno eliminarAerolinea(String nombre) {
        Aerolinea a = new Aerolinea();
        a.setNombre(nombre);
        //En caso de que no exista una aerolínea con dicho nombre
        if(!listaAerolineas.existeElemento(a)) {
            return Retorno.error1();
        }
        Aerolinea aBorrar = listaAerolineas.obtenerElemento(a);

        //Si tiene aviones registrados
        if (!aBorrar.getAviones().esVacia()) {
            return Retorno.error2();
        }
        listaAerolineas.eliminarElemento(aBorrar);
        return Retorno.ok();
    }

 @Override
    public Retorno registrarAvion(String codigo, int capacidadMax, String nomAerolinea) {
        Aerolinea aeroBuscada = new Aerolinea(nomAerolinea);
        if(!listaAerolineas.existeElemento(aeroBuscada)) {
            //Si no existe la aerolínea
            return Retorno.error3();
        } else if(capacidadMax < 9 || (capacidadMax % 3) != 0){
            //Si la capacidad máxima es < que 9 pasajeros o no es múltiplo de 3.
            return Retorno.error2();
        } else {
            //En caso de que ya exista dicho código de avión en la aerolínea.
            Aerolinea aerolinea = listaAerolineas.obtenerElemento(aeroBuscada);
            Avion avion = new Avion(codigo, capacidadMax, aerolinea);
            if (aerolinea.getAviones().existeElemento(avion)) {
                return Retorno.error1();
        }
        aerolinea.setAviones(avion);
        listaAviones.agregarInicio(avion);
        
        return Retorno.ok();
//        Avion avion = new Avion(codigo, capacidadMax, nomAerolinea);
//        
//        Aerolinea aBuscar = new Aerolinea();
//        aBuscar.setNombre(nomAerolinea);
//        
//        //Si no existe la aerolínea
//        if(!listaAerolineas.existeElemento(aBuscar)) {
//            return Retorno.error3();
//        }        
//        
//        Aerolinea aerolinea = listaAerolineas.obtenerElemento(aBuscar);
//        
//        //En caso de que ya exista dicho código de avión en la aerolínea.
//        if (aerolinea.getAviones().existeElemento(avion)) {
//            return Retorno.error1();
//        }
//        
//        //Si la capacidad máxima es < que 9 pasajeros o no es múltiplo de 3.
//        if (capacidadMax < 9 || (capacidadMax % 3) != 0) {
//            return Retorno.error2();
//        }      
//        
//        aerolinea.setAviones(avion);
//        listaAviones.agregarInicio(avion);
//        
//        return Retorno.ok();
        }
    }
    
    @Override
    public Retorno eliminarAvion(String nomAerolinea, String codAvion) {
        Aerolinea aerolinea = new Aerolinea(nomAerolinea); 
        Avion avion = new Avion(codAvion);
        
        if (!listaAerolineas.existeElemento(aerolinea)) { // En caso de que no exista la aerolínea.        
            return Retorno.error1();
        }
        Aerolinea aerolineaBuscada = listaAerolineas.obtenerElemento(aerolinea);
        avion = aerolineaBuscada.getAviones().obtenerElemento(avion);
        if (avion == null) { //En caso de que no exista el código de avión dentro de la aerolínea.
            return Retorno.error2();
        } else {
            // En caso de que tenga algún viaje con pasajes vendidos
            Lista listaVuelosDeAvion = avion.getListaVuelos();
            if (listaVuelosDeAvion.esVacia()) {
                aerolineaBuscada.getAviones().eliminarElemento(avion);
                listaAviones.eliminarElemento(avion);
                return Retorno.ok();       
            }
            Nodo<Vuelo> vueloNodo = listaVuelosDeAvion.getInicio();
            while(vueloNodo != null) {
            if (!vueloNodo.getDato().getPasajesVendidos().esVacia()){
                return Retorno.error3();
            } else {
                vueloNodo = vueloNodo.getSiguiente();
            }
            }
        }
        aerolineaBuscada.getAviones().eliminarElemento(avion);
        listaAviones.eliminarElemento(avion);
        return Retorno.ok();       
    }

    @Override
    //no se hace
    public Retorno registrarCliente(String pasaporte, String nombre, int edad) {
        if (edad < 0) {
        //1.- En caso de que la edad sea < 0
            return Retorno.error1();
        } else if (pasaporte.length() != 7){
        //2.- En caso de que el número de pasaporte sea <> a 7 caracteres.
            return Retorno.error2();
        } else {
        //3.- En caso de que ya exista un cliente con dicho pasaporte
            Cliente nuevoCliente = new Cliente(pasaporte, nombre, edad);
            if(listaClientes.existeElemento(nuevoCliente)) {
                return Retorno.error3();
            } else {
                listaClientes.agregarInicio(nuevoCliente);
                return Retorno.ok();
            }
        }
        
    }

    @Override
    //no se hace
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
        //Completar con OK (armar cadena)
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        Nodo<Aerolinea> nodoAerolinea = listaAerolineas.getInicio();
        ret.valorString = "";
        while(nodoAerolinea!=null){
            ret.valorString+= nodoAerolinea.getDato().toString();
            nodoAerolinea = nodoAerolinea.getSiguiente();
        }
        
        return ret;
    }

    @Override
    public Retorno listarAvionesDeAerolinea(String nombre) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        Aerolinea aBusq = new Aerolinea();
        aBusq.setNombre(nombre);
        
        if (!listaAerolineas.existeElemento(aBusq)) {
            return Retorno.error1();
        } else {
            Aerolinea aerolinea = listaAerolineas.obtenerElemento(aBusq);
            Nodo<Avion> nodoAvion = aerolinea.getAviones().getInicio();
            ret.valorString = "";
            while(nodoAvion!=null) {
                ret.valorString += nodoAvion.getDato().toString();
                nodoAvion = nodoAvion.getSiguiente();
            }
        }
        
        return ret;
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
