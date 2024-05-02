
import sistemaAerolineas.Retorno;
import sistemaAerolineas.Sistema;


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
             
        Retorno ret2 = miSistema.crearAerolinea("Iberia", "Francia", 140);
        assertEquals(Retorno.ok().resultado, ret2.resultado);
    }

    @Test
    public void eliminarAerolineaOK() {
    }
    
    @Test
    public void eliminarAerolineaERROR() {
    
}
