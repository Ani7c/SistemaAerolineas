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
    private Lista<Cliente> listaClientes;
    private Lista<Vuelo> listaVuelos;

    @Override
    public Retorno crearSistemaDeGestion() {
        listaAerolineas = new Lista<>();
        listaClientes = new Lista<>();
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

            return Retorno.ok();
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
        return Retorno.ok();
    }

    @Override
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
            Avion aBuscado = aerolineaBuscada.getAviones().obtenerElemento(new Avion(codAvion));
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

        if ((categoríaPasaje == 1 && (vueloBuscado.CantPasajesEcon - vueloBuscado.CantPasajesEconVendidos) > 0) || (categoríaPasaje == 2 && (vueloBuscado.CantPasajesPrimera - vueloBuscado.CantPasajesPClaseVendidos) > 0)) {
            Pasaje pasajeNuevo = new Pasaje(pasaporteCliente, codigoVuelo, categoríaPasaje);
            cliBuscado.setPasajesCliente(pasajeNuevo);
            vueloBuscado.pasajesVendidos.agregarInicio(pasajeNuevo);
            if (categoríaPasaje == 1) {
                vueloBuscado.CantPasajesEconVendidos++;
            } else if (categoríaPasaje == 2) {
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
        
        //CLIENTE QUE DEVUELVE PASAJE
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
                vueloBuscado.getAerolinea().pasajesDevueltos.agregarFinal(pasaje);
                int categoria = pasaje.getCategoria();
                
                Pasaje devuelto = new Pasaje(pasaporteCliente, codigoVuelo, categoria);
                devuelto.setEstado("DEV");
                cliBuscado.setPasajeDevuelto(devuelto);
                
                Cliente nuevoCliente;               
                
                if (categoria == 1) {
                    if (vueloBuscado.colaEconomica.isEmpty()) {
                        vueloBuscado.CantPasajesEconVendidos--;
                    } else {
                        nuevoCliente = vueloBuscado.eliminarDeListaDeEsperaEcon();
                        Pasaje pasajeNuevo = new Pasaje(nuevoCliente.getPasaporte(), codigoVuelo, categoria);
                        nuevoCliente.setPasajesCliente(pasajeNuevo);
                        vueloBuscado.pasajesVendidos.agregarFinal(pasajeNuevo);
                    }
                } else if (vueloBuscado.colaPClase.isEmpty()) {
                    vueloBuscado.CantPasajesPClaseVendidos--;
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

        if (listaClientes.esVacia()) {
            ret.valorString = "No hay clientes registrados.";
        } else {
            ret.valorString = listarClientesRecursivo(listaClientes.getInicio());
        }

        return ret;
    }

    private String listarClientesRecursivo(Nodo<Cliente> nodo) {
        if (nodo == null) {
            return "";
        }

        String resultado = listarClientesRecursivo(nodo.getSiguiente());

        if (resultado.isEmpty()) {
            return nodo.getDato().toString(); //Cuando es el último cliente
        } else {
            return nodo.getDato().toString() + "\n" + resultado;
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
                    resultado.append("|\n");
                } else {
                    resultado.append("|");
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
            return "";
        }

        String resultado = listarVuelosClienteRecursivo(nodo.getSiguiente());

        if (resultado.isEmpty()) {
            return nodo.getDato().toString() + "|"; // Último pasaje
        } else {
            return nodo.getDato().toString() + "|\n" + resultado;
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
        Retorno ret = new Retorno(Retorno.Resultado.OK);

        Nodo<Pasaje> actual = aerolinea.pasajesDevueltos.getInicio();
        while (actual != null) {
            Pasaje pasaje = actual.getDato();
            Vuelo vuelo = new Vuelo(pasaje.getCodVuelo());
            vuelo = listaVuelos.obtenerElemento(vuelo);
            if (vuelo.getAerolinea().getNombre().equals(nombreAerolinea)) {
                // Agregar el pasaporte del cliente y el vuelo al resultado
                if (actual.getSiguiente() == null) {
                    resultado.append(pasaje.getPasaporte()).append("-").append(vuelo.getCodVuelo()).append("|");
                } else {
                    resultado.append(pasaje.getPasaporte()).append("-").append(vuelo.getCodVuelo()).append("|\n");
                }               
            }
            actual = actual.getSiguiente();
        }

        ret.valorString = resultado.toString();
        return ret;
    }

    @Override
    public Retorno vistaDeVuelo(String codigoVuelo) {
        Vuelo vuelo = listaVuelos.obtenerElemento(new Vuelo(codigoVuelo));

        StringBuilder reporte = new StringBuilder();
        Retorno ret = new Retorno(Retorno.Resultado.OK);

        reporte.append("**********************************\n");
        reporte.append("          * PRIMERA *\n");
        reporte.append("**********************************\n");

        int asientosPorFila = 3;
        int filasPrimeraClase = vuelo.CantPasajesPrimera / asientosPorFila;
        
        Nodo<Pasaje> nodoPasaje = vuelo.getPasajesVendidos().getInicio();
        
        //separar los pasajes en dos listas
        Lista<Pasaje> economica = new Lista<>();
        Lista<Pasaje> primera = new Lista<>();
        while (nodoPasaje != null){
            if (nodoPasaje.getDato().getCategoria() == 1) {
                economica.agregarInicio(nodoPasaje.getDato());
            } else {
                primera.agregarInicio(nodoPasaje.getDato());
            }
            nodoPasaje = nodoPasaje.getSiguiente();
        }
        
        Nodo<Pasaje> nodoPrimera = primera.getInicio();
        for (int i = 0; i < filasPrimeraClase; i++) {
            for (int j = 0; j < asientosPorFila; j++) {
                if (nodoPrimera != null) {
                    String pasaporte = nodoPrimera.getDato().getPasaporte();
                    nodoPrimera = nodoPrimera.getSiguiente();
                    reporte.append("* ").append(pasaporte).append(" ");
                } else {
                    reporte.append("* XXXXXXXX ");
                }
            }
            reporte.append("*\n");
            reporte.append("**********************************\n");
        }

        reporte.append("          * ECONÓMICA *\n");
        reporte.append("**********************************\n");

        int filasEconomicas = vuelo.CantPasajesEcon / asientosPorFila;

        Nodo<Pasaje> nodoEconomica = economica.getInicio();
        for (int i = 0; i < filasEconomicas; i++) {
            for (int j = 0; j < asientosPorFila; j++) {
                if (nodoEconomica != null) {
                    String pasaporte = nodoEconomica.getDato().getPasaporte();
                    nodoEconomica = nodoEconomica.getSiguiente();
                    reporte.append("* ").append(pasaporte).append(" ");
                } else {
                    reporte.append("* XXXXXXXX ");
                }
            }
            reporte.append("*\n");
            reporte.append("**********************************\n");
        }
        //System.out.println(reporte);
        ret.valorString = reporte.toString();
        return ret;
    }
}
