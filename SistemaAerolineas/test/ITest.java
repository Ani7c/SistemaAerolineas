
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
    

    
    
}
