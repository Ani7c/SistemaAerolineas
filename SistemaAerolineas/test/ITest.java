
import sistemaAerolineas.Retorno;
import sistemaAerolineas.Sistema;
import org.junit.*;
import static org.junit.Assert.*;

public class ITest {

    private sistemaAerolineas.Sistema miSistema;

    public ITest() {
    }

    @Before
    public void setUp() {
        miSistema = new Sistema();
        miSistema.crearSistemaDeGestion();
    }

    @Test
    public void crearAerolineaOK() {
        Retorno ret = miSistema.crearAerolinea("Iberia", "España", 160);
        assertEquals(Retorno.ok().resultado, ret.resultado);
        
        Retorno ret1 = miSistema.crearAerolinea("Air France", "Francia", 170);
        assertEquals(Retorno.ok().resultado, ret1.resultado);
        
        Retorno ret2 = miSistema.crearAerolinea("Qatar Airways", "Qatar", 150);
        assertEquals(Retorno.ok().resultado, ret2.resultado);
    }
    
    @Test
    public void crearAerolineaERROR1() {
        Retorno ret1 = miSistema.crearAerolinea("Iberia", "España", 160);
        assertEquals(Retorno.ok().resultado, ret1.resultado);
        
        Retorno ret2 = miSistema.crearAerolinea("Air France", "Francia", 100);
        assertEquals(Retorno.ok().resultado, ret2.resultado);
        
        Retorno ret3 = miSistema.crearAerolinea("Qatar Airways", "Qatar", 130);
        assertEquals(Retorno.ok().resultado, ret3.resultado);
        
        Retorno ret4 = miSistema.crearAerolinea("Iberia", "Francia", 140);
        assertEquals(Retorno.error1().resultado, ret4.resultado);
        
        Retorno ret5 = miSistema.crearAerolinea("Air France", "Francia", 140);
        assertEquals(Retorno.error1().resultado, ret5.resultado);
        
        Retorno ret6 = miSistema.crearAerolinea("Qatar Airways", "Qatar", 90);
        assertEquals(Retorno.error1().resultado, ret6.resultado);
    }
    
    @Test
    public void crearAerolineaERROR2() {
        Retorno ret1 = miSistema.crearAerolinea("Iberia", "España", 0);
        assertEquals(Retorno.error2().resultado, ret1.resultado);
        
        Retorno ret2 = miSistema.crearAerolinea("Air France", "Francia", -10);
        assertEquals(Retorno.error2().resultado, ret2.resultado);
    }

    @Test
    public void eliminarAerolineaOK() {
        Retorno ret1 = miSistema.crearAerolinea("Iberia", "España", 160);
        assertEquals(Retorno.ok().resultado, ret1.resultado);
        ret1 = miSistema.crearAerolinea("American Airlines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, ret1.resultado);
        ret1 = miSistema.crearAerolinea("Emirates", "Emiratos Árabes Unidos", 20);
        assertEquals(Retorno.ok().resultado, ret1.resultado);
        ret1 = miSistema.crearAerolinea("Air France", "Francia", 10);
        assertEquals(Retorno.ok().resultado, ret1.resultado);
        ret1 = miSistema.eliminarAerolinea("Emirates");
        assertEquals(Retorno.ok().resultado, ret1.resultado);     
        ret1 = miSistema.eliminarAerolinea("Iberia");
        assertEquals(Retorno.ok().resultado, ret1.resultado);
        
       
    }
    
    @Test
    public void eliminarAerolineaERROR1() {
        Retorno ret1 = miSistema.crearAerolinea("Iberia", "España", 160);
        assertEquals(Retorno.ok().resultado, ret1.resultado);
        ret1 = miSistema.crearAerolinea("American Airlines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, ret1.resultado);
        ret1 = miSistema.crearAerolinea("Air France", "Francia", 10);
        assertEquals(Retorno.ok().resultado, ret1.resultado);
        
        
        ret1 = miSistema.eliminarAerolinea("British Airways");
        assertEquals(Retorno.error1().resultado, ret1.resultado);     
        ret1 = miSistema.eliminarAerolinea("LATAM Airlines");
        assertEquals(Retorno.error1().resultado, ret1.resultado);
    }
    
    @Test
    public void eliminarAerolineaERROR2() {
        Retorno ret1 = miSistema.crearAerolinea("Iberia", "España", 160);
        assertEquals(Retorno.ok().resultado, ret1.resultado);
        ret1 = miSistema.crearAerolinea("American Airlines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, ret1.resultado);
        ret1 = miSistema.crearAerolinea("Air France", "Francia", 10);
        assertEquals(Retorno.ok().resultado, ret1.resultado);
        
        ret1 = miSistema.registrarAvion("76ER4", 720, "Iberia");
        assertEquals(Retorno.ok().resultado, ret1.resultado); 
        ret1 = miSistema.eliminarAerolinea("Iberia");
        assertEquals(Retorno.error2().resultado, ret1.resultado);
    }
    

    
    
    @Test
    public void registrarAvionOK() {
        Retorno ret1 = miSistema.crearAerolinea("Iberia", "España", 160);
        assertEquals(Retorno.ok().resultado, ret1.resultado);
        
        Retorno ret2 = miSistema.crearAerolinea("Air France", "Francia", 100);
        assertEquals(Retorno.ok().resultado, ret2.resultado);
        
        Retorno ret3 = miSistema.crearAerolinea("Qatar Airways", "Qatar", 130);
        assertEquals(Retorno.ok().resultado, ret3.resultado);
        
        Retorno ret4 = miSistema.registrarAvion("76ER4", 720, "Iberia");
        assertEquals(Retorno.ok().resultado, ret4.resultado);
        
        Retorno ret5 = miSistema.registrarAvion("H8VR9", 723, "Air France");
        assertEquals(Retorno.ok().resultado, ret5.resultado);
        
        Retorno ret6 = miSistema.registrarAvion("0YVK9", 726, "Qatar Airways");
        assertEquals(Retorno.ok().resultado, ret6.resultado);
    }
    
    @Test
    public void registrarAvionERROR1() {
        Retorno ret1 = miSistema.crearAerolinea("Iberia", "España", 160);
        assertEquals(Retorno.ok().resultado, ret1.resultado);
        
        Retorno ret2 = miSistema.registrarAvion("76ER4", 720, "Iberia");
        assertEquals(Retorno.ok().resultado, ret2.resultado);
        
        Retorno ret3 = miSistema.registrarAvion("8UEK0", 726, "Iberia");
        assertEquals(Retorno.ok().resultado, ret3.resultado);
        
        Retorno ret4 = miSistema.registrarAvion("JUHK0", 729, "Iberia");
        assertEquals(Retorno.ok().resultado, ret4.resultado);
        
        Retorno ret5 = miSistema.registrarAvion("76ER4", 723, "Iberia");
        assertEquals(Retorno.error1().resultado, ret5.resultado);    
        
        Retorno ret6 = miSistema.registrarAvion("8UEK0", 729, "Iberia");
        assertEquals(Retorno.error1().resultado, ret6.resultado);
        
        Retorno ret7 = miSistema.registrarAvion("JUHK0", 732, "Iberia");
        assertEquals(Retorno.error1().resultado, ret7.resultado);
    }
    
    @Test
    public void registrarAvionERROR2() {
        Retorno ret1 = miSistema.crearAerolinea("Iberia", "España", 160);
        assertEquals(Retorno.ok().resultado, ret1.resultado);
        
        Retorno ret2 = miSistema.crearAerolinea("Air France", "Francia", 100);
        assertEquals(Retorno.ok().resultado, ret2.resultado);
        
        Retorno ret3 = miSistema.registrarAvion("76ER4", 8, "Iberia");
        assertEquals(Retorno.error2().resultado, ret3.resultado);   

        Retorno ret4 = miSistema.registrarAvion("76ER4", 721, "Air France");
        assertEquals(Retorno.error2().resultado, ret4.resultado); 
    }
    
    @Test
    public void registrarAvionERROR3() {
        Retorno ret1 = miSistema.crearAerolinea("Iberia", "España", 160);
        assertEquals(Retorno.ok().resultado, ret1.resultado);
        
        Retorno ret2 = miSistema.crearAerolinea("Air France", "Francia", 100);
        assertEquals(Retorno.ok().resultado, ret2.resultado);
        
        Retorno ret3 = miSistema.crearAerolinea("Qatar Airways", "Qatar", 130);
        assertEquals(Retorno.ok().resultado, ret3.resultado);
        
        Retorno ret4 = miSistema.registrarAvion("76ER4", 723, "LATAM Airlines");
        assertEquals(Retorno.error3().resultado, ret4.resultado); 
        
        Retorno ret5 = miSistema.registrarAvion("80YR4", 723, "Emirates");
        assertEquals(Retorno.error3().resultado, ret5.resultado);   
    }
    
    @Test
    public void eliminarAvionOK() {
        Retorno ret = miSistema.crearAerolinea("American Airlines", "Estados Unidos", 20);
        assertEquals(Retorno.ok().resultado, ret.resultado);
        ret = miSistema.crearAerolinea("Iberia", "España", 160);
        assertEquals(Retorno.ok().resultado, ret.resultado);
        ret = miSistema.crearAerolinea("Air France", "Francia", 10);
        assertEquals(Retorno.ok().resultado, ret.resultado);
        
        ret = miSistema.registrarAvion("65RE3", 720, "American Airlines");
        assertEquals(Retorno.ok().resultado, ret.resultado);
        ret = miSistema.registrarAvion("87SR3", 150, "Air France");
        assertEquals(Retorno.ok().resultado, ret.resultado);
        ret = miSistema.eliminarAvion("American Airlines", "65RE3");
        assertEquals(Retorno.ok().resultado,ret.resultado);  
    }
    
    public void eliminarAvionERROR1() {
        Retorno ret = miSistema.crearAerolinea("American Airlines", "Estados Unidos", 20);
        assertEquals(Retorno.ok().resultado, ret.resultado);
        ret = miSistema.crearAerolinea("Iberia", "España", 160);
        assertEquals(Retorno.ok().resultado, ret.resultado);
        ret = miSistema.crearAerolinea("Air France", "Francia", 10);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.registrarAvion("65RE3", 720, "American Airlines");
        assertEquals(Retorno.ok().resultado, ret.resultado);
        ret = miSistema.registrarAvion("87SR3", 150, "Air France");
        assertEquals(Retorno.ok().resultado, ret.resultado);
        ret = miSistema.eliminarAvion("United Airlines", "65RE3");
        assertEquals(Retorno.error1().resultado,ret.resultado);  
    }
    @Test
    public void eliminarAvionERROR2() {
        Retorno ret = miSistema.crearAerolinea("American Airlines", "Estados Unidos", 20);
        assertEquals(Retorno.ok().resultado, ret.resultado);
        ret = miSistema.crearAerolinea("Iberia", "España", 160);
        assertEquals(Retorno.ok().resultado, ret.resultado);
        ret = miSistema.crearAerolinea("Air France", "Francia", 10);
        assertEquals(Retorno.ok().resultado, ret.resultado);
        
        ret = miSistema.registrarAvion("65RE3", 720, "American Airlines");
        assertEquals(Retorno.ok().resultado, ret.resultado);
        ret = miSistema.registrarAvion("87SR3", 150, "Air France");
        assertEquals(Retorno.ok().resultado, ret.resultado);
        ret = miSistema.eliminarAvion("American Airlines", "87QE3");
        assertEquals(Retorno.error2().resultado,ret.resultado);              
    }    

    
     @Test
    public void listarAerolineasOK() {
        Retorno ret1 = miSistema.crearAerolinea("American Airlines", "Estados Unidos", 20);
        assertEquals(Retorno.ok().resultado, ret1.resultado);      
        ret1 = miSistema.crearAerolinea("Iberia", "España", 70);
        assertEquals(Retorno.ok().resultado, ret1.resultado);       
        ret1 = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 80);
        assertEquals(Retorno.ok().resultado, ret1.resultado);
        
        ret1 = miSistema.listarAerolineas();
        assertEquals("Aerolineas Argentinas-Argentina-80|American Airlines-Estados Unidos-20|Iberia-España-70|", ret1.valorString);
    }
    
    @Test
    public void listarAvionesDeAerolineaOK() {
        Retorno ret = miSistema.crearAerolinea("American Airlines", "Estados Unidos", 20);
        assertEquals(Retorno.ok().resultado, ret.resultado);
        ret = miSistema.crearAerolinea("Iberia", "España", 160);
        assertEquals(Retorno.ok().resultado, ret.resultado);
        ret = miSistema.crearAerolinea("Air France", "Francia", 10);
        assertEquals(Retorno.ok().resultado, ret.resultado);
        
        ret = miSistema.registrarAvion("65RE3", 720, "American Airlines");
        assertEquals(Retorno.ok().resultado, ret.resultado);       
        ret = miSistema.registrarAvion("45BI6", 150, "American Airlines");
        assertEquals(Retorno.ok().resultado, ret.resultado);     
        ret = miSistema.registrarAvion("87SR3", 150, "Air France");
        assertEquals(Retorno.ok().resultado, ret.resultado);
        ret = miSistema.registrarAvion("H8GE4", 720, "American Airlines");
        assertEquals(Retorno.ok().resultado, ret.resultado);
        
        ret = miSistema.listarAvionesDeAerolinea("American Airlines");
        assertEquals("H8GE4-720|45BI6-150|65RE3-720|", ret.valorString);
    }
    
    @Test
    public void listarAvionesDeAerolineaERROR() {
        Retorno ret = miSistema.crearAerolinea("American Airlines", "Estados Unidos", 20);
        assertEquals(Retorno.ok().resultado, ret.resultado);
        ret = miSistema.crearAerolinea("Iberia", "España", 160);
        assertEquals(Retorno.ok().resultado, ret.resultado);
        ret = miSistema.crearAerolinea("Air France", "Francia", 10);
        assertEquals(Retorno.ok().resultado, ret.resultado);
        
        ret = miSistema.registrarAvion("65RE3", 720, "American Airlines");
        assertEquals(Retorno.ok().resultado, ret.resultado);
        
        ret = miSistema.registrarAvion("45BI6", 720, "American Airlines");
        assertEquals(Retorno.ok().resultado, ret.resultado);
        
        ret = miSistema.listarAvionesDeAerolinea("Air New Zealand ");
        assertEquals(Retorno.error1().resultado, ret.resultado);
    }
    

    @Test
    public void registrarClienteOK() {
        Retorno ret = miSistema.registrarCliente("12E4R67", "Juan", 19);
        assertEquals(Retorno.ok().resultado, ret.resultado);
        
        ret = miSistema.registrarCliente("T65A321", "Maria", 38);
        assertEquals(Retorno.ok().resultado, ret.resultado);
        
        ret = miSistema.registrarCliente("G4J1GDS", "Lucia", 24);
        assertEquals(Retorno.ok().resultado, ret.resultado);
        
        ret = miSistema.registrarCliente("J784HJA", "Joaquin", 40);
        assertEquals(Retorno.ok().resultado, ret.resultado);
    }
    
    

    @Test
    public void crearVueloOK() {
        Retorno ret = miSistema.crearAerolinea("Iberia", "España", 160);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.registrarAvion("45BI6", 720, "Iberia");
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.registrarAvion("H8VR9", 723, "Iberia");
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.registrarAvion("H6VU9", 723, "Iberia");
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.crearVuelo("123HJK", "Iberia", "45BI6", "España", 10, 12, 2024, 9, 6);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.crearVuelo("193HDK", "Iberia", "H8VR9", "Uruguay", 12, 02, 2025, 9, 6);
        assertEquals(Retorno.ok().resultado, ret.resultado);

    }
    
    @Test
    public void crearVueloError1() {
        Retorno ret = miSistema.crearAerolinea("Iberia", "España", 160);
        assertEquals(Retorno.ok().resultado, ret.resultado);
        
        ret = miSistema.registrarAvion("45BI6", 720, "Iberia");
        assertEquals(Retorno.ok().resultado, ret.resultado);
        
        ret = miSistema.registrarAvion("H8VR9", 723, "Iberia");
        assertEquals(Retorno.ok().resultado, ret.resultado);
        
        ret = miSistema.registrarAvion("H6VU9", 723, "Iberia");
        assertEquals(Retorno.ok().resultado, ret.resultado);
        
        ret = miSistema.crearVuelo("123HJK", "Iberia", "45BI6", "España", 10, 12, 2024, 9, 6);
        assertEquals(Retorno.ok().resultado, ret.resultado);
        
        ret = miSistema.crearVuelo("123HJK", "Iberia", "H6VU9", "Uruguay", 12, 02, 2025, 9, 6);
        assertEquals(Retorno.error1().resultado, ret.resultado);
        
        ret = miSistema.crearVuelo("123HJK", "Iberia", "H6JU9", "Uruguay", 12, 02, 2025, 9, 6);
        assertEquals(Retorno.error1().resultado, ret.resultado);
        
    }

    @Test
    public void crearVueloError2() {
        Retorno ret = miSistema.crearAerolinea("Iberia", "España", 160);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.registrarAvion("45BI6", 720, "Iberia");
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.registrarAvion("H8VR9", 723, "Iberia");
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.registrarAvion("H6VU9", 723, "Iberia");
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.crearVuelo("123HJK", "American Airlines", "45BI6", "España", 10, 12, 2024, 9, 6);
        assertEquals(Retorno.error2().resultado, ret.resultado);

        ret = miSistema.crearVuelo("193HDK", "GOL", "H8VR9", "Uruguay", 12, 02, 2025, 9, 6);
        assertEquals(Retorno.error2().resultado, ret.resultado);

    }

    @Test
    public void crearVueloError3() {
        Retorno ret = miSistema.crearAerolinea("Iberia", "España", 160);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.registrarAvion("45BI6", 720, "Iberia");
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.registrarAvion("H8VR9", 723, "Iberia");
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.registrarAvion("H6VU9", 723, "Iberia");
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.crearVuelo("123HJK", "Iberia", "45BI6", "España", 10, 12, 2024, 9, 6);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.crearVuelo("193HDK", "Iberia", "P8VR9", "Uruguay", 12, 02, 2025, 9, 6);
        assertEquals(Retorno.error3().resultado, ret.resultado);
    }

    @Test
    public void crearVueloError4() {
        Retorno ret = miSistema.crearAerolinea("Iberia", "España", 160);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.registrarAvion("45BI6", 720, "Iberia");
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.registrarAvion("H8VR9", 723, "Iberia");
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.registrarAvion("H6VU9", 723, "Iberia");
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.crearVuelo("123HJK", "Iberia", "H8VR9", "España", 10, 12, 2024, 9, 6);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.crearVuelo("193HDK", "Iberia", "H8VR9", "Uruguay", 10, 12, 2024, 9, 6);
        assertEquals(Retorno.error4().resultado, ret.resultado);
    }

    @Test
    public void crearVueloError5() {
        Retorno ret = miSistema.crearAerolinea("Iberia", "España", 160);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.registrarAvion("45BI6", 720, "Iberia");
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.registrarAvion("H8VR9", 723, "Iberia");
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.registrarAvion("H6VU9", 723, "Iberia");
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.crearVuelo("123HJK", "Iberia", "45BI6", "España", 10, 12, 2024, 10, 6);
        assertEquals(Retorno.error5().resultado, ret.resultado);

        ret = miSistema.crearVuelo("193HDK", "Iberia", "H8VR9", "Uruguay", 12, 02, 2025, 9, 7);
        assertEquals(Retorno.error5().resultado, ret.resultado);

        ret = miSistema.crearVuelo("193HDK", "Iberia", "H8VR9", "Uruguay", 12, 02, 2025, 10, 7);
        assertEquals(Retorno.error5().resultado, ret.resultado);
    }

    @Test
    public void crearVueloError6() {
        Retorno ret = miSistema.crearAerolinea("Iberia", "España", 160);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.registrarAvion("45BI6", 15, "Iberia");
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.registrarAvion("H8VR9", 15, "Iberia");
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.registrarAvion("H6VU9", 15, "Iberia");
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.crearVuelo("123HJK", "Iberia", "45BI6", "España", 10, 12, 2024, 12, 6);
        assertEquals(Retorno.error6().resultado, ret.resultado);

        ret = miSistema.crearVuelo("193HDK", "Iberia", "H8VR9", "Uruguay", 12, 02, 2025, 9, 9);
        assertEquals(Retorno.error6().resultado, ret.resultado);

        ret = miSistema.crearVuelo("193HDK", "Iberia", "H6VU9", "Uruguay", 12, 02, 2025, 12, 9);
        assertEquals(Retorno.error6().resultado, ret.resultado);

    }

    @Test
    public void comprarPasajeOK() {
        Retorno ret = miSistema.crearAerolinea("Iberia", "España", 160);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.registrarAvion("45BI6", 720, "Iberia");
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.crearVuelo("123HJK", "Iberia", "45BI6", "España", 10, 12, 2024, 9, 6);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.registrarCliente("J784HJA", "Joaquin", 40);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.comprarPasaje("J784HJA", "123HJK", 1);
        assertEquals(Retorno.ok().resultado, ret.resultado);
    }

    @Test
    public void comprarPasajeError1() {
        Retorno ret = miSistema.crearAerolinea("Iberia", "España", 160);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.registrarAvion("45BI6", 720, "Iberia");
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.crearVuelo("123HJK", "Iberia", "45BI6", "España", 10, 12, 2024, 9, 6);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.registrarCliente("J784HJA", "Joaquin", 40);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.comprarPasaje("K05GHJA", "123HJK", 1);
        assertEquals(Retorno.error1().resultado, ret.resultado);
    }

    @Test
    public void comprarPasajeError2() {
        Retorno ret = miSistema.crearAerolinea("Iberia", "España", 160);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.registrarAvion("45BI6", 720, "Iberia");
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.crearVuelo("123HJK", "Iberia", "45BI6", "España", 10, 12, 2024, 9, 6);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.registrarCliente("J784HJA", "Joaquin", 40);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.comprarPasaje("J784HJA", "073HJK", 1);
        assertEquals(Retorno.error2().resultado, ret.resultado);
    }

    @Test
    public void devolverPasajeOK() {
        Retorno ret = miSistema.crearAerolinea("Iberia", "España", 160);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.registrarAvion("45BI6", 15, "Iberia");
        assertEquals(Retorno.ok().resultado, ret.resultado);

        //VUELO 1
        ret = miSistema.crearVuelo("123HJK", "Iberia", "45BI6", "España", 10, 12, 2024, 6, 3);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        //VUELO 2
        ret = miSistema.crearVuelo("923HJK", "Iberia", "45BI6", "España", 15, 12, 2024, 6, 3);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        //CLIENTE 1
        ret = miSistema.registrarCliente("J784HJA", "Joaquin", 40);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        //CLIENTE 2
        ret = miSistema.registrarCliente("123ASDF", "Juan", 40);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        //CLIENTE 3
        ret = miSistema.registrarCliente("123ASDP", "Juana", 30);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        //CLIENTE 4
        ret = miSistema.registrarCliente("123ASDL", "Maria", 20);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        //CLIENTE 5
        ret = miSistema.registrarCliente("123ASDJ", "Clara", 23);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        //CLIENTE 1 COMPRA PASAJE PARA VUELO 1
        ret = miSistema.comprarPasaje("J784HJA", "123HJK", 1);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        //CLIENTE 2 COMPRA PASAJE PARA VUELO 2 (PRIMERA CLASE)
        ret = miSistema.comprarPasaje("123ASDF", "923HJK", 2);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        //CLIENTE 3 COMPRA PASAJE PARA VUELO 2 (PRIMERA CLASE)
        ret = miSistema.comprarPasaje("123ASDP", "923HJK", 2);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        //CLIENTE 4 COMPRA PASAJE PARA VUELO 2 (PRIMERA CLASE)
        ret = miSistema.comprarPasaje("123ASDL", "923HJK", 2);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        //CLIENTE 5 COMPRA PASAJE PARA VUELO 2 (PRIMERA CLASE , pero ya no quedan => queda en cola de espera)
        ret = miSistema.comprarPasaje("123ASDJ", "923HJK", 2);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        //CLIENTE 1 DEVUELVE PASAJE, NO HAY NADIE EN COLA DE ESPERA
        ret = miSistema.devolverPasaje("J784HJA", "123HJK");
        assertEquals(Retorno.ok().resultado, ret.resultado);

        //CLIENTE 2 DEVUELVE PASAJE, SE LE ASIGNA A CLIENTE 5
        ret = miSistema.devolverPasaje("123ASDF", "923HJK");
        assertEquals(Retorno.ok().resultado, ret.resultado);
    }

    @Test
    public void listarClientes() {
        Retorno ret = miSistema.registrarCliente("12E4R67", "Juan", 19);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.registrarCliente("T65A321", "Maria", 38);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.registrarCliente("G4J1GDS", "Lucia", 24);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.registrarCliente("J784HJA", "Joaquin", 40);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.listarClientes();
        assertEquals("Joaquin-J784HJA-40|\nLucia-G4J1GDS-24|\nMaria-T65A321-38|\nJuan-12E4R67-19|", ret.valorString);

    }

    @Test
    public void listarVuelos() {
        Retorno ret = miSistema.crearAerolinea("Iberia", "España", 160);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.registrarAvion("45BI6", 720, "Iberia");
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.registrarAvion("H8VR9", 723, "Iberia");
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.registrarAvion("H6VU9", 723, "Iberia");
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.crearVuelo("123HJK", "Iberia", "45BI6", "España", 10, 12, 2024, 9, 6);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.crearVuelo("193HDK", "Iberia", "H8VR9", "Uruguay", 12, 02, 2025, 9, 6);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.crearVuelo("564GHT", "Iberia", "H8VR9", "Uruguay", 17, 03, 2025, 12, 9);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.listarVuelos();
        assertEquals("Código de vuelo: 123HJK, Aerolínea: Iberia, Código de Avión: 45BI6, Economica vendidos: 0, Primera clase vendidos: 0, pasajes disponibles: 15\n"
                + "Código de vuelo: 193HDK, Aerolínea: Iberia, Código de Avión: H8VR9, Economica vendidos: 0, Primera clase vendidos: 0, pasajes disponibles: 15\n"
                + "Código de vuelo: 564GHT, Aerolínea: Iberia, Código de Avión: H8VR9, Economica vendidos: 0, Primera clase vendidos: 0, pasajes disponibles: 21", ret.valorString);
    }

    @Test
    public void vuelosDeCliente() {
        // Registro de aerolíneas necesarias con todos sus parámetros
        Retorno ret = miSistema.crearAerolinea("Iberia", "España", 5);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.crearAerolinea("Avianca", "Colombia", 4);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.crearAerolinea("LATAM", "Chile", 3);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.crearAerolinea("Delta", "Estados Unidos", 5);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        // Registro de aviones
        ret = miSistema.registrarAvion("45BI6", 15, "Iberia");
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.registrarAvion("12AV8", 18, "Avianca");
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.registrarAvion("89LA7", 15, "LATAM");
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.registrarAvion("B777D", 9, "Delta");
        assertEquals(Retorno.ok().resultado, ret.resultado);

        // Registro de clientes
        ret = miSistema.registrarCliente("P001234", "Carlos", 30);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.registrarCliente("P002345", "Ana", 25);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        // Registro de vuelos
        ret = miSistema.crearVuelo("123HJK", "Iberia", "45BI6", "España", 10, 12, 2024, 9, 6);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.crearVuelo("456LMN", "Avianca", "12AV8", "Colombia", 15, 11, 2024, 12, 6);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.crearVuelo("789XYZ", "LATAM", "89LA7", "Chile", 20, 1, 2025, 12, 3);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        // Clientes compran pasajes
        ret = miSistema.comprarPasaje("P001234", "123HJK", 1); // Carlos compra en vuelo 123HJK
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.comprarPasaje("P001234", "456LMN", 2); // Carlos compra en vuelo 456LMN
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.devolverPasaje("P001234", "456LMN"); // Carlos devuelve pasaje de 456LMN
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.comprarPasaje("P001234", "789XYZ", 1); // Carlos compra en vuelo 789XYZ
        assertEquals(Retorno.ok().resultado, ret.resultado);

        // Caso de Ana sin pasajes
        ret = miSistema.vuelosDeCliente("P002345");
        assertEquals(Retorno.ok().resultado, ret.resultado);
        assertEquals("", ret.valorString);

        // Caso de Carlos con pasajes comprados y devueltos
        ret = miSistema.vuelosDeCliente("P001234");
        assertEquals(Retorno.ok().resultado, ret.resultado);
        assertEquals("789XYZ-CPR|\n456LMN-DEV|\n123HJK-CPR", ret.valorString);

        // Cliente no registrado
        ret = miSistema.vuelosDeCliente("P003456");
        assertEquals(Retorno.error1().resultado, ret.resultado);
        assertEquals("El pasaporte del cliente no existe.", ret.valorString);

        // Registrar otro vuelo y verificar su inclusión en la lista de pasajes de Carlos
        ret = miSistema.crearVuelo("555AAA", "Delta", "B777D", "Estados Unidos", 5, 7, 2025, 6, 3);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.comprarPasaje("P001234", "555AAA", 1); // Carlos compra en vuelo 555AAA
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.vuelosDeCliente("P001234");
        assertEquals(Retorno.ok().resultado, ret.resultado);
        assertEquals("555AAA-CPR|\n789XYZ-CPR|\n456LMN-DEV|\n123HJK-CPR", ret.valorString);
    }

    @Test
    public void vistaDeVuelo() {
        // Registro de aerolínea con sus aviones
        Retorno ret = miSistema.crearAerolinea("Iberia", "España", 160);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.registrarAvion("45BI6", 15, "Iberia");
        assertEquals(Retorno.ok().resultado, ret.resultado);

        // Creación del vuelo
        ret = miSistema.crearVuelo("123HJK", "Iberia", "45BI6", "España", 10, 12, 2024, 9, 6);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.registrarCliente("P001234", "Carlos", 30);
        assertEquals(Retorno.ok().resultado, ret.resultado);
        
        ret = miSistema.registrarCliente("123GHJK", "Ana", 30);
        assertEquals(Retorno.ok().resultado, ret.resultado);
        
        ret = miSistema.registrarCliente("436GT5T", "Belen", 30);
        assertEquals(Retorno.ok().resultado, ret.resultado);
        
        ret = miSistema.registrarCliente("F5368GY", "Maria", 30);
        assertEquals(Retorno.ok().resultado, ret.resultado);
        
        // Simulación de compra de pasajes
        ret = miSistema.comprarPasaje("P001234", "123HJK", 1);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.comprarPasaje("436GT5T", "123HJK", 2);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.comprarPasaje("123GHJK", "123HJK", 2);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.comprarPasaje("F5368GY", "123HJK", 1);
        assertEquals(Retorno.ok().resultado, ret.resultado);

        ret = miSistema.vistaDeVuelo("123HJK");
        assertEquals(Retorno.ok().resultado, ret.resultado);
        assertEquals("**********************************\n"
                + "* PRIMERA *\n"
                + "**********************************\n"
                + "* 436GT5T * 123GHJK * XXXXXXXX *\n"
                + "**********************************\n"
                + "* XXXXXXXX * XXXXXXXX * XXXXXXXX *\n"
                + "**********************************\n"
                + "* ECONÓMICA *\n"
                + "**********************************\n"
                + "* P001234 * F5368GY * XXXXXXXX *\n"
                + "**********************************\n"
                + "* XXXXXXXX * XXXXXXXX * XXXXXXXX *\n"
                + "**********************************\n"
                + "* XXXXXXXX * XXXXXXXX * XXXXXXXX *\n"
                + "**********************************\n"
                , ret.valorString);
    }

}
