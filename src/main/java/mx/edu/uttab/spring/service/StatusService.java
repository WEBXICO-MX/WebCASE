/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package mx.edu.uttab.spring.service;

import java.util.List;

import mx.edu.uttab.spring.model.Status;

public interface StatusService {
	public void addStatus(Status s);

	public void updateStatus(Status s);

	public List<Status> listStatuss();

	public Status getStatusById(int id);

	public void removeStatus(int id);

}
