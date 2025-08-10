import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/cadastroUsuario")
   public ModelAndView cadastrar (Usuario usuario) {
       ModelAndView mv = new ModelAndView("/administrativo/usuario/cadastro");
       mv.addObject("usuario", usuario);
       return mv;
   }
