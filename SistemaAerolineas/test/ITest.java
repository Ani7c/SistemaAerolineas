
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
    }
    
    @Test
    public void crearAerolineaERROR() {
        Retorno ret1 = miSistema.crearAerolinea("Iberia", "España", 160);
        assertEquals(Retorno.ok().resultado, ret1.resultado);
        
        Retorno ret2 = miSistema.crearAerolinea("Iberia", "Francia", 140);
        assertEquals(Retorno.error1().resultado, ret2.resultado);
        
        Retorno ret3 = miSistema.crearAerolinea("LATAM Airlines", "Chile", 0);
        assertEquals(Retorno.error2().resultado, ret3.resultado);
    }

    @Test
    public void eliminarAerolineaOK() {
        Retorno ret1 = miSistema.crearAerolinea("Iberia", "España", 160);
        assertEquals(Retorno.ok().resultado, ret1.resultado);
        
        Retorno ret2 = miSistema.eliminarAerolinea("Iberia");
        assertEquals(Retorno.ok().resultado, ret2.resultado);
    }
    
    @Test
    public void eliminarAerolineaERROR1() {
        Retorno ret1 = miSistema.crearAerolinea("Iberia", "España", 160);
        assertEquals(Retorno.ok().resultado, ret1.resultado);
        
        Retorno ret3 = miSistema.eliminarAerolinea("LATAM Airlines");
        assertEquals(Retorno.error1().resultado, ret3.resultado);
    }
    
    @Test
    public void eliminarAerolineaERROR2() {
        Retorno ret1 = miSistema.crearAerolinea("Iberia", "España", 160);
        assertEquals(Retorno.ok().resultado, ret1.resultado);
        
        Retorno ret2 = miSistema.registrarAvion("76ER4", 720, "Iberia");
        assertEquals(Retorno.ok().resultado, ret2.resultado);
        
        Retorno ret3 = miSistema.eliminarAerolinea("Iberia");
        assertEquals(Retorno.error2().resultado, ret3.resultado);
    }
    
    
    @Test
    public void registrarAvionOK() {
        Retorno ret1 = miSistema.crearAerolinea("Iberia", "España", 160);
        assertEquals(Retorno.ok().resultado, ret1.resultado);
        
        Retorno ret2 = miSistema.registrarAvion("76ER4", 720, "Iberia");
        assertEquals(Retorno.ok().resultado, ret2.resultado);
    }
    
    @Test
    public void registrarAvionERROR1() {
         Retorno ret1 = miSistema.crearAerolinea("Iberia", "España", 160);
        assertEquals(Retorno.ok().resultado, ret1.resultado);
        
        Retorno ret2 = miSistema.registrarAvion("76ER4", 720, "Iberia");
        assertEquals(Retorno.ok().resultado, ret2.resultado);
        
        Retorno ret3 = miSistema.registrarAvion("76ER4", 723, "Iberia");
        assertEquals(Retorno.error1().resultado, ret3.resultado);    
    }
    
    @Test
    public void registrarAvionERROR2() {
         Retorno ret1 = miSistema.crearAerolinea("Iberia", "España", 160);
        assertEquals(Retorno.ok().resultado, ret1.resultado);
        
        Retorno ret2 = miSistema.registrarAvion("76ER4", 8, "Iberia");
        assertEquals(Retorno.error2().resultado, ret2.resultado);   

        Retorno ret3 = miSistema.registrarAvion("76ER4", 721, "Iberia");
        assertEquals(Retorno.error2().resultado, ret3.resultado); 
    }
    
    @Test
    public void registrarAvionERROR3() {
         Retorno ret1 = miSistema.crearAerolinea("Iberia", "España", 160);
        assertEquals(Retorno.ok().resultado, ret1.resultado);
        
        Retorno ret2 = miSistema.registrarAvion("76ER4", 723, "LATAM Airlines");
        assertEquals(Retorno.error3().resultado, ret2.resultado);   
    }
    
    @Test
    public void eliminarAvionOK() {
        
    }
    
    @Test
    public void eliminarAvionERROR() {
        
    }
    
    @Test
    public void listarAerolineasOK() {
        
    }
    
    @Test
    public void listarAerolineasERROR() {
        
    }
    
    @Test
    public void listarAvionesDeAerolineaOK() {
        
    }
    
    @Test
    public void listarAvionesDeAerolineaERROR() {
        
    }
    
    
}
