package com.julientejedor.JTDProject;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class testDataBase {

	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("JTDProject");

	public static void main(String[] args) {

//		addGasto("gasto1", "categoria1", Date.valueOf("2019-12-06"), Date.valueOf("2019-12-07"));
//		addGasto("gasto2", "categoria2", Date.valueOf("2019-12-06"), Date.valueOf("2019-12-07"));
//		getGasto(1);
//		getGastos();
//		deleteGasto(1);
//		addTarea("tarea4", "categoria1", Date.valueOf("2019-12-05"), Date.valueOf("2019-12-06"));
//		getTarea(1);
//		getTareas();
//		deleteTarea(2);
//		addCompra("leche", "compra");
//		addCompra("cafe", "compra");
//		addCompra("mantequilla", "compra");
//		getCompra(1);
//		getCompras();
//		deleteCompra(1);
		ENTITY_MANAGER_FACTORY.close();
	}

	public static void addCompra(String name, String category) {

		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;

		try {
			et = em.getTransaction();
			et.begin();
			Compra compra = new Compra();
			compra.setName(name);
			compra.setCategory(category);
			em.persist(compra);
			et.commit();
		} catch (Exception ex) {
			if (et != null) {
				et.rollback();
			}
			ex.printStackTrace();
		} finally {
			em.close();
		}

	}

	public static void getCompra(int id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT c FROM Compra c WHERE c.id = :id";

		TypedQuery<Compra> tq = em.createQuery(query, Compra.class);
		tq.setParameter("id", id);
		Compra compra = null;
		try {

			compra = tq.getSingleResult();
			System.out.println(compra.getName() + " " + compra.getCategory());
		} catch (NoResultException ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}
	}

	public static void getCompras() {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String strQuery = "SELECT c FROM Compra c WHERE c.id IS NOT NULL";

		TypedQuery<Compra> tq = em.createQuery(strQuery, Compra.class);
		List<Compra> compras;
		try {

			compras = tq.getResultList();
			compras.forEach(comp -> System.out.println(comp.getName() + " " + comp.getCategory()));
		} catch (NoResultException ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}
	}

	public static void deleteCompra(int id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		Compra compra = null;
		try {
			et = em.getTransaction();
			et.begin();
			compra = em.find(Compra.class, id);
			em.remove(compra);
			et.commit();
		} catch (NoResultException ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}
	}

	public static void addTarea(String name, String category, Date start, Date end) {

		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;

		try {
			et = em.getTransaction();
			et.begin();
			Tareas tarea = new Tareas();
			tarea.setName(name);
			tarea.setCategory(category);
			tarea.setStartDate(start);
			tarea.setEndDate(end);
			em.persist(tarea);
			et.commit();
		} catch (Exception ex) {
			if (et != null) {
				et.rollback();
			}
			ex.printStackTrace();
		} finally {
			em.close();
		}

	}

	public static void getTarea(int id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT t FROM Tareas t WHERE t.id = :id";

		TypedQuery<Tareas> tq = em.createQuery(query, Tareas.class);
		tq.setParameter("id", id);
		Tareas tarea = null;
		try {

			tarea = tq.getSingleResult();
			System.out.println(tarea.getName() + " " + tarea.getCategory() + " " + tarea.getStartDate() + " "
					+ tarea.getEndDate());
		} catch (NoResultException ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}
	}

	public static void getTareas() {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String strQuery = "SELECT t FROM Tareas t WHERE t.id IS NOT NULL";

		TypedQuery<Tareas> tq = em.createQuery(strQuery, Tareas.class);
		List<Tareas> tareas;
		try {

			tareas = tq.getResultList();
			tareas.forEach(tar -> System.out.println(
					tar.getName() + " " + tar.getCategory() + " " + tar.getStartDate() + " " + tar.getEndDate()));
		} catch (NoResultException ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}
	}

	public static void deleteTarea(int id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		Tareas tarea = null;
		try {
			et = em.getTransaction();
			et.begin();
			tarea = em.find(Tareas.class, id);
			em.remove(tarea);
			et.commit();
		} catch (NoResultException ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	public static void addGasto(String name, String category, Date start, Date end) {

		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;

		try {
			et = em.getTransaction();
			et.begin();
			Gastos gasto = new Gastos();
			gasto.setName(name);
			gasto.setCategory(category);
			gasto.setStartDate(start);
			gasto.setEndDate(end);
			em.persist(gasto);
			et.commit();
		} catch (Exception ex) {
			if (et != null) {
				et.rollback();
			}
			ex.printStackTrace();
		} finally {
			em.close();
		}

	}

	public static void getGasto(int id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT g FROM Gastos g WHERE g.id = :id";

		TypedQuery<Gastos> tq = em.createQuery(query, Gastos.class);
		tq.setParameter("id", id);
		Gastos gasto = null;
		try {

			gasto = tq.getSingleResult();
			System.out.println(gasto.getName() + " " + gasto.getCategory() + " " + gasto.getStartDate() + " "
					+ gasto.getEndDate());
		} catch (NoResultException ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}
	}

	public static void getGastos() {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String strQuery = "SELECT g FROM Gastos g WHERE g.id IS NOT NULL";

		TypedQuery<Gastos> tq = em.createQuery(strQuery, Gastos.class);
		List<Gastos> gastos;
		try {

			gastos = tq.getResultList();
			gastos.forEach(gas -> System.out.println(
					gas.getName() + " " + gas.getCategory() + " " + gas.getStartDate() + " " + gas.getEndDate()));
		} catch (NoResultException ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}
	}

	public static void deleteGasto(int id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		Gastos gasto = null;
		try {
			et = em.getTransaction();
			et.begin();
			gasto = em.find(Gastos.class, id);
			em.remove(gasto);
			et.commit();
		} catch (NoResultException ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}
	}

}
