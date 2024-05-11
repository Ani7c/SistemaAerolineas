package sistemaAerolineas;


public interface IObligatorio {
    
    /*
    **************** REGISTROS **************************************
    */
    
    //pre:      
    //post: Se crea la estructura necesaria para representar el sistema de gestión. Devuelve OK si el sistema se inicializó correctamente, o ERROR si la función aún no se ha implementado.
    public Retorno crearSistemaDeGestion();;
     //pre:      post: Se registra una aerolínea especificando la cantidad máxima de aviones que puede gestionar.
    public Retorno crearAerolinea(String nombre, String pais, int cantMaxAviones); 
     //pre:      post:
    public  Retorno eliminarAerolinea(String nombre);; 
     //pre:      post:
    public Retorno registrarAvion(String codigo, int capacidadMax, String nomAerolinea);; 
    //pre:      post:
    public Retorno eliminarAvion(String nomAerolinea, String codAvion); 
    //pre:      post:
    public Retorno registrarCliente(String pasaporte, String nombre, int edad);
    //pre:      post:
    
      /*
    **************** GESTIÓN DE VUELOS Y PASAJES **************************************
    */
    
     //pre:      post:
    public Retorno crearVuelo(String codigoVuelo, String aerolinea, String codAvion, String paisDestino, int dia, int mes, int año, int cantPasajesEcon, int cantPasajesPClase);
    //pre:      post:
    public Retorno comprarPasaje(String pasaporteCliente, String codigoVuelo, int categoríaPasaje);
    //pre:      post:
    public Retorno devolverPasaje(String pasaporteCliente, String codigoVuelo);

     /*
    **************** REPORTES Y CONSULTAS **************************************
    */
    //pre:      post:
    public Retorno listarAerolineas();
    //pre:      post:
    public Retorno listarAvionesDeAerolinea(String nombre);
    //pre:      post: 
    public Retorno listarClientes();
    //pre:      post: 
    public Retorno listarVuelos();
    //pre:      post: 
    public Retorno vuelosDeCliente(String pasaporte);
    //pre:      post: 
    public Retorno pasajesDevueltos(String nombreAerolinea);
    //pre:      post: 
    public Retorno vistaDeVuelo(String codigoVuelo);
    
    
    
}
