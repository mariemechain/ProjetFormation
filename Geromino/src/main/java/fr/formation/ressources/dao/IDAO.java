package fr.formation.ressources.dao;



import java.util.List;

public interface IDAO<T> {
	public T findById(int id);
	public List<T> findAll();
	public T save (T entity);
	public boolean delete(T entity);

}
