package ExerEmAula;

import org.junit.*;

import static org.junit.Assert.*;

public class UsuarioTest {

    @Test
    public void usuarioMaiorDeIdade(){
        Usuario usuario = new Usuario("Igor", 25);
        assertTrue(usuario.ehMaiorDeIdade());

    }

}
