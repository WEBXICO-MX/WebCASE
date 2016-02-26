/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.service;

import java.util.List;

import mx.edu.uttab.spring.model.Usuario;

public interface UsuarioService {
	public void addUsuario(Usuario u);

	public void updateUsuario(Usuario u);

	public List<Usuario> listUsuarios();

	public Usuario getUsuarioById(int id);

	public void removeUsuario(int id);

}
