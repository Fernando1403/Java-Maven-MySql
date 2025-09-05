package br.com.fiap.repositorio;

import br.com.fiap.modelo.PessoaFisica;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.fiap.modelo.Pessoa;
import br.com.fiap.util.HibernateUtil;

import java.util.List;


public class PessoaRepositorioImpl implements PessoaRepositorio {


    public void criar(Pessoa pessoa) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {

            transaction = session.beginTransaction();
            session.persist(pessoa);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<PessoaFisica> consultar(String cpf){
        Session session = HibernateUtil.getSession();
        Query q = session.getNamedQuery("xpto");
        q.setParameter("cpf", cpf);

        return q.getResultList();
    }
}