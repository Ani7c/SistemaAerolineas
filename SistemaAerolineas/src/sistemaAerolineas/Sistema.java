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
        listaAerolineas = new Lista<>();
        listaAviones = new Lista<>();
        listaClientes = new Lista<>();
        listaPasajes = new Lista<>();
        listaVuelos = new Lista<>();
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
        if (!listaAerolineas.existeElemento(a)) {
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
        if (!listaAerolineas.existeElemento(aeroBuscada)) {
            //Si no existe la aerolínea
            return Retorno.error3();
        } else if (capacidadMax < 9 || (capacidadMax % 3) != 0) {
            //Si la capacidad máxima es > que 9 pasajeros o no es múltiplo de 3.
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
            while (vueloNodo != null) {
                if (!vueloNodo.getDato().getPasajesVendidos().esVacia()) {
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
        } else if (pasaporte.length() != 7) {
            //2.- En caso de que el número de pasaporte sea <> a 7 caracteres.
            return Retorno.error2();
        } else {
            //3.- En caso de que ya exista un cliente con dicho pasaporte
            Cliente nuevoCliente = new Cliente(pasaporte, nombre, edad);
            if (listaClientes.existeElemento(nuevoCliente)) {
                return Retorno.error3();
            } else {
                listaClientes.agregarInicio(nuevoCliente);
                return Retorno.ok();
            }
        }

    }

    @Override
    public Retorno crearVuelo(String codigoVuelo, String aerolinea, String codAvion, String paisDestino, int dia, int mes, int año, int cantPasajesEcon, int cantPasajesPClase) {
        Vuelo nuevoVuelo = new Vuelo(codigoVuelo);
        Aerolinea aerolineaBuscada = new Aerolinea(aerolinea);
        aerolineaBuscada = listaAerolineas.obtenerElemento(aerolineaBuscada);
        if (listaVuelos.existeElemento(nuevoVuelo)) {
            //1. -En caso de que ya exista el código de vuelo en el sistema
            return Retorno.error1();
        } else if (aerolineaBuscada == null) {
            //2. - En caso de que la aerolínea no exista en el sistema.
            return Retorno.error2();
        } else {

            if (!aerolineaBuscada.getAviones().existeElemento(new Avion(codAvion))) {
                //3.- En caso de que el código de avión no exista dentro de la aerolínea.
                return Retorno.error3();
            } else {
                //4 - En caso de que ya exista un vuelo creado para ese avión en dicha fecha.
                Nodo<Vuelo> actual = listaVuelos.getInicio();
                while (actual != null) {
                    Vuelo vuelo = actual.getDato();
                    Avion avionBuscado = new Avion(codAvion);
                    if (vuelo.getAvion().equals(avionBuscado) && vuelo.mismaFecha(dia, mes, año)) {
                        return Retorno.error4(); // Ya existe un vuelo para ese avión en esa fecha
                    }
                    actual = actual.getSiguiente();
                }
            }
            //5 – En caso de que las cantidades de pasajes (de cualquiera de las categorías) no sea múltiplo de 3.
            if (cantPasajesEcon < 3 || cantPasajesPClase < 3 || cantPasajesEcon % 3 != 0 || cantPasajesPClase % 3 != 0) {
                return Retorno.error5();
            }
            //6 - En caso de que la suma de los pasajes de ambas categorías supere la cant. máxima permitida por el avión.
            Avion aBuscado = listaAviones.obtenerElemento(new Avion(codAvion));
            if ((cantPasajesEcon + cantPasajesPClase) > aBuscado.getCapacidadMax()) {
                return Retorno.error6();
            }
            nuevoVuelo.setAerolinea(aerolineaBuscada);
            nuevoVuelo.setAvion(aBuscado);
            nuevoVuelo.setDestino(paisDestino);
            nuevoVuelo.setFecha(dia, mes, año);
            nuevoVuelo.setCantPasajesEcon(cantPasajesEcon);
            nuevoVuelo.setCantPasajesPClase(cantPasajesPClase);

            aBuscado.setListaVuelos(nuevoVuelo);
        }

        listaVuelos.agregarFinal(nuevoVuelo);

        return Retorno.ok();

    }

    @Override
    public Retorno comprarPasaje(String pasaporteCliente, String codigoVuelo, int categoríaPasaje) {

//1.- En caso de que el pasaporte del cliente no exista
        Cliente cliBuscado = new Cliente(pasaporteCliente);
        cliBuscado = listaClientes.obtenerElemento(cliBuscado);

        Vuelo vueloBuscado = new Vuelo(codigoVuelo);
        vueloBuscado = listaVuelos.obtenerElemento(vueloBuscado);

        if (cliBuscado == null) {
            return Retorno.error1();
        } else if (vueloBuscado == null) {
            return Retorno.error2();
        }

        if ((categoríaPasaje == 1 && vueloBuscado.CantPasajesEconDisponibles > 0) || (categoríaPasaje == 2 && vueloBuscado.CantPasajesPrimeraDisponibles > 0)) {
            Pasaje pasajeNuevo = new Pasaje(pasaporteCliente, codigoVuelo, categoríaPasaje);
            listaPasajes.agregarFinal(pasajeNuevo);
            cliBuscado.setPasajesCliente(pasajeNuevo);
            vueloBuscado.pasajesVendidos.agregarInicio(pasajeNuevo);
            if (categoríaPasaje == 1) {
                vueloBuscado.CantPasajesEconDisponibles--;
                vueloBuscado.CantPasajesEconVendidos++;
            } else if (categoríaPasaje == 2) {
                vueloBuscado.CantPasajesPrimeraDisponibles--;
                vueloBuscado.CantPasajesPClaseVendidos++;
            }
        } else {
            if (categoríaPasaje == 1) {
                vueloBuscado.agregarAListaDeEsperaEcon(cliBuscado);
            } else if (categoríaPasaje == 2) {
                vueloBuscado.agregarAListaDeEsperaPClase(cliBuscado);
            }
        }

        //2.- En caso de que el código de vuelo no exista
        return Retorno.ok();
    }

    @Override
    public Retorno devolverPasaje(String pasaporteCliente, String codigoVuelo) {
        //1.- En caso de que exista el pasaporte del cliente
        //2.- En caso de que no exista el código de vuelo
        Cliente cliBuscado = listaClientes.obtenerElemento(new Cliente(pasaporteCliente));
        Vuelo vueloBuscado = listaVuelos.obtenerElemento(new Vuelo(codigoVuelo));
        if (cliBuscado == null) {
            return Retorno.error1();
        } else if (vueloBuscado == null) {
            return Retorno.error2();
        }

        //3 – En caso de que no exista una compra del cliente para dicho vuelo
        Nodo<Pasaje> actual = vueloBuscado.getPasajesVendidos().getInicio();
        while (actual != null) {
            Pasaje pasaje = actual.getDato();
            if (pasaje.getPasaporte().equals(pasaporteCliente)) {
                pasaje.setEstado("DEV");
                vueloBuscado.getAerolinea().pasajesDevueltos.agregarFinal(pasaje);
                int categoria = pasaje.getCategoria();

                Cliente nuevoCliente;
                if (categoria == 1) {
                    if (vueloBuscado.colaEconomica.isEmpty()) {
                        vueloBuscado.CantPasajesEconDisponibles++;
                    } else {
                        nuevoCliente = vueloBuscado.eliminarDeListaDeEsperaEcon();
                        Pasaje pasajeNuevo = new Pasaje(nuevoCliente.getPasaporte(), codigoVuelo, categoria);
                        nuevoCliente.setPasajesCliente(pasajeNuevo);
                        vueloBuscado.pasajesVendidos.agregarFinal(pasajeNuevo);
                    }
                } else if (vueloBuscado.colaPClase.isEmpty()) {
                    vueloBuscado.CantPasajesPrimeraDisponibles++;
                } else {
                    nuevoCliente = vueloBuscado.eliminarDeListaDeEsperaPClase();
                    Pasaje pasajeNuevo = new Pasaje(nuevoCliente.getPasaporte(), codigoVuelo, categoria);
                    nuevoCliente.setPasajesCliente(pasajeNuevo);
                    vueloBuscado.pasajesVendidos.agregarFinal(pasajeNuevo);
                }

                return Retorno.ok();
            }
            actual = actual.getSiguiente();
        }
        return Retorno.error3();

    }

    @Override
    public Retorno listarAerolineas() {
        //Completar con OK (armar cadena)
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        Nodo<Aerolinea> nodoAerolinea = listaAerolineas.getInicio();
        ret.valorString = "";
        while (nodoAerolinea != null) {
            ret.valorString += nodoAerolinea.getDato().toString();
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
            while (nodoAvion != null) {
                ret.valorString += nodoAvion.getDato().toString();
                nodoAvion = nodoAvion.getSiguiente();
            }
        }

        return ret;
    }

    @Override
    public Retorno listarClientes() {

        Retorno ret = new Retorno(Retorno.Resultado.OK);

        // Verificar si la lista de clientes está vacía
        if (listaClientes.esVacia()) {
            ret.valorString = "No hay clientes registrados.";
        } else {
            // Iniciar la llamada recursiva
            ret.valorString = listarClientesRecursivo(listaClientes.getInicio());
        }

        return ret;
    }

    // Método recursivo para listar clientes
    private String listarClientesRecursivo(Nodo<Cliente> nodo) {
        if (nodo == null) {
            return ""; // Base de la recursión: si llegamos al final de la lista
        }

        // Llamada recursiva para el siguiente nodo
        String resultado = listarClientesRecursivo(nodo.getSiguiente());

        // Construir el string con el cliente actual primero
        if (resultado.isEmpty()) {
            return nodo.getDato().toString(); // Cuando es el último cliente (primer en ser registrado)
        } else {
            return nodo.getDato().toString() + "\n" + resultado; // Agregar el cliente al inicio del resultado
        }
    }

    @Override
    public Retorno listarVuelos() {

        Retorno ret = new Retorno(Retorno.Resultado.OK);

        if (listaVuelos.esVacia()) {
            ret.valorString = "No hay vuelos registrados.";
        } else {
            StringBuilder resultado = new StringBuilder();
            Nodo<Vuelo> actual = listaVuelos.getInicio();

            while (actual != null) {
                resultado.append(actual.getDato().toString());

                if (actual.getSiguiente() != null) {
                    resultado.append("\n");
                }
                actual = actual.getSiguiente();
            }

            ret.valorString = resultado.toString();
        }
        return ret;
    }

    @Override
    public Retorno vuelosDeCliente(String pasaporte) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);

        // Buscar el cliente en la lista
        Cliente clienteBuscado = new Cliente(pasaporte);
        clienteBuscado = listaClientes.obtenerElemento(clienteBuscado);

        if (clienteBuscado == null) {
            // El cliente no existe
            ret.resultado = Retorno.Resultado.ERROR_1;
            ret.valorString = "El pasaporte del cliente no existe.";
            return ret;
        }

        // Si el cliente existe, listamos sus vuelos
        ret.valorString = listarVuelosClienteRecursivo(clienteBuscado.getPasajes().getInicio());

        return ret;
    }

    private String listarVuelosClienteRecursivo(Nodo<Pasaje> nodo) {
        if (nodo == null) {
            return ""; // Base de la recursión
        }

        String resultado = listarVuelosClienteRecursivo(nodo.getSiguiente());

        if (resultado.isEmpty()) {
            return nodo.getDato().toString(); // Último pasaje
        } else {
            return nodo.getDato().toString() + "|\n" + resultado; // Agregar el pasaje al inicio del resultado
        }
    }

    @Override
    public Retorno pasajesDevueltos(String nombreAerolinea) {

        // Verificar si la aerolínea existe en el sistema
        Aerolinea aerolinea = new Aerolinea(nombreAerolinea);
        aerolinea = listaAerolineas.obtenerElemento(aerolinea);
        if (aerolinea == null) {
            return Retorno.error1();
        }

        StringBuilder resultado = new StringBuilder();

        Nodo<Pasaje> actual = aerolinea.pasajesDevueltos.getInicio();
        while (actual != null) {
            Pasaje pasaje = actual.getDato();
            Vuelo vuelo = new Vuelo(pasaje.getCodVuelo());
            vuelo = listaVuelos.obtenerElemento(vuelo);
            if (vuelo.getAerolinea().equals(nombreAerolinea)) {
                // Agregar el pasaporte del cliente y el vuelo al resultado
                resultado.append(pasaje.getPasaporte()).append("-").append(vuelo.getCodVuelo()).append("|");
            }
            actual = actual.getSiguiente();
        }

        // Devolver el resultado construido
        return Retorno.ok(resultado.toString());
    }

    @Override
    public Retorno vistaDeVuelo(String codigoVuelo) {
        Vuelo vuelo = listaVuelos.obtenerElemento(new Vuelo(codigoVuelo));

        StringBuilder reporte = new StringBuilder();

        // Encabezado para categoría primera
        reporte.append("**********************************\n");
        reporte.append("* PRIMERA *\n");
        reporte.append("**********************************\n");

        // Filas de asientos de primera clase
        int asientosPrimeraClase = vuelo.CantPasajesPClaseVendidos + vuelo.CantPasajesPrimeraDisponibles;
        int asientosEconomicos = vuelo.CantPasajesEconDisponibles + vuelo.CantPasajesEconVendidos;

        int asientosPorFila = 3;
        int filasPrimeraClase = asientosPrimeraClase / asientosPorFila;
        int filasEconomicas = asientosEconomicos / asientosPorFila;

        // Generar filas de asientos de primera clase
        for (int i = 0; i < filasPrimeraClase; i++) {
            for (int j = 0; j < asientosPorFila; j++) {
                reporte.append("* XXXXXXXX ");
            }
            reporte.append("*\n");
        }

        // Encabezado para categoría económica
        reporte.append("**********************************\n");
        reporte.append("* ECONÓMICA *\n");
        reporte.append("**********************************\n");

        // Generar filas de asientos económicos
        for (int i = 0; i < filasEconomicas; i++) {
            for (int j = 0; j < asientosPorFila; j++) {
                reporte.append("* XXXXXXXX ");
            }
            reporte.append("*\n");
        }

        return Retorno.ok(reporte.toString());
    }

}
