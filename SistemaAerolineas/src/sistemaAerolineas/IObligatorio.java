package sistemaAerolineas;


public interface IObligatorio {
    
    /*
    **************** REGISTROS **************************************
    */
    
    //pre:      
    //post: Se crea la estructura necesaria para representar el sistema de gestión. Devuelve OK si el sistema se inicializó correctamente, o ERROR si la función aún no se ha implementado.
    public Retorno crearSistemaDeGestion();;
    //pre:  La cantidad de Aviones debe ser > 0    
    //post: Se registra una aerolínea especificando la cantidad máxima de aviones que puede gestionar.
    public Retorno crearAerolinea(String nombre, String pais, int cantMaxAviones); 
    //pre:  Se debe ingresar un nombre de una Aerolinea existente   
    //post: Se elimina la aerolinea
    public  Retorno eliminarAerolinea(String nombre);; 
    //pre:  La capacidad máxima debe ser > 9 y multiplo de 3
            //no debe haber un avion con el mismo codigo en esa aerolinea
    //post: Se registra un Avion
    public Retorno registrarAvion(String codigo, int capacidadMax, String nomAerolinea);; 
    //pre:  Se debe ingresar una aerolinea existente y un código de avion que exista dentro de la misma   
    //post: Se elimina el avion
    public Retorno eliminarAvion(String nomAerolinea, String codAvion); 
    //pre:  La edad debe ser > 0, se debe ingresar un pasaporte == 7 caracteres    
    //post: Se registra el cliente
    public Retorno registrarCliente(String pasaporte, String nombre, int edad);
    //pre:      
    //post:
    
      /*
    **************** GESTIÓN DE VUELOS Y PASAJES **************************************
    */
    
    //pre:  Existe una Aerolinea con el nombre ingresado, y un avion con el código ingresado dentro de la misma.
        //No existe otro vuelo para ese avion en la fecha ingresada
    //post: Se crea el vuelo en el sistema
    public Retorno crearVuelo(String codigoVuelo, String aerolinea, String codAvion, String paisDestino, int dia, int mes, int año, int cantPasajesEcon, int cantPasajesPClase);
    //pre: Existe disponibilidad para dicha categoria, se ingresa un pasaporte y un codigo de vuelo existentes   
    //post: Se emite el pasaje para dicho cliente
    public Retorno comprarPasaje(String pasaporteCliente, String codigoVuelo, int categoríaPasaje);
    //pre: Existe un cliente con ese pasaporte, un vuelo con ese código, y el cliente realizo una compra para dicho vuelo    
    //post: Se efectua la devolucion del pasaje
    public Retorno devolverPasaje(String pasaporteCliente, String codigoVuelo);

     /*
    **************** REPORTES Y CONSULTAS **************************************
    */
    //pre:     post: Se listan todas las Aerolineas por orden alfabético
    public Retorno listarAerolineas();
    //pre:  Existe una aerolinea con dicho nombre  
    //post: Se listan todos los aviones registrados para dicha aerolinea
    public Retorno listarAvionesDeAerolinea(String nombre);
    //pre:      post: Se listan todos los clientes registados en el sistema, según orden de registro
    public Retorno listarClientes();
    //pre:      post: Se listan todos los vuelos del sistema
    public Retorno listarVuelos();
    //pre:  Existe el pasaporte del cliente    
    //post: Se listan todos los vuelos para los cuales el cliente compro pasajes, incluyendo aquellos para los cuales se realizó devolución
    public Retorno vuelosDeCliente(String pasaporte);
    //pre:  Existe una aerolinea con dicho nombre    
    //post: Se listan los pasajes devueltos para dicha aerolinea
    public Retorno pasajesDevueltos(String nombreAerolinea);
    //pre:      post: Se muestra la distribucion de pasajeros en el avion, según las diferentes categorías de pasajes ofrecidos y vendidos.
    public Retorno vistaDeVuelo(String codigoVuelo);
    
    
    
}
